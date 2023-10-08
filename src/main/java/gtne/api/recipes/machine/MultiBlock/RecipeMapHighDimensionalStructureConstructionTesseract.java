package gtne.api.recipes.machine.MultiBlock;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gtne.api.gui.GTNEGuiTextures;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class RecipeMapHighDimensionalStructureConstructionTesseract <R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapHighDimensionalStructureConstructionTesseract(String unlocalizedName, int maxInputs, boolean modifyItemInputs, int maxOutputs, boolean modifyItemOutputs,
                                                                  int maxFluidInputs, boolean modifyFluidInputs, int maxFluidOutputs, boolean modifyFluidOutputs, R defaultRecipe, boolean isHidden) {
        super(unlocalizedName, maxInputs, modifyItemInputs, maxOutputs, modifyItemOutputs, maxFluidInputs, modifyFluidInputs, maxFluidOutputs, modifyFluidOutputs, defaultRecipe, isHidden);
    }

    @Override
    @NotNull
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable expoteItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 400)
                .widget(new ProgressWidget(200, 18, 11, 139, 170, GTNEGuiTextures.PROGRESSBAR_HDSCT, ProgressWidget.MoveType.HORIZONTAL));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, expoteItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, @Nonnull IItemHandlerModifiable itemHandler, @Nonnull FluidTankList fluidHandler, boolean isOutputs, int yOffset) {
        //開始位置X座標(アイテムスロット)
        int startInputX = 10;
        //ようわからん
        int fluidInputsCount = fluidHandler.getTanks();
        //開始位置Y座標（アイテムスロット）
        int startInputY = 10;

        if (!isOutputs) {
            //Item Slot
            //アイテムスロットのスロット数（縦列）
            for (int i = 0; i < 6; i++) {
                //アイテムスロットのスロット数（横列）
                for (int j = 0; j < 6; j++) {
                    //スロット番号
                    int slotIndex = i * 6 + j;
                    //ビルダー
                    addSlot(builder, startInputX + 18 * j, startInputY + 18 * i, slotIndex, itemHandler, fluidHandler, false, false);
                }
            }

            //Fluid Slot
            //開始位置Y座標（液体）
            int startFluidY = (startInputY * 12) + 8;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 6; j++) {
                        int SlotIndexFluid = i * 6 + j;
                        if (i < 2) {
                            //液体スロットビルダー（isFluidのパラメーターをtrueで指定）
                            addSlot(builder, startInputX + 18 * j, startFluidY + 18 * i, SlotIndexFluid, itemHandler, fluidHandler, true, false);
                        }
                        if (i >= 2) {
                            addSlot(builder, startInputX + 18 * j, (startFluidY + 53) * (i - 2), SlotIndexFluid, itemHandler, fluidHandler, true, false);
                        }
                    }
                }

        } else {
            //Output Slot
            //出力スロット（isOutputsのパラメーターをtrueで指定）
            addSlot(builder, 157, 10, 0, itemHandler, fluidHandler, false, true);
        }
    }
}
