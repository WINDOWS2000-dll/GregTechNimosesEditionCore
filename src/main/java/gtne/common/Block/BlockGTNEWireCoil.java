package gtne.common.Block;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.BlockWireCoil;
import gtne.api.unification.material.GTNEMaterials;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockGTNEWireCoil extends VariantActiveBlock<BlockWireCoil.CoilType> {

    public BlockGTNEWireCoil() {
        super(Material.IRON);
        this.setTranslationKey("gtne_wire_coil");
        this.setHardness(10.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 4);
        this.setDefaultState(this.getState(BlockWireCoil.CoilType.CUPRONICKEL));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public static enum CoilType implements IStringSerializable, IHeatingCoilBlockStats {
        DRACONIUM("draconium", 18000, 16, 10, GTNEMaterials.Draconium),
        AWAKENEDDRACONIUM("awakeneddraconium", 24000, 20, 12, GTNEMaterials.Awakened_Draconium),
        NEUTRONIUM("neutronium", 28000, 24, 14, Materials.Neutronium);



        private final String name;
        private final int coilTemperature;
        private final int level;
        private final int energyDiscount;
        private final gregtech.api.unification.material.Material material;

        private CoilType(String name, int coilTemperature, int level, int energyDiscount, gregtech.api.unification.material.Material material) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.material = material;
        }

        @Nonnull
        public String getName() {
            return this.name;
        }

        public int getCoilTemperature() {
            return this.coilTemperature;
        }

        public int getLevel() {
            return this.level;
        }

        public int getEnergyDiscount() {
            return this.energyDiscount;
        }

        public int getTier() {
            return this.ordinal();
        }

        @Nullable
        public gregtech.api.unification.material.Material getMaterial() {
            return this.material;
        }

        @Nonnull
        public String toString() {
            return this.getName();
        }
    }
}
