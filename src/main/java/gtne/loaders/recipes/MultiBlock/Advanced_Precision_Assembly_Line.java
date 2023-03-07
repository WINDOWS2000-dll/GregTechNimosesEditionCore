package gtne.loaders.recipes.MultiBlock;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.api.util.GTUtility;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.GTNEBlockMetalCasing;
import gtne.common.GTNEMetaBlock;
import gtne.common.metatileentities.GTNEMetaTileEntities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gtne.common.metatileentities.GTNEMetaTileEntities.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class Advanced_Precision_Assembly_Line {

    public static void init() {
        //Fusion Reactor Mk.3 Test Recipe
        GTNERecipeMaps.ADVANCED_PRECISION_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UIV])
                .input(circuit, MarkerMaterials.Tier.UHV, 64)
                .outputs(MetaTileEntities.FUSION_REACTOR[2].getStackForm())
                .duration(600).EUt(VA[UHV])
                .buildAndRegister();
    }
}
