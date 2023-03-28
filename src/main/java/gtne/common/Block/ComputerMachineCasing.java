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

public class ComputerMachineCasing extends VariantBlock<ComputerMachineCasing.ComputerMachineCasingType> {
    public ComputerMachineCasing() {
        super(Material.IRON);
        setTranslationKey("computer_machine_casing");
        setHardness(60.0F);
        setResistance(1.0F);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 5);
        setDefaultState(getState(ComputerMachineCasingType.QUBITSUPERCOMPUTERCORNERCASING));
        setRegistryName("gtne_computer_machine_casing");
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ComputerMachineCasingType implements IStringSerializable {

        PROTOTYPESUPERCOMPUTERMACHINECASING("prototype_supercomputer_casing"),
        QUBITSUPERCOMPUTERCORNERCASING("qubit_supercomputer_corner_casing"),
        QUBITSUPERCOMPUTERBEAMCASING("qubit_supercomputer_beam_casing");


        private final String name;

        ComputerMachineCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }
    }
}
