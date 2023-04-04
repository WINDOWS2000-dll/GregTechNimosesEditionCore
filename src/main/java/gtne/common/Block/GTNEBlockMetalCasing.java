package gtne.common.Block;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class GTNEBlockMetalCasing extends VariantBlock<GTNEBlockMetalCasing.MetalCasingType> {

    public GTNEBlockMetalCasing() {
        super(Material.IRON);
        setTranslationKey("gtne_metal_casing");
        setHardness(15.0f);
        setResistance(100.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 4);
        setDefaultState(getState(MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINECASING));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MetalCasingType implements IStringSerializable {

        ADVANCEDPRECISIONASSEMBLYLINECASING("advanced_precision_assembly_line_casing"),
        ADVANCEDPRECISIONASSEMBLYLINEFILTER("advanced_precision_assembly_line_filter"),
        ADVANCEDPRECISIONASSEMBLYLINECONTROL("advanced_precision_assembly_line_control"),
        ADVANCEDPRECISIONASSEMBLYLINE("advanced_precision_assembly_line");


        private final String name;

        MetalCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }
    }
}
