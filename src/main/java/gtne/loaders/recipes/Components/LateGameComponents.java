package gtne.loaders.recipes.Components;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;
import static gtne.api.unification.material.GTNEMaterials.*;

public class LateGameComponents {

    //ToDo Late IVの各種コンポーネントレシピのZenScriptからの移行
    public static void init() {
        if (ConfigHolder.recipeoption.Harder_LateGame_Components_Recipe) {
            RemoveLuVComponentsRecipe();
            LuVComponents();
            RemoveZPMComponentsRecipe();
            ZPMComponents();
            RemoveUVComponentsRecipe();
            UVComponents();
        }
    }

    private static void RemoveLuVComponentsRecipe() {
        //Motor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, SamariumMagnetic, 1), OreDictUnifier.get(stickLong, HSSS, 2), OreDictUnifier.get(ring, HSSS, 2), OreDictUnifier.get(round, HSSS, 4), OreDictUnifier.get(wireFine, Ruridit, 64), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, ELECTRIC_MOTOR_IV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Pump
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_LuV.getStackForm(1), OreDictUnifier.get(pipeSmallFluid, NiobiumTitanium, 1), OreDictUnifier.get(plate, HSSS, 2), OreDictUnifier.get(screw, HSSS, 8), OreDictUnifier.get(ring, SiliconeRubber, 4), OreDictUnifier.get(rotor, HSSS, 1), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, ELECTRIC_PUMP_IV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Conveyor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_LuV.getStackForm(2), OreDictUnifier.get(plate, HSSS, 2), OreDictUnifier.get(ring, HSSS, 4), OreDictUnifier.get(round, HSSS, 16), OreDictUnifier.get(screw, HSSS, 4), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250), StyreneButadieneRubber.getFluid(1152)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, CONVEYOR_MODULE_IV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Piston
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_LuV.getStackForm(1), OreDictUnifier.get(plate, HSSS, 4), OreDictUnifier.get(ring, HSSS, 4), OreDictUnifier.get(round, HSSS, 16), OreDictUnifier.get(stick, HSSS, 4), OreDictUnifier.get(gear, HSSS, 1), OreDictUnifier.get(gearSmall, HSSS, 2), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, ELECTRIC_PISTON_IV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Robot Arm
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, HSSS, 4), OreDictUnifier.get(gear, HSSS, 1), OreDictUnifier.get(gearSmall, HSSS, 3), ELECTRIC_MOTOR_LuV.getStackForm(2), ELECTRIC_PISTON_LUV.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV, 2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.EV, 4), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(576), Lubricant.getFluid(250)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, ROBOT_ARM_IV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Field Generator
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, HSSS, 1), OreDictUnifier.get(plate, HSSS, 6), QUANTUM_STAR.getStackForm(1), EMITTER_LuV.getStackForm(2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 2), OreDictUnifier.get(wireFine, IndiumTinBariumTitaniumCuprate, 64), OreDictUnifier.get(wireFine, IndiumTinBariumTitaniumCuprate, 64), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(576)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, FIELD_GENERATOR_IV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Emitter
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, HSSS, 1), ELECTRIC_MOTOR_LuV.getStackForm(1), OreDictUnifier.get(stickLong, Ruridit, 4), QUANTUM_STAR.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 2), OreDictUnifier.get(foil, Palladium, 64), OreDictUnifier.get(foil, Palladium, 32), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(288)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, EMITTER_IV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Sensor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, HSSS, 1), ELECTRIC_MOTOR_LuV.getStackForm(1), OreDictUnifier.get(plate, Ruridit, 4), QUANTUM_STAR.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 2), OreDictUnifier.get(foil, Palladium, 64), OreDictUnifier.get(foil, Palladium, 32), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(288)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, SENSOR_IV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
    }

    private static void LuVComponents() {

        //Motor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 1)
                .input(stickLong, HSSS, 2)
                .input(ring, HSSS, 2)
                .input(round, HSSS, 4)
                .input(wireFine, Ruridit, 64)
                .input(wireFine, Ruridit, 64)
                .input(cableGtSingle, YttriumBariumCuprate, 2)
                .fluidInputs(Indalloy_140.getFluid(L * 2))
                .fluidInputs(Lubricant.getFluid(250))
                .output(ELECTRIC_MOTOR_LuV, 1)
                .scannerResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(7680).duration(600)
                .buildAndRegister();

        //Pump
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_LuV, 1)
                .input(pipeSmallFluid, NiobiumTitanium, 2)
                .input(plate, HSSS, 2)
                .input(screw, HSSS, 8)
                .input(ring, StyreneButadieneRubber, 4)
                .input(rotor, HSSS, 2)
                .input(cableGtSingle, YttriumBariumCuprate, 2)
                .fluidInputs(Indalloy_140.getFluid(L * 2))
                .fluidInputs(Lubricant.getFluid(250))
                .output(ELECTRIC_PUMP_LuV, 1)
                .scannerResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(7680).duration(600)
                .buildAndRegister();

        //Conveyor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(plate, HSSS, 2)
                .input(ring, HSSS, 4)
                .input(round, HSSS, 32)
                .input(cableGtSingle, YttriumBariumCuprate, 2)
                .input(plate, SiliconeRubber, 16)
                .fluidInputs(Indalloy_140.getFluid(L * 2))
                .fluidInputs(Lubricant.getFluid(250))
                .output(CONVEYOR_MODULE_LuV, 1)
                .scannerResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(7680).duration(600)
                .buildAndRegister();

        //Piston
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_LuV, 1)
                .input(plate, HSSS, 6)
                .input(ring, HSSS, 4)
                .input(round, HSSS, 32)
                .input(stick, HSSS, 4)
                .input(gear, HSSS, 2)
                .input(gearSmall, HSSS, 4)
                .input(cableGtSingle, YttriumBariumCuprate, 4)
                .fluidInputs(Indalloy_140.getFluid(L * 2))
                .fluidInputs(Lubricant.getFluid(250))
                .output(ELECTRIC_PISTON_LUV, 1)
                .scannerResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(7680).duration(600)
                .buildAndRegister();

        //RoBot Arm
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, HSSS, 4)
                .input(gear, HSSS, 1)
                .input(gear, HSSS, 3)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(ELECTRIC_PISTON_LUV, 1)
                .input(circuit, MarkerMaterials.Tier.LuV, 2)
                .input(circuit, MarkerMaterials.Tier.IV, 4)
                .input(circuit, MarkerMaterials.Tier.EV, 8)
                .input(cableGtSingle, YttriumBariumCuprate, 6)
                .fluidInputs(Indalloy_140.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(250))
                .output(ROBOT_ARM_LuV, 1)
                .scannerResearch(b -> b
                        .researchStack(ROBOT_ARM_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(7680).duration(600)
                .buildAndRegister();

        //Field Generator
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 1)
                .input(plate, HSSS, 6)
                .input(QUANTUM_STAR, 2)
                .input(EMITTER_LuV, 4)
                .input(SENSOR_LuV, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(wireFine, Ruridit, 64)
                .input(wireFine, Ruridit, 64)
                .input(wireFine, Ruridit, 64)
                .input(wireFine, Ruridit, 64)
                .input(cableGtSingle, YttriumBariumCuprate, 8)
                .fluidInputs(Indalloy_140.getFluid(L * 4))
                .output(FIELD_GENERATOR_LuV, 1)
                .scannerResearch(b -> b
                        .researchStack(FIELD_GENERATOR_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(7680).duration(600)
                .buildAndRegister();

        //Emitter
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 1)
                .input(ELECTRIC_MOTOR_LuV, 1)
                .input(stick, Ruridit, 8)
                .input(QUANTUM_STAR, 1)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(foil, Gallium, 64)
                .input(foil, Gallium, 64)
                .input(foil, Gallium, 64)
                .input(cableGtSingle, YttriumBariumCuprate, 7)
                .fluidInputs(Indalloy_140.getFluid(L * 4))
                .output(EMITTER_LuV, 1)
                .scannerResearch(b -> b
                        .researchStack(EMITTER_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(7680).duration(600)
                .buildAndRegister();

        //Sensor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 1)
                .input(ELECTRIC_MOTOR_LuV, 1)
                .input(plate, Ruridit, 8)
                .input(QUANTUM_STAR, 1)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(foil, Gallium, 64)
                .input(foil, Gallium, 64)
                .input(foil, Gallium, 64)
                .input(cableGtSingle, YttriumBariumCuprate, 7)
                .fluidInputs(Indalloy_140.getFluid(L * 4))
                .output(SENSOR_LuV, 1)
                .scannerResearch(b -> b
                        .researchStack(SENSOR_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(7680).duration(600)
                .buildAndRegister();



    }

    private static void RemoveZPMComponentsRecipe() {
        //Motor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, SamariumMagnetic, 1), OreDictUnifier.get(stickLong, Osmiridium, 4), OreDictUnifier.get(ring, Osmiridium, 4), OreDictUnifier.get(round, Osmiridium, 8), OreDictUnifier.get(wireFine, Europium, 64), OreDictUnifier.get(wireFine, Europium, 32), OreDictUnifier.get(cableGtSingle, VanadiumGallium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(288), Lubricant.getFluid(500)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, ELECTRIC_MOTOR_LuV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Pump
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_ZPM.getStackForm(1), OreDictUnifier.get(pipeNormalFluid, Polybenzimidazole, 1), OreDictUnifier.get(plate, Osmiridium, 2), OreDictUnifier.get(screw, Osmiridium, 8), OreDictUnifier.get(ring, SiliconeRubber, 8), OreDictUnifier.get(rotor, Osmiridium, 1), OreDictUnifier.get(cableGtSingle, VanadiumGallium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(288), Lubricant.getFluid(500)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, ELECTRIC_PUMP_LuV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Conveyor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_ZPM.getStackForm(2), OreDictUnifier.get(plate, Osmiridium, 2), OreDictUnifier.get(ring, Osmiridium, 4), OreDictUnifier.get(round, Osmiridium, 16), OreDictUnifier.get(screw, Osmiridium, 4), OreDictUnifier.get(cableGtSingle, VanadiumGallium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(288), Lubricant.getFluid(500), StyreneButadieneRubber.getFluid(2304)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, CONVEYOR_MODULE_LuV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Piston
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_ZPM.getStackForm(1), OreDictUnifier.get(plate, Osmiridium, 4), OreDictUnifier.get(ring, Osmiridium, 4), OreDictUnifier.get(round, Osmiridium, 16), OreDictUnifier.get(stick, Osmiridium, 4), OreDictUnifier.get(gear, Osmiridium, 1), OreDictUnifier.get(gearSmall, Osmiridium, 2), OreDictUnifier.get(cableGtSingle, VanadiumGallium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(288), Lubricant.getFluid(500)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, ELECTRIC_PISTON_ZPM.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //RoBot Arm
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, Osmiridium, 4), OreDictUnifier.get(gear, Osmiridium, 1), OreDictUnifier.get(gearSmall, Osmiridium, 3), ELECTRIC_MOTOR_ZPM.getStackForm(2), ELECTRIC_PISTON_ZPM.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 1),OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV, 4), OreDictUnifier.get(cableGtSingle, VanadiumGallium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(1152), Lubricant.getFluid(500)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.SCANNER_RECIPES, ROBOT_ARM_LuV.getStackForm(1), TOOL_DATA_STICK.getStackForm(1));
        //Field Generator
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, NaquadahAlloy, 1), OreDictUnifier.get(plate, NaquadahAlloy, 6), QUANTUM_STAR.getStackForm(1), EMITTER_ZPM.getStackForm(2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 2), OreDictUnifier.get(wireFine, UraniumRhodiumDinaquadide, 64), OreDictUnifier.get(wireFine, UraniumRhodiumDinaquadide, 64), OreDictUnifier.get(cableGtSingle, VanadiumGallium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(1152)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.RESEARCH_STATION_RECIPES, FIELD_GENERATOR_LuV.getStackForm(1), TOOL_DATA_ORB.getStackForm(1));
        //Emitter
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, NaquadahAlloy, 1), ELECTRIC_MOTOR_ZPM.getStackForm(1), OreDictUnifier.get(stickLong, Osmiridium, 4), QUANTUM_STAR.getStackForm(2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 2), OreDictUnifier.get(foil, Trinium, 64), OreDictUnifier.get(foil, Trinium, 32), OreDictUnifier.get(cableGtSingle, VanadiumGallium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(576)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.RESEARCH_STATION_RECIPES, EMITTER_LuV.getStackForm(1), TOOL_DATA_ORB.getStackForm(1));
        //Sensor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, NaquadahAlloy, 1), ELECTRIC_MOTOR_ZPM.getStackForm(1), OreDictUnifier.get(plate, Osmiridium, 4), QUANTUM_STAR.getStackForm(2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.ZPM, 2), OreDictUnifier.get(foil, Trinium, 64), OreDictUnifier.get(foil, Trinium, 32), OreDictUnifier.get(cableGtSingle, VanadiumGallium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(576)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.RESEARCH_STATION_RECIPES, SENSOR_LuV.getStackForm(1), TOOL_DATA_ORB.getStackForm(1));
    }


    private static void ZPMComponents() {
        //Motor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 1)
                .input(stickLong, NaquadahAlloy, 4)
                .input(ring, NaquadahAlloy, 4)
                .input(round, NaquadahAlloy, 16)
                .input(wireFine, Europium, 64)
                .input(wireFine, Europium, 64)
                .input(wireFine, Europium, 64)
                .input(cableGtQuadruple, VanadiumGallium, 2)
                .fluidInputs(Indalloy_140.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(750))
                .output(ELECTRIC_MOTOR_ZPM, 1)
                .scannerResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_LuV.getStackForm())
                        .EUt(7680)
                        .duration(7200))
                .EUt(30720).duration(600)
                .buildAndRegister();
        //Pump
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_ZPM, 1)
                .input(pipeNormalFluid, Naquadah, 2)
                .input(plate, NaquadahAlloy, 4)
                .input(screw, NaquadahAlloy, 8)
                .input(ring, SiliconeRubber, 8)
                .input(rotor, NaquadahAlloy, 2)
                .input(cableGtQuadruple, VanadiumGallium, 2)
                .fluidInputs(Indalloy_140.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(750))
                .output(ELECTRIC_PUMP_ZPM, 1)
                .scannerResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_LuV.getStackForm())
                        .EUt(7680)
                        .duration(7200))
                .EUt(30720).duration(600)
                .buildAndRegister();
        //Conveyor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(plate, NaquadahAlloy, 2)
                .input(ring, NaquadahAlloy, 4)
                .input(round, NaquadahAlloy, 32)
                .input(cableGtQuadruple, VanadiumGallium, 2)
                .input(plate, StyreneButadieneRubber, 20)
                .fluidInputs(Indalloy_140.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(750))
                .output(CONVEYOR_MODULE_ZPM, 1)
                .scannerResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_LuV.getStackForm())
                        .EUt(7680)
                        .duration(7200))
                .EUt(30720).duration(600)
                .buildAndRegister();
        //Electric Piston
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_ZPM, 1)
                .input(plate, NaquadahAlloy,  6)
                .input(ring, NaquadahAlloy, 4)
                .input(round, NaquadahAlloy, 32)
                .input(stickLong, NaquadahAlloy, 4)
                .input(gear, NaquadahAlloy, 2)
                .input(gearSmall, NaquadahAlloy, 4)
                .input(cableGtQuadruple, VanadiumGallium, 4)
                .fluidInputs(Indalloy_140.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(750))
                .output(ELECTRIC_PISTON_ZPM, 1)
                .scannerResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_LUV.getStackForm())
                        .EUt(7680)
                        .duration(7200))
                .EUt(30720).duration(600)
                .buildAndRegister();
        //Robot Arm
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, NaquadahAlloy, 4)
                .input(gear, NaquadahAlloy, 1)
                .input(gearSmall, NaquadahAlloy, 3)
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(ELECTRIC_PISTON_ZPM, 1)
                .input(circuit, MarkerMaterials.Tier.ZPM, 2)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(circuit, MarkerMaterials.Tier.IV, 8)
                .input(cableGtQuadruple, VanadiumGallium, 6)
                .fluidInputs(Indalloy_140.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(750))
                .output(ROBOT_ARM_ZPM, 1)
                .scannerResearch(b -> b
                        .researchStack(ROBOT_ARM_LuV.getStackForm())
                        .EUt(7680)
                        .duration(7200))
                .EUt(30720).duration(600)
                .buildAndRegister();
        //Field Generator
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 1)
                .input(plateDouble, NaquadahAlloy, 6)
                .input(QUANTUM_STAR, 4)
                .input(EMITTER_ZPM, 4)
                .input(SENSOR_ZPM, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 8)
                .input(wireFine, Europium, 64)
                .input(wireFine, Europium, 64)
                .input(wireFine, Europium, 64)
                .input(wireFine, Europium, 64)
                .input(cableGtQuadruple, VanadiumGallium, 8)
                .fluidInputs(Indalloy_140.getFluid(1152))
                .output(FIELD_GENERATOR_ZPM, 1)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_LuV.getStackForm())
                        .EUt(7680)
                        .CWUt(12, 86400))
                .EUt(30720).duration(600)
                .buildAndRegister();

        //Emitter
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 1)
                .input(ELECTRIC_MOTOR_ZPM, 1)
                .input(stickLong, Osmiridium, 8)
                .input(QUANTUM_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(foil, Trinium, 64)
                .input(foil, Trinium, 64)
                .input(foil, Trinium, 64)
                .input(cableGtQuadruple, VanadiumGallium, 7)
                .fluidInputs(Indalloy_140.getFluid(1152))
                .output(EMITTER_ZPM, 1)
                .stationResearch(b -> b
                        .researchStack(EMITTER_LuV.getStackForm())
                        .EUt(7680)
                        .CWUt(8, 57600))
                .EUt(30720).duration(600)
                .buildAndRegister();
        //Sensor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 1)
                .input(ELECTRIC_MOTOR_ZPM, 1)
                .input(plateDouble, Osmiridium, 8)
                .input(QUANTUM_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(foil, Trinium, 64)
                .input(foil, Trinium, 64)
                .input(foil, Trinium, 64)
                .input(cableGtQuadruple, VanadiumGallium, 7)
                .fluidInputs(Indalloy_140.getFluid(1152))
                .output(SENSOR_ZPM, 1)
                .stationResearch(b -> b
                        .researchStack(SENSOR_LuV.getStackForm())
                        .EUt(7680)
                        .CWUt(4, 28800))
                .EUt(30720).duration(600)
                .buildAndRegister();
    }

    private static void RemoveUVComponentsRecipe() {
        //Electric Motor

    }

    private static void UVComponents() {
        //
    }
}
