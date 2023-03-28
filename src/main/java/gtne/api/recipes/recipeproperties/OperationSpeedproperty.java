package gtne.api.recipes.recipeproperties;

import gregtech.api.recipes.recipeproperties.*;

import gregtech.api.unification.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class OperationSpeedproperty extends RecipeProperty<Integer> {

    public static final String KEY = "operationspeed";

    private static final TreeMap<Integer, Object> registeredComputerTier = new TreeMap<>((x, y) -> y - x);

    private static OperationSpeedproperty INSTANCE;

    private OperationSpeedproperty() {
        super(KEY, Integer.class);
    }

    public static OperationSpeedproperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OperationSpeedproperty();
        }
        return INSTANCE;
    }

    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtne.recipe.operation_speed", new Object[]{value, this.getMinTierForOprerationSpeed((Integer)this.castValue(value))}), x, y, color);
    }

    private String getMinTierForOprerationSpeed(Integer value) {
        String name = "";
        Iterator var3 = registeredComputerTier.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<Integer, Object> casing = (Map.Entry)var3.next();
            if (value <= (Integer)casing.getKey()) {
                Object mapValue = casing.getValue();
                if (mapValue instanceof Material) {
                    name = ((Material)mapValue).getLocalizedName();
                } else if (mapValue instanceof String) {
                    name = I18n.format((String)mapValue, new Object[0]);
                }
            }
        }

        if (name.length() >= 13) {
            name = name.substring(0, 10) + "..";
        }

        return name;
    }

    public static void registeredComputerTier(int operationspeed, Material casingMaterial, String casingName) {
        Validate.notNull(casingName);
        if (casingMaterial == null) {
            registeredComputerTier.put(operationspeed, casingName);
        } else {
            registeredComputerTier.put(operationspeed, casingMaterial);
        }

    }
}
