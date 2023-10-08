package gtne.common.Block;

import gregtech.api.block.VariantActiveBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class DHSCTCasing extends VariantActiveBlock<DHSCTCasing.DHSCTCasingType> {

    public DHSCTCasing() {
        super(Material.IRON);
        setTranslationKey("gtne_hdsct_casing");
        setHardness(40.0F);
        setResistance(60.0F);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 4);
        setDefaultState(getState(DHSCTCasingType.DIMENTIONALLY_TRANSCENDENT_CASING));
        setRegistryName("gtne_hdsct_casing");
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum DHSCTCasingType implements IStringSerializable {

        DIMENTIONAL_BRIDGE("dimentional_bridge"),
        DIMENTIONALLY_TRANSCENDENT_CASING("dimentionally_transcendent_casing"),
        DIMENTIONAL_MATTER_INJECTION_CASING("dimentional_matter_injection_casing"),
        DIMENTIONAL_STABILISATION_FIELD_GENERATOR("dimentional_stabilisation_field_generator"),
        SPACETIME_CONTAINMENT_FIELD_GENERATOR("spacetime_containment_field_generator"),
        SPACETIME_DILATION_FIELD_GENERATOR("spacetime_dilation_field_generator");


        private final String name;

        DHSCTCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }

    }

}
