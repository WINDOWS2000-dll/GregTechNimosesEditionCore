package gtne.common.Block;

import gtne.common.Block.BlockGTNEWireCoil;
import gtne.common.Block.GTNEBlockMetalCasing;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

public class GTNEMetaBlock {

    public static final GTNEBlockMetalCasing GTNE_BLOCK_METAL_CASING = new GTNEBlockMetalCasing();
    public static final BlockGTNEWireCoil BLOCK_GTNE_WIRE_COIL = new BlockGTNEWireCoil();
    public static final GTNEGlasses GTNE_GLASSES = new GTNEGlasses();

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(GTNE_BLOCK_METAL_CASING);
        BLOCK_GTNE_WIRE_COIL.onModelRegister();
        GTNE_GLASSES.onModelRegister();
    }



    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }
}