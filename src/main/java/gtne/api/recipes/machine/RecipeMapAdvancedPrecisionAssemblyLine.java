package gtne.api.recipes.machine;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import net.minecraftforge.items.IItemHandlerModifiable;
import gtne.api.gui.GTNEGuiTextures;

import javax.annotation.Nonnull;


public class RecipeMapAdvancedPrecisionAssemblyLine<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapAdvancedPrecisionAssemblyLine(String unlocalizedName,
                                                  int minInputs, int maxInputs, int minOutputs, int maxOutputs,
                                                  int minFluidInputs, int maxFluidInputs, int minFluidOutputs, int maxFluidOutputs,
                                                  R defaultRecipe, boolean isHidden) {
        super(unlocalizedName, minInputs, maxInputs, minOutputs, maxOutputs, minFluidInputs, maxFluidInputs, minFluidOutputs, maxFluidOutputs, defaultRecipe, isHidden);
    }

    @Override
    @Nonnull
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 200, 200)
                .widget(new ProgressWidget(200, 80, 1, 72, 90, GTNEGuiTextures.PROGRESSBAR_ADVANDED_PRECISION_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, @Nonnull IItemHandlerModifiable itemHandler, @Nonnull FluidTankList fluidHandler, boolean isOutputs, int yOffset) {
        int itemInputsCount = itemHandler.getSlots();
        int fluidInputsCount = fluidHandler.getTanks();
        boolean invertFluids = false;
        if(itemInputsCount == 0) {
            int tmp = itemInputsCount;
            itemInputsCount = fluidInputsCount;
            fluidInputsCount = tmp;
            invertFluids = true;
        }
        int[] inputSlotGrid = determineSlotsGrid(itemInputsCount);
        int itemSlotsToLeft = inputSlotGrid[0];
        int itemSlotsToDown = inputSlotGrid[1];
        int startInputsX = 80 - itemSlotsToLeft * 21;
        int startInputsY = 37 - (int) (itemSlotsToDown / 2.0 * 21);

        if(!isOutputs) {
            for (int i = 0; i < itemSlotsToDown; i++) {
                for (int j = 0; j < itemSlotsToLeft; j++) {
                    int slotIndex = i * itemSlotsToLeft + j;
                    addSlot(builder, startInputsX + 22 * j, startInputsY + 22 * i, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                }
            }
            if (fluidInputsCount > 0 || invertFluids) {
                if (itemSlotsToDown >= fluidInputsCount) {
                    int startSpecX = startInputsX + 18 * 5;
                    for (int i = 0; i < fluidInputsCount; i++) {
                        addSlot(builder, startSpecX, startInputsY + 22 * i, i, itemHandler, fluidHandler, true, false);
                    }
                }
            }
        } else {
            addSlot(builder,startInputsX + 22 * 4, 1, 0, itemHandler, fluidHandler, invertFluids, true);
        }
    }
}
