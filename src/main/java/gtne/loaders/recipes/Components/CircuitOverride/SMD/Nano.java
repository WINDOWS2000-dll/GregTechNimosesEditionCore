package gtne.loaders.recipes.Components.CircuitOverride.SMD;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.RecipeMaps;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gtne.common.item.GTNEMetaItems.*;

public class Nano {

    public static void init() {

        //Transistor
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Palladium, 12)
                .input(plate, Magnalium)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(NANO_SMD_TRANSISTOR, 32)
                .EUt(480).duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Resistor
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Cerium, 8)
                .input(dust, Graphite, 1)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(NANO_SMD_RESISTOR, 24)
                .EUt(480).duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Capacitor
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(foil, HIGH_PURITY_SILICON, 4)
                .input(foil, Titanium, 1)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(NANO_SMD_CAPACITOR, 16)
                .EUt(480).duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Diode
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, ReinforcedEpoxyResin, 8)
                .input(dust, Caesium, 1)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(NANO_SMD_DIODE, 32)
                .EUt(360).duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }

}
