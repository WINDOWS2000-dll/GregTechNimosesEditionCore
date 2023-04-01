package gtne.common.Block;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.BlockWireCoil;
import gtne.api.unification.material.GTNEMaterials;
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
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BlockGTNEWireCoil extends VariantActiveBlock<BlockGTNEWireCoil.CoilType> {

    public BlockGTNEWireCoil() {
        super(Material.IRON);
        setTranslationKey("gtne_wire_coil");
        setHardness(10.0F);
        setResistance(10.0F);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 4);
        setDefaultState(this.getState(CoilType.DRACONIUM));
        setRegistryName("gtne_wire_coil");
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack itemStack, @Nullable World worldIn, List<String> lines, @Nonnull ITooltipFlag tooltipFlag) {
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);
        VariantItemBlock itemBlock = (VariantItemBlock)itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        BlockGTNEWireCoil.CoilType coilType = (BlockGTNEWireCoil.CoilType)this.getState(stackState);
        lines.add(I18n.format("tile.wire_coil.tooltip_heat", new Object[]{coilType.coilTemperature}));
        if (!Keyboard.isKeyDown(42) && !Keyboard.isKeyDown(54)) {
            lines.add(I18n.format("gregtech.tooltip.hold_shift"));
        } else {
            int coilTier = coilType.ordinal();
            lines.add(I18n.format("tile.wire_coil.tooltip_smelter"));
            lines.add(I18n.format("tile.wire_coil.tooltip_parallel_smelter", coilType.level * 32));
            lines.add(I18n.format("tile.wire_coil.tooltip_energy_smelter", Math.max(1, 16 / coilType.energyDiscount)));
            lines.add(I18n.format("tile.wire_coil.tooltip_pyro"));
            lines.add(I18n.format("tile.wire_coil.tooltip_speed_pyro", coilTier == 0 ? 75 : 50 * (coilTier + 1)));
            lines.add(I18n.format("tile.wire_coil.tooltip_cracking"));
            lines.add(I18n.format("tile.wire_coil.tooltip_energy_cracking", 100 - 10 * coilTier));
        }

    }

    public static enum CoilType implements IStringSerializable, IHeatingCoilBlockStats {
        DRACONIUM("machine_coil_draconium", 18000, 16, 10, GTNEMaterials.Draconium),
        AWAKENEDDRACONIUM("machine_coil_awakeneddraconium", 24000, 20, 12, GTNEMaterials.Awakened_Draconium),
        NEUTRONIUM("machine_coil_neutronium", 28000, 24, 14, Materials.Neutronium);



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
