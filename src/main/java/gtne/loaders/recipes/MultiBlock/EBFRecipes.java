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
import gtne.common.ConfigHolder;
import scala.collection.script.Remove;

import javax.annotation.Nonnull;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.api.metatileentity.multiblock.CleanroomType.CLEANROOM;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class EBFRecipes {

    public static void init() {
        if (ConfigHolder.recipeoption.Harder_EBF_Recipe) {
            EBFRecipe();
        }
    }

    private static void EBFRecipe() {

        //TungstenCarbide
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, OreDictUnifier.get(dust, TungstenCarbide, 1), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, TungstenCarbide, 1), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Helium.getFluid(100)});

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, TungstenCarbide, 1)
                .circuitMeta(1)
                .output(ingotHot, TungstenCarbide, 1)
                .blastFurnaceTemp(3058)
                .EUt(1920)
                .duration(1500)
                .buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, TungstenCarbide, 1)
                .circuitMeta(2)
                .fluidInputs(Helium.getFluid(100))
                .output(ingotHot, TungstenCarbide, 1)
                .blastFurnaceTemp(3058)
                .EUt(1920)
                .duration(1005)
                .buildAndRegister();

    }

}
