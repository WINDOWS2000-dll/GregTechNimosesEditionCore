package gtne.loaders.recipes.LateGameMachines;

import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.recipes.*;
import gregtech.api.recipes.ingredients.nbtmatch.NBTCondition;
import gregtech.api.recipes.ingredients.nbtmatch.NBTMatcher;
import gregtech.api.unification.material.MarkerMaterial;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gtne.common.ConfigHolder;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;
import static gtne.api.util.GTNEUtil.GTNEMachineRecipeName;

public class LateGameMachines {

    public static void init() {
            if (ConfigHolder.recipeoption.Super_HardMode_LateGame) {
                RemoveLuVMachinesRecipe();
                ChangeLuVMachineRecipe();
                RemoveZPMMachineRecipe();
                ChangeZPMMachineRecipe();
                RemoveUVMachineRecipe();
                ChangeUVMachineRecipe();
        }
    }

    //LuV Machine Recipe Remove
    private static void RemoveLuVMachinesRecipe() {

        for (int i = 0; i < GTNEMachineRecipeName.length; i++) {
            ModHandler.removeRecipeByName("gregtech:gregtech.machine." + GTNEMachineRecipeName[i] + ".luv");
        }

    }

    //LuV Machine Recipe Change
    private static void ChangeLuVMachineRecipe() {

        //Electric Furnace
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(wireGtQuadruple, NiobiumTitanium, 6)
                .input(VOLTAGE_COIL_LuV, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(ELECTRIC_FURNACE[6].getStackForm())
                .research(b -> b
                        .researchStack(ELECTRIC_FURNACE[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Macerator
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(gear, TungstenSteel, 2)
                .input(gearSmall, TungstenSteel, 4)
                .input(COMPONENT_GRINDER_TUNGSTEN, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(MACERATOR[6].getStackForm())
                .research(b -> b
                        .researchStack(MACERATOR[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Alloy Smelter
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TUNGSTENSTEEL, 2))
                .input(wireGtQuadruple, HSSG, 2)
                .input(VOLTAGE_COIL_LuV, 6)
                .input(VOLTAGE_COIL_IV, 12)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 8)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(ALLOY_SMELTER[6].getStackForm())
                .research(b ->b
                        .researchStack(ALLOY_SMELTER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Arc Furnace
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 6)
                .input(dust, Graphite, 16)
                .input(cableGtOctal, HSSG, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 12)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(ARC_FURNACE[6].getStackForm())
                .research(b -> b
                        .researchStack(ARC_FURNACE[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Assembling Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(ROBOT_ARM_LuV, 2)
                .input(CONVEYOR_MODULE_LuV, 2)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(EMITTER_LuV, 1)
                .input(SENSOR_LuV, 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 8)
                .input(cableGtSingle, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(2880))
                .fluidInputs(TungstenSteel.getFluid(576))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(ASSEMBLER[6].getStackForm())
                .research(b -> b
                        .researchStack(ASSEMBLER[5].getStackForm())
                        .EUt(8000)
                        .duration(24000))
                .EUt(20000).duration(1200)
                .buildAndRegister();

        //Auto Clave
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 4))
                .input(plate, HSSG, 16)
                .input(plateDouble, StainlessSteel, 8)
                .input(ring, SiliconeRubber, 8)
                .input(VOLTAGE_COIL_LuV,4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(AUTOCLAVE[6].getStackForm())
                .research(b -> b
                        .researchStack(AUTOCLAVE[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Bending Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 4)
                .input(ELECTRIC_MOTOR_LuV, 4)
                .input(plate, HSSG, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(BENDER[6].getStackForm())
                .research(b -> b
                        .researchStack(BENDER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Brewery
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 4))
                .input(spring, HSSG, 2)
                .input(pipeSmallFluid, Polybenzimidazole, 8)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(BREWERY[6].getStackForm())
                .research(b -> b
                        .researchStack(BREWERY[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Canning Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 6))
                .input(pipeSmallFluid, Polybenzimidazole, 6)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(CANNER[6].getStackForm())
                .research(b -> b
                        .researchStack(CANNER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Centrifuge
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(ELECTRIC_MOTOR_LuV, 4)
                .input(gear, HSSG, 2)
                .input(gearSmall, HSSG, 4)
                .input(FLUID_FILTER, 4)
                .input(ITEM_FILTER, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(CENTRIFUGE[6].getStackForm())
                .research(b -> b
                        .researchStack(CENTRIFUGE[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Chemical Bath
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(CONVEYOR_MODULE_LuV, 3)
                .input(ELECTRIC_PUMP_LuV, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 4))
                .input(pipeNormalFluid, Polybenzimidazole, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(CHEMICAL_BATH[6].getStackForm())
                .research(b -> b
                        .researchStack(CHEMICAL_BATH[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Chemical Reactor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(rotor, HSSG, 2)
                .input(ring, SiliconeRubber, 8)
                .input(VOLTAGE_COIL_LuV, 2)
                .input(pipeNormalFluid, Polybenzimidazole, 4)
                .input(pipeHugeFluid, Polybenzimidazole, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 4))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(CHEMICAL_REACTOR[6].getStackForm())
                .research(b -> b
                        .researchStack(CHEMICAL_REACTOR[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Compressor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 4)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(block, TungstenSteel, 2)
                .input(gear, HSSG, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(COMPRESSOR[6].getStackForm())
                .research(b -> b
                        .researchStack(COMPRESSOR[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Cutting Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(CONVEYOR_MODULE_LuV, 2)
                .input(gearSmall, HSSG, 2)
                .input(toolHeadBuzzSaw, HSSE, 1)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 2))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(CUTTER[6].getStackForm())
                .research(b -> b
                        .researchStack(CUTTER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Distillery
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 2)
                .input(spring, HSSG, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 4))
                .input(pipeLargeFluid, Polybenzimidazole, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(DISTILLERY[6].getStackForm())
                .research(b -> b
                        .researchStack(DISTILLERY[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Electrolyzer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(wireGtDouble, Osmium, 4)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 2))
                .input(pipeNormalFluid, Polybenzimidazole, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(ELECTROLYZER[6].getStackForm())
                .research(b -> b
                        .researchStack(ELECTROLYZER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Electromagnetic Separator
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(CONVEYOR_MODULE_LuV, 2)
                .input(cableGtOctal, Graphene, 2)
                .input(stickLong, Osmium, 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(ELECTROMAGNETIC_SEPARATOR[6].getStackForm())
                .research(b -> b
                        .researchStack(ELECTROMAGNETIC_SEPARATOR[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Extractor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 2)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(VOLTAGE_COIL_LuV, 2)
                .input(pipeLargeFluid, NiobiumTitanium, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 4))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(EXTRACTOR[6].getStackForm())
                .research(b -> b
                        .researchStack(EXTRACTOR[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Extruder
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 4)
                .input(wireGtQuadruple, HSSG, 4)
                .input(VOLTAGE_COIL_LuV, 4)
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TUNGSTENSTEEL, 4))
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 2))
                .input(pipeLargeFluid, NiobiumTitanium, 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 8)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(EXTRUDER[6].getStackForm())
                .research(b -> b
                        .researchStack(EXTRUDER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Fermenter
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 2)
                .input(pipeNormalFluid, Polybenzimidazole, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 4))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(FERMENTER[6].getStackForm())
                .research(b -> b
                        .researchStack(FERMENTER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //FluidHeater
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 4)
                .input(pipeNormalFluid, NiobiumTitanium, 2)
                .input(cableGtQuadruple, HSSG, 4)
                .input(VOLTAGE_COIL_LuV, 2)
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TUNGSTENSTEEL, 1))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(FLUID_HEATER[6].getStackForm())
                .research(b -> b
                        .researchStack(FLUID_HEATER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Fluid Solidifier
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PUMP_LuV, 4)
                .input(pipeNormalFluid, NiobiumTitanium, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 2))
                .input("chestWood", 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(FLUID_SOLIDIFIER[6].getStackForm())
                .research(b -> b
                        .researchStack(FLUID_SOLIDIFIER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Forge Hammer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 2)
                .input(gear, HSSG, 2)
                .input("craftingAnvil", 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(FORGE_HAMMER[6].getStackForm())
                .research(b -> b
                        .researchStack(FORGE_HAMMER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Forming Press
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 4)
                .input(gear, HSSG, 2)
                .input(plate, HSSG, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(FORMING_PRESS[6].getStackForm())
                .research(b -> b
                        .researchStack(FORMING_PRESS[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Lathe
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 2)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(COMPONENT_GRINDER_TUNGSTEN, 2)
                .input(bolt, Diamond, 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(LATHE[6].getStackForm())
                .research(b -> b
                        .researchStack(LATHE[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Scanner
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(EMITTER_LuV, 4)
                .input(SENSOR_LuV, 4)
                .inputNBT(TOOL_DATA_ORB, 4, NBTMatcher.ANY, NBTCondition.ANY)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(SCANNER[6].getStackForm())
                .research(b -> b
                        .researchStack(SCANNER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Mixer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(ELECTRIC_PUMP_LuV, 1)
                .input(pipeSmallFluid, Polybenzimidazole, 4)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 8))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(MIXER[6].getStackForm())
                .research(b -> b
                        .researchStack(MIXER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Ore Washer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(ELECTRIC_PUMP_LuV, 1)
                .input(pipeSmallFluid, Polybenzimidazole, 4)
                .input(rotor, HSSG, 4)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 2))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(ORE_WASHER[6].getStackForm())
                .research(b -> b
                        .researchStack(ORE_WASHER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Packager
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ROBOT_ARM_LuV, 2)
                .input(CONVEYOR_MODULE_LuV, 2)
                .input("chestWood", 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(PACKER[6].getStackForm())
                .research(b -> b
                        .researchStack(PACKER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Gas Collector
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 2)
                .input(ELECTRIC_PUMP_LuV, 4)
                .input(FLUID_FILTER, 4)
                .input("barsIron", 32)
                .input(pipeSmallFluid, Polybenzimidazole, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(GAS_COLLECTOR[6].getStackForm())
                .research(b -> b
                        .researchStack(GAS_COLLECTOR[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Polarizer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 1)
                .input(stickLong, Osmium, 2)
                .input(wireGtOctal, Graphene, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(POLARIZER[6].getStackForm())
                .research(b -> b
                        .researchStack(POLARIZER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Precision Laser Engraver
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 6)
                .input(EMITTER_LuV, 2)
                .input(ELECTRIC_PISTON_LUV, 4)
                .input(SENSOR_LuV, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(LASER_ENGRAVER[6].getStackForm())
                .research(b -> b
                        .researchStack(LASER_ENGRAVER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Sifting Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 4)
                .input(ITEM_FILTER, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(SIFTER[6].getStackForm())
                .research(b -> b
                        .researchStack(SIFTER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Thermal Centrifuge
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_MOTOR_LuV, 4)
                .input(wireGtQuadruple, HSSG, 4)
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TUNGSTENSTEEL, 2))
                .input(VOLTAGE_COIL_LuV, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(THERMAL_CENTRIFUGE[6].getStackForm())
                .research(b -> b
                        .researchStack(THERMAL_CENTRIFUGE[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //WireMill
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_MOTOR_LuV, 8)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(WIREMILL[6].getStackForm())
                .research(b -> b
                        .researchStack(WIREMILL[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //Circuit Assembler
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(ROBOT_ARM_LuV, 2)
                .input(EMITTER_LuV, 4)
                .input(SENSOR_LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 1)
                .input(CONVEYOR_MODULE_LuV, 4)
                .inputNBT(TOOL_DATA_ORB, 8, NBTMatcher.ANY, NBTCondition.ANY)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(2880))
                .fluidInputs(TungstenSteel.getFluid(576))
                .fluidInputs(HSSG.getFluid(144))
                .outputs(CIRCUIT_ASSEMBLER[6].getStackForm())
                .research(b -> b
                        .researchStack(CIRCUIT_ASSEMBLER[5].getStackForm())
                        .EUt(8000)
                        .duration(24000))
                .EUt(20000).duration(1200)
                .buildAndRegister();

        //RockBreaker
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.LuV, 2)
                .input(ELECTRIC_PISTON_LUV, 1)
                .input(ELECTRIC_MOTOR_LuV, 1)
                .input(COMPONENT_GRINDER_TUNGSTEN, 1)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 6))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 8)
                .input(cableGtSingle, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(ROCK_BREAKER[6].getStackForm())
                .research(b -> b
                        .researchStack(ROCK_BREAKER[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
                .buildAndRegister();

        //World Accelerator
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(circuit, MarkerMaterials.Tier.ZPM, 32)
                .input(circuit, MarkerMaterials.Tier.LuV, 64)
                .input(FIELD_GENERATOR_LuV, 8)
                .input(EMITTER_LuV, 8)
                .input(SENSOR_LuV, 8)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(CARBON_FIBER_PLATE, 8)
                .input(cableGtDouble, NiobiumTitanium, 32)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(WORLD_ACCELERATOR[6].getStackForm())
                .research(b -> b
                        .researchStack(WORLD_ACCELERATOR[5].getStackForm())
                        .EUt(8000)
                        .duration(48000))
                .EUt(30000).duration(4800)
                .buildAndRegister();

    }

    //ZPM Machine Recipe Remove
    private static void RemoveZPMMachineRecipe() {

        for (int i = 0; i < GTNEMachineRecipeName.length; i++) {
            ModHandler.removeRecipeByName("gregtech:gregtech.machine." + GTNEMachineRecipeName[i] + ".zpm");
        }

    }

    //ZPM Machine Recipe Change
    private static void ChangeZPMMachineRecipe() {

        //Electric Furnace
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(wireGtQuadruple, VanadiumGallium, 6)
                .input(VOLTAGE_COIL_ZPM, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(2280))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(ELECTRIC_FURNACE[7].getStackForm())
                .research(b -> b
                        .researchStack(ELECTRIC_FURNACE[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Macerator
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(gear, HSSS, 2)
                .input(gearSmall, HSSS, 4)
                .input(COMPONENT_GRINDER_TUNGSTEN, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(2880))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(MACERATOR[7].getStackForm())
                .research(b -> b
                        .researchStack(MACERATOR[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Alloy Smelter
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.HSS_G, 2))
                .input(wireGtQuadruple, Naquadah, 2)
                .input(VOLTAGE_COIL_ZPM, 6)
                .input(VOLTAGE_COIL_LuV, 12)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(ALLOY_SMELTER[7].getStackForm())
                .research(b ->b
                        .researchStack(ALLOY_SMELTER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Arc Furnace
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 6)
                .input(dust, Graphite, 24)
                .input(cableGtOctal, Naquadah, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(CARBON_FIBER_PLATE, 48)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(ARC_FURNACE[7].getStackForm())
                .research(b -> b
                        .researchStack(ARC_FURNACE[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Assembling Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(ROBOT_ARM_ZPM, 2)
                .input(CONVEYOR_MODULE_ZPM, 2)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(EMITTER_ZPM, 1)
                .input(SENSOR_ZPM, 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(cableGtSingle, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(2880 * 2))
                .fluidInputs(HSSG.getFluid(576))
                .fluidInputs(Naquadah.getFluid(288))
                .outputs(ASSEMBLER[7].getStackForm())
                .research(b -> b
                        .researchStack(ASSEMBLER[6].getStackForm())
                        .EUt(30000)
                        .CWUt(4)
                        .duration(24000))
                .EUt(100000).duration(1200)
                .buildAndRegister();

        //Auto Clave
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 4))
                .input(plate, Naquadah, 16)
                .input(plateDouble, StainlessSteel, 16)
                .input(ring, SiliconeRubber, 16)
                .input(VOLTAGE_COIL_ZPM,4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 32)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(AUTOCLAVE[7].getStackForm())
                .research(b -> b
                        .researchStack(AUTOCLAVE[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Bending Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(plate, Naquadah, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(BENDER[7].getStackForm())
                .research(b -> b
                        .researchStack(BENDER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Brewery
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 4))
                .input(spring, Naquadah, 2)
                .input(pipeSmallFluid, Naquadah, 8)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(BREWERY[7].getStackForm())
                .research(b -> b
                        .researchStack(BREWERY[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Canning Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 6))
                .input(pipeSmallFluid, Naquadah, 6)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(CANNER[7].getStackForm())
                .research(b -> b
                        .researchStack(CANNER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Centrifuge
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(gear, Naquadah, 2)
                .input(gearSmall, Naquadah, 4)
                .input(FLUID_FILTER, 8)
                .input(ITEM_FILTER, 8)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(CENTRIFUGE[7].getStackForm())
                .research(b -> b
                        .researchStack(CENTRIFUGE[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Chemical Bath
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(CONVEYOR_MODULE_ZPM, 3)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 4))
                .input(pipeNormalFluid, Naquadah, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(CHEMICAL_BATH[7].getStackForm())
                .research(b -> b
                        .researchStack(CHEMICAL_BATH[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Chemical Reactor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(rotor, NaquadahAlloy, 2)
                .input(ring, SiliconeRubber, 16)
                .input(VOLTAGE_COIL_ZPM, 2)
                .input(pipeNormalFluid, Naquadah, 4)
                .input(pipeHugeFluid, Naquadah, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 4))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(CHEMICAL_REACTOR[7].getStackForm())
                .research(b -> b
                        .researchStack(CHEMICAL_REACTOR[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Compressor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(block, HSSG, 2)
                .input(gear, Naquadah, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(COMPRESSOR[7].getStackForm())
                .research(b -> b
                        .researchStack(COMPRESSOR[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Cutting Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(CONVEYOR_MODULE_ZPM, 2)
                .input(gearSmall, Naquadah, 2)
                .input(toolHeadBuzzSaw, NaquadahAlloy, 1)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 2))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(CUTTER[7].getStackForm())
                .research(b -> b
                        .researchStack(CUTTER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Distillery
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 2)
                .input(spring, Naquadah, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 4))
                .input(pipeLargeFluid, Naquadah, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(DISTILLERY[7].getStackForm())
                .research(b -> b
                        .researchStack(DISTILLERY[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Electrolyzer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(wireGtDouble, YttriumBariumCuprate, 4)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 2))
                .input(pipeNormalFluid, Naquadah, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(ELECTROLYZER[7].getStackForm())
                .research(b -> b
                        .researchStack(ELECTROLYZER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Electromagnetic Separator
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(CONVEYOR_MODULE_ZPM, 2)
                .input(cableGtOctal, Graphene, 2)
                .input(stickLong, Osmiridium, 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(ELECTROMAGNETIC_SEPARATOR[7].getStackForm())
                .research(b -> b
                        .researchStack(ELECTROMAGNETIC_SEPARATOR[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Extractor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 2)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(VOLTAGE_COIL_ZPM, 2)
                .input(pipeLargeFluid, Naquadah, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 4))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(EXTRACTOR[7].getStackForm())
                .research(b -> b
                        .researchStack(EXTRACTOR[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Extruder
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 4)
                .input(wireGtQuadruple, Naquadah, 4)
                .input(VOLTAGE_COIL_LuV, 4)
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TUNGSTENSTEEL, 4))
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 2))
                .input(pipeLargeFluid, NiobiumTitanium, 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(EXTRUDER[7].getStackForm())
                .research(b -> b
                        .researchStack(EXTRUDER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Fermenter
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 2)
                .input(pipeNormalFluid, Naquadah, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 4))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(FERMENTER[7].getStackForm())
                .research(b -> b
                        .researchStack(FERMENTER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //FluidHeater
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 4)
                .input(pipeNormalFluid, Naquadah, 2)
                .input(cableGtQuadruple, Naquadah, 4)
                .input(VOLTAGE_COIL_ZPM, 2)
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.HSS_G, 1))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(FLUID_HEATER[7].getStackForm())
                .research(b -> b
                        .researchStack(FLUID_HEATER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Fluid Solidifier
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 4)
                .input(pipeNormalFluid, Naquadah, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 2))
                .input("chestWood", 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(FLUID_SOLIDIFIER[7].getStackForm())
                .research(b -> b
                        .researchStack(FLUID_SOLIDIFIER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Forge Hammer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 2)
                .input(gear, Naquadah, 2)
                .input("craftingAnvil", 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(FORGE_HAMMER[7].getStackForm())
                .research(b -> b
                        .researchStack(FORGE_HAMMER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Forming Press
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 4)
                .input(gear, Naquadah, 2)
                .input(plate, Naquadah, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(1440* 2 ))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(FORMING_PRESS[7].getStackForm())
                .research(b -> b
                        .researchStack(FORMING_PRESS[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Lathe
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 2)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(COMPONENT_GRINDER_TUNGSTEN, 2)
                .input(bolt, Diamond, 1)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(LATHE[7].getStackForm())
                .research(b -> b
                        .researchStack(LATHE[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Scanner
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(EMITTER_ZPM, 4)
                .input(SENSOR_ZPM, 4)
                .inputNBT(TOOL_DATA_ORB, 8, NBTMatcher.ANY, NBTCondition.ANY)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(SCANNER[7].getStackForm())
                .research(b -> b
                        .researchStack(SCANNER[6].getStackForm())
                        .EUt(24000)
                        .CWUt(4)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Mixer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(ELECTRIC_PUMP_ZPM, 1)
                .input(pipeSmallFluid, Naquadah, 4)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 8))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(MIXER[7].getStackForm())
                .research(b -> b
                        .researchStack(MIXER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Ore Washer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(ELECTRIC_PUMP_ZPM, 1)
                .input(pipeSmallFluid, Naquadah, 4)
                .input(rotor, NaquadahAlloy, 4)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 2))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(ORE_WASHER[7].getStackForm())
                .research(b -> b
                        .researchStack(ORE_WASHER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Packager
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ROBOT_ARM_ZPM, 2)
                .input(CONVEYOR_MODULE_ZPM, 2)
                .input("chestWood", 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(PACKER[7].getStackForm())
                .research(b -> b
                        .researchStack(PACKER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Gas Collector
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 2)
                .input(ELECTRIC_PUMP_ZPM, 4)
                .input(FLUID_FILTER, 8)
                .input("barsIron", 32)
                .input(pipeSmallFluid, Naquadah, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(GAS_COLLECTOR[7].getStackForm())
                .research(b -> b
                        .researchStack(GAS_COLLECTOR[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Polarizer
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 1)
                .input(stickLong, Osmiridium, 2)
                .input(wireGtOctal, Graphene, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(POLARIZER[7].getStackForm())
                .research(b -> b
                        .researchStack(POLARIZER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Precision Laser Engraver
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 6)
                .input(EMITTER_ZPM, 2)
                .input(ELECTRIC_PISTON_ZPM, 4)
                .input(SENSOR_ZPM, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(LASER_ENGRAVER[7].getStackForm())
                .research(b -> b
                        .researchStack(LASER_ENGRAVER[6].getStackForm())
                        .EUt(4096)
                        .CWUt(4)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Sifting Machine
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 4)
                .input(ITEM_FILTER, 8)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(SIFTER[7].getStackForm())
                .research(b -> b
                        .researchStack(SIFTER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Thermal Centrifuge
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(wireGtQuadruple, Naquadah, 4)
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.HSS_G, 2))
                .input(VOLTAGE_COIL_ZPM, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(THERMAL_CENTRIFUGE[7].getStackForm())
                .research(b -> b
                        .researchStack(THERMAL_CENTRIFUGE[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //WireMill
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 8)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(WIREMILL[7].getStackForm())
                .research(b -> b
                        .researchStack(WIREMILL[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //Circuit Assembler
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 16)
                .input(ROBOT_ARM_ZPM, 2)
                .input(EMITTER_ZPM, 4)
                .input(SENSOR_ZPM, 4)
                .input(ELECTRIC_PISTON_ZPM, 1)
                .input(CONVEYOR_MODULE_ZPM, 4)
                .inputNBT(TOOL_DATA_ORB, 16, NBTMatcher.ANY, NBTCondition.ANY)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(cableGtSingle, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(2880 * 2))
                .fluidInputs(HSSG.getFluid(576))
                .fluidInputs(Naquadah.getFluid(144))
                .outputs(CIRCUIT_ASSEMBLER[7].getStackForm())
                .research(b -> b
                        .researchStack(CIRCUIT_ASSEMBLER[6].getStackForm())
                        .EUt(32000)
                        .CWUt(8)
                        .duration(24000))
                .EUt(120000).duration(1200)
                .buildAndRegister();

        //RockBreaker
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.ZPM, 2)
                .input(ELECTRIC_PISTON_ZPM, 1)
                .input(ELECTRIC_MOTOR_ZPM, 1)
                .input(COMPONENT_GRINDER_TUNGSTEN, 1)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 6))
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(CARBON_FIBER_PLATE, 16)
                .input(cableGtSingle, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(ROCK_BREAKER[7].getStackForm())
                .research(b -> b
                        .researchStack(ROCK_BREAKER[6].getStackForm())
                        .EUt(24000)
                        .duration(12000))
                .EUt(50000).duration(600)
                .buildAndRegister();

        //World Accelerator
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .input(circuit, MarkerMaterials.Tier.UV, 32)
                .input(circuit, MarkerMaterials.Tier.ZPM, 64)
                .input(FIELD_GENERATOR_ZPM, 8)
                .input(EMITTER_ZPM, 8)
                .input(SENSOR_ZPM, 8)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 64)
                .input(CARBON_FIBER_PLATE, 32)
                .input(cableGtDouble, VanadiumGallium, 32)
                .fluidInputs(SolderingAlloy.getFluid(1440 * 2))
                .fluidInputs(HSSG.getFluid(288))
                .outputs(WORLD_ACCELERATOR[7].getStackForm())
                .research(b -> b
                        .researchStack(WORLD_ACCELERATOR[6].getStackForm())
                        .EUt(32000)
                        .CWUt(16)
                        .duration(48000))
                .EUt(131072).duration(4800)
                .buildAndRegister();

    }

    //UV Machine Recipe Remove
    private static void RemoveUVMachineRecipe() {

        for (int i = 0; i < GTNEMachineRecipeName.length; i++) {
            ModHandler.removeRecipeByName("gregtech:gregtech.machine." + GTNEMachineRecipeName[i] + ".uv");
        }

    }

    //UV Machine Recipe Change
    private static void ChangeUVMachineRecipe() {
    }

}
