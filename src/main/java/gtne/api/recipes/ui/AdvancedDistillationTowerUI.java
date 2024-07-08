package gtne.api.recipes.ui;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.gui.widgets.TankWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.ui.RecipeMapUI;
import gtne.api.gui.GTNEGuiTextures;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;

public class AdvancedDistillationTowerUI<R extends RecipeMap<?>> extends RecipeMapUI<R> {

    public AdvancedDistillationTowerUI(@NotNull R recipeMap) {
        super(recipeMap, true, true, true, false);
    }

    /**
     * JEI(HEI)に表示するUIのテンプレート作成を行うコード
     * @param importItems 入力アイテムの受け渡し
     * @param exportItems 出力アイテムの受け渡し
     * @param importFluids 入力流体の受け渡し
     * @param exportFluids　出力流体の受け渡し
     * @param yOffset テンプレートのy軸開始位置
     * @return 作成されたUIのテンプレート(default Builder)
     */
    @Override
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems,
                                                 FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder UIbuilder = ModularUI.defaultBuilder(yOffset);
        UIbuilder.widget(new ProgressWidget(200, 18, 17, 56, 63,
                GTNEGuiTextures.PROGRESSBAR_ADVANCED_DISTILLATION_TOWER, ProgressWidget.MoveType.HORIZONTAL));
        addInventorySlotGroup(UIbuilder, importItems, importFluids, false, yOffset);
        addInventorySlotGroup(UIbuilder, exportItems, exportFluids, true, yOffset);

        if (specialTexture() != null && specialTexturePosition() != null) {
            addSpecialTexture(UIbuilder);
        }
        return UIbuilder;
    }

    /**
     * 各種スロットにオーバーレイを表示させる為のコード
     * <p>ついでにFluidTankListにslotIndexをつけてもいる</p>
     * @param builder ModularUIのBuilder
     * @param x GUIのx軸
     * @param y GUIのy軸
     * @param slotIndex GUIのスロット番号、レシピの出力順に1～
     * @param itemHandler ItemStackDataの受け渡し
     * @param fluidHandler FluidTankListの受け渡し
     * @param isFluid そのスロットに入っているものが液体か否か
     * @param isOutputs そのスロットが完成品の出力スロットてあるか否か
     */
    @Override
    protected void addSlot(ModularUI.Builder builder, int x, int y, int slotIndex, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isFluid, boolean isOutputs) {
        if (isFluid) {
            TankWidget tankWidget = new TankWidget(fluidHandler.getTankAt(slotIndex), x, y, 18, 18);
            TextureArea base = GuiTextures.FLUID_SLOT;

            if (!isOutputs)
                tankWidget.setBackgroundTexture(base, GuiTextures.BEAKER_OVERLAY_1);
            else if (slotIndex == 0 || slotIndex == 4 || slotIndex == 8 || slotIndex == 12)
                tankWidget.setBackgroundTexture(base, GuiTextures.BEAKER_OVERLAY_2);
            else if (slotIndex == 1 || slotIndex == 2 || slotIndex == 5 || slotIndex == 6 || slotIndex == 9 || slotIndex == 10 || slotIndex == 13 || slotIndex == 14)
                tankWidget.setBackgroundTexture(base, GuiTextures.BEAKER_OVERLAY_3);
            else if (slotIndex == 3 || slotIndex == 7 || slotIndex == 11 || slotIndex == 15)
                tankWidget.setBackgroundTexture(base, GuiTextures.BEAKER_OVERLAY_4);

            tankWidget.setAlwaysShowFull(true);
            builder.widget(tankWidget);
        } else {
            SlotWidget slotWidget = new SlotWidget(itemHandler, slotIndex, x, y, true, !isOutputs);
            TextureArea base = GuiTextures.SLOT;

            slotWidget.setBackgroundTexture(base, GuiTextures.DUST_OVERLAY);

            builder.widget(slotWidget);
        }

    }

    /**
     * Advanced Distillation TowerのUIを作るところ
     * @param builder ModularUIのUIBuilder
     * @param itemHandler ItemStackの受け渡し
     * @param fluidHandler FluidTankListの受け渡し
     * @param isOutput そのスロットのアイテム or 流体が出力物であるか否か
     * @param yOffset y軸始点
     */
    @Override
    protected void addInventorySlotGroup(@NotNull ModularUI.Builder builder,
                                         @NotNull IItemHandlerModifiable itemHandler,
                                         @NotNull FluidTankList fluidHandler, boolean isOutput, int yOffset) {
        int StartOutputX = 74;
        int StartOutputY = 10;

        if (!isOutput) {
            //FluidInputSlot
            addSlot(builder, 10, 47, 16, itemHandler, fluidHandler, true, false);
        } else {
            //ItemOutput
            addSlot(builder, 46, 64, 17, itemHandler, fluidHandler, false, true);

            //FluidSlot(縦列）
            for (int i = 0; i < 4; i++) {
                //FluidSlot(横列)
                for (int j = 0; j < 4; j++) {
                    int SlotIndex = i * 4 + j;
                    if (i == 0) {
                        //SlotIndex 0 ~ 3
                        addSlot(builder, StartOutputX + 18 * j, StartOutputY, SlotIndex, itemHandler, fluidHandler, true, true);
                    }
                    if (i == 1) {
                        //SlotIndex 4 ~ 7
                        addSlot(builder, StartOutputX + 18 * j, StartOutputY + 18 * i, SlotIndex, itemHandler, fluidHandler, true, true);
                    }
                    if (i == 2) {
                        //SlotIndex 8 ~ 11
                        addSlot(builder, StartOutputX + 18 * j, StartOutputY + 18 * i, SlotIndex, itemHandler, fluidHandler, true, true);
                    }
                    if (i == 3) {
                        //SlotIndex 12 ~ 15
                        addSlot(builder, StartOutputX + 18 * j, StartOutputY + 18 * i, SlotIndex, itemHandler, fluidHandler, true, true);
                    }
                }
            }
        }
    }

}
