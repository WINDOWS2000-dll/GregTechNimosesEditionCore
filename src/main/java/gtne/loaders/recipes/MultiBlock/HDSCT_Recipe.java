package gtne.loaders.recipes.MultiBlock;

import crafttweaker.api.item.IItemStack;
import gregtech.api.GTValues;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gtne.common.Block.BlockGTNEWireCoil;
import gtne.common.Block.GTNEMetaBlock;
import gtne.common.ConfigHolder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import gtne.api.recipes.GTNERecipeMaps;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gtne.api.unification.material.GTNEMaterials.*;

public class HDSCT_Recipe {

    public static void init() {
        GTNERecipeMaps.HIGH_DIMENTIONAL_STRUCTURE_CONSTRUCTION_TESSERACT.recipeBuilder()
                .input(ELECTRIC_MOTOR_LV, 64)
                .fluidInputs(SolderingAlloy.getFluid(114514))
                .output(ELECTRIC_MOTOR_UIV, 1)
                .EUt(30000000)
                .CWUt(128)
                .duration(1200)
                .buildAndRegister();
    }

}
