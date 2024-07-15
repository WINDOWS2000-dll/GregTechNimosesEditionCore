package gtne.api.recipes;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.gui.GuiTextures;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMapBuilder;
import gregtech.api.recipes.builders.*;
import gregtech.core.sound.GTSoundEvents;
import gtne.api.gui.GTNEGuiTextures;
import gtne.api.recipes.builders.SuperDeepMinerBuilder;
import gtne.api.recipes.machine.MultiBlock.RecipeMapHighDimensionalStructureConstructionTesseract;
import gtne.api.recipes.ui.AdvancedAssemblyLineUI;
import gtne.api.recipes.ui.AdvancedDistillationTowerUI;
import gtne.api.recipes.ui.HighDimensionalStructureConstructionTesseractUI;
import net.minecraft.init.SoundEvents;
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
            new RecipeMapAdvancedPrecisionAssemblyLine<>("advanced_precision_assembly_line", new AssemblyLineRecipeBuilder(), AdvancedAssemblyLineUI::new);

    @ZenProperty
    public static final RecipeMap<ComputationRecipeBuilder> HIGH_DIMENTIONAL_STRUCTURE_CONSTRUCTION_TESSERACT =
            new RecipeMapHighDimensionalStructureConstructionTesseract<>("high_dimensional_structure_construction_tesseract", new ComputationRecipeBuilder(), HighDimensionalStructureConstructionTesseractUI::new);


    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENTS_ASSEMBLER = new RecipeMapBuilder<>("components_assembler",
            new SimpleRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(1)
            .fluidInputs(3)
            .fluidOutputs(0)
            .progressBar(GTNEGuiTextures.PREGRESSBAR_CONPONENTS_ASSEMBLER)
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    /**
     * @deprecated GTNH版のEIM実装時に削除の為あんま使うな
     */
    @ZenProperty
    @Deprecated
    public static final RecipeMap<SimpleRecipeBuilder> HighEnergyElectromagneticImplosionMachine = new RecipeMapBuilder<>("high_energy_electromagnetic_implosion_machine",
            new SimpleRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .progressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            .sound(SoundEvents.ENTITY_GENERIC_EXPLODE)
            .build();

    @ZenProperty
    public static final RecipeMap<UniversalDistillationRecipeBuilder> ADVANCED_DISTILLATION_TOWER = new RecipeMapBuilder<>("advanced_distillation_tower",
            new UniversalDistillationRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(1)
            .fluidInputs(1)
            .fluidOutputs(16)
            .ui(AdvancedDistillationTowerUI::new)
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> SiliconMonocrystallineRefiningFurnace = new RecipeMapBuilder<>("silicon_monocrystalline_refining_furnace",
            new BlastRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(1)
            .fluidInputs(3)
            .fluidOutputs(0)
            .sound(GTSoundEvents.FURNACE)
            .build();

    @ZenProperty
    public static final RecipeMap<SuperDeepMinerBuilder> SUPER_DEEP_MINER_RECIPES = new RecipeMapBuilder<>("deep_miner",
            new SuperDeepMinerBuilder())
            .itemInputs(6)
            .itemOutputs(12)
            .fluidInputs(3)
            .fluidOutputs(6)
            .sound(GTSoundEvents.MINER)
            .build();

}