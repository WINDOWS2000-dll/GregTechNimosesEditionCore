package gtne.loaders.recipes.MultiBlock;

import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gtne.common.ConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;
import static gtne.api.unification.material.GTNEMaterials.*;

public class AlloyBlastFurnaceRecipe {

    public static void init() {
        if (ConfigHolder.recipeoption.Harder_LateGame_Components_Recipe) {
            ABSRecipes();
        }
    }

    private static void ABSRecipes() {
        GCYMRecipeMaps.ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Bismuth, 47)
                .input(dust, Lead, 25)
                .input(dust, Tin, 13)
                .input(dust, Cadmium, 10)
                .input(dust, Indium, 5)
                .circuitMeta(5)
                .fluidOutputs(Indalloy_140.getFluid(14400))
                .blastFurnaceTemp(5000)
                .EUt(7680).duration(800)
                .buildAndRegister();
    }

}
