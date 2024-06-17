package gtne.loaders.recipes;

import gtne.loaders.recipes.AboveUV.Material.UHV.UHVMaterialsRecipe;
import gtne.loaders.recipes.Adjustment.NeutroniumFix;
import gtne.loaders.recipes.Adjustment.UVSuperConductorCable;
import gtne.loaders.recipes.Adjustment.VoltageController;
import gtne.loaders.recipes.ChemicalChains.PlatLines;
import gtne.loaders.recipes.ChemicalChains.SiliconTech;
import gtne.loaders.recipes.ChemicalChains.WaterLine;
import gtne.loaders.recipes.Components.CircuitOverride.CircuitOverride;
import gtne.loaders.recipes.Components.LateGameComponents;
import gtne.loaders.recipes.LateGameMachines.ComputationRecipes;
import gtne.loaders.recipes.LateGameMachines.LateGameMachines;
import gtne.loaders.recipes.MultiBlock.*;
import gtne.loaders.recipes.Other.GTNEWoodRecipeLoader;
import gtne.loaders.recipes.Other.VanillaFix;
import gtne.loaders.recipes.SingleBlocks.ComponentsAssembler;
import net.minecraftforge.fml.common.Loader;

public class RecipeHandler {

    public static void initRecipes() {

        ComponentsAssembler.init();
        VanillaFix.init();
        if (Loader.isModLoaded("twilightforest")) {
            GTNEWoodRecipeLoader.registerRecipes();
            GTNEWoodRecipeLoader.registerUnificationInfo();
        }
        Advanced_Precision_Assembly_Line.init();
        AlloyBlastFurnaceRecipe.init();
        Assembly_Line_Recipe.init();
        EBFCoils.init();
        EBFRecipes.init();
        HDSCT_Recipe.init();
        ComputationRecipes.init();
        LateGameMachines.init();
        NeutroniumFix.init();
        UVSuperConductorCable.init();
        VoltageController.init();
        LateGameComponents.init();
        CircuitOverride.init();

    }

    public static void ChemicalChainInit() {
        PlatLines.init();
        SiliconTech.init();
        WaterLine.init();
    }

    public static void AboveUVInit() {
        UHVMaterialsRecipe.init(); //TODO Init統合
    }

}
