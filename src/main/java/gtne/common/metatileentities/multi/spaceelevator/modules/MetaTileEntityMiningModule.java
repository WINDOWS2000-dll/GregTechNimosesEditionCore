package gtne.common.metatileentities.multi.spaceelevator.modules;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.*;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.Widget;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.*;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTTransferUtils;
import gregtech.api.util.TextComponentUtil;
import gregtech.common.ConfigHolder;
import gtne.client.GTNETextures;
import gtne.common.metatileentities.multi.spaceelevator.MetaTileEntityModuleBase;
import gtne.loaders.recipes.MultiBlock.spaceelevator.SpaceMiningRecipes;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.eclipse.xtext.xbase.lib.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.BooleanSupplier;

import static gregtech.api.unification.material.Materials.*;
import static gtne.common.item.GTNEMetaItems.*;
import static gtne.loaders.recipes.MultiBlock.spaceelevator.SpaceMiningRecipes.*;

public class MetaTileEntityMiningModule extends MetaTileEntityModuleBase implements IOpticalComputationReceiver {

    private IItemHandlerModifiable inputInventory;

    private IItemHandlerModifiable outputInventory;

    private IMultipleTankHandler inputFluidInventory;

    private IOpticalComputationProvider computationProvider;

    private int minDistance = 0;

    private int maxDistance = 0;

    private int distance = 0;

    private int range = 0;

    private final int MAX_PARALLEL;

    private final int MAX_DISTANCE = 300;

    private final int MAX_RANGE = 150;

    private boolean cycleMode = false;

    private int step = 0;

    private int parallel;

    private SpaceMiningRecipes.SpaceMiningRecipePartTwo randomRecipes;

    private List<ItemStack> randomOutput = new ArrayList<>();

    private List<String> Whitelist = new ArrayList<>();

    private boolean isWhitelist = true;

    private long totalEUt = 0;

    private int totalComputation = 0;

    public MetaTileEntityMiningModule(ResourceLocation metaTileEntityId, int tier, int moduleTier, int minMotorTier, int maxParallel) {
        super(metaTileEntityId, tier, moduleTier, minMotorTier);
        this.MAX_PARALLEL = maxParallel;
        this.parallel = maxParallel;
    }

    @Override
    public void initializeAbilities() {
        this.inputInventory = new ItemHandlerList(getAbilities(MultiblockAbility.IMPORT_ITEMS));
        this.outputInventory = new ItemHandlerList(getAbilities(MultiblockAbility.EXPORT_ITEMS));
        this.inputFluidInventory = new FluidTankList(false, getAbilities(MultiblockAbility.IMPORT_FLUIDS));

        try {
            this.computationProvider = getSpaceElevator().getComputationProvider();
        } catch (NullPointerException ignored) {
            //TODO NullPoint Exception Error MSG
        }
    }

    @Override
    protected TraceabilityPredicate abilities() {
        return abilities(MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.IMPORT_FLUIDS);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityMiningModule(this.metaTileEntityId, this.tier, this.moduleTier, this.minMotorTier, this.MAX_PARALLEL);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        for (EnumFacing renderSide : EnumFacing.HORIZONTALS) {
            if (renderSide == getFrontFacing()) {
                getFrontOverlay().renderOrientedState(renderState, translation, pipeline,
                        getFrontFacing(), this.isActive(), true);
            } else
                GTNETextures.MINING_MODULE_OVERLAY.renderSided(renderSide, renderState, translation, pipeline);
        }
    }

