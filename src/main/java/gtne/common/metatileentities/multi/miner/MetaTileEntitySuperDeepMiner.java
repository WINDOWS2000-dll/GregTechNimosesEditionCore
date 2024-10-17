package gtne.common.metatileentities.multi.miner;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import cofh.thermalfoundation.init.TFFluids;
import gregicality.multiblocks.api.capability.impl.GCYMMultiblockRecipeLogic;
import gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import gtne.api.metatileentity.multiblock.GTNESuperDeepMinerMultiBlockController;
import gtne.api.recipes.properties.GTNETemperatureProperty;
import gtne.api.unification.material.GTNEMaterials;
import gtne.common.metatileentities.GTNEMetaTileEntities;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MetaTileEntitySuperDeepMiner extends GTNESuperDeepMinerMultiBlockController implements IHeatingCoil {

    protected final MetaTileEntity metaTileEntity;

    private final float TEMPERATURE_DURATION_MULTIPLIER = 1.11F;

    private final float TEMPERATURE_DURATION_MULTIPLIER_INVERSE = 0.99F;

    private int currentTemperature;

    private int maxTemperature;

    private int fluidType = 0;

    public MetaTileEntitySuperDeepMiner(ResourceLocation metaTileEntity, RecipeMap<?> recipeMap, boolean isParallel) {
        super(metaTileEntity, recipeMap, isParallel);
        this.recipeMapWorkable = new MetaTileEntitySuperDeepMiner.SuperDeepMinerRecipeLogic(this);
        this.metaTileEntity = this;
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("###########", "##X#####X##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "##X#####X##", "##X#####X##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "XXXFFFFFXXX", "#XXFFFFFXX#", "##X#####X##", "##F#####F##", "##F#####F##", "##F#####F##", "##F#####F##", "##XXFFFXX##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###YYYYY###", "##F     F##", "##F     F##", "###FXEXO###", "###########", "###########", "###########", "###########", "##XXXXXXX##", "###GGUGG###", "##### #####", "##### #####", "##### #####", "##### #####", "###########", "###########", "###########")
                .aisle("###Y###Y###", "##F     F##", "##F     F##", "###XTTTO###", "####XMX####", "####HHH####", "####HHH####", "####HHH####", "##LXXXXXL##", "###GF#FG###", "####F F####", "####F F####", "####F F####", "####F F####", "###########", "###########", "###########")
                .aisle("###Y#P#Y###", "##F  P  F##", "##F  P  F##", "###FTPTO###", "####XPX####", "####HPH####", "####HPH####", "####HPH####", "##LXXPXXL##", "###U#P#U###", "     P     ", "     P     ", "     P     ", "     P     ", "     F     ", "     F     ", "     F     ")
                .aisle("###Y###Y###", "##F     F##", "##F     F##", "###XTTTO###", "####XSX####", "####HHH####", "####HHH####", "####HHH####", "##LXXXXXL##", "###GF#FG###", "####F F####", "####F F####", "####F F####", "####F F####", "###########", "###########", "###########")
                .aisle("###YYYYY###", "##F     F##", "##F     F##", "###FXIXO###", "###########", "###########", "###########", "###########", "##XXXXXXX##", "###GGUGG###", "##### #####", "##### #####", "##### #####", "##### #####", "###########", "###########", "###########")
                .aisle("###########", "XXXFFFFFXXX", "#XXFFFFFXX#", "##X#####X##", "##F#####F##", "##F#####F##", "##F#####F##", "##F#####F##", "##XXFFFXX##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "##X#####X##", "##X#####X##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "##X#####X##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .where(' ', air())
                .where('#', any())
                .where('T', tieredCasing())
                .where('S', selfPredicate())
                .where('H', heatingCoils())
                .where('P', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE)))
                .where('Y', states(MetaBlocks.WARNING_SIGN.getState(BlockWarningSign.SignType.YELLOW_STRIPES)))
                .where('X', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)))
                .where('F', states(MetaBlocks.FRAMES.get(Materials.Steel).getBlock(Materials.Steel)))
                .where('G', states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING)))
                .where('I', abilities(MultiblockAbility.IMPORT_ITEMS))
                .where('O', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where('F', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('L', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('U', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('M', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .build();
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("###########", "##X#####X##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "##X#####X##", "##X#####X##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "XXXFFFFFXXX", "#XXFFFFFXX#", "##X#####X##", "##F#####F##", "##F#####F##", "##F#####F##", "##F#####F##", "##XXFFFXX##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###YYYYY###", "##F#####F##", "##F#####F##", "###FXEXO###", "###########", "###########", "###########", "###########", "##XXXXXXX##", "###GGUGG###", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###Y###Y###", "##F#####F##", "##F#####F##", "###XTTTO###", "####XMX####", "####HHH####", "####HHH####", "####HHH####", "##QXXXXXL##", "###GF#FG###", "####F#F####", "####F#F####", "####F#F####", "####F#F####", "###########", "###########", "###########")
                .aisle("###Y#P#Y###", "##F##P##F##", "##F##P##F##", "###FTPTO###", "####XPX####", "####HPH####", "####HPH####", "####HPH####", "##QXXPXXL##", "###U#P#U###", "#####P#####", "#####P#####", "#####P#####", "#####P#####", "#####F#####", "#####F#####", "#####F#####")
                .aisle("###Y###Y###", "##F#####F##", "##F#####F##", "###XTTTO###", "####XSX####", "####HHH####", "####HHH####", "####HHH####", "##QXXXXXL##", "###GF#FG###", "####F#F####", "####F#F####", "####F#F####", "####F#F####", "###########", "###########", "###########")
                .aisle("###YYYYY###", "##F#####F##", "##F#####F##", "###FXIXO###", "###########", "###########", "###########", "###########", "##XXXXXXX##", "###GGUGG###", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "XXXFFFFFXXX", "#XXFFFFFXX#", "##X#####X##", "##F#####F##", "##F#####F##", "##F#####F##", "##F#####F##", "##XXFFFXX##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "##X#####X##", "##X#####X##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .aisle("###########", "##X#####X##", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########", "###########")
                .where('P', MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE))
                .where('Y', MetaBlocks.WARNING_SIGN.getState(BlockWarningSign.SignType.YELLOW_STRIPES))
                .where('X', MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                .where('F', MetaBlocks.FRAMES.get(Materials.Steel).getBlock(Materials.Steel))
                .where('G', MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.MV], EnumFacing.SOUTH)
                .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.MV], EnumFacing.WEST)
                .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.MV], EnumFacing.EAST)
                .where('L', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.MV], EnumFacing.WEST)
                .where('Q', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.MV], EnumFacing.EAST)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.MV], EnumFacing.NORTH)
                .where('M', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.NORTH)
                .where('U', MetaTileEntities.MUFFLER_HATCH[GTValues.MV], EnumFacing.UP)
                .where('#', Blocks.AIR.getDefaultState())
                .where('S', GTNEMetaTileEntities.SUPER_DEEP_MINER, EnumFacing.SOUTH)
                .where('T', GCYMMetaTileEntities.TIERED_HATCH[2], EnumFacing.DOWN);
        GregTechAPI.HEATING_COILS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                .forEach(entry -> shapeInfo.add(builder.where('H', entry.getKey()).build()));

        return shapeInfo;

    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player,
                               List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.1"));
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.2"));
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.3"));
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.4"));
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.5"));
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.6"));
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.11"));
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.7"));
        tooltip.add(I18n.format("gtne.machine.super_deep_miner.tooltip.8", TEMPERATURE_DURATION_MULTIPLIER_INVERSE));
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (this.isStructureFormed() && !this.hasMaintenanceProblems()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.universal.vom.temperature", getCurrentTemperature()));
            textList.add(new TextComponentTranslation("gregtech.multiblock.super_deep_miner.max.temperature", getMaxTemperature()));
            textList.add(new TextComponentTranslation("gregtech.multiblock.super_deep_miner.max.fluid consumption", this.recipeMapWorkable.isActive() && getCurrentTemperature() == getMaxTemperature() ? getHeatingFluidActiveMax(getFluidType()).amount : getHeatingFluid(getFluidType()).amount));
        }
        if (this.getPos().getY() > 8 && !this.getWorld().isRemote) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.deep_miner_error"));
        }
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats) {
            this.maxTemperature = (int) (((IHeatingCoilBlockStats) type).getCoilTemperature() * getTemperatureModifierFromFluidType(getFluidType()));
        } else {
            this.maxTemperature = BlockWireCoil.CoilType.CUPRONICKEL.getCoilTemperature();
        }
    }

    @Override
    protected void updateFormedValid() {
        super.updateFormedValid();

        if (this.recipeMapWorkable.isWorkingEnabled() && checkHeatingFluid() && getCurrentTemperature() <= getMaxTemperature()) {
            if (getOffsetTimer() % 20 == 0) {
                if (getCurrentTemperature() < getMaxTemperature()) {
                    drainHeatingFluid();
                    increaseTemperature();
                }
                else if (getCurrentTemperature() == getMaxTemperature() && this.recipeMapWorkable.isActive()) {
                    drainHeatingFluidActiveMax();
                }
                else {
                    if (!this.isActive())
                        decreaseTemperature();
                }
            }
        }
        else {
            if (getOffsetTimer() % 20 == 0 && getCurrentTemperature() != 0 && !this.recipeMapWorkable.isActive()) {
                decreaseTemperature();
            }
        }
    }

    /**
     * Pyrotheum使用量算出式
     */
    int pyrotheumFluidAmount = (int) (Math.pow(2, 1.5 * GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage())));

    protected FluidStack getHeatingFluid(int fluidType) {
        return switch (fluidType) {
            case 0  ->
                Materials.Lava.getFluid(4 * (int) (Math.pow(2, 1.5 * GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage()))));

            case 1  ->
                    new FluidStack(TFFluids.fluidPyrotheum, pyrotheumFluidAmount);

            case 2  ->
                Materials.Helium.getFluid(FluidStorageKeys.PLASMA, (int) (4 * Math.pow(2, GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage()))));

            default -> GTNEMaterials.CosmicNeutronium.getFluid(FluidStorageKeys.PLASMA,(int) (2 * Math.pow(2, GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage()))));

        };
    }

    int pyrotheumFluidActiveAmount = (int) (Math.pow(2, 1.5 * GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage())) / 10.0);

    protected FluidStack getHeatingFluidActiveMax(int fluidType) {
        return switch (fluidType) {
            case 0 ->
                    Materials.Lava.getFluid(4 * (int) (Math.pow(2, 1.5 * GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage())) / 10.0));

            case 1 ->
                new FluidStack(TFFluids.fluidPyrotheum, pyrotheumFluidActiveAmount);
            case 2 ->
                    Materials.Helium.getFluid(FluidStorageKeys.PLASMA, (int) (4 * Math.pow(2, GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage())) / 10.0));

            default -> GTNEMaterials.CosmicNeutronium.getFluid(FluidStorageKeys.PLASMA,(int) (2 * Math.pow(2, GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage())) / 10.0));

        };
    }

    protected boolean checkHeatingFluid() {
        IMultipleTankHandler inputTank = this.getInputFluidInventory();
        return getHeatingFluid(getFluidType()).isFluidStackIdentical(inputTank.drain(getHeatingFluid(getFluidType()), false));
    }

    protected void drainHeatingFluid() {
        this.getInputFluidInventory().drain(getHeatingFluid(getFluidType()), true);
    }

    protected void drainHeatingFluidActiveMax() {
        this.getInputFluidInventory().drain(getHeatingFluidActiveMax(getFluidType()), true);
    }

    protected void increaseTemperature() {
        if (getCurrentTemperature() < getMaxTemperature()) {
            int tTemperature = this.currentTemperature;
            tTemperature += (int) (Math.max(((getMaxTemperature() - getCurrentTemperature()) / 20.0), 5) * getModifierFromFluidType(getFluidType()));
            this.currentTemperature = Math.min(tTemperature, getMaxTemperature());
        }
    }

    protected void decreaseTemperature() {
        if (getCurrentTemperature() > 0) {
            int tTemperature = this.currentTemperature;
            tTemperature -= Math.max((int) (getCurrentTemperature() / 20.0), 5);
            this.currentTemperature = Math.max(tTemperature, 0);
        }
    }

    protected double getModifierFromFluidType(int type) {
        return switch (type) {
            case 0  -> 0.5;
            case 1  -> 1.0;
            case 2  -> 4.0;
            default -> 16.0;
        };
    }

    protected double getTemperatureModifierFromFluidType(int type) {
        return switch (type) {
            case 0  -> 0.75;
            case 1  -> 1.0;
            case 2  -> 4.0;
            default -> 16.0;
        };
    }

    @Override
    public boolean onScrewdriverClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
                                      CuboidRayTraceResult hitResult) {
        if (!getWorld().isRemote && !this.isActive()) {
            if (fluidType == 0) {
                fluidType = 1;
                playerIn.sendStatusMessage(
                        new TextComponentTranslation("gtne.machine.super_deep_miner.config.1"), false);
                invalidateStructure();
            } else if (fluidType == 1) {
                fluidType = 2;
                playerIn.sendStatusMessage(
                        new TextComponentTranslation("gtne.machine.super_deep_miner.config.2"), false);
                invalidateStructure();
                this.createStructurePattern();
            }
            else if (fluidType == 2) {
                fluidType = 3;
                playerIn.sendStatusMessage(
                        new TextComponentTranslation("gtne.machine.super_deep_miner.config.3"), false);
                this.createStructurePattern();
                invalidateStructure();
            }
            else {
                fluidType = 0;
                playerIn.sendStatusMessage(
                        new TextComponentTranslation("gtne.machine.super_deep_miner.config.0"), false);
                this.createStructurePattern();
                invalidateStructure();
            }
        }
        return true;
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.currentTemperature = 0;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return switch (fluidType) {
            default -> Textures.SOLID_STEEL_CASING;
        };
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntitySuperDeepMiner(metaTileEntityId, this.recipeMap, this.isParallel());
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.LARGE_MINER_OVERLAY_BASIC;
    }

    @Override
    public int getCurrentTemperature() {
        return this.currentTemperature;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    public int getMaxTemperature() {
        return this.maxTemperature;
    }

    public int getFluidType() {
        return this.fluidType;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setTag("temperature", new NBTTagInt(getCurrentTemperature()));
        data.setTag("fluidtype", new NBTTagInt(getFluidType()));
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        currentTemperature = data.getInteger("temperature");
        fluidType = data.getInteger("fluidtype");
    }

    private class SuperDeepMinerRecipeLogic extends GCYMMultiblockRecipeLogic {

        private final MetaTileEntitySuperDeepMiner superDeepMiner;

        public SuperDeepMinerRecipeLogic(GTNESuperDeepMinerMultiBlockController metaTileEntity) {
            super(metaTileEntity);
            this.superDeepMiner = (MetaTileEntitySuperDeepMiner) metaTileEntity;
        }

        @Override
        public boolean checkRecipe(Recipe recipe) {
            if (!super.checkRecipe(recipe))
                return false;

            if (superDeepMiner.getPos().getY() > 10)
                return false;

            return recipe.getProperty(GTNETemperatureProperty.getInstance(), 0) <= superDeepMiner.getCurrentTemperature();
        }

        @Deprecated
        @Override
        protected void modifyOverclockPre(int @NotNull [] values, @NotNull IRecipePropertyStorage storage) {
            super.modifyOverclockPre(values, storage);

            int recipeTemperature = storage.getRecipePropertyValue(GTNETemperatureProperty.getInstance(), 0);
            int temperatureDiff = superDeepMiner.getCurrentTemperature() - recipeTemperature;
            double durationModifier = temperatureDiff / 1000 < 1 ? 1 : TEMPERATURE_DURATION_MULTIPLIER * (temperatureDiff / 1000);
            int recipeDuration = (int) (values[1] / durationModifier);

            values[1] = recipeDuration;
        }

    }

}
