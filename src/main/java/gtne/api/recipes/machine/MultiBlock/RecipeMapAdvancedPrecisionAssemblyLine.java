package gtne.api.recipes.machine.MultiBlock;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.machines.IResearchRecipeMap;
import gregtech.api.recipes.recipeproperties.ResearchProperty;
import gregtech.api.recipes.recipeproperties.ResearchPropertyData;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraftforge.items.IItemHandlerModifiable;
import gtne.api.gui.GTNEGuiTextures;
import gtne.api.recipes.GTNERecipeMaps;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;


public class RecipeMapAdvancedPrecisionAssemblyLine<R extends RecipeBuilder<R>> extends RecipeMap<R> implements IResearchRecipeMap {

    private final Map<String, Collection<Recipe>> researchEntries = new Object2ObjectOpenHashMap<>();

    public RecipeMapAdvancedPrecisionAssemblyLine(String unlocalizedName,
                                                  int maxInputs,  int maxOutputs,
                                                   int maxFluidInputs,  int maxFluidOutputs,
                                                  R defaultRecipe, boolean isHidden) {
        super(unlocalizedName,  maxInputs,  maxOutputs,  maxFluidInputs, maxFluidOutputs, defaultRecipe, isHidden);
    }

    @Override
    @Nonnull
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 200)
                .widget(new ProgressWidget(200, 90, 3, 72, 90, GTNEGuiTextures.PROGRESSBAR_ADVANDED_PRECISION_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, @Nonnull IItemHandlerModifiable itemHandler, @Nonnull FluidTankList fluidHandler, boolean isOutputs, int yOffset) {
        int itemInputsCount = itemHandler.getSlots();
        int fluidInputsCount = fluidHandler.getTanks();
        boolean invertFluids = false;
        if (itemInputsCount == 0) {
            int tmp = itemInputsCount;
            itemInputsCount = fluidInputsCount;
            fluidInputsCount = tmp;
            invertFluids = true;
        }
        int[] inputSlotGrid = determineSlotsGrid(itemInputsCount);
        int itemSlotsToLeft = inputSlotGrid[0];
        int itemSlotsToDown = inputSlotGrid[1];
        int startInputsX = 105 - itemSlotsToLeft * 21;
        int startInputsY = 45 - (int) (itemSlotsToDown / 2.0 * 21);

        if (!isOutputs) {
            //Data Slot
            builder.widget(new SlotWidget(itemHandler, 20, startInputsX + 18 * 4, 3 + 18 * 2, true, true)
                    .setBackgroundTexture(GuiTextures.SLOT, GuiTextures.DATA_ORB_OVERLAY));

            for (int i = 0; i < itemSlotsToDown; i++) {
                for (int j = 0; j < itemSlotsToLeft; j++) {
                    int slotIndex = i * itemSlotsToLeft + j;
                    addSlot(builder, startInputsX + 18 * j, startInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                }
            }
            if (fluidInputsCount > 0 || invertFluids) {
                if (itemSlotsToDown <= fluidInputsCount) {
                    for (int i = 0; i < fluidInputsCount; i++) {
                        if (i <= 4) {
                            addSlot(builder, (startInputsX + 21 * 5) + 3, startInputsY + 18 * i, i, itemHandler, fluidHandler, true, false);
                        }
                        if (i >= 5) {
                            addSlot(builder, (startInputsX + 21 * 8) - 42, (startInputsY + 18 * i) - 90, i, itemHandler, fluidHandler, true, false);
                        }
                    }
                }
            }
        } else {
            addSlot(builder, startInputsX + 18 * 4, 3, 0, itemHandler, fluidHandler, invertFluids, true);
        }
    }

    @Override
    public boolean compileRecipe(Recipe recipe) {
        if (!super.compileRecipe(recipe)) return false;
        if (recipe.hasProperty(ResearchProperty.getInstance())) {
            ResearchPropertyData data = recipe.getProperty(ResearchProperty.getInstance(), null);
            if (data != null) {
                for (ResearchPropertyData.ResearchEntry entry : data) {
                    addDataStickEntry(entry.getResearchId(), recipe);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean removeRecipe(@Nonnull Recipe recipe) {
        if (!super.removeRecipe(recipe)) return false;
        if (recipe.hasProperty(ResearchProperty.getInstance())) {
            ResearchPropertyData data = recipe.getProperty(ResearchProperty.getInstance(), null);
            if (data != null) {
                for (ResearchPropertyData.ResearchEntry entry : data) {
                    return removeDataStickEntry(entry.getResearchId(), recipe);
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public void addDataStickEntry(@Nonnull String researchId, @Nonnull Recipe recipe) {
        Collection<Recipe> collection = researchEntries.computeIfAbsent(researchId, (k) -> new ObjectOpenHashSet<>());
        collection.add(recipe);
    }

    @Nullable
    @Override
    public Collection<Recipe> getDataStickEntry(@Nonnull String researchId) {
        return researchEntries.get(researchId);
    }

    @Override
    public boolean removeDataStickEntry(@Nonnull String researchId, @Nonnull Recipe recipe) {
        Collection<Recipe> collection = researchEntries.get(researchId);
            if (collection == null) return false;
            if (collection.remove(recipe)) {
                if (collection.isEmpty()) {
                    return researchEntries.remove(researchId) != null;
            }
            return true;
        }
        return false;
    }
}
