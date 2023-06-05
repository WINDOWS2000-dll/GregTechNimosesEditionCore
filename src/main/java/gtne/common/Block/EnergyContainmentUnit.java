package gtne.common.Block;

import gregtech.api.block.VariantActiveBlock;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EnergyContainmentUnit extends VariantActiveBlock<EnergyContainmentUnit.EnergyContainmentUnitType> {

    public EnergyContainmentUnit() {
        super(Material.IRON);
        setTranslationKey("gtne_energy_containment_unit");
        setHardness(6.0F);
        setResistance(10.0F);
        setSoundType(SoundType.METAL);
        setDefaultState(getState(EnergyContainmentUnitType.EnergyContainmentUnitCasing));
        setRegistryName("gtne_energy_containment_unit");
    }

    public static long getCapacity(IBlockState state) {
        return getType(state).getCapacity();
    }

    public static int getPassiveLoss(IBlockState state) {
        return getType(state).getPassiveLoss();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack stack, @Nullable World player, List<String> tooltip, @NotNull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        EnergyContainmentUnitType type = getState(stack);
        tooltip.add(I18n.format("gtne.casing.energycontainmentunit.part"));
        if (type.getCapacity() > 0) {
            tooltip.add(I18n.format("gtne.casing.energycontainmentunit.capacity", type.getCapacity()));
        }
        if (type.getPassiveLoss() > 0) {
            tooltip.add(I18n.format("gtne.casing.energycontainmentunit.passive_loss", type.getPassiveLoss()));
        }
    }

    public static EnergyContainmentUnitType getType(IBlockState state) {
        if (isEnergyContainmentUnit(state)) {
            return GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(state);
        }
        return EnergyContainmentUnitType.EnergyContainmentUnitCasing;
    }

    public static boolean isEnergyContainmentUnit(IBlockState state) {
        return state.getBlock() == GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT;
    }

    public static boolean isCapacitor(IBlockState state) {
        return getType(state) != EnergyContainmentUnitType.EnergyContainmentUnitCasing;
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum EnergyContainmentUnitType implements IStringSerializable {

        EnergyContainmentUnitCasing("energy_containment_unit_casing", 0, 0L),
        EnergyContainmentUnitEmpty("energy_containment_unit_empty", 0, 0L),
        EnergyContainmentUnitEV("energy_containment_unit_ev", 1, 100_000_000L),
        EnergyContainmentUnitIV("energy_containment_unit_iv", 16, 1_000_000_000L),
        EnergyContainmentUnitLuV("energy_containment_unit_luv", 256, 10_000_000_000L),
        EnergyContainmentUnitZPM("energy_containment_unit_zpm", 4096, 100_000_000_000L),
        EnergyContainmentUnitUV("energy_containment_unit_uv", 65536, 1_000_000_000_000L),
        EnergyContainmentUnitUHV("energy_containment_unit_uhv", 262144, Long.MAX_VALUE / 2),
        EnergyContainmentUnitUEV("energy_containment_unit_uev", 1048576, Long.MAX_VALUE);


        private final String name;
        private final int passiveLoss;
        private final long capacity;

        EnergyContainmentUnitType(String name, int passiveLoss, long capacity) {
            this.name = name;
            this.passiveLoss= passiveLoss;
            this.capacity = capacity;
        }

        @Override
        public String getName() {
            return name;
        }

        public int getPassiveLoss() {
            return passiveLoss;
        }

        public long getCapacity() {
            return capacity;
        }

    }

}