    @Override
    public void updateFormedValid() {
        super.updateFormedValid();
        if (!this.isWorkingEnabled()) {
            return;
        }

        if (!drainEnergy(true, this.totalEUt) || this.computationProvider.requestCWUt(this.totalComputation, true) != this.totalComputation) {
            if (this.progressTime >= 2) {
                if (ConfigHolder.machines.recipeProgressLowEnergy) this.progressTime = 1;
                else this.progressTime = Math.max(1, this.progressTime - 2);
            }
            return;
        }

        if (progressTime == 0 && checkFluidInventory(true) == null) {
            setActive(false);
            return;
        }

        if (progressTime == 0 && checkRecipes(true) == null) {
            setActive(false);
            if (this.cycleMode) {
                setDistance(String.valueOf(this.distance + this.step));
            }
        } else {
            Random random = this.getWorld().rand;

            setActive(true);

            if (progressTime == 0) {
                List<SpaceMiningRecipes.SpaceMiningRecipePartTwo> recipes = checkRecipes(false);
                Fluid fluid = checkFluidInventory(false);

                int averageProgress = 0;

                for (int x = 0; x < this.parallel; x++) {
                    int totalWeight = 0;
                    for (SpaceMiningRecipes.SpaceMiningRecipePartTwo i : recipes) {
                        totalWeight += i.getWeight();
                    }

                    int idx = 0;
                    for (int r = random.nextInt(totalWeight); idx <  recipes.size() - 1; ++idx) {
                        r -= recipes.get(idx).getWeight();
                        if (r <= 0)
                            break;
                    }

                    this.randomRecipes = recipes.get(idx);

                    averageProgress += this.randomRecipes.getDuration();
                    this.totalEUt += this.randomRecipes.getEUt();
                    this.totalComputation += this.randomRecipes.getComputation();

                    int randomStackSize = random.nextInt(this.randomRecipes.getMaxSize() - this.randomRecipes.getMinSize() + this.randomRecipes.getMinSize());

                    int totalWeight2 = 0;

                    for (Pair<Material, Integer> i : this.randomRecipes.getOutputs()) {
                        totalWeight2 += i.getValue();
                    }

                    int idx2 = 0;
                    for (int r = random.nextInt(totalWeight2); idx2 < this.randomRecipes.getOutputs().size() - 1; ++idx2) {
                        r -= this.randomRecipes.getOutputs().get(idx2).getValue();
                        if (r <= 0)
                            break;
                    }

                    if (!this.Whitelist.isEmpty()) {
                        for (int i = 0; i < this.Whitelist.size(); i++) {
                            if (this.Whitelist.get(i).equalsIgnoreCase(this.randomRecipes.getOutputs().get(idx2).getKey().getLocalizedName())) {
                                if (this.isWhitelist) {
                                    this.randomOutput.add(OreDictUnifier.get(OrePrefix.ore, this.randomRecipes.getOutputs().get(idx2).getKey(), randomStackSize));
                                    break;
                                } else continue;
                            }

                            if (i == this.Whitelist.size() - 1 && !this.isWhitelist) {
                                this.randomOutput.add(OreDictUnifier.get(OrePrefix.ore, this.randomRecipes.getOutputs().get(idx2).getKey(), randomStackSize));
                            }
                        }
                    } else {
                        this.randomOutput.add(OreDictUnifier.get(OrePrefix.ore, this.randomRecipes.getOutputs().get(idx2).getKey(), randomStackSize));
                    }

                    if (x == this.parallel - 1) {
                        if (fluid == Helium.getFluid()) {
                            setMaxProgress(averageProgress / this.parallel);
                        } else if (fluid == Bismuth.getFluid()) {
                            setMaxProgress(averageProgress / this.parallel / 2);
                        } else if (fluid == Radon.getFluid()) {
                            setMaxProgress(averageProgress / this.parallel / 4);
                        }
                    }
                }
            }

            if (this.randomRecipes == null || this.randomOutput == null) {
                progressTime = 0;
                return;
            }

            this.computationProvider.requestCWUt(this.totalComputation, false);
            drainEnergy(false, this.totalEUt);

            progressTime++;
            if (progressTime % getMaxProgress() != 0)
                return;
            progressTime = 0;

            if (cycleMode) {
                setDistance(String.valueOf(this.distance + this.step));
            }

            GTTransferUtils.addItemsToItemHandler(this.outputInventory, false, this.randomOutput);

            this.randomOutput.clear();
            this.totalEUt = 0;
            this.totalComputation = 0;

        }
    }

