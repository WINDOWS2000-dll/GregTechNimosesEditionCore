package gtne.api.recipes.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTLog;
import gtne.api.recipes.recipeproperties.OperationSpeedproperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class ComputerRecipeBuilder extends RecipeBuilder<ComputerRecipeBuilder> {

    public ComputerRecipeBuilder() {
    }

    public ComputerRecipeBuilder(Recipe recipe, RecipeMap<ComputerRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public ComputerRecipeBuilder(ComputerRecipeBuilder recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public ComputerRecipeBuilder copy() {
        return new ComputerRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(OperationSpeedproperty.KEY)) {
            this.computerOperationSpeed(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public ComputerRecipeBuilder computerOperationSpeed(int computerOperationSpeed) {
        if (computerOperationSpeed <= 0) {
            GTLog.logger.error("Computer Operation Speed cannot be less or equal to 0", new IllegalAccessError());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(OperationSpeedproperty.getInstance(), computerOperationSpeed);
        return this;
    }

    public int getComputerOperationSpeed() {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(OperationSpeedproperty.getInstance(), 0);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(OperationSpeedproperty.getInstance().getKey(), getComputerOperationSpeed())
                .toString();
    }
}
