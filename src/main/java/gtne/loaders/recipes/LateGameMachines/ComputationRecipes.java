package gtne.loaders.recipes.LateGameMachines;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.*;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.blocks.*;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.MetaBlocks.OPTICAL_PIPES;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gtne.api.unification.material.GTNEMaterials.Indalloy_140;
import static gtne.common.item.GTNEMetaItems.*;

public class ComputationRecipes {

    public static void init() {
        if (ConfigHolder.recipeoption.Harder_Computation_System_Recipe) {
            AHSPU_IHSAIP();
            RemoveComputationSystemRecipe();
            ComputationSystemRecipes();
        }
    }

    private static void RemoveComputationSystemRecipe() {
        //Research Station
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{DATA_BANK.getStackForm(1), SENSOR_LuV.getStackForm(8), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 8), FIELD_GENERATOR_LuV.getStackForm(2), ELECTRIC_MOTOR_ZPM.getStackForm(2), OreDictUnifier.get(wireGtDouble, UraniumRhodiumDinaquadide, 32), OreDictUnifier.get(foil, Trinium, 32), new ItemStack(OPTICAL_PIPES[0], 16)}, new FluidStack[]{SolderingAlloy.getFluid(1152), VanadiumGallium.getFluid(1152)});
            //Research Station Research Recipe
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, TOOL_DATA_STICK.getStackForm(1), SCANNER[LuV].getStackForm(1));
        //High Performance Computing Array
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{DATA_BANK.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 4), FIELD_GENERATOR_LuV.getStackForm(8), TOOL_DATA_ORB.getStackForm(1), COVER_SCREEN.getStackForm(1), OreDictUnifier.get(wireGtDouble, UraniumRhodiumDinaquadide, 64), new ItemStack(OPTICAL_PIPES[0], 16)}, new FluidStack[]{SolderingAlloy.getFluid(1152), VanadiumGallium.getFluid(1152), PCBCoolant.getFluid(4000)});
            //High Performance Computing Array Research Recipe
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, TOOL_DATA_STICK.getStackForm(1), COVER_SCREEN.getStackForm(1));
        //Network Switch
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1), EMITTER_ZPM.getStackForm(4), SENSOR_ZPM.getStackForm(4), OreDictUnifier.get(circuit, MarkerMaterials.Tier.UV, 4), OreDictUnifier.get(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide, 32), OreDictUnifier.get(foil, Tritanium, 64), OreDictUnifier.get(foil, Tritanium, 64), new ItemStack(OPTICAL_PIPES[0], 8)}, new FluidStack[]{SolderingAlloy.getFluid(576), Polybenzimidazole.getFluid(576)});
            //Network Switch Research Recipe
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.RESEARCH_STATION_RECIPES, TOOL_DATA_ORB.getStackForm(1), new ItemStack(OPTICAL_PIPES[0], 1));
        //Computation Data Reception Hatch
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OPTICAL_DATA_HATCH_RECEIVER.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 1), SENSOR_LuV.getStackForm(1)}, new FluidStack[]{Polybenzimidazole.getFluid(288)});
        //Computation Data Transmission Hatch
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OPTICAL_DATA_HATCH_TRANSMITTER.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 1), EMITTER_LuV.getStackForm(1)}, new FluidStack[]{Polybenzimidazole.getFluid(288)});
        //HPCA Computation Component
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{HPCA_EMPTY_COMPONENT.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 4), FIELD_GENERATOR_LuV.getStackForm(1)}, new FluidStack[]{PCBCoolant.getFluid(1000)});
        //HPCA Advanced Computation Component
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{HPCA_COMPUTATION_COMPONENT.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.UV, 4), FIELD_GENERATOR_ZPM.getStackForm(1)}, new FluidStack[]{PCBCoolant.getFluid(1000)});
        //Optical Fiber Cable
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, BorosilicateGlass, 8), OreDictUnifier.get(foil, Silver, 8)}, new FluidStack[]{Polytetrafluoroethylene.getFluid(144)});
        //Computer Casing
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(frameGt, Iridium, 1), OreDictUnifier.get(plate, Iridium, 6), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 1), OreDictUnifier.get(wireFine, Osmium, 32), OreDictUnifier.get(wireFine, Copper, 32), OreDictUnifier.get(wireGtSingle, VanadiumGallium, 2));
        //Advanced Computer Casing
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 1), OreDictUnifier.get(wireFine, Cobalt, 64), OreDictUnifier.get(wireFine, Electrum, 64), OreDictUnifier.get(wireGtSingle, IndiumTinBariumTitaniumCuprate, 4));
        //Computer Heat Vent
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(frameGt, StainlessSteel, 1), ELECTRIC_MOTOR_IV.getStackForm(2), OreDictUnifier.get(rotor, StainlessSteel, 2), OreDictUnifier.get(pipeTinyFluid, StainlessSteel, 16), OreDictUnifier.get(plate, Copper, 16), OreDictUnifier.get(wireGtSingle, SamariumIronArsenicOxide, 1));
        //HPCA Heat Sink Components
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{HPCA_EMPTY_COMPONENT.getStackForm(1), OreDictUnifier.get(plate, Aluminium, 32), OreDictUnifier.get(screw, StainlessSteel, 8)}, new FluidStack[]{PCBCoolant.getFluid(1000)});
        //HPCA Active Colling Components
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.ADVANCED_COMPUTER_CASING, 1), OreDictUnifier.get(plate, Aluminium, 16), OreDictUnifier.get(pipeTinyFluid, StainlessSteel, 16), OreDictUnifier.get(screw, StainlessSteel, 8)}, new FluidStack[]{PCBCoolant.getFluid(1000)});
        //Empty HPCA Components
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV, 1), TOOL_DATA_STICK.getStackForm(1)}, new FluidStack[]{PCBCoolant.getFluid(1000)});
        //HPCA Bridge Components
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.ADVANCED_COMPUTER_CASING, 1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.UV, 1), EMITTER_ZPM.getStackForm(1), new ItemStack(OPTICAL_PIPES[0], 2)}, new FluidStack[]{PCBCoolant.getFluid(1000)});
        //Object Holder
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ITEM_IMPORT_BUS[ZPM].getStackForm(1), EMITTER_LuV.getStackForm(8), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 1), ROBOT_ARM_ZPM.getStackForm(2), ELECTRIC_MOTOR_ZPM.getStackForm(2), OreDictUnifier.get(wireGtDouble, UraniumRhodiumDinaquadide, 16), new ItemStack(OPTICAL_PIPES[0], 2)}, new FluidStack[]{SolderingAlloy.getFluid(576), Polybenzimidazole.getFluid(288)});
            //Object Holder Research Recipe
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, TOOL_DATA_STICK.getStackForm(1), ITEM_IMPORT_BUS[ZPM].getStackForm(1));
        //Optical Data Reception Hatch
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1), ITEM_IMPORT_BUS[LuV].getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 1), SENSOR_LuV.getStackForm(1), new ItemStack(OPTICAL_PIPES[0], 2)}, new FluidStack[]{Polybenzimidazole.getFluid(288)});
        //Optical Data Transmission Hatch
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1), ITEM_EXPORT_BUS[LuV].getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 1), EMITTER_IV.getStackForm(1), new ItemStack(OPTICAL_PIPES[0], 2)}, new FluidStack[]{Polybenzimidazole.getFluid(288)});
        //Data Access Hatch
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{ITEM_IMPORT_BUS[EV].getStackForm(1), TOOL_DATA_STICK.getStackForm(4), OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV, 4)}, new FluidStack[]{Polytetrafluoroethylene.getFluid(288)});
        //Advanced Data Access Hatch
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ITEM_IMPORT_BUS[LuV].getStackForm(1), TOOL_DATA_ORB.getStackForm(4), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 4)}, new FluidStack[]{SolderingAlloy.getFluid(576), Polybenzimidazole.getFluid(576)});
            //Advanced Data Access Hatch Research Recipe
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.RESEARCH_STATION_RECIPES, DATA_BANK.getStackForm(1), TOOL_DATA_ORB.getStackForm(1));
        //Data Bank
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 8), TOOL_DATA_ORB.getStackForm(1), OreDictUnifier.get(wireFine, Cobalt, 64), OreDictUnifier.get(wireFine, Copper, 64), new ItemStack(OPTICAL_PIPES[0], 4), OreDictUnifier.get(wireGtDouble, IndiumTinBariumTitaniumCuprate, 16)}, new FluidStack[]{SolderingAlloy.getFluid(288), Lubricant.getFluid(500)});
            //Data Bank Research Recipe
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, TOOL_DATA_STICK.getStackForm(1), DATA_ACCESS_HATCH.getStackForm(1));

    }

    private static void AHSPU_IHSAIP() {
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELITE_CIRCUIT_BOARD, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT, 8)
                .input(ENGRAVED_LAPOTRON_CHIP, 16)
                .input(ADVANCED_SMD_TRANSISTOR, 64)
                .input(ADVANCED_SMD_RESISTOR,  48)
                .input(ADVANCED_SMD_CAPACITOR, 48)
                .input(ADVANCED_SMD_DIODE, 48)
                .input(RANDOM_ACCESS_MEMORY, 64)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(pipeTinyFluid, Iridium, 8)
                .input(wireFine, IndiumTinBariumTitaniumCuprate, 32)
                .fluidInputs(Indalloy_140.getFluid(1440))
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 1)
                .scannerResearch(b -> b
                        .researchStack(CRYSTAL_PROCESSOR_IV.getStackForm())
                        .EUt(24000)
                        .duration(240))
                .EUt(80000).duration(2000)
                .buildAndRegister();

        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WETWARE_CIRCUIT_BOARD, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(CRYSTAL_SYSTEM_ON_CHIP, 4)
                .input(ENGRAVED_LAPOTRON_CHIP, 32)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT, 16)
                .input(ADVANCED_SMD_TRANSISTOR, 64)
                .input(ADVANCED_SMD_RESISTOR,  64)
                .input(ADVANCED_SMD_CAPACITOR, 64)
                .input(ADVANCED_SMD_DIODE, 64)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(pipeTinyFluid, Iridium, 32)
                .input(wireFine, UraniumRhodiumDinaquadide, 32)
                .fluidInputs(Indalloy_140.getFluid(1440))
                .fluidInputs(PCBCoolant.getFluid(8000))
                .output(IMPROVED_HIGH_SPEED_ARITHMETIC_INTEGRATED_PROCESSOR, 1)
                .stationResearch(b -> b
                        .researchStack(ADVANCED_HIGH_SPEED_PROCESSING_UNIT.getStackForm(1))
                        .EUt(100_000)
                        .CWUt(8, 256000))
                .EUt(100_000).duration(2400)
                .buildAndRegister();
    }

    private static void ComputationSystemRecipes() {
        //Research Station
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(DATA_BANK, 1)
                .input(SENSOR_LuV, 16)
                .input(EMITTER_LuV, 16)
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 8)
                .input(FIELD_GENERATOR_LuV, 4)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(wireGtDouble, UraniumRhodiumDinaquadide, 32)
                .input(foil, Trinium, 64)
                .input(foil, Trinium, 64)
                .input(OPTICAL_PIPES[0], 32)
                .fluidInputs(Indalloy_140.getFluid(2304))
                .fluidInputs(VanadiumGallium.getFluid(2304))
                .output(RESEARCH_STATION, 1)
                .scannerResearch(b -> b
                        .researchStack(SCANNER[6].getStackForm(1))
                        .EUt(7680)
                        .duration(24000))
                .EUt(100_000).duration(2400)
                .buildAndRegister();

        //High Performance Computing Array
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(DATA_BANK, 1)
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(FIELD_GENERATOR_LuV, 8)
                .input(TOOL_DATA_ORB, 8)
                .input(COVER_SCREEN, 2)
                .input(wireGtDouble, UraniumRhodiumDinaquadide, 64)
                .input(OPTICAL_PIPES[0], 32)
                .fluidInputs(Indalloy_140.getFluid(2304))
                .fluidInputs(VanadiumGallium.getFluid(2304))
                .fluidInputs(PCBCoolant.getFluid(8000))
                .output(HIGH_PERFORMANCE_COMPUTING_ARRAY, 1)
                .scannerResearch(b -> b
                        .researchStack(COVER_SCREEN.getStackForm(1))
                        .EUt(7680)
                        .duration(24000))
                .EUt(100_000).duration(2400)
                .buildAndRegister();

        //Network Switch
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1))
                .input(EMITTER_ZPM, 4)
                .input(SENSOR_ZPM, 4)
                .input(IMPROVED_HIGH_SPEED_ARITHMETIC_INTEGRATED_PROCESSOR, 4)
                .input(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide, 32)
                .input(foil, Tritanium, 64)
                .input(foil, Tritanium, 64)
                .input(OPTICAL_PIPES[0], 16)
                .fluidInputs(Indalloy_140.getFluid(1152))
                .fluidInputs(Polybenzimidazole.getFluid(1152))
                .output(NETWORK_SWITCH, 1)
                .stationResearch(b -> b
                        .researchStack(new ItemStack(OPTICAL_PIPES[0], 1))
                        .EUt(122880)
                        .CWUt(32, 256000))
                .EUt(122800).duration(2400)
                .buildAndRegister();

        //Computation Data Reception Hatch
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_DATA_HATCH_RECEIVER, 1)
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 2)
                .input(SENSOR_LuV, 1)
                .fluidInputs(Polybenzimidazole.getFluid(288))
                .output(COMPUTATION_HATCH_RECEIVER, 1)
                .EUt(30720).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Computation Data Transmission Hatch
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_DATA_HATCH_TRANSMITTER, 1)
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 2)
                .input(SENSOR_LuV, 1)
                .fluidInputs(Polybenzimidazole.getFluid(288))
                .output(COMPUTATION_HATCH_TRANSMITTER, 1)
                .EUt(30720).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //HPCA Computation Components
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(HPCA_EMPTY_COMPONENT, 1)
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(TOOL_DATA_ORB, 8)
                .input(wireGtSingle, UraniumRhodiumDinaquadide, 16)
                .input(FIELD_GENERATOR_LuV, 1)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(HPCA_COMPUTATION_COMPONENT, 1)
                .EUt(30720).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //HPCA Advanced Computation Components
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(HPCA_COMPUTATION_COMPONENT, 1)
                .input(IMPROVED_HIGH_SPEED_ARITHMETIC_INTEGRATED_PROCESSOR, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(TOOL_DATA_MODULE, 8)
                .input(wireGtDouble, UraniumRhodiumDinaquadide, 32)
                .input(FIELD_GENERATOR_ZPM, 2)
                .fluidInputs(PCBCoolant.getFluid(8000))
                .output(HPCA_ADVANCED_COMPUTATION_COMPONENT, 1)
                .EUt(122880).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Optical Fiber Cable
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, BorosilicateGlass, 8)
                .input(foil, Silver, 16)
                .input(plate, Glass, 1)
                .fluidInputs(Polybenzimidazole.getFluid(144))
                .output(OPTICAL_PIPES[0], 1)
                .EUt(7680).duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Computer Casing
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Iridium, 1)
                .input(plateDouble, Iridium, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 2)
                .input(circuit, MarkerMaterials.Tier.IV, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(ENGRAVED_LAPOTRON_CHIP, 8)
                .input(wireFine, Osmiridium, 32)
                .input(wireFine, Copper, 32)
                .input(wireGtSingle, VanadiumGallium, 2)
                .fluidInputs(VanadiumGallium.getFluid(576))
                .outputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 2))
                .EUt(30720).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Advanced Computer Casing
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1))
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 1)
                .input(wireFine, Cobalt, 64)
                .input(wireFine, Cobalt, 64)
                .input(wireFine, Electrum, 64)
                .input(wireFine, Electrum, 64)
                .input(wireGtSingle, IndiumTinBariumTitaniumCuprate, 4)
                .fluidInputs(IndiumTinBariumTitaniumCuprate.getFluid(144))
                .outputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.ADVANCED_COMPUTER_CASING, 1))
                .EUt(30720).duration(960)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Computer Heat Vent
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel, 1)
                .input(circuit, MarkerMaterials.Tier.IV, 1)
                .input(ELECTRIC_MOTOR_IV, 2)
                .input(rotor, StainlessSteel, 2)
                .input(STAINLESS_STEEL_BARS, 4) //TODO Stainless Steel Barsのレシピを書く（場所はここ）
                .input(pipeTinyFluid, StainlessSteel, 16)
                .input(plate, AnnealedCopper, 32)
                .input(wireGtSingle, SamariumIronArsenicOxide, 2)
                .outputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_HEAT_VENT, 2))
                .EUt(6000).duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //HPCA Heat Sink Components
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(HPCA_EMPTY_COMPONENT, 1)
                .input(plate, Aluminium, 48)
                .input(screw, StainlessSteel, 16)
                .input(pipeTinyFluid, StainlessSteel, 8)
                .fluidInputs(PCBCoolant.getFluid(1000))
                .outputs(HPCA_HEAT_SINK_COMPONENT.getStackForm(1))
                .EUt(7680).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //HPCA Active Colling Components
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.ADVANCED_COMPUTER_CASING, 1))
                .input(plateDouble, Aluminium, 16)
                .input(circuit, MarkerMaterials.Tier.IV, 1)
                .input(ELECTRIC_PUMP_IV, 1)
                .input(ELECTRIC_MOTOR_IV, 1)
                .input(rotor, StainlessSteel, 2)
                .input(pipeTinyFluid, StainlessSteel, 16)
                .input(screw, StainlessSteel, 16)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .outputs(HPCA_ACTIVE_COOLER_COMPONENT.getStackForm(1))
                .EUt(7680).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Empty HPCA Components
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1))
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(wireGtSingle, SamariumIronArsenicOxide, 2)
                .input(TOOL_DATA_STICK, 1)
                .fluidInputs(PCBCoolant.getFluid(1000))
                .outputs(HPCA_EMPTY_COMPONENT.getStackForm(1))
                .EUt(7680).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //HPCA Bridge Components
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.ADVANCED_COMPUTER_CASING, 1))
                .input(IMPROVED_HIGH_SPEED_ARITHMETIC_INTEGRATED_PROCESSOR, 2)
                .input(EMITTER_ZPM, 1)
                .input(SENSOR_ZPM, 1)
                .input(OPTICAL_PIPES[0], 4)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .outputs(HPCA_BRIDGE_COMPONENT.getStackForm(1))
                .EUt(30720).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Object Holder
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(ITEM_IMPORT_BUS[ZPM].getStackForm(1))
                .input(EMITTER_LuV, 16)
                .input(SENSOR_LuV, 16)
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 2)
                .input(ROBOT_ARM_ZPM, 2)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(wireGtDouble, UraniumRhodiumDinaquadide, 32)
                .input(OPTICAL_PIPES[0],4)
                .fluidInputs(Indalloy_140.getFluid(1152))
                .fluidInputs(Polybenzimidazole.getFluid(576))
                .output(OBJECT_HOLDER, 1)
                .EUt(100_000).duration(2400)
                .buildAndRegister();

        //Optical Data Reception Hatch
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1))
                .inputs(ITEM_IMPORT_BUS[LuV].getStackForm(1))
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 2)
                .input(SENSOR_IV, 2)
                .input(plate, Glass, 1)
                .input(OPTICAL_PIPES[0], 4)
                .fluidInputs(Polybenzimidazole.getFluid(288))
                .outputs(OPTICAL_DATA_HATCH_RECEIVER.getStackForm(1))
                .EUt(30720).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Optical Data Transmission Hatch
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.COMPUTER_CASING, 1))
                .inputs(ITEM_EXPORT_BUS[LuV].getStackForm(1))
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 2)
                .input(EMITTER_IV, 2)
                .input(plate, Glass, 1)
                .input(OPTICAL_PIPES[0], 4)
                .fluidInputs(Polybenzimidazole.getFluid(288))
                .outputs(OPTICAL_DATA_HATCH_TRANSMITTER.getStackForm(1))
                .EUt(30720).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Data Access Hatch
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(ITEM_IMPORT_BUS[EV].getStackForm(1))
                .input(TOOL_DATA_STICK, 8)
                .input(circuit, MarkerMaterials.Tier.IV, 8)
                .input(circuit, MarkerMaterials.Tier.EV, 16)
                .fluidInputs(Polytetrafluoroethylene.getFluid(576))
                .output(DATA_ACCESS_HATCH, 1)
                .EUt(1920).duration(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //Advanced Data Access Hatch
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(ITEM_IMPORT_BUS[LuV].getStackForm(1))
                .input(TOOL_DATA_ORB, 8)
                .input(ADVANCED_HIGH_SPEED_PROCESSING_UNIT, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .fluidInputs(Indalloy_140.getFluid(576))
                .fluidInputs(Polybenzimidazole.getFluid(1152))
                .output(ADVANCED_DATA_ACCESS_HATCH, 1)
                .stationResearch(b -> b
                        .researchStack(DATA_BANK.getStackForm(1))
                        .EUt(30720)
                        .CWUt(4, 64000))
                .EUt(8000).duration(4000)
                .buildAndRegister();

    }
}
