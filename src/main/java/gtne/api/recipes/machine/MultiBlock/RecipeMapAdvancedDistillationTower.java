package gtne.api.recipes.machine.MultiBlock;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.gui.widgets.TankWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gtne.api.gui.GTNEGuiTextures;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;

public class RecipeMapAdvancedDistillationTower <R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapAdvancedDistillationTower(String unlocalizedName, int maxInputs, int maxOutputs,
                                              int maxFluidInputs, int maxFluidOutputs, R defaultRecipe, boolean isHidden) {
        super(unlocalizedName, maxInputs, maxOutputs, maxFluidInputs, maxFluidOutputs, defaultRecipe, isHidden);

    }

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

    @Override
    @NotNull
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable expoteItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 160)
            .widget(new ProgressWidget(200, 18, 17, 56, 63, GTNEGuiTextures.PROGRESSBAR_ADVANCED_DISTILLATION_TOWER, ProgressWidget.MoveType.HORIZONTAL));
        addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        addInventorySlotGroup(builder, expoteItems, exportFluids, true, yOffset);
        if (this.specialTexture != null && this.specialTexturePosition != null) {
            addSpecialTexture(builder);
        }
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutput, int yOffset) {
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
                        addSlot(builder, StartOutputX + 18 * j, StartOutputY, SlotIndex, itemHandler, fluidHandler, true, true);
                    }
                    if (i == 1) {
                        addSlot(builder, StartOutputX + 18 * j, StartOutputY + 18 * i, SlotIndex, itemHandler, fluidHandler, true, true);
                    }
                    if (i == 2) {
                        addSlot(builder, StartOutputX + 18 * j, StartOutputY + 18 * i, SlotIndex, itemHandler, fluidHandler, true, true);
                    }
                    if (i == 3) {
                        addSlot(builder, StartOutputX + 18 * j, StartOutputY + 18 * i, SlotIndex, itemHandler, fluidHandler, true, true);
                    }
                }
            }
        }
    }
}
