package gtne.loaders.recipes.ChemicalChains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.RecipeMaps.*;
import gregtech.api.recipes.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

import gregtech.api.unification.OreDictUnifier;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.common.items.MetaItems.*;
import static gtne.api.unification.material.GTNEMaterials.*;

public class WaterLine {

    public static void init() {
        if (ConfigHolder.recipeoption.Harder_Water_Recipe) {
            Remove_Default_Water_Recipes();
            Add_Water_Purification_Line();
            Change_Default_Water_Recipes();
        }
    }

    private static void Remove_Default_Water_Recipes() {
        //Bacteria
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.BREWING_RECIPES, new ItemStack[]{BIO_CHAFF.getStackForm(4)}, new FluidStack[]{DistilledWater.getFluid(1000)});
        //Agar
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.AUTOCLAVE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Gelatin, 1)}, new FluidStack[]{DistilledWater.getFluid(1000)});
        //Gelatin Mixture
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Collagen, 4)}, new FluidStack[]{Water.getFluid(3000), PhosphoricAcid.getFluid(1000)});
    }

    private static void Add_Water_Purification_Line() {

        //A(1) -> B(2) -> C(3) -> D(4) -> E(5) -> F(6) -> G(7) -> H(8)

        //Grade8 H
        RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder()
                .notConsumable(CARBON_MESH)
                .fluidInputs(Water.getFluid(64000))
                .output(dust, Stone, 8)
                .output(dust, Clay, 4)
                .fluidOutputs(Purified_Water_Grade_H.getFluid(48000))
                .cleanroom(CleanroomType.CLEANROOM)
                .EUt(1920).duration(10000)
                .buildAndRegister();

        //Grade7 G
        RecipeMaps.FLUID_HEATER_RECIPES.recipeBuilder()
                .circuitMeta(32)
                .fluidInputs(Purified_Water_Grade_H.getFluid(12000))
                .fluidOutputs(Purified_Water_Grade_G.getFluid(8000))
                .cleanroom(CleanroomType.CLEANROOM)
                .EUt(7680).duration(8000)
                .buildAndRegister();

        //Grade6 F
        RecipeMaps.DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(Purified_Water_Grade_G.getFluid(8000))
                .output(dustSmall, MetalMixture, 2)
                .fluidOutputs(Purified_Water_Grade_F.getFluid(7000))
                .fluidOutputs(Oil.getFluid(25))
                .fluidOutputs(Purified_Water_Grade_G.getFluid(225))
                .fluidOutputs(Purified_Water_Grade_H.getFluid(550))
                .fluidOutputs(Ammonia.getFluid(200))
                .cleanroom(CleanroomType.CLEANROOM)
                .EUt(12800).duration(9000)
                .buildAndRegister();

        //Grade5 E
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(Purified_Water_Grade_F.getFluid(14000))
                .output(dustSmall, Meat, 2)
                .fluidOutputs(BacterialSludge.getFluid(100))
                .fluidOutputs(Purified_Water_Grade_E.getFluid(10000))
                .cleanroom(CleanroomType.CLEANROOM)
                .EUt(32000).duration(6400)
                .buildAndRegister();

        //Grade4 D
        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Zeolite)
                .circuitMeta(32)
                .fluidInputs(Purified_Water_Grade_E.getFluid(10000))
                .fluidOutputs(Purified_Water_Grade_D.getFluid(8000))
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .EUt(120000).duration(6000)
                .buildAndRegister();

        //Grade3 C
        RecipeMaps.ELECTROLYZER_RECIPES.recipeBuilder()
                .circuitMeta(32)
                .fluidInputs(Purified_Water_Grade_D.getFluid(8000))
                .notConsumable(plate, EnrichedNaquadahTriniumEuropiumDuranide)
                .fluidOutputs(Purified_Water_Grade_C.getFluid(6000))
                .fluidOutputs(DistilledWater.getFluid(2000))
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .EUt(480000).duration(8000)
                .buildAndRegister();

        //Grade2 B
        RecipeMaps.DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(Purified_Water_Grade_C.getFluid(6000))
                .fluidOutputs(Purified_Water_Grade_B.getFluid(4000))
                .fluidOutputs(Purified_Water_Grade_D.getFluid(500))
                .fluidOutputs(Purified_Water_Grade_E.getFluid(500))
                .fluidOutputs(Ethanol.getFluid(1000))
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .EUt(2000000).duration(7200)
                .buildAndRegister();

        //Grade1 A
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(BLACKLIGHT)
                .fluidInputs(Purified_Water_Grade_B.getFluid(4000))
                .fluidOutputs(Purified_Water_Grade_A.getFluid(2000))
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .EUt(8100000).duration(9000)
                .buildAndRegister();

    }

    private static void Change_Default_Water_Recipes() {
        //Bacteria
        RecipeMaps.BREWING_RECIPES.recipeBuilder()
                .input(BIO_CHAFF, 4)
                .fluidInputs(Purified_Water_Grade_D.getFluid(1000))
                .fluidOutputs(Bacteria.getFluid(1000))
                .EUt(480).duration(300)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //Agar
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, Gelatin, 1)
                .fluidInputs(Purified_Water_Grade_D.getFluid(1000))
                .output(dust, Agar, 1)
                .EUt(480).duration(600)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //Gelatin Mixture
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Collagen, 4)
                .fluidInputs(Purified_Water_Grade_D.getFluid(3000))
                .fluidInputs(PhosphoricAcid.getFluid(1000))
                .EUt(480).duration(1600)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();
    }
}
