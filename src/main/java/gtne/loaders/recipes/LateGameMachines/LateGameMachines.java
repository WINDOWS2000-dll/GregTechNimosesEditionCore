package gtne.loaders.recipes.LateGameMachines;

import gregtech.api.GTValues;
import gregtech.api.recipes.*;
import gregtech.api.unification.material.MarkerMaterial;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gtne.common.ConfigHolder;

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
                .input(wireGtQuadruple, HSSG, 6)
                .input(VOLTAGE_COIL_LuV, 4)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, HSSG, 4)
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
                .input(circuit, MarkerMaterials.Tier.LuV, 6)
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(gear, TungstenSteel, 2)
                .input(gearSmall, TungstenSteel, 4)
                .input(COMPONENT_GRINDER_TUNGSTEN, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(CARBON_FIBER_PLATE, 4)
                .input(cableGtSingle, HSSG, 4)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(TungstenSteel.getFluid(288))
                .outputs(MACERATOR[6].getStackForm())
                .research(b -> b
                        .researchStack(MACERATOR[5].getStackForm())
                        .EUt(4096)
                        .duration(12000))
                .EUt(10000).duration(600)
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
