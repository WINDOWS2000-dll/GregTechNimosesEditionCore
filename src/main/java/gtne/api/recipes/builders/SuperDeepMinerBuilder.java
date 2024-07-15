package gtne.api.recipes.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTLog;
import gtne.api.recipes.properties.GTNETemperatureProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

public class SuperDeepMinerBuilder extends RecipeBuilder<SuperDeepMinerBuilder> {

    public SuperDeepMinerBuilder() {
        /**/
    }

    public SuperDeepMinerBuilder(Recipe recipe, RecipeMap<SuperDeepMinerBuilder> recipeMap) {
        super(recipe, recipeMap);
    }
    public SuperDeepMinerBuilder(SuperDeepMinerBuilder recipeBuilder) {
        super(recipeBuilder);
    }

    public SuperDeepMinerBuilder copy() {
        return new SuperDeepMinerBuilder(this);
    }

    public boolean applyProperty(@NotNull String key, Object value) {
        if (key.equals("temperature")) {
            this.temperature(((Number)value).intValue());
            return true;
        } else {
            return super.applyProperty(key, value);
        }
    }

    public SuperDeepMinerBuilder temperature(int temperature) {
        if (temperature <= 0) {
            GTLog.logger.error("Temperature cannot be less than or equal to 0");
            this.recipeStatus = EnumValidationResult.INVALID;
        }

        this.applyProperty(GTNETemperatureProperty.getInstance(), temperature);
        return this;
    }

    public int getTemperature() {
        return this.recipePropertyStorage == null ? 0 : (Integer)this.recipePropertyStorage.getRecipePropertyValue(GTNETemperatureProperty.getInstance(), 0);
    }

    public String toString() {
        return (new ToStringBuilder(this)).appendSuper(super.toString()).append(GTNETemperatureProperty.getInstance().getKey(), this.getTemperature()).toString();
    }

}
