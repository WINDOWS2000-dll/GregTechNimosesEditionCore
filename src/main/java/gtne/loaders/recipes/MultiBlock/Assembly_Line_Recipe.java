package gtne.loaders.recipes.MultiBlock;

import com.google.common.graph.Graph;
import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.*;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import cofh.thermalfoundation.init.TFFluids;
import scala.collection.script.End;

import javax.annotation.Nonnull;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class Assembly_Line_Recipe {

    public static void init() {
        APALCasingRecipe();
    }

    private static void APALCasingRecipe() {

        //APALCasing
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Europium, 4)
                .input(plate, Osmiridium, 32)
                .input(VOLTAGE_COIL_IV, 8)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(gear, Tungsten, 4)
                .input(CONVEYOR_MODULE_IV, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(pipeTinyFluid, StainlessSteel, 16)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Lubricant.getFluid(4000))
                .fluidInputs(Polybenzimidazole.getFluid(1440))
                .EUt(262144).duration(1600)
                .buildAndRegister();

        //APAL Filter Casing
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                //.input()
                .buildAndRegister();

    }
}
