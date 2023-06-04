package gtne.api.blocks;

import gregtech.api.GTValues;
import gregtech.common.blocks.MetaBlocks;
import gtne.common.Block.GTNEMetaBlock;
import net.minecraft.block.state.IBlockState;

public interface ITiredGlasses extends ITired {

    @Override
    default Object getTire() {
        return getGlassTier();
    }

    int getGlassTier();

    default long getTierVoltage() {
        return GTValues.V[getGlassTier()];
    }

    default String getTireName() {
        return GTValues.VN[getGlassTier()];
    }

    default String getTireNameColored() {
        return GTValues.VNF[getGlassTier()];
    }

    static int getGlassTier(IBlockState state) {
        if (state.getBlock() == MetaBlocks.TRANSPARENT_CASING) {
            return ((ITiredGlasses)(Object)MetaBlocks.TRANSPARENT_CASING.getState(state)).getGlassTier();
        }
        if(state.getBlock() == GTNEMetaBlock.GTNE_GLASSES){
            return GTNEMetaBlock.GTNE_GLASSES.getState(state).getGlassTier();
        }
        return 0;
    }

}
