package gtne.loaders.recipes.ChemicalChains.Polymers;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.RecipeMaps;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gtne.api.unification.material.GTNEMaterials.*;

public class Kevlar {

    public static void init() {
        kevlar_chemical_chain();
    }

    private static void kevlar_chemical_chain() {

        //Kevlar Chain
        //1x Kevlar
        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, CalciumChloride, 1)
                .input(dust, PARA_PHENYLENEDIAMINE, 9)
                .input(dust, TEREPHTHALOYL_CHLORIDE, 9)
                .fluidInputs(N_METHYL_TWO_PYRROLIDONE.getFluid(1000))
                .fluidOutputs(LIQUID_CRYSTAL_KEVLAR.getFluid(9000))
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(2000))
                .EUt(262144).duration(720)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //7x Kevlar
        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(9)
                .input(dust, CalciumChloride, 7)
                .input(dust, PARA_PHENYLENEDIAMINE, 63)
                .input(dust, TEREPHTHALOYL_CHLORIDE, 63)
                .fluidInputs(N_METHYL_TWO_PYRROLIDONE.getFluid(7000))
                .fluidOutputs(LIQUID_CRYSTAL_KEVLAR.getFluid(63000))
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(14000))
                .EUt(262144).duration(5040)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //Para-Phenylenediamine Chain
        /*
        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, Palladium, 1)
                .fluidInputs(NitrogenDioxide.getFluid(100))
                .fluidInputs(Hydrogen.getFluid(6000))
                .fluidInputs(FOUR_NITROANILINE.getFluid(1000))
                .output(dust, PARA_PHENYLENEDIAMINE, 16)
                .fluidOutputs(Water.getFluid(2000))

         */
    }

}
