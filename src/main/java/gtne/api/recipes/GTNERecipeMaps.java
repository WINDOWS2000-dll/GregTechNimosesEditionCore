package gtne.api.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.*;
import gregtech.core.sound.GTSoundEvents;
import gtne.api.gui.GTNEGuiTextures;
import net.minecraft.init.SoundEvents;
import stanhebben.zenscript.annotations.ZenProperty;
import gtne.api.recipes.machine.MultiBlock.RecipeMapAdvancedPrecisionAssemblyLine;

public class GTNERecipeMaps {

    /**
     * Example:
     * <pre>
     *      RecipeMaps.ADVANCED_PRECISION_ASSEMBLY_LINE_RECIPES.recipeBuilder()
     *               .inputs(new ItemStack(Items.COAL, 1, GTValues.W))
     *               .input(OrePrefix.stick, Materials.Wood, 1)
     *               .fluidInputs(SolderingAlloy.getFluid(1152))
     *               .outputs(new ItemStack(Blocks.TORCH, 4))
     *               .duration(100).EUt(1).buildAndRegister();
     * </pre>
     * inputs 1 ~ 20 output Only 1 FluidInputs 0 ~ 10
     */

    @ZenProperty
    public static final RecipeMapAdvancedPrecisionAssemblyLine<SimpleRecipeBuilder> ADVANCED_PRECISION_ASSEMBLY_LINE_RECIPES = (RecipeMapAdvancedPrecisionAssemblyLine<SimpleRecipeBuilder>) new RecipeMapAdvancedPrecisionAssemblyLine<>("advanced_precision_assembly_line", 1, 20, 1, 1, 0, 10, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENTS_ASSEMBLER =
            new RecipeMap<>("components_assembler", 1, 6, 1, 1, 1, 3, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GTNEGuiTextures.PREGRESSBAR_CONPONENTS_ASSEMBLER, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> HighEnergyElectromagneticImplosionMachine =
            new RecipeMap<>("high_energy_electromagnetic_implosion_machine", 6, 3, 3, 3, new SimpleRecipeBuilder(), false)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.COMPRESSOR);

}