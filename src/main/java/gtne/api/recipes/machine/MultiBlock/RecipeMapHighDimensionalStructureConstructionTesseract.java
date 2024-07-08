package gtne.api.recipes.machine.MultiBlock;

import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.ui.RecipeMapUIFunction;
import gregtech.core.sound.GTSoundEvents;
import org.jetbrains.annotations.NotNull;

public class RecipeMapHighDimensionalStructureConstructionTesseract <R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapHighDimensionalStructureConstructionTesseract(@NotNull String unlocalizedName, @NotNull R defaultRecipeBuilder,
                                                                  @NotNull RecipeMapUIFunction recipeMapUI) {
        super(unlocalizedName, defaultRecipeBuilder, recipeMapUI, 36, 1, 24, 0);
        setSound(GTSoundEvents.COMPUTATION);
    }

}
