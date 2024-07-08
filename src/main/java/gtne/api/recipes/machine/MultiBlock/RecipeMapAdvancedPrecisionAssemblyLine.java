package gtne.api.recipes.machine.MultiBlock;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.machines.IResearchRecipeMap;
import gregtech.api.recipes.recipeproperties.ResearchProperty;
import gregtech.api.recipes.recipeproperties.ResearchPropertyData;
import gregtech.api.recipes.ui.RecipeMapUIFunction;
import gregtech.core.sound.GTSoundEvents;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;

public class RecipeMapAdvancedPrecisionAssemblyLine<R extends RecipeBuilder<R>> extends RecipeMap<R> implements IResearchRecipeMap {

    private final Map<String, Collection<Recipe>> researchEntries = new Object2ObjectOpenHashMap<>();

    public RecipeMapAdvancedPrecisionAssemblyLine(@NotNull String unlocalizedName, @NotNull R defaultRecipeBuilder,
                                                  @NotNull RecipeMapUIFunction recipeMapUI) {
        super(unlocalizedName, defaultRecipeBuilder, recipeMapUI, 20, 1, 10, 0);
        setSound(GTSoundEvents.ASSEMBLER);
    }

    @Override
    public boolean compileRecipe(Recipe recipe) {
        if (!super.compileRecipe(recipe)) return false;
        if (recipe.hasProperty(ResearchProperty.getInstance())) {
            ResearchPropertyData data = recipe.getProperty(ResearchProperty.getInstance(), null);
            if (data != null) {
                for (ResearchPropertyData.ResearchEntry entry : data) {
                    addDataStickEntry(entry.getResearchId(), recipe);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean removeRecipe(@Nonnull Recipe recipe) {
        if (!super.removeRecipe(recipe)) return false;
        if (recipe.hasProperty(ResearchProperty.getInstance())) {
            ResearchPropertyData data = recipe.getProperty(ResearchProperty.getInstance(), null);
            if (data != null) {
                for (ResearchPropertyData.ResearchEntry entry : data) {
                    return removeDataStickEntry(entry.getResearchId(), recipe);
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public void addDataStickEntry(@Nonnull String researchId, @Nonnull Recipe recipe) {
        Collection<Recipe> collection = researchEntries.computeIfAbsent(researchId, (k) -> new ObjectOpenHashSet<>());
        collection.add(recipe);
    }

    @Nullable
    @Override
    public Collection<Recipe> getDataStickEntry(@Nonnull String researchId) {
        return researchEntries.get(researchId);
    }

    @Override
    public boolean removeDataStickEntry(@Nonnull String researchId, @Nonnull Recipe recipe) {
        Collection<Recipe> collection = researchEntries.get(researchId);
            if (collection == null) return false;
            if (collection.remove(recipe)) {
                if (collection.isEmpty()) {
                    return researchEntries.remove(researchId) != null;
            }
            return true;
        }
        return false;
    }
}
