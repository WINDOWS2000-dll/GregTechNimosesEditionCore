package gtne.loaders.recipes.ChemicalChains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gtne.api.unification.material.GTNEMaterials.*;

public class SiliconTech {

    public static void init() {
        if (ConfigHolder.recipeoption.GTNHSiliconLine) {
            Remove_GregTechCEu_Silicon_Line();
            Add_GregTech_New_Horizons_Silicone_Line();
        }
    }

    private static void Remove_GregTechCEu_Silicon_Line() {
        //Monocrystalline Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, OreDictUnifier.get(dust, Silicon, 32), OreDictUnifier.get(dustSmall, GalliumArsenide, 1));
        //Glowstone-doped Monocrystalline Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Silicon, 64), OreDictUnifier.get(dust, Glowstone, 8)}, new FluidStack[]{Nitrogen.getFluid(8000)});
        //Naquadah-doped Monocrystalline Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(block, Silicon, 16), OreDictUnifier.get(ingot, Naquadah, 1)}, new FluidStack[]{Argon.getFluid(8000)});
        //Neutronium-doped Monocrystalline Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(block, Silicon, 32), OreDictUnifier.get(ingot, Neutronium, 4)}, new FluidStack[]{Xenon.getFluid(8000)});
    }

    private static void Add_GregTech_New_Horizons_Silicone_Line() {
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Silicon, 1)
                .circuitMeta(2)
                .fluidInputs(Chlorine.getFluid(4000))
                .fluidOutputs(SILICON_TETRACHLORIDE.getFluid(1000))
                .EUt(VA[LV]).duration(400)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium, 4)
                .circuitMeta(1)
                .fluidInputs(SILICON_TETRACHLORIDE.getFluid(1000))
                .output(dust, HIGH_PURITY_SILICON, 1)
                .output(dust, Salt, 8)
                .EUt(VA[LV]).duration(100)
                .buildAndRegister();
    }

    private static void GTNESiliconTech() {
        //Monocrystalline Silicon Boule
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, HIGH_PURITY_SILICON, 32)
                .input(dustSmall, GalliumArsenide, 2)
                .fluidInputs(Nitrogen.getFluid(1600))
                .output(SILICON_BOULE)
                .EUt(VA[MV]).duration(9000)
                .buildAndRegister();
        //Glowstone-doped Monocrystalline Silicon Boule
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, HIGH_PURITY_SILICON, 64)
                .input(dust, Glowstone, 8)
                .fluidInputs(Nitrogen.getFluid(16000))
                .output(GLOWSTONE_BOULE)
                .EUt(VA[HV]).duration(12000)
                .buildAndRegister();
    }
}
