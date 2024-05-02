package gtne.loaders.recipes.Adjustment;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gtne.common.ConfigHolder;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gtne.api.unification.material.GTNEMaterials.*;

public class NeutroniumFix {

    public static void init() {
        if (ConfigHolder.recipeoption.Neutronium_Fix) {
            RemoveNeutroniumSmeltAndMelt();
            NeutroniumZPM();
        }
    }

    private static void RemoveNeutroniumSmeltAndMelt() {
        ModHandler.removeFurnaceSmelting(OreDictUnifier.get(dust, Neutronium, 1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Neutronium, 1)}, new FluidStack[]{Oxygen.getFluid(1000)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.EXTRACTOR_RECIPES, OreDictUnifier.get(dust, Neutronium, 1));
    }

    private static void NeutroniumZPM() {

        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, Naquadria, 4)
                .fluidInputs(new FluidStack(BlocksAS.fluidLiquidStarlight, 1000))
                .output(dust, Neutronium, 1)
                .EUt(122880).duration(4800)
                .buildAndRegister();

        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(dust, Neutronium, 1)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Xenon.getFluid(3000))
                .output(dust, RawNeutronium, 1)
                .EUt(122880).duration(3600)
                .buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, RawNeutronium, 1)
                .fluidInputs(Xenon.getFluid(4000))
                .output(ingot, Neutronium, 1)
                .EUt(320000).duration(480)
                .blastFurnaceTemp(10000)
                .buildAndRegister();

    }

}
