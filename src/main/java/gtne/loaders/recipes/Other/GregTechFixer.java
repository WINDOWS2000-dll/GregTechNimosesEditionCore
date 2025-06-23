package gtne.loaders.recipes.Other;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.*;
import static gregtech.common.blocks.BlockSteamCasing.SteamCasingType.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

public class GregTechFixer {

    public static void init() {
        SteamAge();
    }

    private static void SteamAge() {

        final String[] RemoveRecipe = {
                "gregtech:wood_tank_valve", "gregtech:wood_multiblock_tank", "gregtech:wood_wall", "gregtech:casing_coke_bricks", "gregtech:coke_oven", "gregtech:coke_oven_hatch",
                "gregtech:casing_bronze_bricks"
        };

        for (String remove_steamage_recipe : RemoveRecipe) {
            ModHandler.removeRecipeByName(remove_steamage_recipe);
        }
        /*
         *
         * <li>{@code 'c'} - {@code craftingToolCrowbar}</li>
         * <li>{@code 'd'} - {@code craftingToolScrewdriver}</li>
         * <li>{@code 'f'} - {@code craftingToolFile}</li>
         * <li>{@code 'h'} - {@code craftingToolHardHammer}</li>
         * <li>{@code 'k'} - {@code craftingToolKnife}</li>
         * <li>{@code 'm'} - {@code craftingToolMortar}</li>
         * <li>{@code 'r'} - {@code craftingToolSoftHammer}</li>
         * <li>{@code 's'} - {@code craftingToolSaw}</li>
         * <li>{@code 'w'} - {@code craftingToolWrench}</li>
         * <li>{@code 'x'} - {@code craftingToolWireCutter}</li>
        */

        //Wooden Tank
        ModHandler.addShapedRecipe("wooden_multiblock_tank", new ItemStack(WOODEN_TANK.getStackForm().getItem()),
                " R ", "rWs", " R ",
                'R', OreDictUnifier.get(ring, Bronze),
                'W', new ItemStack(MetaBlocks.STEAM_CASING.getItemVariant(WOOD_WALL).getItem())
        );
        //Wooden Tank Valve
        ModHandler.addShapedRecipe("wooden_tank_valve", new ItemStack(WOODEN_TANK_VALVE.getStackForm().getItem()),
                " R ", "rWs", " T ",
                'R', OreDictUnifier.get(ring, Bronze),
                'T', OreDictUnifier.get(rotor, Bronze),
                'W', new ItemStack(MetaBlocks.STEAM_CASING.getItemVariant(WOOD_WALL).getItem())
        );
        //Wooden Tank Wall
        ModHandler.addShapedRecipe("wooden_tank_wall", new ItemStack(MetaBlocks.STEAM_CASING.getItemVariant(WOOD_WALL).getItem()),
                "W W", "sPh", "W W",
                'W', OreDictUnifier.get(plank, TreatedWood),
                'P', OreDictUnifier.get(plate, Bronze)
        );
        //Coke Oven Brick
        ModHandler.addShapedRecipe("hard_cokeoven_brick", new ItemStack(BlockMetalCasing.getBlockFromItem(COKE_OVEN_BRICK.getMetaItem())),
                " C ", "CBC", " C ",
                'C', new ItemStack(COKE_OVEN_BRICK.getMetaItem()),
                'B', Blocks.BRICK_BLOCK
        );
        //Coke Oven
        ModHandler.addShapedRecipe("harder_cokeoven", new ItemStack(COKE_OVEN.getStackForm().getItem()),
                "BPB", "PwP", "BPB",
                'B', new ItemStack(BlockMetalCasing.getBlockFromItem(COKE_OVEN_BRICK.getMetaItem())),
                'P', OreDictUnifier.get(plateDouble, Iron)
        );
        //Coke Oven Hatch
        ModHandler.addShapedRecipe("harder_cokeoven_hatch", new ItemStack(COKE_OVEN_HATCH.getStackForm().getItem()),
                " w ", "BWP", " r ",
                'B', new ItemStack(BlockMetalCasing.getBlockFromItem(COKE_OVEN_BRICK.getMetaItem())),
                'W', new ItemStack(WOODEN_DRUM.getStackForm().getItem()),
                'P', OreDictUnifier.get(pipeNormalFluid, TreatedWood)
        );
        //Bronze Machine Casing
        ModHandler.addShapedRecipe("harder_bronze_machine_casing", new ItemStack(MetaBlocks.METAL_CASING.getItemVariant(BRONZE_BRICKS).getItem()),
                "PhP", "PBP", "PwP",
                'P', OreDictUnifier.get(plate, Bronze),
                'B', new ItemStack(MetaBlocks.METAL_CASING.getItemVariant(PRIMITIVE_BRICKS).getItem())
        );

    }

}
