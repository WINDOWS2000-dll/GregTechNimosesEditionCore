package gtne.loaders.recipes.ChemicalChains;

import com.google.common.graph.Graph;
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
import static gtne.api.unification.material.GTNEMaterials.*;

import gtne.api.unification.material.GTNEChemical.*;

public class Chemical {

    public static void init() {
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(AMMONIUM_CHLORIDE.getFluid(1000))
                .circuitMeta(1)
                .EUt(VA[LV]).duration(15)
                .buildAndRegister();

        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(64000))
                .fluidInputs(HydrochloricAcid.getFluid(64000))
                .fluidOutputs(AMMONIUM_CHLORIDE.getFluid(64000))
                .circuitMeta(9)
                .circuitMeta(1)
                .EUt(VA[HV]).duration(60)
                .buildAndRegister();
    }
}
