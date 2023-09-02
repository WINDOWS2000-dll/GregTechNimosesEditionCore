package gtne.loaders.recipes.ChemicalChains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.nbtmatch.NBTCondition;
import gregtech.api.recipes.ingredients.nbtmatch.NBTMatcher;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.GTValues.*;

public class PlatLines {

    //Init Recipe
    public static void init() {
        if (ConfigHolder.recipeoption.GTNHPlatLine) {
            PlatLine_Platinum();
            PlatLine_Separation();
            PlatLine_Iridium();
            PlatLine_Osmium();
            PlatLine_Rhodium();
            PlatLine_Ruthenium();
            PlatLine_Palladium();
        }
    }

    private static void PlatLine_Platinum() {
        // Remove GregTechCE: UnofficialPlatinum_PlatLine
        //Platinum Grope Sludge
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, PlatinumGroupSludge, 6)}, new FluidStack[]{AquaRegia.getFluid(1200)});
        //Platinum Dust
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(dust, PlatinumRaw, 3));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(dust, Cooperite, 6));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_BATH_RECIPES, new ItemStack[]{OreDictUnifier.get(crushed, Nickel, 1)}, new FluidStack[]{Mercury.getFluid(100)});


        //New Horizons PlatLine Recipes
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Cooperite, 1)
                .fluidInputs(AquaRegia.getFluid(150))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(150))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Tetrahedrite, 1)
                .fluidInputs(AquaRegia.getFluid(150))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(150))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Pentlandite, 1)
                .fluidInputs(AquaRegia.getFluid(150))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(150))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Chalcopyrite, 1)
                .fluidInputs(AquaRegia.getFluid(150))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(150))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();

        //Platinum Metallic Powder
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PLATINUM_METALLIC_POWDER, 1)
                .fluidInputs(AquaRegia.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1000))
                .output(dustTiny, PLATINUM_RESIDUE, 1)
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();
        //9xPlatinum Metallic Powder
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PLATINUM_METALLIC_POWDER, 1)
                .fluidInputs(AquaRegia.getFluid(9000))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(9000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Tetrahedrite, 9)
                .input(dust, PLATINUM_METALLIC_POWDER, 9)
                .fluidInputs(AquaRegia.getFluid(10000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(10000))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Pentlandite, 9)
                .fluidInputs(AquaRegia.getFluid(1350))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1350))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Tetrahedrite, 9)
                .fluidInputs(AquaRegia.getFluid(1350))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1350))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Cooperite, 9)
                .fluidInputs(AquaRegia.getFluid(1350))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1350))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Chalcopyrite, 9)
                .fluidInputs(AquaRegia.getFluid(1350))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1350))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Pentlandite, 9)
                .input(dust, PLATINUM_METALLIC_POWDER, 9)
                .fluidInputs(AquaRegia.getFluid(10000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(10000))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Chalcopyrite, 9)
                .input(dust, PLATINUM_METALLIC_POWDER, 9)
                .fluidInputs(AquaRegia.getFluid(10000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(10000))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Cooperite, 9)
                .input(dust, PLATINUM_METALLIC_POWDER, 9)
                .fluidInputs(AquaRegia.getFluid(10000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(10000))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();

        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PLATINUM_CONCENTRATE.getFluid(2000))
                .fluidInputs(AMMONIUM_CHLORIDE.getFluid(400))
                .circuitMeta(1)
                .fluidOutputs(PALLADIUM_ENRICHED_AMMONIA.getFluid(400))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .output(dustTiny, PLATINUM_SALT, 16)
                .output(dustTiny, REPRECIPITATED_PLATINUM, 4)
                .EUt(VA[LV]).duration(1200)
                .buildAndRegister();

        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PLATINUM_CONCENTRATE.getFluid(18000))
                .fluidInputs(AMMONIUM_CHLORIDE.getFluid(3600))
                .circuitMeta(1)
                .fluidOutputs(PALLADIUM_ENRICHED_AMMONIA.getFluid(3600))
                .fluidOutputs(NitrogenDioxide.getFluid(9000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(9000))
                .output(dust, PLATINUM_SALT, 16)
                .output(dust, REPRECIPITATED_PLATINUM, 4)
                .EUt(240).duration(1400)
                .buildAndRegister();

        RecipeMaps.SIFTER_RECIPES.recipeBuilder()
                .input(dust, PLATINUM_SALT, 1)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1500, 20)
                .EUt(VA[LV]).duration(600)
                .buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, REFINED_PLATINUM_SALT, 1)
                .output(dust, PLATINUM_METALLIC_POWDER, 1)
                .fluidOutputs(Chlorine.getFluid(87))
                .circuitMeta(1)
                .blastFurnaceTemp(900)
                .EUt(VA[MV]).duration(200)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, REPRECIPITATED_PLATINUM, 4)
                .input(dust, Calcium, 1)
                .output(dust, Platinum, 2)
                .output(dust, CalciumChloride, 3)
                .EUt(VA[LV]).duration(30)
                .buildAndRegister();

    }

    private static void PlatLine_Separation() {

        //Leach Residue & Rhodium Separation
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, PLATINUM_RESIDUE, 1)
                .circuitMeta(11)
                .fluidInputs(POTASSIUM_DISULFATE.getFluid(360))
                .output(dust, LEACH_RESIDUE, 1)
                .fluidOutputs(RhodiumSulfate.getFluid(360))
                .blastFurnaceTemp(775)
                .EUt(VA[MV]).duration(200)
                .buildAndRegister();

        //Other Separation
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, LEACH_RESIDUE, 10)
                .input(dust, Salt, 10)
                .fluidInputs(SaltWater.getFluid(1000))
                .output(dust, SODIUM_RUTHENATE, 3)
                .output(dust, RAREST_METAL_RESIDUE, 6)
                .fluidOutputs(Steam.getFluid(1000))
                .blastFurnaceTemp(775)
                .EUt(VA[MV]).duration(200)
                .buildAndRegister();

        //Iridium & Osmium Separation
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, RAREST_METAL_RESIDUE, 2)
                .circuitMeta(11)
                .fluidInputs(HydrochloricAcid.getFluid(500))
                .output(dust, IRIDIUM_METAL_RESIDUE, 1)
                .fluidOutputs(AcidicOsmiumSolution.getFluid(1000))
                .blastFurnaceTemp(775)
                .EUt(VA[MV]).duration(100)
                .buildAndRegister();
    }

    private static void PlatLine_Iridium() {

        //Iridium Dioxide
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust,IRIDIUM_METAL_RESIDUE, 1)
                .circuitMeta(1)
                .output(dust, SLUDGE_DUST_RESIDUE, 1)
                .output(dust, IRIDIUM_DIOXIDE, 1)
                .blastFurnaceTemp(775)
                .EUt(VA[MV]).duration(200)
                .buildAndRegister();

        //Acidic Iridium Solution
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, IRIDIUM_DIOXIDE, 1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(ACIDIC_IRIDIUM_SOLUTION.getFluid(1000))
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();

        //Acidic Iridium Solution
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ACIDIC_IRIDIUM_SOLUTION.getFluid(1000))
                .fluidInputs(AMMONIUM_CHLORIDE.getFluid(3000))
                .output(dust, IRIDIUM_CHLORIDE ,1)
                .fluidOutputs(Ammonia.getFluid(3000))
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();

        //Iridium
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, IRIDIUM_CHLORIDE, 1)
                .input(dust, Calcium, 1)
                .output(dust, METALLIC_SLUDGE_DUST_RESIDUE, 1)
                .output(dust, Iridium, 1)
                .output(dust, CalciumChloride, 3)
                .EUt(VA[EV]).duration(300)
                .buildAndRegister();
    }

    private static void PlatLine_Osmium() {

        //Osmium Solution
        RecipeMaps.DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AcidicOsmiumSolution.getFluid(1000))
                .fluidOutputs(OSMIUM_SOLUTION.getFluid(100))
                .fluidOutputs(Water.getFluid(900))
                .EUt(7680).duration(150)
                .buildAndRegister();

        //Osmium
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(OSMIUM_SOLUTION.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(6000))
                .output(dust, Osmium, 1)
                .fluidOutputs(Chlorine.getFluid(7000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();
    }

    private static void PlatLine_Rhodium() {

        //Rhodium Sulfate Solution
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RhodiumSulfate.getFluid(11000))
                .fluidInputs(Water.getFluid(10000))
                .circuitMeta(1)
                .output(dustTiny, LEACH_RESIDUE, 10)
                .fluidOutputs(RHODIUM_SULFATE_SOLUTION.getFluid(11000))
                .fluidOutputs(Potassium.getFluid(2000))
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();

        //Another Rhodium Sulfate Solution Recipe
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RhodiumSulfate.getFluid(39000))
                .fluidInputs(Water.getFluid(36000))
                .circuitMeta(3)
                .output(dust, LEACH_RESIDUE, 4)
                .fluidOutputs(Potassium.getFluid(7200))
                .fluidOutputs(RHODIUM_SULFATE_SOLUTION.getFluid(39000))
                .EUt(VA[LV]).duration(1200)
                .buildAndRegister();

        //Crude Rhodium Metal
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Zinc, 1)
                .fluidInputs(RHODIUM_SULFATE_SOLUTION.getFluid(1000))
                .output(dust, ZINC_SULFATE, 6)
                .output(dust, CRUDE_RHODIUM_METAL, 1)
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();

        //Rhodium Salt
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, CRUDE_RHODIUM_METAL, 1)
                .input(dust, Salt, 1)
                .fluidInputs(Chlorine.getFluid(1000))
                .output(dust, RHODIUM_SALT, 3)
                .blastFurnaceTemp(600)
                .EUt(VA[MV]).duration(300)
                .buildAndRegister();

        //Rhodium Salt Solution
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(dust, RHODIUM_SALT, 1)
                .fluidInputs(Water.getFluid(200))
                .fluidOutputs(RHODIUM_SALT_SOLUTION.getFluid(200))
                .EUt(VA[LV]).duration(30)
                .buildAndRegister();

        //Rhodium Nitrate
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SODIUM_NITRATE, 5)
                .circuitMeta(1)
                .fluidInputs(RHODIUM_SALT_SOLUTION.getFluid(1000))
                .output(dust, RHODIUM_NITRATE, 1)
                .output(dust, Salt, 2)
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();

        //Rhodium Filter Cake
        RecipeMaps.SIFTER_RECIPES.recipeBuilder()
                .input(dust, RHODIUM_NITRATE, 1)
                .chancedOutput(dust, RHODIUM_FILTER_CAKE, 1, 1300, 20)
                .chancedOutput(dust, RHODIUM_FILTER_CAKE, 1, 1300, 20)
                .chancedOutput(dust, RHODIUM_FILTER_CAKE, 1, 1300, 20)
                .chancedOutput(dust, RHODIUM_FILTER_CAKE, 1, 1300, 20)
                .chancedOutput(dust, RHODIUM_FILTER_CAKE, 1, 1300, 20)
                .chancedOutput(dust, RHODIUM_FILTER_CAKE, 1, 1500, 20)
                .EUt(VA[LV]).duration(900)
                .buildAndRegister();

        //Rhodium Filter Cake Solution
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(dust, RHODIUM_FILTER_CAKE, 1)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(RHODIUM_FILTER_CAKE_SOLUTION.getFluid(1000))
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();

        //Reprecipitated Rhodium
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(RHODIUM_FILTER_CAKE_SOLUTION.getFluid(1000))
                .output(dust, REPRECIPITATED_RHODIUM, 1)
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();

        //Rhodium
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, REPRECIPITATED_RHODIUM, 1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, Rhodium, 1)
                .fluidOutputs(Ammonia.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(1000))
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();
    }

    private static void PlatLine_Ruthenium() {

        //Ruthenium Tetroxide Solution
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SODIUM_RUTHENATE, 6)
                .fluidInputs(Chlorine.getFluid(3000))
                .fluidOutputs(RUTHENIUM_TETROXIDE_SOLUTION.getFluid(9000))
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();

        //Hot Ruthenium Tetroxide Solution
        RecipeMaps.CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(17)
                .fluidInputs(Steam.getFluid(1000))
                .fluidInputs(RUTHENIUM_TETROXIDE_SOLUTION.getFluid(1000))
                .fluidOutputs(HOT_RUTHENIUM_TETROXIDE_SOLUTION.getFluid(2000))
                .EUt(VA[HV]).duration(150)
                .buildAndRegister();

        //Ruthenium Tetroxide
        RecipeMaps.DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(HOT_RUTHENIUM_TETROXIDE_SOLUTION.getFluid(9000))
                .output(dust, Salt, 6)
                .fluidOutputs(Water.getFluid(1800))
                .fluidOutputs(RUTHENIUM_TETROXIDE.getFluid(7200))
                .EUt(VA[HV]).duration(1500)
                .buildAndRegister();

        //Ruthenium Tetroxide Dust
        RecipeMaps.FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(RUTHENIUM_TETROXIDE.getFluid(1000))
                .circuitMeta(1)
                .output(dust, RUTHENIUM_TETROXIDE, 1)
                .EUt(VA[LV]).duration(33)
                .buildAndRegister();

        //Ruthenium
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, RUTHENIUM_TETROXIDE, 1)
                .fluidInputs(HydrochloricAcid.getFluid(6000))
                .output(dust, Ruthenium, 1)
                .fluidOutputs(Chlorine.getFluid(6000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[LV]).duration(300)
                .buildAndRegister();
    }

    private static void PlatLine_Palladium() {

        //Palladium Salt
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(PALLADIUM_ENRICHED_AMMONIA.getFluid(1000))
                .output(dust, PALLADIUM_SALT, 1)
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();

        //Palladium Metallic Powder
        RecipeMaps.SIFTER_RECIPES.recipeBuilder()
                .input(dust, PALLADIUM_SALT, 1)
                .chancedOutput(dust, PALLADIUM_METALLIC_POWDER, 1, 1300, 20)
                .chancedOutput(dust, PALLADIUM_METALLIC_POWDER, 1, 1300, 20)
                .chancedOutput(dust, PALLADIUM_METALLIC_POWDER, 1, 1300, 20)
                .chancedOutput(dust, PALLADIUM_METALLIC_POWDER, 1, 1300, 20)
                .chancedOutput(dust, PALLADIUM_METALLIC_POWDER, 1, 1300, 20)
                .chancedOutput(dust, PALLADIUM_METALLIC_POWDER, 1, 1500, 20)
                .EUt(VA[LV]).duration(900)
                .buildAndRegister();

        //Reprecipitated Palladium
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PALLADIUM_METALLIC_POWDER, 1)
                .circuitMeta(1)
                .fluidInputs(PALLADIUM_ENRICHED_AMMONIA.getFluid(1000))
                .output(dustTiny, PALLADIUM_SALT, 16)
                .output(dustTiny, REPRECIPITATED_PALLADIUM, 2)
                .EUt(30).duration(250)
                .buildAndRegister();

        //Another Reprecipitated Palladium
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PALLADIUM_METALLIC_POWDER, 9)
                .circuitMeta(9)
                .fluidInputs(PALLADIUM_ENRICHED_AMMONIA.getFluid(9000))
                .output(dust, PALLADIUM_SALT, 16)
                .output(dust, REPRECIPITATED_PALLADIUM, 2)
                .EUt(30).duration(2250)
                .buildAndRegister();

        //Palladium
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, REPRECIPITATED_PALLADIUM, 4)
                .fluidInputs(FORMIC_ACID.getFluid(4000))
                .output(dust, Palladium, 2)
                .fluidOutputs(Ammonia.getFluid(4000))
                .fluidOutputs(Ethylene.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();

    }
}
