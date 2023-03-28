package gtne.loaders.recipes.SingleBlocks;

import com.google.common.graph.Graph;
import gregtech.api.items.OreDictNames;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.*;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gtne.api.recipes.GTNERecipeMaps;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import cofh.thermalfoundation.init.TFFluids;
import scala.collection.script.End;

import javax.annotation.Nonnull;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class ComponentsAssembler {

    public static void init() {

        int robotarm_duration = 160;
        int field_generator_duration = 240;
        int other_duration = 120;
        int halfsold = 72;
        int sold = 144;

        //MV Components
        //Motor
        ModHandler.removeRecipeByName("gregtech:electric_motor_mv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Aluminium, 2), OreDictUnifier.get(stick, SteelMagnetic, 1),
                OreDictUnifier.get(wireGtDouble, Cupronickel, 4), OreDictUnifier.get(cableGtSingle, Copper, 2));
        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Aluminium, 2)
                .input(stick, SteelMagnetic, 1)
                .input(wireGtDouble, Cupronickel, 4)
                .input(cableGtSingle, Copper, 2)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(ELECTRIC_MOTOR_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();


        //Pump
        ModHandler.removeRecipeByName("gregtech:electric_pump_mv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_mv_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_mv_styrene_butadiene_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(pipeNormalFluid, Steel, 1),
                OreDictUnifier.get(screw, Bronze, 1), OreDictUnifier.get(rotor, Bronze, 1),
                OreDictUnifier.get(ring, SiliconeRubber, 2), ELECTRIC_MOTOR_MV.getStackForm(1));

        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(pipeNormalFluid, Steel, 1),
                OreDictUnifier.get(screw, Bronze, 1), OreDictUnifier.get(rotor, Bronze, 1),
                OreDictUnifier.get(ring, StyreneButadieneRubber, 2), ELECTRIC_MOTOR_MV.getStackForm(1));

        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(pipeNormalFluid, Steel, 1),
                OreDictUnifier.get(screw, Bronze, 1), OreDictUnifier.get(rotor, Bronze, 1),
                OreDictUnifier.get(ring, Rubber, 2), ELECTRIC_MOTOR_MV.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 2)
                .input(pipeNormalFluid, Steel, 1)
                .input(screw, Bronze, 2)
                .input(rotor, Bronze, 1)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_MV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 2)
                .input(pipeNormalFluid, Steel, 1)
                .input(screw, Bronze, 2)
                .input(rotor, Bronze, 1)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_MV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 2)
                .input(pipeNormalFluid, Steel, 1)
                .input(screw, Bronze, 2)
                .input(rotor, Bronze, 1)
                .input(ring, Rubber, 4)
                .input(ELECTRIC_MOTOR_MV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();


        //Conveyor
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(plate, StyreneButadieneRubber, 6), ELECTRIC_MOTOR_MV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(plate, SiliconeRubber, 6), ELECTRIC_MOTOR_MV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(plate, Rubber, 6), ELECTRIC_MOTOR_MV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 1)
                .input(plate, Rubber, 12)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input(ring, Bronze, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 1)
                .input(plate, SiliconeRubber, 6)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input(ring, Bronze, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 1)
                .input(plate, StyreneButadieneRubber, 6)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input(ring, Bronze, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();


        //Electric Piston
        ModHandler.removeRecipeByName("gregtech:electric_piston_mv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Aluminium, 2), OreDictUnifier.get(cableGtSingle, Copper, 2),
                OreDictUnifier.get(plate, Aluminium, 3), OreDictUnifier.get(gearSmall, Aluminium, 1),
                ELECTRIC_MOTOR_MV.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Aluminium, 3)
                .input(cableGtSingle, Copper, 2)
                .input(plate, Aluminium, 3)
                .input(gear, Aluminium, 1)
                .input(gearSmall, Aluminium, 2)
                .input(ELECTRIC_MOTOR_MV, 1)
                .fluidInputs(Lubricant.getFluid(200))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PISTON_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();


        //Robot Arm
        ModHandler.removeRecipeByName("gregtech:robot_arm_mv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 3), OreDictUnifier.get(stick, Aluminium, 2),
                ELECTRIC_MOTOR_MV.getStackForm(2), ELECTRIC_PISTON_MV.getStackForm(1),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.MV));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 3)
                .input(stick, Aluminium, 4)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input(ELECTRIC_PISTON_MV, 1)
                .input(gearSmall, Aluminium, 2)
                .input(circuit, MarkerMaterials.Tier.MV)
                .fluidInputs(Lubricant.getFluid(240))
                .fluidInputs(SolderingAlloy.getFluid(sold * 2))
                .output(ROBOT_ARM_MV)
                .duration(robotarm_duration).EUt(VA[LV])
                .buildAndRegister();


        //Field_Generator
        ModHandler.removeRecipeByName("gregtech:field_generator_mv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(gem, EnderEye, 1), OreDictUnifier.get(plate, Aluminium, 2),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.MV, 2), OreDictUnifier.get(wireGtQuadruple, MagnesiumDiboride, 4));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(gem, EnderEye, 1)
                .input(plate, Aluminium, 4)
                .input(circuit, MarkerMaterials.Tier.MV, 4)
                .input(wireGtQuadruple, MagnesiumDiboride, 4)
                .input(SENSOR_MV, 1)
                .input(EMITTER_MV, 1)
                .fluidInputs(SolderingAlloy.getFluid(sold * 4))
                .fluidInputs(Helium3.getFluid(1000))
                .fluidInputs(new FluidStack(TFFluids.fluidEnder, 1000))
                .output(FIELD_GENERATOR_MV)
                .duration(field_generator_duration).EUt(VA[LV])
                .buildAndRegister();


        //Emitter
        ModHandler.removeRecipeByName("gregtech:emitter_mv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Electrum, 4), OreDictUnifier.get(cableGtSingle, Copper, 2),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.MV, 2), OreDictUnifier.get(gemFlawless, Emerald, 1),
                IntCircuitIngredient.getIntegratedCircuit(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Electrum, 6)
                .input(cableGtSingle, Copper, 2)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(gemFlawless, Emerald, 1)
                .input(lens, Glass, 2)
                .circuitMeta(1)
                .fluidInputs(Glass.getFluid(576))
                .fluidInputs(SolderingAlloy.getFluid(sold * 3))
                .output(EMITTER_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();


        //Sensor
        ModHandler.removeRecipeByName("gregtech:sensor_mv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Electrum, 1), OreDictUnifier.get(plate, Aluminium, 4),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.MV), OreDictUnifier.get(gemFlawless, Emerald, 1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Electrum, 2)
                .input(plate, Aluminium, 6)
                .input(cableGtSingle, Copper, 2)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(gemFlawless, Emerald, 1)
                .fluidInputs(SolderingAlloy.getFluid(sold * 3))
                .output(SENSOR_MV)
                .duration(other_duration).EUt(VA[LV])
                .buildAndRegister();


        //HV Components
        //Motor
        ModHandler.removeRecipeByName("gregtech:electric_motor_hv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtDouble, Silver, 2), OreDictUnifier.get(stick, StainlessSteel, 2),
                                                                            OreDictUnifier.get(stick, SteelMagnetic, 1), OreDictUnifier.get(wireGtDouble, Electrum, 4));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, SteelMagnetic, 1)
                .input(stick, StainlessSteel, 2)
                .input(wireGtDouble, Electrum, 4)
                .input(cableGtDouble, Silver, 2)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(ELECTRIC_MOTOR_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();


        //Pump
        ModHandler.removeRecipeByName("gregtech:electric_pump_hv_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_hv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_hv_styrene_butadiene_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Gold, 1), OreDictUnifier.get(pipeNormalFluid, StainlessSteel, 1), OreDictUnifier.get(screw, Steel, 1), OreDictUnifier.get(rotor, Steel, 1), OreDictUnifier.get(ring, Rubber, 2), ELECTRIC_MOTOR_HV.getStackForm(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Gold, 1), OreDictUnifier.get(pipeNormalFluid, StainlessSteel, 1), OreDictUnifier.get(screw, Steel, 1), OreDictUnifier.get(rotor, Steel, 1), OreDictUnifier.get(ring, SiliconeRubber, 2), ELECTRIC_MOTOR_HV.getStackForm(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Gold, 1), OreDictUnifier.get(pipeNormalFluid, StainlessSteel, 1), OreDictUnifier.get(screw, Steel, 1), OreDictUnifier.get(rotor, Steel, 1), OreDictUnifier.get(ring, StyreneButadieneRubber, 2), ELECTRIC_MOTOR_HV.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Gold, 2)
                .input(pipeNormalFluid, StainlessSteel, 1)
                .input(screw, Steel, 2)
                .input(rotor, Steel, 1)
                .input(ring, Rubber, 4)
                .input(ELECTRIC_MOTOR_HV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Gold, 2)
                .input(pipeNormalFluid, StainlessSteel, 1)
                .input(screw, Steel, 2)
                .input(rotor, Steel, 1)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_HV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Gold, 2)
                .input(pipeNormalFluid, StainlessSteel, 1)
                .input(screw, Steel, 2)
                .input(rotor, Steel, 1)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_HV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();


        //Conveyor
        ModHandler.removeRecipeByName("gregtech:conveyor_module_hv_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_hv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_hv_styrene_butadiene_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Gold, 1), OreDictUnifier.get(plate, StyreneButadieneRubber, 6), ELECTRIC_MOTOR_HV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Gold, 1), OreDictUnifier.get(plate, SiliconeRubber, 6), ELECTRIC_MOTOR_HV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Gold, 1), OreDictUnifier.get(plate, Rubber, 6), ELECTRIC_MOTOR_HV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Gold, 1)
                .input(plate, Rubber, 12)
                .input(ELECTRIC_MOTOR_HV, 2)
                .input(ring, Steel, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Gold, 1)
                .input(plate, SiliconeRubber, 6)
                .input(ELECTRIC_MOTOR_HV, 2)
                .input(ring, Steel, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Gold, 1)
                .input(plate, StyreneButadieneRubber, 6)
                .input(ELECTRIC_MOTOR_HV, 2)
                .input(ring, Steel, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();


        //Electric Piston
        ModHandler.removeRecipeByName("gregtech:electric_piston_hv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, StainlessSteel, 2), OreDictUnifier.get(cableGtSingle, Gold, 2),
                                                                            OreDictUnifier.get(plate, StainlessSteel, 3), OreDictUnifier.get(gearSmall, StainlessSteel, 1),
                                                                            ELECTRIC_MOTOR_HV.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, StainlessSteel, 3)
                .input(cableGtSingle, Gold, 2)
                .input(plate, StainlessSteel, 3)
                .input(gear, StainlessSteel, 1)
                .input(gearSmall, StainlessSteel, 2)
                .input(ELECTRIC_MOTOR_HV, 1)
                .fluidInputs(Lubricant.getFluid(200))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PISTON_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();

        //Robot Arm
        ModHandler.removeRecipeByName("gregtech:robot_arm_hv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Gold, 3), OreDictUnifier.get(stick, StainlessSteel, 2),
                                                                            ELECTRIC_MOTOR_HV.getStackForm(2), ELECTRIC_PISTON_HV.getStackForm(1),
                                                                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.HV));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Gold, 3)
                .input(stick, StainlessSteel, 4)
                .input(ELECTRIC_MOTOR_HV, 2)
                .input(ELECTRIC_PISTON_HV, 1)
                .input(gearSmall, StainlessSteel, 2)
                .input(circuit, MarkerMaterials.Tier.HV)
                .fluidInputs(Lubricant.getFluid(240))
                .fluidInputs(SolderingAlloy.getFluid(sold * 2))
                .output(ROBOT_ARM_HV)
                .duration(robotarm_duration).EUt(VA[MV])
                .buildAndRegister();


        //Field Generator
        ModHandler.removeRecipeByName("gregtech:field_generator_hv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, QUANTUM_EYE.getStackForm(1), OreDictUnifier.get(plate, StainlessSteel, 2),
                                                                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.HV, 2), OreDictUnifier.get(wireGtQuadruple, MercuryBariumCalciumCuprate, 4));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(QUANTUM_EYE, 1)
                .input(plate, StainlessSteel, 4)
                .input(circuit, MarkerMaterials.Tier.HV, 4)
                .input(wireGtQuadruple, MercuryBariumCalciumCuprate, 4)
                .input(EMITTER_HV)
                .input(SENSOR_HV)
                .fluidInputs(SolderingAlloy.getFluid(sold * 4))
                .fluidInputs(new FluidStack(TFFluids.fluidEnder, 2000))
                .fluidInputs(Argon.getFluid(2000))
                .output(FIELD_GENERATOR_HV)
                .duration(field_generator_duration).EUt(VA[MV])
                .buildAndRegister();


        //Emitter
        ModHandler.removeRecipeByName("gregtech:emitter_hv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Chrome, 4), OreDictUnifier.get(cableGtSingle, Gold, 2),
                                                                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.HV, 2), OreDictUnifier.get(gem, EnderEye, 1),
                                                                            IntCircuitIngredient.getIntegratedCircuit(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Chrome, 6)
                .input(cableGtSingle, Gold, 2)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(gem, EnderEye, 1)
                .input(lens, Emerald, 2)
                .circuitMeta(1)
                .fluidInputs(Glass.getFluid(864))
                .fluidInputs(SolderingAlloy.getFluid(sold * 3))
                .output(EMITTER_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();


        //Sensor
        ModHandler.removeRecipeByName("gregtech:sensor_hv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Chrome, 1), OreDictUnifier.get(plate, StainlessSteel, 4),
                                                                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.HV, 1), OreDictUnifier.get(gem, EnderEye, 1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Chrome, 2)
                .input(plate, StainlessSteel, 6)
                .input(cableGtSingle, Gold, 2)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(gem, EnderEye, 1)
                .fluidInputs(SolderingAlloy.getFluid(sold * 3))
                .fluidInputs(new FluidStack(TFFluids.fluidRedstone, 1500))
                .output(SENSOR_HV)
                .duration(other_duration).EUt(VA[MV])
                .buildAndRegister();


        //EV Components
        //Motor
        ModHandler.removeRecipeByName("gregtech:electric_motor_ev");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtDouble, Aluminium, 2), OreDictUnifier.get(stick, Titanium,  2),
                                                                            OreDictUnifier.get(stick, NeodymiumMagnetic, 1), OreDictUnifier.get(wireGtDouble, Kanthal, 4));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtDouble, Aluminium, 2)
                .input(stick, Titanium, 2)
                .input(stick, NeodymiumMagnetic, 1)
                .input(wireGtDouble, Kanthal, 4)
                .input(wireFine, Copper, 64)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(ELECTRIC_MOTOR_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();


        //Pump
        ModHandler.removeRecipeByName("gregtech:electric_pump_ev_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_ev_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_ev_styrene_butadiene_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Aluminium, 1), OreDictUnifier.get(pipeNormalFluid, Titanium, 1), OreDictUnifier.get(screw, StainlessSteel, 1), OreDictUnifier.get(rotor, StainlessSteel, 1), OreDictUnifier.get(ring, Rubber, 2), ELECTRIC_MOTOR_EV.getStackForm(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Aluminium, 1), OreDictUnifier.get(pipeNormalFluid, Titanium, 1), OreDictUnifier.get(screw, StainlessSteel, 1), OreDictUnifier.get(rotor, StainlessSteel, 1), OreDictUnifier.get(ring, SiliconeRubber, 2), ELECTRIC_MOTOR_EV.getStackForm(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Aluminium, 1), OreDictUnifier.get(pipeNormalFluid, Titanium, 1), OreDictUnifier.get(screw, StainlessSteel, 1), OreDictUnifier.get(rotor, StainlessSteel, 1), OreDictUnifier.get(ring, StyreneButadieneRubber, 2), ELECTRIC_MOTOR_EV.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Aluminium, 2)
                .input(pipeNormalFluid, Titanium, 1)
                .input(screw, StainlessSteel, 2)
                .input(rotor, StainlessSteel, 1)
                .input(ring, Rubber, 4)
                .input(ELECTRIC_MOTOR_EV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Aluminium, 2)
                .input(pipeNormalFluid, Titanium, 1)
                .input(screw, StainlessSteel, 2)
                .input(rotor, StainlessSteel, 1)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_EV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Aluminium, 2)
                .input(pipeNormalFluid, Titanium, 1)
                .input(screw, StainlessSteel, 2)
                .input(rotor, StainlessSteel, 1)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_EV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();


        //Conveyor
        ModHandler.removeRecipeByName("gregtech:conveyor_module_ev_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_ev_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_ev_styrene_butadiene_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Aluminium, 1), OreDictUnifier.get(plate, StyreneButadieneRubber, 6), ELECTRIC_MOTOR_EV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Aluminium, 1), OreDictUnifier.get(plate, SiliconeRubber, 6), ELECTRIC_MOTOR_EV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Aluminium, 1), OreDictUnifier.get(plate, Rubber, 6), ELECTRIC_MOTOR_EV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Aluminium, 1)
                .input(plate, Rubber, 12)
                .input(ELECTRIC_MOTOR_EV, 2)
                .input(ring, StainlessSteel, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Aluminium, 1)
                .input(plate, SiliconeRubber, 6)
                .input(ELECTRIC_MOTOR_EV, 2)
                .input(ring, StainlessSteel, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Aluminium, 1)
                .input(plate, StyreneButadieneRubber, 6)
                .input(ELECTRIC_MOTOR_EV, 2)
                .input(ring, StainlessSteel, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();


        //Electric Piston
        ModHandler.removeRecipeByName("gregtech:electric_piston_ev");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Titanium, 2), OreDictUnifier.get(cableGtSingle, Aluminium, 2),
                OreDictUnifier.get(plate, Titanium, 3), OreDictUnifier.get(gearSmall, Titanium, 1),
                ELECTRIC_MOTOR_EV.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Titanium, 3)
                .input(cableGtSingle, Aluminium, 2)
                .input(plate, Titanium, 3)
                .input(gear, Titanium, 1)
                .input(gearSmall, Titanium, 2)
                .input(ELECTRIC_MOTOR_EV, 1)
                .fluidInputs(Lubricant.getFluid(200))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PISTON_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();


        //Robot Arm
        ModHandler.removeRecipeByName("gregtech:robot_arm_ev");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Aluminium, 3), OreDictUnifier.get(stick, Titanium, 2),
                ELECTRIC_MOTOR_EV.getStackForm(2), ELECTRIC_PISTON_EV.getStackForm(1),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.EV));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Aluminium, 3)
                .input(stick, Titanium, 4)
                .input(ELECTRIC_MOTOR_EV, 2)
                .input(ELECTRIC_PISTON_EV, 1)
                .input(gearSmall, Titanium, 2)
                .input(circuit, MarkerMaterials.Tier.EV)
                .fluidInputs(Lubricant.getFluid(240))
                .fluidInputs(SolderingAlloy.getFluid(sold * 2))
                .output(ROBOT_ARM_EV)
                .duration(robotarm_duration).EUt(VA[HV])
                .buildAndRegister();


        //Field Generator
        ModHandler.removeRecipeByName("gregtech:field_generator_ev");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(gem, NetherStar, 1), OreDictUnifier.get(plateDouble, Titanium, 2),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.EV, 2), OreDictUnifier.get(wireGtQuadruple, UraniumTriplatinum, 4));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(gem, NetherStar, 1)
                .input(plateDouble, Titanium, 4)
                .input(circuit, MarkerMaterials.Tier.EV, 4)
                .input(wireGtQuadruple, UraniumTriplatinum, 4)
                .input(EMITTER_EV)
                .input(SENSOR_EV)
                .fluidInputs(SolderingAlloy.getFluid(sold * 4))
                .fluidInputs(new FluidStack(TFFluids.fluidEnder, 2500))
                .fluidInputs(Krypton.getFluid(2000))
                .output(FIELD_GENERATOR_EV)
                .duration(field_generator_duration).EUt(VA[HV])
                .buildAndRegister();


        //Emitter
        ModHandler.removeRecipeByName("gregtech:emitter_ev");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Platinum, 4), OreDictUnifier.get(cableGtSingle, Aluminium, 2),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.EV, 2), QUANTUM_EYE.getStackForm(1),
                IntCircuitIngredient.getIntegratedCircuit(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Platinum, 6)
                .input(cableGtSingle, Aluminium, 2)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(QUANTUM_EYE, 1)
                .input(lens, Diamond, 2)
                .circuitMeta(1)
                .fluidInputs(Glass.getFluid(864))
                .fluidInputs(SolderingAlloy.getFluid(sold * 3))
                .fluidInputs(Argon.getFluid(1000))
                .output(EMITTER_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();


        //Sensor
        ModHandler.removeRecipeByName("gregtech:sensor_ev");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Platinum, 1), OreDictUnifier.get(plate, Titanium, 4),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.EV, 1), QUANTUM_EYE.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, Platinum, 2)
                .input(plate, Titanium, 6)
                .input(cableGtSingle, Aluminium, 2)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(QUANTUM_EYE, 1)
                .fluidInputs(SolderingAlloy.getFluid(sold * 3))
                .fluidInputs(new FluidStack(TFFluids.fluidRedstone, 2000))
                .output(SENSOR_EV)
                .duration(other_duration).EUt(VA[HV])
                .buildAndRegister();


        //IV Components
        //Motor
        ModHandler.removeRecipeByName("gregtech:motor_iv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtDouble, Tungsten, 2), OreDictUnifier.get(stick, TungstenSteel, 2),
                                                                            OreDictUnifier.get(stick, NeodymiumMagnetic, 1), OreDictUnifier.get(wireGtDouble, Graphene, 4));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtDouble, Tungsten, 2)
                .input(stick, TungstenSteel, 2)
                .input(stick, NeodymiumMagnetic, 1)
                .input(wireGtDouble, Graphene, 4)
                .input(wireFine, Copper, 64)
                .input(wireFine, Copper, 64)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .duration(other_duration).EUt(VA[EV])
                .buildAndRegister();


        //Pump
        ModHandler.removeRecipeByName("gregtech:electric_pump_iv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_iv_styrene_butadiene_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tungsten, 1), OreDictUnifier.get(pipeNormalFluid, TungstenSteel, 1), OreDictUnifier.get(screw, TungstenSteel, 1), OreDictUnifier.get(rotor, TungstenSteel, 1), OreDictUnifier.get(ring, SiliconeRubber, 2), ELECTRIC_MOTOR_IV.getStackForm(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tungsten, 1), OreDictUnifier.get(pipeNormalFluid, TungstenSteel, 1), OreDictUnifier.get(screw, TungstenSteel, 1), OreDictUnifier.get(rotor, TungstenSteel, 1), OreDictUnifier.get(ring, StyreneButadieneRubber, 2), ELECTRIC_MOTOR_IV.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Tungsten, 2)
                .input(pipeNormalFluid, TungstenSteel, 1)
                .input(screw, TungstenSteel, 2)
                .input(rotor, TungstenSteel, 1)
                .input(ring, SiliconeRubber, 4)
                .input(ELECTRIC_MOTOR_IV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_IV)
                .duration(other_duration).EUt(VA[EV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Tungsten, 2)
                .input(pipeNormalFluid, TungstenSteel, 1)
                .input(screw, TungstenSteel, 2)
                .input(rotor, TungstenSteel, 1)
                .input(ring, StyreneButadieneRubber, 4)
                .input(ELECTRIC_MOTOR_IV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PUMP_IV)
                .duration(other_duration).EUt(VA[EV])
                .buildAndRegister();


        //Conveyor
        ModHandler.removeRecipeByName("gregtech:conveyor_module_iv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_iv_styrene_butadiene_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tungsten, 1), OreDictUnifier.get(plate, StyreneButadieneRubber, 6), ELECTRIC_MOTOR_IV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tungsten, 1), OreDictUnifier.get(plate, SiliconeRubber, 6), ELECTRIC_MOTOR_IV.getStackForm(2), IntCircuitIngredient.getIntegratedCircuit(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Tungsten, 1)
                .input(plate, SiliconeRubber, 8)
                .input(ELECTRIC_MOTOR_IV, 2)
                .input(ring, TungstenSteel, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_IV)
                .duration(other_duration).EUt(VA[EV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Tungsten, 1)
                .input(plate, StyreneButadieneRubber, 8)
                .input(ELECTRIC_MOTOR_IV, 2)
                .input(ring, TungstenSteel, 4)
                .circuitMeta(1)
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(halfsold))
                .output(CONVEYOR_MODULE_IV)
                .duration(other_duration).EUt(VA[EV])
                .buildAndRegister();


        //Electric Piston
        ModHandler.removeRecipeByName("gregtech:electric_piston_iv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, TungstenSteel, 2), OreDictUnifier.get(cableGtSingle, Tungsten, 2),
                OreDictUnifier.get(plate, TungstenSteel, 3), OreDictUnifier.get(gearSmall, TungstenSteel, 1),
                ELECTRIC_MOTOR_IV.getStackForm(1));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(stick, TungstenSteel, 3)
                .input(cableGtSingle, Tungsten, 2)
                .input(plate, TungstenSteel, 3)
                .input(gear, TungstenSteel, 1)
                .input(gearSmall, TungstenSteel, 2)
                .input(ELECTRIC_MOTOR_IV, 1)
                .fluidInputs(Lubricant.getFluid(200))
                .fluidInputs(SolderingAlloy.getFluid(sold))
                .output(ELECTRIC_PISTON_IV)
                .duration(other_duration).EUt(VA[EV])
                .buildAndRegister();

        //Robot Arm
        ModHandler.removeRecipeByName("gregtech:robot_arm_iv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tungsten, 3), OreDictUnifier.get(stick, TungstenSteel, 2),
                ELECTRIC_MOTOR_IV.getStackForm(2), ELECTRIC_PISTON_IV.getStackForm(1),
                OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV));

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(stickLong, TungstenSteel, 2)
                .input(gear, TungstenSteel, 1)
                .input(gearSmall, TungstenSteel, 3)
                .input(ELECTRIC_MOTOR_IV, 2)
                .input(ELECTRIC_PISTON_IV, 1)
                .input(circuit, MarkerMaterials.Tier.IV)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(circuit, MarkerMaterials.Tier.HV, 4)
                .input(cableGtSingle, Tungsten, 4)
                .fluidInputs(Lubricant.getFluid(240))
                .duration(robotarm_duration).EUt(VA[EV])
                .buildAndRegister();


        //Field Generator
        ModHandler.removeRecipeByName("gregtech:field_generator_iv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, QUANTUM_STAR.getStackForm(1), OreDictUnifier.get(plateDouble, TungstenSteel, 2),
                                                                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV, 2), OreDictUnifier.get(wireGtQuadruple, SamariumIronArsenicOxide, 4));

        /*
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input()
                .buildAndRegister();

         */


        //Emitter
        ModHandler.removeRecipeByName("gregtech:emitter_iv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Iridium, 4), OreDictUnifier.get(cableGtSingle, Tungsten, 2),
                                                                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV, 2), QUANTUM_STAR.getStackForm(1),
                                                                            IntCircuitIngredient.getIntegratedCircuit(1));

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel, 1)
                .input(stick, Iridium, 4)
                .input(QUANTUM_STAR, 1)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(EMITTER_EV, 2)
                .input(EMITTER_HV, 4)
                .input(EMITTER_MV, 8)
                .input(foil, Platinum, 32)
                .input(cableGtSingle, Tungsten, 4)
                .fluidInputs(SolderingAlloy.getFluid(sold * 8))
                .output(EMITTER_IV)
                .duration(other_duration * 2).EUt(VA[EV])
                .buildAndRegister();


        //Sensor
        ModHandler.removeRecipeByName("gregtech:sensor_iv");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Iridium, 1), OreDictUnifier.get(plate ,TungstenSteel, 4),
                                                                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV), QUANTUM_STAR.getStackForm(1));

    }
}
