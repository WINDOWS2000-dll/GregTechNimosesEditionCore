package gtne.api.recipes.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class GTNETemperatureProperty extends RecipeProperty<Integer> {

    public static final String KEY = "temperature";

    private static GTNETemperatureProperty INSTANCE;

    private GTNETemperatureProperty() {
        super("temperature", Integer.class);
    }
    public static GTNETemperatureProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GTNETemperatureProperty();
        }

        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtne.recipe.temperature", value), x, y, color);
    }

}
