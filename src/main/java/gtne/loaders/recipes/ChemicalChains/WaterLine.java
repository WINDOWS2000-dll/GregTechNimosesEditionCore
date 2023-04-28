package gtne.loaders.recipes.ChemicalChains;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.*;
import gtne.common.ConfigHolder;

public class WaterLine {

    public static void init() {
        if (ConfigHolder.recipeoption.Harder_Water_Recipe) {
            Remove_Default_Water_Recipes();
            Add_Water_Purification_Line();
            Change_Default_Water_Recipes();
        }
    }

    private static void Remove_Default_Water_Recipes() {
        //
    }

    private static void Add_Water_Purification_Line() {
        //
    }

    private static void Change_Default_Water_Recipes() {
        //
    }
}
