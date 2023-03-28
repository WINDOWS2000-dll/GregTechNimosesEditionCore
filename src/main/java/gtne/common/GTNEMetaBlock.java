package gtne.common;

import gtne.common.Block.ComputerCasing;
import gtne.common.Block.ComputerMachineCasing;
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
    public static final ComputerCasing COMPUTER_CASING = new ComputerCasing();
    public static final ComputerMachineCasing COMPUTER_MACHINE_CASING = new ComputerMachineCasing();

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(GTNE_BLOCK_METAL_CASING);
        registerItemModel(COMPUTER_CASING);
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
