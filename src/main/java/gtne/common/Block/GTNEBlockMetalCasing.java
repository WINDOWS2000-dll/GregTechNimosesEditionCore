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
        setRegistryName("gtne_metal_casing");
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MetalCasingType implements IStringSerializable {

        ADVANCEDPRECISIONASSEMBLYLINECASING("advanced_precision_assembly_line_casing"),
        ADVANCEDPRECISIONASSEMBLYLINEFILTER("advanced_precision_assembly_line_filter"),
        ADVANCEDPRECISIONASSEMBLYLINECONTROL("advanced_precision_assembly_line_control"),
        ADVANCEDPRECISIONASSEMBLYLINE("advanced_precision_assembly_line"),
        ELECTRO_MAGNETIC_IMPLOSION_COIL("electromagnetic_implosion_coil"),
        FUSION_MACHINE_CASING_MKIV("fusion_machine_casing_mk_iv"),
        FUSION_MACHINE_CASING_MKV("fusion_machine_casing_mk_v"),
        ADVANCED_FUSION_COIL("advanced_fusion_coil"),
        ADVANCED_DISTILLATION_TOWER_CASING("advanced_distillation_tower_casing"),
        ADVANCED_DISTILLATION_TOWER_PIPE_CASING("advanced_distillation_tower_pipe_casing"),
        ADVANCED_DISTILLATION_TOWER_BASE_CASING("advanced_distillation_tower_base_casing"),
        QUANTIUM_CASING("quantium_casing"),
        TRITANIUM_CASING("tritanium_casing");


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
