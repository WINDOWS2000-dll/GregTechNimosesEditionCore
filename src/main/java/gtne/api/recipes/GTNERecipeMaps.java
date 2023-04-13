package gtne.api.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.*;
import gregtech.core.sound.GTSoundEvents;
import gtne.api.gui.GTNEGuiTextures;
import stanhebben.zenscript.annotations.ZenProperty;
import gtne.api.recipes.machine.MultiBlock.RecipeMapAdvancedPrecisionAssemblyLine;

public class GTNERecipeMaps {

    @ZenProperty
    public static final RecipeMapAdvancedPrecisionAssemblyLine<SimpleRecipeBuilder> ADVANCED_PRECISION_ASSEMBLY_LINE_RECIPES = (RecipeMapAdvancedPrecisionAssemblyLine<SimpleRecipeBuilder>) new RecipeMapAdvancedPrecisionAssemblyLine<>("advanced_precision_assembly_line", 1, 20, 1, 1, 0, 10, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENTS_ASSEMBLER =
            new RecipeMap<>("components_assembler", 1, 6, 1, 1, 1, 3, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GTNEGuiTextures.PREGRESSBAR_CONPONENTS_ASSEMBLER, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    //Todo Quantum Computer
    /*
    @ZenProperty
    public static final

     */

}