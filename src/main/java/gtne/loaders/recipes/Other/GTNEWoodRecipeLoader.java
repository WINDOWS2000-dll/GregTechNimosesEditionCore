package gtne.loaders.recipes.Other;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.api.util.GTUtility;
import gregtech.common.ConfigHolder;
import gregtech.loaders.WoodTypeEntry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import org.jetbrains.annotations.NotNull;
import twilightforest.block.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.loaders.recipe.WoodRecipeLoader.registerWoodUnificationInfo;

public class GTNEWoodRecipeLoader {

    private static List<WoodTypeEntry> DEFAULT_ENTRIES;

    private static List<WoodTypeEntry> getDefaultEntries() {
        if (DEFAULT_ENTRIES == null) {
            if (Loader.isModLoaded("twilightforest")) {
                final String twModId = "twilightforest";
                return DEFAULT_ENTRIES = Arrays.asList(
                        new WoodTypeEntry.Builder(twModId, "twilight_oak")
                                .planks(new ItemStack(TFBlocks.twilight_oak_planks), "wood/twilight_oak_planks")
                                .log(new ItemStack(TFBlocks.twilight_log, 1, 0)).removeCharcoalRecipe()
                                .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:twilight_oak_door"))), "wood/twilight_oak_door")
                                .slab(new ItemStack(TFBlocks.twilight_oak_slab), "wood/twilight_oak_slab")
                                .fence(new ItemStack(TFBlocks.twilight_oak_fence), "wood/twilight_oak_fence")
                                .fenceGate(new ItemStack(TFBlocks.twilight_oak_gate), "wood/twilight_oak_gate")
                                .stairs(new ItemStack(TFBlocks.twilight_oak_stairs), "wood/twilight_oak_stairs")
                                .registerAllUnificationInfo()
                                .build(),
                        new WoodTypeEntry.Builder(twModId, "canopy")
                                .planks(new ItemStack(TFBlocks.canopy_planks), "wood/canopy_planks")
                                .log(new ItemStack(TFBlocks.twilight_log, 1, 1))
                                .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:canopy_door"))), "wood/canopy_door")
                                .slab(new ItemStack(TFBlocks.canopy_slab), "wood/canopy_slab")
                                .fence(new ItemStack(TFBlocks.canopy_fence), "wood/canopy_fence")
                                .fenceGate(new ItemStack(TFBlocks.canopy_gate), "wood/canopy_gate")
                                .stairs(new ItemStack(TFBlocks.canopy_stairs), "wood/canopy_stairs")
                                .registerAllUnificationInfo()
                                .build(),
                        new WoodTypeEntry.Builder(twModId, "mangrove")
                                .planks(new ItemStack(TFBlocks.mangrove_planks), "wood/mangrove_planks")
                                .log(new ItemStack(TFBlocks.twilight_log, 1, 2))
                                .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:mangrove_door"))), "wood/mangrove_door")
                                .slab(new ItemStack(TFBlocks.mangrove_slab), "wood/mangrove_slab")
                                .fence(new ItemStack(TFBlocks.mangrove_fence), "wood/mangrove_fence")
                                .fenceGate(new ItemStack(TFBlocks.mangrove_gate), "wood/mangrove_gate")
                                .stairs(new ItemStack(TFBlocks.mangrove_stairs), "wood/mangrove_stairs")
                                .registerAllUnificationInfo()
                                .build(),
                        new WoodTypeEntry.Builder(twModId, "dark_wood")
                                .planks(new ItemStack(TFBlocks.dark_planks), "wood/darkwood_planks")
                                .log(new ItemStack(TFBlocks.twilight_log, 1, 3))
                                .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:dark_door"))), "wood/darkwood_door")
                                .slab(new ItemStack(TFBlocks.dark_slab), "wood/darkwood_slab")
                                .fence(new ItemStack(TFBlocks.dark_fence), "wood/darkwood_fence")
                                .fenceGate(new ItemStack(TFBlocks.dark_gate), "wood/darkwood_gate")
                                .stairs(new ItemStack(TFBlocks.dark_stairs), "wood/dark_wood_stairs")
                                .registerAllUnificationInfo()
                                .build(),
                        new WoodTypeEntry.Builder(twModId, "time_wood")
                                .planks(new ItemStack(TFBlocks.time_planks), "wood/time_planks")
                                .log(new ItemStack(TFBlocks.magic_log, 1, 0)).removeCharcoalRecipe()
                                .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:time_door"))), "wood/time_door")
                                .slab(new ItemStack(TFBlocks.time_slab), "wood/time_slab")
                                .fence(new ItemStack(TFBlocks.time_fence), "wood/time_fence")
                                .fenceGate(new ItemStack(TFBlocks.time_gate), "wood/time_gate")
                                .stairs(new ItemStack(TFBlocks.time_stairs), "wood/time_wood_stairs")
                                .registerAllUnificationInfo()
                                .build(),
                        new WoodTypeEntry.Builder(twModId, "trans_wood")
                                .planks(new ItemStack(TFBlocks.trans_planks), "wood/trans_planks")
                                .log(new ItemStack(TFBlocks.magic_log, 1, 1)).removeCharcoalRecipe()
                                .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:trans_door"))), "wood/trans_door")
                                .slab(new ItemStack(TFBlocks.trans_slab), "wood/trans_slab")
                                .fence(new ItemStack(TFBlocks.trans_fence), "wood/trans_fence")
                                .fenceGate(new ItemStack(TFBlocks.trans_gate), "wood/trans_gate")
                                .stairs(new ItemStack(TFBlocks.trans_stairs), "wood/trans_wood_stairs")
                                .registerAllUnificationInfo()
                                .build(),
                        new WoodTypeEntry.Builder(twModId, "mine_wood")
                                .planks(new ItemStack(TFBlocks.mine_planks), "wood/mine_planks")
                                .log(new ItemStack(TFBlocks.magic_log, 1, 2)).removeCharcoalRecipe()
                                .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:mine_door"))), "wood/mine_door")
                                .slab(new ItemStack(TFBlocks.mine_slab), "wood/mine_slab")
                                .fence(new ItemStack(TFBlocks.mine_fence), "wood/mine_fence")
                                .fenceGate(new ItemStack(TFBlocks.mine_gate), "wood/mine_gate")
                                .stairs(new ItemStack(TFBlocks.mine_stairs), "wood/mine_wood_stairs")
                                .registerAllUnificationInfo()
                                .build(),
                        new WoodTypeEntry.Builder(twModId, "sort_wood")
                                .planks(new ItemStack(TFBlocks.sort_planks), "wood/sort_planks")
                                .log(new ItemStack(TFBlocks.magic_log, 1, 3)).removeCharcoalRecipe()
                                .door(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("twilightforest:sort_door"))), "wood/sort_door")
                                .slab(new ItemStack(TFBlocks.sort_slab), "wood/sort_slab")
                                .fence(new ItemStack(TFBlocks.sort_fence), "wood/sort_fence")
                                .fenceGate(new ItemStack(TFBlocks.sort_gate), "wood/sort_gate")
                                .stairs(new ItemStack(TFBlocks.sort_stairs), "wood/sort_wood_stairs")
                                .registerAllUnificationInfo()
                                .build()
                );
            }
        }
        return DEFAULT_ENTRIES;
    }

    public static void registerUnificationInfo() {
        for (WoodTypeEntry entry : getDefaultEntries()) {
            registerWoodUnificationInfo(entry);
        }
    }

    private static void removeTFDefaultRecipes() {
        /**/
    }

    public static void registerRecipes() {
        registerWoodRecipe();
    }

    private static void registerWoodRecipe() {
        for (WoodTypeEntry entry : getDefaultEntries()) {
            registerTFWoodTypeRecipe(entry);
        }
    }

    public static void registerTFWoodTypeRecipe(@NotNull WoodTypeEntry entry) {
        final String name = entry.woodName;

        if (entry.planks.isEmpty()) {
            throw new IllegalStateException("Could not find planks from of WoodTypeEntry '" + name + "'.");
        }

        if (!entry.log.isEmpty()) {
            boolean hasPlanksRecipe = entry.planksRecipeName != null;
            if (ConfigHolder.recipes.nerfWoodCrafting) {
                if (hasPlanksRecipe) {
                    ModHandler.removeRecipeByName(new ResourceLocation(entry.modid, Objects.requireNonNull(entry.planksRecipeName)));
                }
                ModHandler.addShapelessRecipe(hasPlanksRecipe ? entry.planksRecipeName : name + "_planks",
                        GTUtility.copy(2, entry.planks), entry.log.copy());
            } else {
                if (!hasPlanksRecipe) {
                    ModHandler.addShapelessRecipe(name + "_planks", GTUtility.copy(4, entry.planks), entry.log.copy());
                }
            }

            ModHandler.addShapedRecipe(name + "_planks_saw",
                    GTUtility.copy(ConfigHolder.recipes.nerfWoodCrafting ? 4 : 6, entry.planks),
                    "s", "L", 'L', entry.log.copy());

            CUTTER_RECIPES.recipeBuilder()
                    .inputs(entry.log.copy())
                    .outputs(GTUtility.copy(6, entry.planks))
                    .output(dust, Wood, 2)
                    .duration(200)
                    .EUt(VA[ULV])
                    .buildAndRegister();

            if (ConfigHolder.recipes.harderCharcoalRecipe) {
                if (entry.removeCharcoalRecipe) {
                    final ItemStack outputStack = FurnaceRecipes.instance().getSmeltingResult(entry.log);
                    if (outputStack.getItem() == Items.COAL && outputStack.getItemDamage() == 1) {
                        ModHandler.removeFurnaceSmelting(entry.log);
                    }
                }
            }
        }

        // door
        if (!entry.door.isEmpty()) {
            final boolean hasDoorRecipe = entry.doorRecipeName != null;
            if (ConfigHolder.recipes.hardWoodRecipes) {
                // hard plank -> door crafting
                if (hasDoorRecipe) {
                    ModHandler.removeRecipeByName(new ResourceLocation(entry.modid, entry.doorRecipeName));
                }
                ModHandler.addShapedRecipe(hasDoorRecipe ? entry.doorRecipeName : name + "_door", entry.door.copy(),
                        "PTd", "PRS", "PPs",
                        'P', entry.planks.copy(),
                        'T', new ItemStack(Blocks.TRAPDOOR),
                        'R', new UnificationEntry(ring, Iron),
                        'S', new UnificationEntry(screw, Iron));

                // plank -> door assembling
                ASSEMBLER_RECIPES.recipeBuilder()
                        .inputs(new ItemStack(Blocks.TRAPDOOR))
                        .inputs(GTUtility.copy(4, entry.planks))
                        .fluidInputs(Iron.getFluid(GTValues.L / 9))
                        .outputs(entry.door.copy())
                        .duration(400).EUt(4).buildAndRegister();
            } else {
                if (!hasDoorRecipe) {
                    ModHandler.addShapedRecipe(name + "_door", GTUtility.copy(3, entry.door),
                            "PP", "PP", "PP",
                            'P', entry.planks.copy());
                }

                ASSEMBLER_RECIPES.recipeBuilder()
                        .inputs(GTUtility.copy(6, entry.planks))
                        .outputs(GTUtility.copy(3, entry.door))
                        .circuitMeta(6)
                        .duration(600).EUt(4)
                        .buildAndRegister();
            }
        }

        // stairs
        if (!entry.stairs.isEmpty()) {
            if (entry.addStairsCraftingRecipe) {
                ModHandler.addShapedRecipe(name + "_stairs", GTUtility.copy(4, entry.stairs),
                        "P  ", "PP ", "PPP",
                        'P', entry.planks.copy());
            }

            // plank -> stairs assembling
            ASSEMBLER_RECIPES.recipeBuilder()
                    .inputs(GTUtility.copy(6, entry.planks))
                    .outputs(GTUtility.copy(4, entry.stairs))
                    .circuitMeta(7)
                    .EUt(1).duration(100).buildAndRegister();
        }

        // slab
        if (!entry.slab.isEmpty()) {
            if (entry.addSlabCraftingRecipe && !ConfigHolder.recipes.hardWoodRecipes) {
                ModHandler.addShapedRecipe(name + "_slab", GTUtility.copy(6, entry.slab),
                        "PPP", 'P', entry.planks.copy());
            }

            // plank -> slab crafting
            ModHandler.addShapedRecipe(name + "_slab_saw", GTUtility.copy(2, entry.slab),
                    "sS", 'S', entry.planks.copy());

            if (ConfigHolder.recipes.hardWoodRecipes && entry.slabRecipeName != null) {
                ModHandler.removeRecipeByName(new ResourceLocation(entry.modid, entry.slabRecipeName));
            }

            // plank -> slab cutting
            CUTTER_RECIPES.recipeBuilder()
                    .inputs(entry.planks.copy())
                    .outputs(GTUtility.copy(2, entry.slab))
                    .duration(200).EUt(VA[ULV])
                    .buildAndRegister();
        }

        //fence
        if (!entry.fence.isEmpty()) {
            final boolean hasFenceRecipe = entry.fenceRecipeName != null;
            if (ConfigHolder.recipes.hardWoodRecipes) {
                //hard plank -> fence crafting
                if (hasFenceRecipe) {
                    ModHandler.removeRecipeByName(new ResourceLocation(entry.modid, entry.fenceRecipeName));
                }

                ModHandler.addShapedRecipe(hasFenceRecipe ? entry.fenceRecipeName : name + "_fence", entry.fence.copy(),
                        "IPI", "SUS", "SUS",
                        'I', OreDictUnifier.get(screw, Iron),
                        'P', entry.planks.copy(),
                        'U', new UnificationEntry(OrePrefix.plank, Materials.Wood),
                        'S', entry.getStick());
            } else {
                if (!hasFenceRecipe) {
                    ModHandler.addShapedRecipe(name + "_fence", GTUtility.copy(3, entry.fence),
                            "PSP", "PSP",
                            'P', entry.planks.copy(),
                            'S', entry.getStick());
                }
            }

            // plank -> fence assembling
            ASSEMBLER_RECIPES.recipeBuilder()
                    .inputs(entry.planks.copy())
                    .outputs(entry.fence.copy())
                    .circuitMeta(1)
                    .duration(100).EUt(4)
                    .buildAndRegister();

        }

        //fenceGate
        if (!entry.fenceGate.isEmpty()) {
            final boolean hasFenceGateRecipe = entry.fenceGateRecipeName != null;
            if (ConfigHolder.recipes.hardWoodRecipes) {
                if (hasFenceGateRecipe) {
                    ModHandler.removeRecipeByName(new ResourceLocation(entry.modid, entry.fenceGateRecipeName));
                }

                ModHandler.addShapedRecipe(hasFenceGateRecipe ? entry.fenceGateRecipeName : name + "_fence_gate",
                        entry.fenceGate.copy(),
                        "   ", "FIF", "FIF",
                        'F', entry.fence,
                        'I', OreDictUnifier.get(screw, Iron)
                );

            } else {
                if (!hasFenceGateRecipe) {
                    ModHandler.addShapedRecipe(name + "_fence_gate", entry.fenceGate.copy(),
                            "SPS", "SPS",
                            'P', entry.planks.copy(),
                            'S', entry.getStick());
                }
            }

            // plank -> fence gate assembling
            ASSEMBLER_RECIPES.recipeBuilder()
                    .inputs(GTUtility.copy(2, entry.planks))
                    .input(entry.getStick().toString(), 2)
                    .outputs(entry.fenceGate.copy())
                    .circuitMeta(2)
                    .duration(100).EUt(4).buildAndRegister();

        }
    }

}