    public List<SpaceMiningRecipes.SpaceMiningRecipePartTwo> checkRecipes(boolean simulate) {

        ItemStack item = null;

        Material materialStick = null;
        Material materialDrill = null;

        int stickCount = 0;
        int drillCount = 0;

        final int neededSticks = STICK_INPUT_STACK_SIZE * this.parallel;
        final int neededDrills = DRILL_HEAD_INPUT_STACK_SIZE * this.parallel;

        for (int i = 0; i < getInputInventory().getSlots(); i++) {
            ItemStack slot = getInputInventory().getStackInSlot(i);
            if (ItemStack.areItemStacksEqual(slot, MINING_DRONE_1.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_2.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_3.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_4.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_5.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_6.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_7.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_8.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_9.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_10.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_11.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_12.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_13.getStackForm())
                    || ItemStack.areItemStacksEqual(slot, MINING_DRONE_14.getStackForm())) {
                item = slot;
                continue;
            }
            if (OreDictUnifier.getPrefix(slot) == OrePrefix.stick) {
                if (materialStick != null && materialStick != Objects.requireNonNull(OreDictUnifier.getMaterial(slot)).material) {
                    return null;
                }
                materialStick = Objects.requireNonNull(OreDictUnifier.getMaterial(slot)).material;
                stickCount += slot.getCount();

                continue;
            }

            if (OreDictUnifier.getPrefix(slot) == OrePrefix.toolHeadDrill) {
                if (materialDrill != null && materialDrill != Objects.requireNonNull(OreDictUnifier.getMaterial(slot)).material) {
                    return null;
                }
                materialDrill = Objects.requireNonNull(OreDictUnifier.getMaterial(slot)).material;
                drillCount += slot.getCount();
            }

            if (item != null && stickCount >= neededSticks && drillCount >= neededDrills)
                break;
        }

        if (stickCount < neededSticks || drillCount < neededDrills) {
            return null;
        } else {
            stickCount = neededSticks;
            drillCount = neededDrills;
        }

        if (materialStick != materialDrill || materialStick == null)
            return null;

        List<SpaceMiningRecipes.SpaceMiningRecipePartTwo> recipeBeforeCheck = SPACE_MINING_RECIPES.get(new SpaceMiningRecipes.SpaceMiningRecipePartOne(item, materialStick).hashCode());

        if (recipeBeforeCheck == null)
            return null;

        List<SpaceMiningRecipes.SpaceMiningRecipePartTwo> recipesAfterCheck = new ArrayList<>();

        for (SpaceMiningRecipes.SpaceMiningRecipePartTwo recipe : recipeBeforeCheck) {
            if (recipe != null) {
                if (this.moduleTier < recipe.getMinModuleTier()) {
                    continue;
                }

                if (!(this.minDistance <= recipe.getMaxDistance() && recipe.getMinDistance() <= this.maxDistance)) {
                    continue;
                }

                if (!drainEnergy(true, recipe.getEUt() * this.parallel)) {
                    continue;
                }

                if (this.computationProvider.requestCWUt(recipe.getComputation() * this.parallel, true) != recipe.getComputation() * this.parallel) {
                    continue;
                }

                recipesAfterCheck.add(recipe);

                if (simulate)
                    return recipesAfterCheck;

            }
        }

        if (recipesAfterCheck.isEmpty())
            return null;

        else {
            int currentStickCount = 0;
            int currentDrillCount = 0;
            for (int i = 0; i < getInputInventory().getSlots(); i++) {
                ItemStack item2 = getInputInventory().getStackInSlot(i);

                try {
                    if (currentStickCount != stickCount && OreDictUnifier.getPrefix(item2) == OrePrefix.stick && OreDictUnifier.getMaterial(item2).material == materialStick) {
                        currentStickCount += item2.getCount();
                        getInputInventory().extractItem(i, Math.min(item2.getCount(), stickCount), false);
                    }

                    if (currentDrillCount != drillCount && OreDictUnifier.getPrefix(item2) == OrePrefix.toolHeadDrill && OreDictUnifier.getMaterial(item2).material == materialDrill) {
                        currentDrillCount += item2.getCount();
                        getInputInventory().extractItem(i, Math.min(item2.getCount(), drillCount), false);
                    }

                } catch (NullPointerException ignored) {
                }

                if (currentStickCount >= stickCount && currentDrillCount >= drillCount)
                    break;

            }
            return recipesAfterCheck;
        }
    }

    private Fluid checkFluidInventory(boolean simulate) {
        FluidStack canDrainHelium = getInputFluidInventory().drain(Helium.getPlasma(1000 * this.parallel), false);
        FluidStack canDrainBismuth = getInputFluidInventory().drain(Bismuth.getPlasma(500 * this.parallel), false);
        FluidStack canDrainRadon = getInputFluidInventory().drain(Radon.getPlasma(300 * this.parallel), false);

        if (canDrainHelium != null || canDrainBismuth != null || canDrainRadon != null) {

            if (canDrainHelium != null && canDrainHelium.isFluidStackIdentical(Helium.getPlasma(1000 * this.parallel))) {
                if (!simulate) {
                    getFluidInventory().drain(Helium.getPlasma(1000 * this.parallel), true);
                }
                return Helium.getFluid();
            }

            if (canDrainBismuth != null && canDrainBismuth.isFluidStackIdentical(Bismuth.getPlasma(500 * this.parallel))) {
                if (!simulate) {
                    getFluidInventory().drain(Bismuth.getPlasma(500 * this.parallel), true);
                }
                return Bismuth.getFluid();
            }

            if (canDrainRadon != null && canDrainRadon.isFluidStackIdentical(Radon.getPlasma(300 * this.parallel))) {
                if (!simulate) {
                    getFluidInventory().drain(Radon.getPlasma(300 * this.parallel), true);
                }
                return Radon.getFluid();
            }
        }
        return null;
    }

