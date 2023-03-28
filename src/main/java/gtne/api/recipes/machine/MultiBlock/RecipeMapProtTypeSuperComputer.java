package gtne.api.recipes.machine.MultiBlock;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gtne.api.gui.GTNEGuiTextures;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

public class RecipeMapProtTypeSuperComputer <R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapProtTypeSuperComputer(String unlocalizedName,
                                                  int minInputs, int maxInputs, int minOutputs, int maxOutputs,
                                                  int minFluidInputs, int maxFluidInputs, int minFluidOutputs, int maxFluidOutputs,
                                                  R defaultRecipe, boolean isHidden) {
        super(unlocalizedName, minInputs, maxInputs, minOutputs, maxOutputs, minFluidInputs, maxFluidInputs, minFluidOutputs, maxFluidOutputs, defaultRecipe, isHidden);
    }

    @Override
    @Nonnull
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 200)
                .widget(new ProgressWidget(200, 14, 27, 117, 63, GTNEGuiTextures.PROGRESSBAR_PROTTYPE_SUPERCOMPUTER, ProgressWidget.MoveType.HORIZONTAL));
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
        int startInputsX = 94 - itemSlotsToLeft * 13;
        int startInputsY = 27;

        if (!isOutputs) {
            for (int i = 0; i < itemSlotsToDown; i++) {
                for (int j = 0; j < itemSlotsToLeft; j++) {
                    int slotIndex = i * itemSlotsToLeft + j;
                    if (i == 1) {
                        addSlot(builder, 14, 9, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                    }
                    if (i == 2) {
                        addSlot(builder, 6, 90, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                    }
                    if (i == 3) {
                        addSlot(builder, 24, 90, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                    }
                    if (i > 3 && i < 7) {
                        addSlot(builder, startInputsX - (18 * (i- 3)), startInputsY, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                    }
                    if (i > 6 && i < 10) {
                        addSlot(builder, startInputsX - (18 * (i - 6)), startInputsY + 18, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                    }
                    if (i > 9 && i < 13) {
                        addSlot(builder, startInputsX - (18 * (i - 9)), startInputsY + 36, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                    }
                }
            }
            if (fluidInputsCount > 0 || invertFluids) {
                if (itemSlotsToDown >= fluidInputsCount) {
                    for (int i = 0; i < fluidInputsCount; i++) {
                        addSlot(builder, startInputsX - (i * 18), 90, i, itemHandler, fluidHandler, true, false);
                    }
                }
            }
        } else {
            addSlot(builder, 131, 45, 0, itemHandler, fluidHandler, invertFluids, true);
            addSlot(builder, 131, 90, 0, itemHandler, fluidHandler, true, true);
            addSlot(builder, 149, 90, 0, itemHandler, fluidHandler, true, true);
        }
    }
}
