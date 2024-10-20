package gtne.api.recipes;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.*;
import gregtech.api.util.AssemblyLineManager;
import gregtech.core.sound.GTSoundEvents;
import gtne.api.gui.GTNEGuiTextures;
import gtne.api.recipes.machine.MultiBlock.RecipeMapAdvancedDistillationTower;
import gtne.api.recipes.machine.MultiBlock.RecipeMapHighDimensionalStructureConstructionTesseract;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenProperty;
import gtne.api.recipes.machine.MultiBlock.RecipeMapAdvancedPrecisionAssemblyLine;

@ZenExpansion("mods.gregtech.recipe.RecipeMaps")
@ZenRegister
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
    public static final RecipeMap<AssemblyLineRecipeBuilder> ADVANCED_PRECISION_ASSEMBLY_LINE_RECIPES =
            new RecipeMapAdvancedPrecisionAssemblyLine<>("advanced_precision_assembly_line",  20,  1,  10, 0, new AssemblyLineRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER)
            .onRecipeBuild(AssemblyLineManager::createDefaultResearchRecipe);

    @ZenProperty
    public static final RecipeMap<ComputationRecipeBuilder> HIGH_DIMENTIONAL_STRUCTURE_CONSTRUCTION_TESSERACT =
            new RecipeMapHighDimensionalStructureConstructionTesseract<>("high_dimensional_structure_construction_tesseract", 36, 1, 24, 0, new ComputationRecipeBuilder(), false)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.COMPUTATION);


    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENTS_ASSEMBLER =
            new RecipeMap<>("components_assembler", 6,1,3, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GTNEGuiTextures.PREGRESSBAR_CONPONENTS_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> HighEnergyElectromagneticImplosionMachine =
            new RecipeMap<>("high_energy_electromagnetic_implosion_machine", 6, 3, 3, 3, new SimpleRecipeBuilder(), false)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.COMPRESSOR);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ADVANCED_DISTILLATION_TOWER =
            new RecipeMapAdvancedDistillationTower<>("advanced_distillation_tower", 0, 1, 1, 16, new SimpleRecipeBuilder(), false);

    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> SiliconMonocrystallineRefiningFurnace =
            new RecipeMap<>("silicon_monocrystalline_refining_furnace", 6, 1, 3, 0, new BlastRecipeBuilder(), false)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.FURNACE);

}