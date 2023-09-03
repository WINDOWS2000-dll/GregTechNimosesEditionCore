package gtne.loaders.recipes.LateGameMachines;

import gregtech.api.GTValues;
import gregtech.api.recipes.*;
import gtne.common.ConfigHolder;

import static gtne.api.util.GTNEUtil.GTNEMachineRecipeName;

public class LateGameMachines {

    public static void init() {
            if (ConfigHolder.recipeoption.Super_HardMode_LateGame) {
                RemoveLuVMachinesRecipe();
        }
    }

    //LuV
    private static void RemoveLuVMachinesRecipe() {

        for (int i = 0; i < GTNEMachineRecipeName.length; i++) {
            ModHandler.removeRecipeByName("gregtech:gregtech.machine." + GTNEMachineRecipeName[i] + ".luv");
        }

    }

}
