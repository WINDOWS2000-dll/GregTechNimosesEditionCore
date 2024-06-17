package gtne.loaders.recipes.Components.CircuitOverride;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;
import static gtne.common.item.GTNEMetaItems.*;

public class CircuitOverride {

    public static void init() {
        CircuitRecipeRemove();
        Add_Circuit_Recipe();
    }

    private static void CircuitRecipeRemove() {
        //GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{}, new FluidStack[]{});
        //Nano
        //Processor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), SMD_RESISTOR.getStackForm(8), SMD_CAPACITOR.getStackForm(8), SMD_TRANSISTOR.getStackForm(8), OreDictUnifier.get(wireFine, Electrum, 8)}, new FluidStack[]{SolderingAlloy.getFluid(72)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), SMD_RESISTOR.getStackForm(8), SMD_CAPACITOR.getStackForm(8), SMD_TRANSISTOR.getStackForm(8), OreDictUnifier.get(wireFine, Electrum, 8)}, new FluidStack[]{Tin.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), ADVANCED_SMD_RESISTOR.getStackForm(2), ADVANCED_SMD_CAPACITOR.getStackForm(2), ADVANCED_SMD_TRANSISTOR.getStackForm(2), OreDictUnifier.get(wireFine, Electrum, 8)}, new FluidStack[]{SolderingAlloy.getFluid(72)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), ADVANCED_SMD_RESISTOR.getStackForm(2), ADVANCED_SMD_CAPACITOR.getStackForm(2), ADVANCED_SMD_TRANSISTOR.getStackForm(2), OreDictUnifier.get(wireFine, Electrum, 8)}, new FluidStack[]{Tin.getFluid(144)});
        //Assembly
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_PROCESSOR_HV.getStackForm(2), SMD_INDUCTOR.getStackForm(4), SMD_CAPACITOR.getStackForm(8), RANDOM_ACCESS_MEMORY.getStackForm(8), OreDictUnifier.get(wireFine, Electrum, 16)}, new FluidStack[]{SolderingAlloy.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_PROCESSOR_HV.getStackForm(2), SMD_INDUCTOR.getStackForm(4), SMD_CAPACITOR.getStackForm(8), RANDOM_ACCESS_MEMORY.getStackForm(8), OreDictUnifier.get(wireFine, Electrum, 16)}, new FluidStack[]{Tin.getFluid(288)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_PROCESSOR_HV.getStackForm(2), ADVANCED_SMD_INDUCTOR.getStackForm(1), ADVANCED_SMD_CAPACITOR.getStackForm(2), RANDOM_ACCESS_MEMORY.getStackForm(8), OreDictUnifier.get(wireFine, Electrum, 16)}, new FluidStack[]{SolderingAlloy.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_PROCESSOR_HV.getStackForm(2), ADVANCED_SMD_INDUCTOR.getStackForm(1), ADVANCED_SMD_CAPACITOR.getStackForm(2), RANDOM_ACCESS_MEMORY.getStackForm(8), OreDictUnifier.get(wireFine, Electrum, 16)}, new FluidStack[]{Tin.getFluid(288)});
        //Super_Computer
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2), SMD_DIODE.getStackForm(8), NOR_MEMORY_CHIP.getStackForm(4), RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(wireFine, Electrum, 16)}, new FluidStack[]{SolderingAlloy.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2), SMD_DIODE.getStackForm(8), NOR_MEMORY_CHIP.getStackForm(4), RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(wireFine, Electrum, 16)}, new FluidStack[]{Tin.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2), ADVANCED_SMD_DIODE.getStackForm(2), NOR_MEMORY_CHIP.getStackForm(4), RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(wireFine, Electrum, 16)}, new FluidStack[]{SolderingAlloy.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{ADVANCED_CIRCUIT_BOARD.getStackForm(), NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2), ADVANCED_SMD_DIODE.getStackForm(2), NOR_MEMORY_CHIP.getStackForm(4), RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(wireFine, Electrum, 16)}, new FluidStack[]{Tin.getFluid(144)});
        //Main_Frame
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, Aluminium, 2), NANO_COMPUTER_IV.getStackForm(2), SMD_INDUCTOR.getStackForm(16), SMD_CAPACITOR.getStackForm(32), RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(wireGtSingle, Copper, 32)}, new FluidStack[]{SolderingAlloy.getFluid(288)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, Aluminium, 2), NANO_COMPUTER_IV.getStackForm(2), SMD_INDUCTOR.getStackForm(16), SMD_CAPACITOR.getStackForm(32), RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(wireGtSingle, Copper, 32)}, new FluidStack[]{Tin.getFluid(576)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, Aluminium, 2), NANO_COMPUTER_IV.getStackForm(2), ADVANCED_SMD_INDUCTOR.getStackForm(4), ADVANCED_SMD_CAPACITOR.getStackForm(8), RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(wireGtSingle, Copper, 32)}, new FluidStack[]{SolderingAlloy.getFluid(288)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, Aluminium, 2), NANO_COMPUTER_IV.getStackForm(2), ADVANCED_SMD_INDUCTOR.getStackForm(4), ADVANCED_SMD_CAPACITOR.getStackForm(8), RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(wireGtSingle, Copper, 32)}, new FluidStack[]{Tin.getFluid(576)});

        //Quantum

        //Crystal
    }

    private static void Add_Circuit_Recipe() {

        //Nano Circuit - Soldering Alloy Recipe
        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(NANO_CENTRAL_PROCESSING_UNIT, 4)
                .input(NANO_SMD_RESISTOR, 4)
                .input(NANO_SMD_CAPACITOR, 4)
                .input(NANO_SMD_TRANSISTOR, 4)
                .input(wireFine, Electrum, 16)
                .fluidInputs(SolderingAlloy.getFluid(144))
                .output(NANO_PROCESSOR_HV, 1)
                .EUt(720).duration(240)
                .buildAndRegister();

        //Nano Circuit - Tin Recipe
        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(NANO_CENTRAL_PROCESSING_UNIT, 4)
                .input(NANO_SMD_RESISTOR, 4)
                .input(NANO_SMD_CAPACITOR, 4)
                .input(NANO_SMD_TRANSISTOR, 4)
                .input(wireFine, Electrum, 16)
                .fluidInputs(Tin.getFluid(288))
                .output(NANO_PROCESSOR_HV, 1)
                .EUt(720).duration(240)
                .buildAndRegister();

        //Nano Assembly - Soldering Alloy Recipe
        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(NANO_PROCESSOR_HV, 2)
                .input(NANO_SMD_INDUCTOR, 4)
                .input(NANO_SMD_CAPACITOR, 8)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(wireFine, Electrum, 32)
                .fluidInputs(SolderingAlloy.getFluid(288))
                .output(NANO_PROCESSOR_ASSEMBLY_EV, 1)
                .EUt(720).duration(480)
                .buildAndRegister();

        //Nano Assembly - Tin Recipe
        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(NANO_PROCESSOR_HV, 2)
                .input(NANO_SMD_INDUCTOR, 4)
                .input(NANO_SMD_CAPACITOR, 8)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(wireFine, Electrum, 32)
                .fluidInputs(Tin.getFluid(576))
                .output(NANO_PROCESSOR_ASSEMBLY_EV, 1)
                .EUt(720).duration(480)
                .buildAndRegister();

        //Nano Super Computer - Soldering Recipe
        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                .input(NANO_SMD_DIODE, 4)
                .input(NOR_MEMORY_CHIP, 8)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(wireFine, Electrum, 48)
                .fluidInputs(SolderingAlloy.getFluid(288))
                .output(NANO_COMPUTER_IV, 1)
                .EUt(720).duration(480)
                .buildAndRegister();

        //Nano Super Computer - Tin Recipe
        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                .input(NANO_SMD_DIODE, 4)
                .input(NOR_MEMORY_CHIP, 8)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(wireFine, Electrum, 48)
                .fluidInputs(Tin.getFluid(576))
                .output(NANO_COMPUTER_IV, 1)
                .EUt(720).duration(480)
                .buildAndRegister();

        //Nano MainFrame - Soldering Recipe
        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium, 2)
                .input(NANO_COMPUTER_IV, 2)
                .input(NANO_SMD_INDUCTOR, 8)
                .input(NANO_SMD_CAPACITOR, 16)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtDouble, AnnealedCopper, 32)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .output(NANO_MAINFRAME_LUV, 1)
                .EUt(1920).duration(960)
                .buildAndRegister();

        //Nano MainFrame - Tin Recipe
        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium, 2)
                .input(NANO_COMPUTER_IV, 2)
                .input(NANO_SMD_INDUCTOR, 8)
                .input(NANO_SMD_CAPACITOR, 16)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtDouble, AnnealedCopper, 32)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .output(NANO_MAINFRAME_LUV, 1)
                .EUt(1920).duration(960)
                .buildAndRegister();


    }

}
