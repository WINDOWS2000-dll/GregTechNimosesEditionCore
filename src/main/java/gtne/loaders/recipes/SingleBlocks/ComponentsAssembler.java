package gtne.loaders.recipes.SingleBlocks;

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


    }
}
