package gtne.loaders.recipes.LateGameMachines;

import gregtech.api.GTValues;
import gregtech.api.recipes.*;
import gtne.common.ConfigHolder;

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