    private IMultipleTankHandler getInputFluidInventory() {
        return this.inputFluidInventory;
    }

    private IItemHandlerModifiable getInputInventory() {
        return this.inputInventory;
    }

    @Override
    public IOpticalComputationProvider getComputationProvider() {
        return this.computationProvider;
    }

    @Override
    protected ModularUI.Builder createUITemplate(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 198, 238);

        builder.image(4, 4, 190, 147, GuiTextures.DISPLAY);
        builder.widget((new IndicatorImageWidget(174, 131, 17, 17, this.getLogo())).setWarningStatus(this.getWarningLogo(), this::addWarningText).setErrorStatus(this.getErrorLogo(), this::addErrorText));

        builder.label(9, 9, this.getMetaFullName(), 16777215);

        int size = 18;
        int padding = 3;

        builder.widget(new LabelWidget(120, 9 + (size + padding), "gtne.gui.mining_module.distance", 0xFF55FF));
        builder.widget(new TextFieldWidget2(170, 9 + (size + padding), size * size, size, this::getDistance, this::setDistance).setMaxLength(3).setAllowedChars(TextFieldWidget2.NATURAL_NUMS));

        builder.widget(new LabelWidget(120, 9 + 2 * (size + padding), "gtne.gui.mining_module.range", 0xFF55FF));
        builder.widget(new TextFieldWidget2(170, 9 + 2 * (size + padding), size * size, size, this::getRange, this::setRange).setMaxLength(3).setAllowedChars(TextFieldWidget2.NATURAL_NUMS));

        builder.widget(new LabelWidget(120, 9 + 3 * (size + padding), "gtne.gui.mining_module.step", 0xFF55FF));
        builder.widget(new TextFieldWidget2(170, 9 + 3 * (size + padding), size * size, size, this::getStep, this::setStep).setMaxLength(3).setAllowedChars(TextFieldWidget2.NATURAL_NUMS));

        builder.widget(new LabelWidget(120, 9 + 4 * (size + padding), "gtne.gui.mining_module.parallel", 0xFF55FF));
        builder.widget(new TextFieldWidget2(170, 9 + 4 * (size + padding), size * size, size, this::getParallel, this::setParallel).setMaxLength(1).setAllowedChars(TextFieldWidget2.NATURAL_NUMS));

        builder.widget(new TextFieldWidget2(9, (size + padding) + 11 * 5, size * size, size, this::getBlankName, this::addToWhiteList).setMaxLength(21).setAllowedChars(TextFieldWidget2.LETTERS));

        builder.widget(new TextFieldWidget2(9, (size + padding) + 11 * 7, size * size, size, this::getBlankRemoveName, this::removeFromWhitelist).setMaxLength(21).setAllowedChars(TextFieldWidget2.LETTERS));

        //Control
        builder.widget((new AdvancedTextWidget(9, (size + padding), this::addDisplayText, 16777215)).setMaxWidthLimit(181).setClickHandler(this::handleDisplayClick));
        IControllable controllable = this.getCapability(GregtechTileCapabilities.CAPABILITY_CONTROLLABLE, null);
        TextureArea area;
        BooleanSupplier booleanSupplier;
        if (controllable != null) {
            area = GuiTextures.BUTTON_POWER;
            Objects.requireNonNull(controllable);
            booleanSupplier = controllable::isWorkingEnabled;
            Objects.requireNonNull(controllable);
            builder.widget(new ImageCycleButtonWidget(173, 213, 18, 18, area, booleanSupplier, controllable::setWorkingEnabled));
            builder.widget(new ImageWidget(173, 231, 18, 6, GuiTextures.BUTTON_POWER_DETAIL));
        }

