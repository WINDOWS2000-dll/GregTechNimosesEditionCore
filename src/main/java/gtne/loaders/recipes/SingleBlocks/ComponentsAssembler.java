package gtne.loaders.recipes.SingleBlocks;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gtne.api.recipes.GTNERecipeMaps;

import javax.annotation.Nonnull;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
public class ComponentsAssembler {

    public static void init() {

        //MV Components
        //Motor
        ModHandler.removeRecipeByName("gregtech:electric_motor_mv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Aluminium, 2), OreDictUnifier.get(stick, SteelMagnetic, 1),
                                                                            OreDictUnifier.get(wireGtDouble, Cupronickel, 4), OreDictUnifier.get(cableGtSingle, Copper, 2));
        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Aluminium, 2)
                .input(stick, SteelMagnetic, 1)
                .input(wireGtDouble, Cupronickel, 4)
                .input(cableGtSingle, Copper, 2)
                .fluidInputs(Lubricant.getFluid(144))
                .fluidInputs(SolderingAlloy.getFluid(72))
                .output(ELECTRIC_MOTOR_MV)
                .duration(120).EUt(VA[LV])
                .buildAndRegister();
    }
}
