package gtne.api.recipes.properties;

import gregtech.api.GregTechAPI;
import gregtech.api.recipes.properties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import org.jetbrains.annotations.NotNull;

public class GTNETemperatureProperty extends RecipeProperty<Integer> {

    public static final String KEY = "temperature";

    private static GTNETemperatureProperty INSTANCE;

    private GTNETemperatureProperty() {
        super("temperature", Integer.class);
    }
    public static GTNETemperatureProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GTNETemperatureProperty();
            GregTechAPI.RECIPE_PROPERTIES.register(KEY, INSTANCE);
        }

        return INSTANCE;
    }

    @Override
    public @NotNull NBTBase serialize(@NotNull Object value) {
        return new NBTTagInt(castValue(value));
    }

    @Override
    public @NotNull Object deserialize(@NotNull NBTBase nbt) {
        return ((NBTTagInt) nbt).getInt();
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtne.recipe.temperature", value), x, y, color);
    }

}
