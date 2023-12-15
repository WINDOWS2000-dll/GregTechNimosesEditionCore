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
    }

    private static void RemoveAddonRecipes() {
        ModHandler.removeRecipeByName("enderio:tweak_wood_hopper");
        ModHandler.removeRecipeByName("enderio:tweak_stick_from_wood");
        ModHandler.removeRecipeByName("gregtech:stick_normal");
        ModHandler.removeRecipeByName("enderio:tweak_chest_from_wood");
        ModHandler.removeRecipeByName("enderio:compatibility_glass_pane");
        ModHandler.removeRecipeByName("thermalfoundation:saddle");

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
        ModHandler.addShapedRecipe("bed", new ItemStack(Blocks.BED, 1, 0),
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
            ModHandler.addShapedRecipe("bed_colored_" + i, new ItemStack(Blocks.BED, 1, i),
                            "DDD",
                                    "DBD",
                                    "DDD",
                    'D', new ItemStack(Items.DYE, 1, i),
                    'B', new ItemStack(Blocks.BED, 1, 0)
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
            ModHandler.addShapedRecipe("brick_compound", new ItemStack(BRICK_COMPOUND.getStackForm().getItem()),
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
            ModHandler.addShapelessRecipe("compressed_clay", new ItemStack(COMPRESSED_CLAY.getStackForm().getItem()),
                    "wc",
                    'w', new ItemStack(BRICK_COMPOUND.getStackForm().getItem()),
                    'c', new ItemStack(WOODEN_FORM_BRICK.getStackForm().getItem())
            );

            //Alloy Smelter Brick Recipe
            RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(BRICK_COMPOUND, 1)
                    .notConsumable(SHAPE_MOLD_INGOT)
                    .output(Items.BRICK, 1)
                    .EUt(2).duration(200)
                    .buildAndRegister();
    }
}
