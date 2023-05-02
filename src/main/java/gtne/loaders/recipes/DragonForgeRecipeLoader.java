package gtne.loaders.recipes;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import gregtech.api.items.materialitem.MetaPrefixItem;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItem1;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;

import static com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry.FIRE_FORGE_RECIPES;

public class DragonForgeRecipeLoader {

    public static void preInit() {
        FIRE_FORGE_RECIPES.add(new DragonForgeRecipe(OreDictUnifier.get(OrePrefix.ingot, Materials.Titanium), new ItemStack(IafItemRegistry.fire_dragon_blood), new ItemStack(IafItemRegistry.dragonsteel_fire_ingot)));
    }

}
