package gtne.loaders.recipes.Other;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItem1;
import gregtech.common.items.MetaItems;
import gtne.common.ConfigHolder;
import gtne.common.item.GTNEMetaItem1;
import gtne.common.item.GTNEMetaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.api.metatileentity.multiblock.CleanroomType.CLEANROOM;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gtne.api.util.GTNEUtil.*;
import static gtne.common.item.GTNEMetaItems.*;

public class VanillaFix {

    public static void init() {
        if (ConfigHolder.recipeoption.Harder_Vanilla_Recipe) {
            RemoveVanillaRecipe();
            RemoveAddonRecipes();
            Hard_Vanilla_Recipe();
        }
    }

    private static void RemoveVanillaRecipe() {
        //Chest Normal
        ModHandler.removeRecipeByOutput(new ItemStack(Blocks.CHEST));
        //Furnace Normal
        ModHandler.removeRecipeByOutput(new ItemStack(Blocks.FURNACE));
        //Bed Normal
        ModHandler.removeRecipeByOutput(new ItemStack(Blocks.BED));
        //Bed Stained
        for (String bed_recipe_name : BedRecipeName) {
            ModHandler.removeRecipeByName(bed_recipe_name + "white_bed");
        }
        //Bed Vanilla
        for (String bed_recipe_name_1 : BedRecipeName1) {
            ModHandler.removeRecipeByName(bed_recipe_name_1);
        }
        //Fence Normal
        ModHandler.removeRecipeByName("gregtech:fence");
        ModHandler.removeRecipeByName("gregtech:fence_gate");
        for (String fence_recipe_name : WoodType_1) {
            ModHandler.removeRecipeByName("gregtech:" + fence_recipe_name + "_fence");
            ModHandler.removeRecipeByName("gregtech:" + fence_recipe_name + "_fence_gate");
            ModHandler.removeRecipeByName("gregtech:" + fence_recipe_name + "_fence_gate_screws");
        }
        //Brick Line
            //Brick
            GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ALLOY_SMELTER_RECIPES, new ItemStack(Items.CLAY_BALL, 1), SHAPE_MOLD_INGOT.getStackForm(1));
            //Compressed Clay
            ModHandler.removeRecipeByName("gregtech:compressed_clay");
        //WoodenTools
            ModHandler.removeRecipeByName("minecraft:wooden_pickaxe");
            ModHandler.removeRecipeByName("minecraft:wooden_sword");
            ModHandler.removeRecipeByName("minecraft:wooden_shovel");
            ModHandler.removeRecipeByName("minecraft:wooden_axe");
            ModHandler.removeRecipeByName("minecraft:wooden_hoe");
        //Armor Stand
            ModHandler.removeRecipeByName("minecraft:armor_stand");
        //Vanilla Armor
            ModHandler.removeRecipeByName("minecraft:leather_helmet");
            ModHandler.removeRecipeByName("minecraft:leather_chestplate");
            ModHandler.removeRecipeByName("minecraft:leather_leggings");
            ModHandler.removeRecipeByName("minecraft:leather_boots");
            ModHandler.removeRecipeByName("gregtech:iron_helmet");
            ModHandler.removeRecipeByName("gregtech:iron_chestplate");
            ModHandler.removeRecipeByName("gregtech:iron_leggings");
            ModHandler.removeRecipeByName("gregtech:iron_boots");
            ModHandler.removeRecipeByName("gregtech:golden_helmet");
            ModHandler.removeRecipeByName("gregtech:golden_chestplate");
            ModHandler.removeRecipeByName("gregtech:golden_leggings");
            ModHandler.removeRecipeByName("gregtech:golden_boots");
        //Hopper
            ModHandler.removeRecipeByName("gregtech:hopper");
    }

    private static void RemoveAddonRecipes() {
        ModHandler.removeRecipeByName("gregtech:stick_normal");
        ModHandler.removeRecipeByName("enderio:compatibility_glass_pane");
        ModHandler.removeRecipeByName("thermalfoundation:saddle");
        ModHandler.removeRecipeByName("extrautils2:shortcut_stick");
        ModHandler.removeRecipeByName("extrautils2:shortcut_chest");
        ModHandler.removeRecipeByName("extrautils2:shortcut_hopper");

    }

    private static void Hard_Vanilla_Recipe() {
        //Chest GTNE
        ModHandler.addShapedRecipe("chest", new ItemStack(Blocks.CHEST),
                "SLS",
                        "LFL",
                        "SLS",
                'S', OreDictUnifier.get(screw, Wood),
                'L', new ItemStack(Blocks.LOG, 1, 0),
                'F', OreDictUnifier.get(frameGt, Wood)
        );
        //Furnace GTNE
        ModHandler.addShapedRecipe("furnace", new ItemStack(Blocks.FURNACE),
                "SSS",
                        "FFF",
                        "SSS",
                'S', new ItemStack(Blocks.COBBLESTONE),
                'F', new ItemStack(Items.FLINT)
        );
        //Bed GTNE
        ModHandler.addShapedRecipe("bed", new ItemStack(Items.BED, 1, 0),
                "WWW",
                        "SSS",
                        "FIF",
                'W', new ItemStack(Blocks.WOOL, 1,0),
                'S', new UnificationEntry(slab, Wood),
                'F', new UnificationEntry(fence, Wood),
                'I', OreDictUnifier.get(screw, Iron)
        );
        //Bed Stain
        for (int i = 0; i < 16; i++) {
            ModHandler.addShapedRecipe("bed_colored_" + i, new ItemStack(Items.BED, 1, i),
                            "DDD",
                                    "DBD",
                                    "DDD",
                    'D', new ItemStack(Items.DYE, 1, i),
                    'B', new ItemStack(Items.BED, 1, 0)
            );
        }
        //Fence
            //Oak
            ModHandler.addShapedRecipe("oak_fence", new ItemStack(Blocks.OAK_FENCE),
                            "IPI",
                                    "SUS",
                                    "SUS",
                    'I', OreDictUnifier.get(screw, Iron),
                    'P', new ItemStack(Blocks.PLANKS, 1, 0),
                    'U', new UnificationEntry(OrePrefix.plank, Materials.Wood),
                    'S', new ItemStack(Items.STICK)
            );
            //Spruce
            ModHandler.addShapedRecipe("spruce_fence", new ItemStack(Blocks.SPRUCE_FENCE),
                            "IPI",
                                    "SUS",
                                    "SUS",
                    'I', OreDictUnifier.get(screw, Iron),
                    'P', new ItemStack(Blocks.PLANKS, 1, 1),
                    'U', new UnificationEntry(OrePrefix.plank, Materials.Wood),
                    'S', new ItemStack(Items.STICK)
            );
            //Birch
            ModHandler.addShapedRecipe("birch_fence", new ItemStack(Blocks.BIRCH_FENCE),
                            "IPI",
                                    "SUS",
                                    "SUS",
                    'I', OreDictUnifier.get(screw, Iron),
                    'P', new ItemStack(Blocks.PLANKS, 1, 2),
                    'U', new UnificationEntry(OrePrefix.plank, Materials.Wood),
                    'S', new ItemStack(Items.STICK)
            );
            //Jungle
            ModHandler.addShapedRecipe("jungle_fence", new ItemStack(Blocks.JUNGLE_FENCE),
                            "IPI",
                                    "SUS",
                                    "SUS",
                    'I', OreDictUnifier.get(screw, Iron),
                    'P', new ItemStack(Blocks.PLANKS, 1, 3),
                    'U', new UnificationEntry(OrePrefix.plank, Materials.Wood),
                    'S', new ItemStack(Items.STICK)
            );
            //Acacia
            ModHandler.addShapedRecipe("acacia_fence", new ItemStack(Blocks.ACACIA_FENCE),
                            "IPI",
                                    "SUS",
                                    "SUS",
                    'I', OreDictUnifier.get(screw, Iron),
                    'P', new ItemStack(Blocks.PLANKS, 1, 4),
                    'U', new UnificationEntry(OrePrefix.plank, Materials.Wood),
                    'S', new ItemStack(Items.STICK)
            );
            //Dark Oak
            ModHandler.addShapedRecipe("dark_oak_fence", new ItemStack(Blocks.DARK_OAK_FENCE),
                            "IPI",
                                    "SUS",
                                    "SUS",
                    'I', OreDictUnifier.get(screw, Iron),
                    'P', new ItemStack(Blocks.PLANKS, 1, 5),
                    'U', new UnificationEntry(OrePrefix.plank, Materials.Wood),
                    'S', new ItemStack(Items.STICK)
            );
        //Fence Gate
            //Oak
            ModHandler.addShapedRecipe("oak_fence_gate", new ItemStack(Blocks.OAK_FENCE_GATE),
                    "   ",
                            "FIF",
                            "FIF",
                    'F', new ItemStack(Blocks.OAK_FENCE),
                    'I', OreDictUnifier.get(screw, Iron)
                    );
            //Spruce
            ModHandler.addShapedRecipe("spruce_fence_gate", new ItemStack(Blocks.SPRUCE_FENCE_GATE),
                    "   ",
                            "FIF",
                            "FIF",
                    'F', new ItemStack(Blocks.SPRUCE_FENCE),
                    'I', OreDictUnifier.get(screw, Iron)
            );
            //Birch
            ModHandler.addShapedRecipe("birch_fence_gate", new ItemStack(Blocks.BIRCH_FENCE_GATE),
                    "   ",
                            "FIF",
                            "FIF",
                    'F', new ItemStack(Blocks.BIRCH_FENCE),
                    'I', OreDictUnifier.get(screw, Iron)
            );
            //Jungle
            ModHandler.addShapedRecipe("jungle_fence_gate", new ItemStack(Blocks.JUNGLE_FENCE_GATE),
                    "   ",
                            "FIF",
                            "FIF",
                    'F', new ItemStack(Blocks.JUNGLE_FENCE),
                    'I', OreDictUnifier.get(screw, Iron)
            );
            //Acacia
            ModHandler.addShapedRecipe("acacia_fence_gate", new ItemStack(Blocks.ACACIA_FENCE_GATE),
                    "   ",
                            "FIF",
                            "FIF",
                    'F', new ItemStack(Blocks.ACACIA_FENCE),
                    'I', OreDictUnifier.get(screw, Iron)
            );
            //Dark Oak
            ModHandler.addShapedRecipe("dark_oak_fance_gate", new ItemStack(Blocks.DARK_OAK_FENCE_GATE),
                    "   ",
                            "FIF",
                            "FIF",
                    'F', new ItemStack(Blocks.DARK_OAK_FENCE),
                    'I', OreDictUnifier.get(screw, Iron)
            );
        //Brick Line
            //Brick Compound
            ModHandler.addShapedRecipe(true,"brick_compound", BRICK_COMPOUND.getStackForm(),
                    "CCC",
                            "CWG",
                            "GGG",
                    'C', new ItemStack(Blocks.SAND),
                    'W', new ItemStack(Items.WATER_BUCKET),
                    'G', new ItemStack(Blocks.GRAVEL)
            );

            //Brick Compound Mixer Recipe
            RecipeMaps.MIXER_RECIPES.recipeBuilder()
                    .input(Blocks.SAND, 4)
                    .input(Blocks.GRAVEL, 4)
                    .fluidInputs(Water.getFluid(1000))
                    .output(BRICK_COMPOUND, 2)
                    .EUt(8).duration(20)
                    .buildAndRegister();

            //Compressed Clay
            ModHandler.addShapelessRecipe("compressed_clay", COMPRESSED_CLAY.getStackForm(),
                BRICK_COMPOUND.getStackForm(),
                WOODEN_FORM_BRICK.getStackForm()
            );

            //Alloy Smelter Brick Recipe
            RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(BRICK_COMPOUND, 1)
                    .notConsumable(SHAPE_MOLD_INGOT)
                    .output(Items.BRICK, 1)
                    .EUt(2).duration(200)
                    .buildAndRegister();
        //Wooden Half Block Recipe
            //Oak
            ModHandler.addShapedRecipe("oak_half_block", new ItemStack(Blocks.WOODEN_SLAB, 2, 0),
                    "  s",
                            " W ",
                            "   ",
                    'W', new ItemStack(Blocks.PLANKS, 1, 0)
            );
            //Spruce
            ModHandler.addShapedRecipe("spruce_half_block", new ItemStack(Blocks.WOODEN_SLAB, 2, 1),
                    "  s",
                            " W ",
                            "   ",
                    'W', new ItemStack(Blocks.PLANKS, 1, 1)
            );
            //Birch
            ModHandler.addShapedRecipe("birch_half_block", new ItemStack(Blocks.WOODEN_SLAB, 2, 2),
                    "  s",
                            " W ",
                            "   ",
                    'W', new ItemStack(Blocks.PLANKS, 1, 2)
            );
            //Jungle
            ModHandler.addShapedRecipe("jungle_half_block", new ItemStack(Blocks.WOODEN_SLAB, 2, 3),
                    "  s",
                            " W ",
                            "   ",
                    'W', new ItemStack(Blocks.PLANKS, 1, 3)
            );
            //Acacia
            ModHandler.addShapedRecipe("acacia_half_block", new ItemStack(Blocks.WOODEN_SLAB, 2, 4),
                    "  s",
                            " W ",
                            "   ",
                    'W', new ItemStack(Blocks.PLANKS, 1, 4)
            );
            //Dark Oak
            ModHandler.addShapedRecipe("dark_oak_half_block", new ItemStack(Blocks.WOODEN_SLAB, 2, 5),
                    "  s",
                            " W ",
                            "   ",
                    'W', new ItemStack(Blocks.PLANKS, 1, 5));
        //WoodenTools
            //Pickaxe
            ModHandler.addShapedRecipe("wooden_tool_pickaxe", new ItemStack(Items.WOODEN_PICKAXE, 1),
                    "WWW",
                            "CSC",
                            "FSF",
                    'W', OreDictUnifier.get(plank, Wood, 1),
                    'C', OreDictUnifier.get(screw, Wood, 1),
                    'S', new ItemStack(Items.STICK),
                    'F', new ItemStack(Items.FLINT)
                    );
            //Sword
            ModHandler.addShapedRecipe("wooden_tool_sword", new ItemStack(Items.WOODEN_SWORD, 1),
                    "CWF",
                            "FWF",
                            "FSC",
                    'W', OreDictUnifier.get(plank, Wood, 1),
                    'C', OreDictUnifier.get(screw, Wood, 1),
                    'S', new ItemStack(Items.STICK),
                    'F', new ItemStack(Items.FLINT)
            );
            //Shovel
            ModHandler.addShapedRecipe("wooden_tool_shovel", new ItemStack(Items.WOODEN_SHOVEL, 1),
                    "FWF",
                            "CSC",
                            " S ",
                    'W', OreDictUnifier.get(plank, Wood, 1),
                    'C', OreDictUnifier.get(screw, Wood, 1),
                    'S', new ItemStack(Items.STICK),
                    'F', new ItemStack(Items.FLINT)
            );
            //Axe
            ModHandler.addShapedRecipe("wooden_tool_axe", new ItemStack(Items.WOODEN_AXE, 1),
                    "FWF",
                            "SFW",
                            "CSF",
                    'W', OreDictUnifier.get(plank, Wood, 1),
                    'C', OreDictUnifier.get(screw, Wood, 1),
                    'S', new ItemStack(Items.STICK),
                    'F', new ItemStack(Items.FLINT)
            );
            //Hoe
            ModHandler.addShapedRecipe("wooden_tool_hoe", new ItemStack(Items.WOODEN_HOE, 1),
                    "CWW",
                            " SF",
                            " SC",
                    'W', OreDictUnifier.get(plank, Wood, 1),
                    'C', OreDictUnifier.get(screw, Wood, 1),
                    'S', new ItemStack(Items.STICK),
                    'F', new ItemStack(Items.FLINT)
            );
        //Super Nerf Stick Recipe
            ModHandler.addShapedRecipe("nerfed_stick_recipe", new ItemStack(Items.STICK),
                    "W",
                            "W",
                    'W', new UnificationEntry(plank, Wood)
            );
        //Armor Stand
            ModHandler.addShapedRecipe("armor_stand", new ItemStack(Items.ARMOR_STAND, 1),
                    "SSS",
                            "CSd",
                            "SHS",
                    'S', OreDictUnifier.get(stickLong, Wood, 1),
                    'C', OreDictUnifier.get(screw, Iron, 1),
                    'H', new ItemStack(Blocks.STONE_SLAB, 1, 0)
            );
        //Leather Armor
            //helmet
                ModHandler.addShapedRecipe("leather_helmet", new ItemStack(Items.LEATHER_HELMET, 1),
                        "LLL",
                                "LkL",
                                "   ",
                        'L', new ItemStack(Items.LEATHER)
                );
            //Chest Plate
                ModHandler.addShapedRecipe("leather_chest_plate", new ItemStack(Items.LEATHER_CHESTPLATE, 1),
                        "LkL",
                                "LLL",
                                "LLL",
                        'L', new ItemStack(Items.LEATHER)
                );
            //Leggings
                ModHandler.addShapedRecipe("leather_leggings", new ItemStack(Items.LEATHER_LEGGINGS),
                        "LLL",
                                "LkL",
                                "L L",
                        'L', new ItemStack(Items.LEATHER)
                );
            //Boots
                ModHandler.addShapedRecipe("leather_boot", new ItemStack(Items.LEATHER_BOOTS, 1),
                        "   ",
                                "L L",
                                "LkL",
                        'L', new ItemStack(Items.LEATHER)
                );
        //Iron Armor
            //helmet
                ModHandler.addShapedRecipe("iron_helmet", new ItemStack(Items.IRON_HELMET),
                        "DDD",
                                "PhP",
                                "SdS",
                        'D', OreDictUnifier.get(plateDouble, Iron, 1),
                        'P', OreDictUnifier.get(plate,Iron, 1),
                        'S', OreDictUnifier.get(screw, Iron, 1)
                );
            //chestplate
                ModHandler.addShapedRecipe("iron_chestplate", new ItemStack(Items.IRON_CHESTPLATE, 1),
                        "DhD",
                                "PDP",
                                "DPD",
                        'D', OreDictUnifier.get(plateDouble, Iron, 1),
                        'P', OreDictUnifier.get(plate,Iron, 1)
                );
            //Leggings
                ModHandler.addShapedRecipe("iron_leggings", new ItemStack(Items.IRON_LEGGINGS, 1),
                        "DDD",
                                "PhP",
                                "P P",
                        'D', OreDictUnifier.get(plateDouble, Iron, 1),
                        'P', OreDictUnifier.get(plate,Iron, 1)
                );
            //Boots
                ModHandler.addShapedRecipe("iron_boots", new ItemStack(Items.IRON_BOOTS, 1),
                        "S S",
                                "DdD",
                                "DhD",
                        'D', OreDictUnifier.get(plateDouble, Iron, 1),
                        'S', OreDictUnifier.get(screw, Iron, 1)
                );
        //THE GOLDEN AGE WILL RETURN AGAIN Armor
            //helmet
                ModHandler.addShapedRecipe("golden_helmet", new ItemStack(Items.GOLDEN_HELMET),
                        "DDD",
                                "PhP",
                                "SdS",
                        'D', OreDictUnifier.get(plateDouble, Gold, 1),
                        'P', OreDictUnifier.get(plate, Gold, 1),
                        'S', OreDictUnifier.get(screw, Gold, 1)
                );
            //chestplate
                ModHandler.addShapedRecipe("golden_chestplate", new ItemStack(Items.GOLDEN_CHESTPLATE, 1),
                        "DhD",
                                "PDP",
                                "DPD",
                        'D', OreDictUnifier.get(plateDouble, Gold, 1),
                        'P', OreDictUnifier.get(plate, Gold, 1)
                );
            //Leggings
                ModHandler.addShapedRecipe("golden_leggings", new ItemStack(Items.GOLDEN_LEGGINGS, 1),
                        "DDD",
                                "PhP",
                                "P P",
                        'D', OreDictUnifier.get(plateDouble, Gold, 1),
                        'P', OreDictUnifier.get(plate, Gold, 1)
                );
            //Boots
                ModHandler.addShapedRecipe("golden_boots", new ItemStack(Items.GOLDEN_BOOTS, 1),
                        "S S",
                                "DdD",
                                "DhD",
                        'D', OreDictUnifier.get(plateDouble, Gold, 1),
                        'S', OreDictUnifier.get(screw, Gold, 1)
                );
        //Wooden Screw Recipe
            ModHandler.addShapedRecipe("easy_wooden_screw", OreDictUnifier.get(screw, Wood, 2),
                    "S F",
                    'S', new ItemStack(Items.STICK),
                    'F', new ItemStack(Items.FLINT)
            );
        //Hopper
            ModHandler.addShapedRecipe("hopper", new ItemStack(Blocks.HOPPER, 1),
                    "DSD",
                            "GCG",
                            "hDw",
                    'D', OreDictUnifier.get(plateDouble, Iron, 1),
                    'S', OreDictUnifier.get(spring, Iron, 1),
                    'G', OreDictUnifier.get(gear, Iron, 1),
                    'C', new ItemStack(Blocks.CHEST)
            );

    }
}
