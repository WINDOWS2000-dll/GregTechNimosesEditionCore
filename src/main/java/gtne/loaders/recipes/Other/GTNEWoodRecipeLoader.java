package gtne.loaders.recipes.Other;

import gregtech.loaders.WoodTypeEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import twilightforest.block.*;
import twilightforest.enums.WoodVariant;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static gregtech.loaders.recipe.WoodRecipeLoader.registerWoodTypeRecipe;
import static gregtech.loaders.recipe.WoodRecipeLoader.registerWoodUnificationInfo;

public class GTNEWoodRecipeLoader {

    private static List<WoodTypeEntry> DEFAULT_ENTRIES;

    private static List<WoodTypeEntry> getDefaultEntries() {
        if (DEFAULT_ENTRIES == null) {
            final String twModId = "twilightforest";
            return DEFAULT_ENTRIES = Arrays.asList(
                    new WoodTypeEntry.Builder(twModId, "twilight_oak")
                            .planks(new ItemStack(TFBlocks.twilight_oak_planks), "twilight_oak_plank")
                            .log(new ItemStack(TFBlocks.twilight_log, 1, 0)).removeCharcoalRecipe()
                            .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:twilight_oak_door"))), "twilight_oak_door")
                            .slab(new ItemStack(TFBlocks.twilight_oak_slab), "twilight_oak_slab")
                            .fence(new ItemStack(TFBlocks.twilight_oak_fence), "twilight_oak_fence")
                            .fenceGate(new ItemStack(TFBlocks.twilight_oak_gate), "twilight_oak_fence_gate")
                            .stairs(new ItemStack(TFBlocks.twilight_oak_stairs))
                            .registerAllUnificationInfo()
                            .build(),
                    new WoodTypeEntry.Builder(twModId, "canopy")
                            .planks(new ItemStack(TFBlocks.canopy_planks), "canopy_plank")
                            .log(new ItemStack(TFBlocks.twilight_log, 1, 1))
                            .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:canopy_door"))), "canopy_door")
                            .slab(new ItemStack(TFBlocks.canopy_slab), "canopy_slab")
                            .fence(new ItemStack(TFBlocks.canopy_fence), "canopy_fence")
                            .fenceGate(new ItemStack(TFBlocks.canopy_gate), "canopy_fence_gate")
                            .stairs(new ItemStack(TFBlocks.canopy_stairs))
                            .registerAllUnificationInfo()
                            .build(),
                    new WoodTypeEntry.Builder(twModId, "mangrove")
                            .planks(new ItemStack(TFBlocks.mangrove_planks), "mangrove_plank")
                            .log(new ItemStack(TFBlocks.twilight_log, 1, 2))
                            .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:mangrove_door"))), "mangrove_door")
                            .slab(new ItemStack(TFBlocks.mangrove_slab), "mangrove_slab")
                            .fence(new ItemStack(TFBlocks.mangrove_fence), "mangrove_fence")
                            .fenceGate(new ItemStack(TFBlocks.mangrove_gate), "mangrove_fence_gate")
                            .stairs(new ItemStack(TFBlocks.mangrove_stairs))
                            .registerAllUnificationInfo()
                            .build(),
                    new WoodTypeEntry.Builder(twModId, "dark_wood")
                            .planks(new ItemStack(TFBlocks.dark_planks), "dark_wood_plank")
                            .log(new ItemStack(TFBlocks.twilight_log, 1, 3))
                            .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:dark_door"))), "dark_wood_door")
                            .slab(new ItemStack(TFBlocks.dark_slab), "dark_wood_slab")
                            .fence(new ItemStack(TFBlocks.dark_fence), "dark_wood_fence")
                            .fenceGate(new ItemStack(TFBlocks.dark_gate), "dark_wood_fence_gate")
                            .stairs(new ItemStack(TFBlocks.dark_stairs))
                            .registerAllUnificationInfo()
                            .build(),
                    new WoodTypeEntry.Builder(twModId, "time_wood")
                            .planks(new ItemStack(TFBlocks.time_planks), "time_wood_planks")
                            .log(new ItemStack(TFBlocks.magic_log, 1, 0)).removeCharcoalRecipe()
                            .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:time_door"))), "time_wood_door")
                            .slab(new ItemStack(TFBlocks.time_slab), "time_wood_slab")
                            .fence(new ItemStack(TFBlocks.time_fence), "time_wood_fence")
                            .fenceGate(new ItemStack(TFBlocks.time_gate), "time_wood_fence_gate")
                            .stairs(new ItemStack(TFBlocks.time_stairs))
                            .registerAllUnificationInfo()
                            .build(),
                    new WoodTypeEntry.Builder(twModId, "trans_wood")
                            .planks(new ItemStack(TFBlocks.trans_planks), "trans_wood_planks")
                            .log(new ItemStack(TFBlocks.magic_log, 1, 1)).removeCharcoalRecipe()
                            .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:trans_door"))), "trans_wood_door")
                            .slab(new ItemStack(TFBlocks.trans_slab), "trans_wood_slab")
                            .fence(new ItemStack(TFBlocks.trans_fence), "trans_wood_fence")
                            .fenceGate(new ItemStack(TFBlocks.trans_gate), "trans_wood_fence_gate")
                            .stairs(new ItemStack(TFBlocks.trans_stairs))
                            .registerAllUnificationInfo()
                            .build(),
                    new WoodTypeEntry.Builder(twModId, "mine_wood")
                            .planks(new ItemStack(TFBlocks.mine_planks), "mine_wood_planks")
                            .log(new ItemStack(TFBlocks.magic_log, 1, 2)).removeCharcoalRecipe()
                            .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:mine_door"))), "mine_wood_door")
                            .slab(new ItemStack(TFBlocks.mine_slab), "mine_wood_slab")
                            .fence(new ItemStack(TFBlocks.mine_fence), "mine_wood_fence")
                            .fenceGate(new ItemStack(TFBlocks.mine_gate), "mine_wood_fence_gate")
                            .stairs(new ItemStack(TFBlocks.mine_stairs))
                            .registerAllUnificationInfo()
                            .build(),
                    new WoodTypeEntry.Builder(twModId, "sort_wood")
                            .planks(new ItemStack(TFBlocks.sort_planks), "sort_wood_planks")
                            .log(new ItemStack(TFBlocks.magic_log, 1, 3)).removeCharcoalRecipe()
                            .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:sort_door"))), "sort_wood_door")
                            .slab(new ItemStack(TFBlocks.sort_slab), "sort_wood_slab")
                            .fence(new ItemStack(TFBlocks.sort_fence), "sort_wood_fence")
                            .fenceGate(new ItemStack(TFBlocks.sort_gate), "sort_wood_fence_gate")
                            .stairs(new ItemStack(TFBlocks.sort_stairs))
                            .registerAllUnificationInfo()
                            .build()
            );
        }
        return DEFAULT_ENTRIES;
    }

    public static void registerUnificationInfo() {
        for (WoodTypeEntry entry : getDefaultEntries()) {
            registerWoodUnificationInfo(entry);
        }
    }

    public static void registerRecipes() {
        registerWoodRecipe();
    }

    private static void registerWoodRecipe() {
        for (WoodTypeEntry entry : getDefaultEntries()) {
            registerWoodTypeRecipe(entry);
        }
    }

}
