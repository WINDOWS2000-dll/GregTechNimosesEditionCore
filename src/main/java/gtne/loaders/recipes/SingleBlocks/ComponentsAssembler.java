package gtne.loaders.recipes.SingleBlocks;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gtne.api.recipes.GTNERecipeMaps;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
public class ComponentsAssembler {

    public static void init() {

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
                .fluidInputs(SolderingAlloy.getFluid(72))
                .output(ELECTRIC_MOTOR_MV)
                .duration(120).EUt(VA[LV])
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
                .fluidInputs(SolderingAlloy.getFluid(144))
                .output(ELECTRIC_PUMP_MV)
                .duration(120).EUt(VA[LV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 2)
                .input(pipeNormalFluid, Steel, 1)
                .input(screw, Bronze, 2)
                .input(rotor, Bronze, 1)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_MV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(144))
                .output(ELECTRIC_PUMP_MV)
                .duration(120).EUt(VA[LV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 2)
                .input(pipeNormalFluid, Steel, 1)
                .input(screw, Bronze, 2)
                .input(rotor, Bronze, 1)
                .input(ring, Rubber, 4)
                .input(ELECTRIC_MOTOR_MV, 1)
                .fluidInputs(Lubricant.getFluid(180))
                .fluidInputs(SolderingAlloy.getFluid(144))
                .output(ELECTRIC_PUMP_MV)
                .duration(120).EUt(VA[LV])
                .buildAndRegister();

        //Conveyor
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_rubber");
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(plate, StyreneButadieneRubber, 6),
                                                                            ELECTRIC_MOTOR_MV.getStackForm(2));

        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(plate, SiliconeRubber, 6),
                                                                            ELECTRIC_MOTOR_MV.getStackForm(2));

        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 1), OreDictUnifier.get(plate, Rubber, 6),
                                                                            ELECTRIC_MOTOR_MV.getStackForm(2));

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 1)
                .input(plate, Rubber, 12)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input(ring, Bronze, 4)
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(72))
                .output(CONVEYOR_MODULE_MV)
                .duration(120).EUt(VA[LV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 1)
                .input(plate, SiliconeRubber, 6)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input(ring, Bronze, 4)
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(72))
                .output(CONVEYOR_MODULE_MV)
                .duration(120).EUt(VA[LV])
                .buildAndRegister();

        GTNERecipeMaps.COMPONENTS_ASSEMBLER.recipeBuilder()
                .input(cableGtSingle, Copper, 1)
                .input(plate, StyreneButadieneRubber, 6)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input(ring, Bronze, 4)
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Lubricant.getFluid(160))
                .fluidInputs(SolderingAlloy.getFluid(72))
                .output(CONVEYOR_MODULE_MV)
                .duration(120).EUt(VA[LV])
                .buildAndRegister();


    }
}