        //Clear or retrieve lists
        builder.widget(new ClickButtonWidget(173, 155, 18, 18, "", data -> printWhitelistOrClear(data, entityPlayer)).setButtonTexture(GuiTextures.BUTTON_CLEAR_GRID).setTooltipText("gtne.gui.mining_module.print_whitelist_or_clear"));

        //whitelist or blacklist
        builder.widget(new ImageCycleButtonWidget(173, 173, 18, 18, GTNETextures.BUTTON_WHITE_BLACK_LIST, this::getWhitelistMode, this::setWhitelistMode).setTooltipHoverString("gtne.gui.mining_module.change_whitelist_mode"));

        //Cycle mode
        builder.widget(new ImageCycleButtonWidget(173, 191, 18, 18, GTNETextures.BUTTON_CYCLE, this::getCycleMode, this::setCycleMode).setTooltipHoverString("gtne.gui.mining_module.cycle"));

        builder.bindPlayerInventory(entityPlayer.inventory, 155);
        return builder;

    }

    @Override
    protected void addDisplayText(List<ITextComponent> textlist) {
        MultiblockDisplayText.builder(textlist, this.isStructureFormed())
                .setWorkingStatus(isWorkingEnabled(), isActive())
                .addWorkingStatusLine()
                .addParallelsLine(this.MAX_PARALLEL)
                .addCustom(textList -> {
                    textList.add(TextComponentUtil.translationWithColor(TextFormatting.YELLOW, "gtne.gui.mining_module.min_distance", this.minDistance));
                    textList.add(TextComponentUtil.translationWithColor(TextFormatting.RED, "gtne.gui.mining_module.max_distance", this.maxDistance));
                })
                .addCustom(textList -> {
                    textList.add(TextComponentUtil.translationWithColor(this.isWhitelist ? TextFormatting.DARK_GREEN : TextFormatting.DARK_RED, this.isWhitelist ? "gtne.gui.mining_module.whitelist" : "gtne.gui.mining_module.blacklist"));
                })
                .addEmptyLine()
                .addCustom(textList -> {
                    textList.add(TextComponentUtil.translationWithColor(TextFormatting.RED, "gtne.gui.mining_module.remove"));
                })
                .addEmptyLine()
                .addProgressLine(getProgressPercent() / 100.000)
                .addEnergyUsageExactLine(this.totalEUt)
                .addComputationUsageExactLine(this.totalComputation);
    }

    private void printWhitelistOrClear(Widget.ClickData data, EntityPlayer entityPlayer) {

        if (this.Whitelist.isEmpty()) {
            entityPlayer.sendStatusMessage(TextComponentUtil.translationWithColor(TextFormatting.WHITE, "gtne.gui.mining_module." + (this.isWhitelist ? "whitelist_empty" : "blacklist_empty")), false);
            return;
        }

        if (data.isShiftClick) {
            this.Whitelist.clear();
            entityPlayer.sendStatusMessage(TextComponentUtil.translationWithColor(TextFormatting.WHITE, "gtne.gui.mining_module." + (this.isWhitelist ? "whitelist_cleared" : "blacklist_cleared")), false);
        } else {

            StringBuilder stringBuilder = new StringBuilder(I18n.format("gtne.gui.mining_module." + (this.isWhitelist ? "whitelist" : "blacklist")) + "\n");

            for (int i = 0; i < this.Whitelist.size(); i++) {
                stringBuilder.append(this.Whitelist.get(i));
                if (i != this.Whitelist.size() - 1) {
                    stringBuilder.append("\n");
                }
            }
            entityPlayer.sendStatusMessage(TextComponentUtil.stringWithColor(TextFormatting.WHITE, stringBuilder.toString()), false);

        }
    }

    private void addToWhiteList(String name) {
        if (!this.Whitelist.contains(name) && !Objects.equals(name, I18n.format("gtne.gui.mining_module.blank_name"))) {
            this.Whitelist.add(name);
        }
    }

    private void removeFromWhitelist(String name) {
        this.Whitelist.remove(name);
    }

    private String getBlankName() {
        return I18n.format("gtne.gui.mining_module.blank_name");
    }

    private String getBlankRemoveName() {
        return I18n.format("gtne.gui.mining_module.blank_name_remove");
    }

    private void setWhitelistMode(boolean bool) {
        this.isWhitelist = bool;
    }

    private boolean getWhitelistMode() {
        return this.isWhitelist;
    }

    private void setCycleMode(boolean bool) {
        this.cycleMode = bool;
    }

    private boolean getCycleMode() {
        return this.cycleMode;
    }

    private void setDistance(String distance) {
        try {
            int real = Integer.parseInt(distance);

            if (real > this.MAX_DISTANCE) {
                while (real > this.MAX_DISTANCE) {
                    real -= this.MAX_DISTANCE;
                }
            }
            this.distance = real;
            this.minDistance = Math.max(this.distance - this.range / 2, 0);
            this.maxDistance = Math.min(this.distance + this.range / 2, this.MAX_DISTANCE);
        } catch (NumberFormatException exception) {
            this.distance = 0;
            this.minDistance = Math.max(this.distance - this.range / 2, 0);
            this.maxDistance = Math.min(this.distance + this.range / 2, this.MAX_DISTANCE);
        }
    }

    private String getDistance() {
        return String.valueOf(this.distance);
    }

    private void setRange(String range) {
        try {
            if (Integer.parseInt(range) > this.MAX_RANGE) {
                this.range = 0;
                this.minDistance = this.distance;
                this.maxDistance = this.distance;
            } else {
                this.range = Integer.parseInt(range);
                this.minDistance = Math.max(this.distance - this.range / 2, 0);
                this.maxDistance = Math.min(this.distance + this.range / 2, this.MAX_DISTANCE);
            }
        } catch (NumberFormatException exception) {
            this.range = 0;
            this.minDistance = this.distance;
            this.maxDistance = this.distance;
        }
    }

    private String getRange() {
        return String.valueOf(this.range);
    }

    private void setStep(String step) {
        try {
            this.step = Integer.parseInt(step);
        } catch (NumberFormatException exception) {
            this.step = 0;
        }
    }

    private String getStep() {
        return String.valueOf(this.step);
    }

    private void setParallel(String parallel) {
        try {
            int real = Integer.parseInt(parallel);
            if (real < 1)
                this.parallel = 1;
            else this.parallel = Math.min(real, this.MAX_PARALLEL);
        } catch (NumberFormatException exception) {
            this.parallel = 1;
        }
    }

    private String getParallel() {
        return String.valueOf(this.parallel);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("distance", this.distance);
        data.setInteger("minDistance", this.minDistance);
        data.setInteger("range", this.range);
        data.setInteger("step", this.step);
        data.setInteger("parallel", this.parallel);
        data.setBoolean("cycle", this.cycleMode);
        data.setBoolean("isWhitelist", this.isWhitelist);

            NBTTagList nbtTagList = new NBTTagList();

            for (String string : this.Whitelist) {
                NBTTagCompound tag = new NBTTagCompound();

                tag.setString("material", string);
                nbtTagList.appendTag(tag);
            }

            data.setInteger("whitelist_size", this.Whitelist.size());
            data.setTag("whitelist", nbtTagList);

        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.distance = data.getInteger("distance");
        this.minDistance = data.getInteger("minDistance");
        this.maxDistance = data.getInteger("maxDistance");
        this.range = data.getInteger("range");
        this.step = data.getInteger("step");
        this.parallel = data.getInteger("parallel");
        this.cycleMode = data.getBoolean("cycle");
        this.isWhitelist = data.getBoolean("isWhitelist");

        if (data.getInteger("whitelistSize") > 0) {
            NBTTagList nbtTagList = data.getTagList("whitelist", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < data.getInteger("whitelistSize"); i++) {
                NBTTagCompound tag = nbtTagList.getCompoundTagAt(i);
                this.Whitelist.add(tag.getString("material"));
            }
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buffer) {
        super.writeInitialSyncData(buffer);
        buffer.writeInt(this.distance);
        buffer.writeInt(this.minDistance);
        buffer.writeInt(this.maxDistance);
        buffer.writeInt(this.range);
        buffer.writeInt(this.step);
        buffer.writeInt(this.parallel);
        buffer.writeBoolean(this.cycleMode);
        buffer.writeBoolean(this.isWhitelist);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buffer) {
        super.receiveInitialSyncData(buffer);
        this.distance = buffer.readInt();
        this.minDistance = buffer.readInt();
        this.maxDistance = buffer.readInt();
        this.range = buffer.readInt();
        this.step = buffer.readInt();
        this.parallel = buffer.readInt();
        this.cycleMode = buffer.readBoolean();
        this.isWhitelist = buffer.readBoolean();
    }
}
