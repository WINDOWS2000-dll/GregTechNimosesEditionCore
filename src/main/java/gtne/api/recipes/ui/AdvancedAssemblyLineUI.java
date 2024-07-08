package gtne.api.recipes.ui;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.ui.RecipeMapUI;
import gtne.api.gui.GTNEGuiTextures;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Internal
public final class AdvancedAssemblyLineUI <R extends RecipeMap<?>> extends RecipeMapUI<R> {

    public AdvancedAssemblyLineUI(@NotNull R recipeMap) {
        super(recipeMap, false, false, false, false);
        setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
    }

    @Override
    @NotNull
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems,
                                                 FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 200)
                .widget(new ProgressWidget(200, 90, 3, 72, 90, GTNEGuiTextures.PROGRESSBAR_ADVANDED_PRECISION_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(@NotNull ModularUI.Builder builder,
                                         @NotNull IItemHandlerModifiable itemHandler,
                                         @NotNull FluidTankList fluidHandler, boolean isOutput, int yOffset) {
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

        if (!isOutput) {
            //Data Slot
            builder.widget(new SlotWidget(itemHandler, 16, startInputsX + 18 * 4, 3 + 18 * 2, true, true)
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

}
