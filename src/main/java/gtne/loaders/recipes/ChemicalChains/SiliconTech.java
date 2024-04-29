package gtne.loaders.recipes.ChemicalChains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItem1;
import gregtech.common.items.MetaItems;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.ConfigHolder;
import gtne.common.item.GTNEMetaItems;
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
            GTNESiliconTech();
        }
    }

    private static void Remove_GregTechCEu_Silicon_Line() {
        //Monocrystalline Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, OreDictUnifier.get(dust, Silicon, 32), OreDictUnifier.get(dustSmall, GalliumArsenide, 1), IntCircuitIngredient.getIntegratedCircuit(2));
        //Glowstone-doped Monocrystalline Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Silicon, 64), OreDictUnifier.get(dust, Phosphorus, 8), OreDictUnifier.get(dustSmall, GalliumArsenide, 2)}, new FluidStack[]{Nitrogen.getFluid(8000)});
        //Naquadah-doped Monocrystalline Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(block, Silicon, 16), OreDictUnifier.get(ingot, Naquadah, 1), OreDictUnifier.get(dust, GalliumArsenide, 1)}, new FluidStack[]{Argon.getFluid(8000)});
        //Neutronium-doped Monocrystalline Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(block, Silicon, 32), OreDictUnifier.get(ingot, Neutronium, 4), OreDictUnifier.get(dust, GalliumArsenide, 2)}, new FluidStack[]{Xenon.getFluid(8000)});
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

        //Steel Reinforced Wire
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Steel, 32)
                .input(wireGtSingle, Steel, 1)
                .fluidInputs(WroughtIron.getFluid(1440))
                .output(GTNEMetaItems.STEEL_REINFORCED_WIRE, 2)
                .EUt(30).duration(240)
                .buildAndRegister();

        //Vanadium Steel Reinforced Wire
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, VanadiumSteel, 32)
                .input(wireGtSingle, BlackSteel, 16)
                .fluidInputs(Steel.getFluid(1440))
                .output(GTNEMetaItems.VANADIUM_STEEL_REINFORCED_WIRE, 2)
                .EUt(480).duration(240)
                .buildAndRegister();

        //Tungsten Carbide Reinforced Wire
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, TungstenCarbide, 32)
                .input(wireFine, TungstenSteel, 32)
                .input(wireGtSingle, TungstenSteel, 16)
                .fluidInputs(Tungsten.getFluid(1440))
                .output(GTNEMetaItems.TUNGSTEN_CARBIDE_REINFORCED_WIRE, 2)
                .EUt(2000).duration(480)
                .buildAndRegister();

        //Silicon Crystal
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, HIGH_PURITY_SILICON, 8)
                .fluidInputs(SILICON_TETRACHLORIDE.getFluid(4000))
                .output(GTNEMetaItems.SILICON_CRYSTAL, 1)
                .EUt(30).duration(10000)
                .buildAndRegister();

        //Monocrystalline Silicon Boule
        GTNERecipeMaps.SiliconMonocrystallineRefiningFurnace.recipeBuilder()
                .input(GTNEMetaItems.SILICON_CRYSTAL, 1)
                .input(dust, HIGH_PURITY_SILICON, 32)
                .input(dustSmall, GalliumArsenide, 2)
                .notConsumable(GTNEMetaItems.STEEL_REINFORCED_WIRE)
                .fluidInputs(Nitrogen.getFluid(4800))
                .output(SILICON_BOULE, 1)
                .blastFurnaceTemp(1784)
                .EUt(120).duration(36000)
                .buildAndRegister();

        //Phosphorus-doped Monocrystalline Silicon Boule
        GTNERecipeMaps.SiliconMonocrystallineRefiningFurnace.recipeBuilder()
                .input(GTNEMetaItems.SILICON_CRYSTAL, 1)
                .input(dust, Silicon, 64)
                .input(dust, Phosphorus, 8)
                .input(dustSmall, GalliumArsenide, 2)
                .notConsumable(GTNEMetaItems.VANADIUM_STEEL_REINFORCED_WIRE)
                .fluidInputs(Helium.getFluid(8000))
                .fluidInputs(HIGH_PURITY_SILICON.getFluid(9216))
                .output(PHOSPHORUS_BOULE, 1)
                .EUt(480).duration(48000)
                .blastFurnaceTemp(2484)
                .buildAndRegister();

        //Naquadah-doped Monocrystalline Silicon Boule
        GTNERecipeMaps.SiliconMonocrystallineRefiningFurnace.recipeBuilder()
                .input(GTNEMetaItems.SILICON_CRYSTAL)
                .input(block, HIGH_PURITY_SILICON, 16)
                .input(ingot, Naquadah, 2)
                .input(dust, GalliumArsenide, 1)
                .notConsumable(GTNEMetaItems.TUNGSTEN_CARBIDE_REINFORCED_WIRE)
                .fluidInputs(Argon.getFluid(8000))
                .fluidInputs(HIGH_PURITY_SILICON.getFluid(18432))
                .output(NAQUADAH_BOULE, 1)
                .EUt(1920).duration(60000)
                .blastFurnaceTemp(5600)
                .buildAndRegister();


    }
}
