package gtne.common.Block;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.unification.material.Materials;
import gregtech.common.ConfigHolder;
import gtne.api.unification.material.GTNEMaterials;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
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

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.SOLID;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack itemStack, @Nullable World worldIn, List<String> lines, @Nonnull ITooltipFlag tooltipFlag) {
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);
        VariantItemBlock itemBlock = (VariantItemBlock)itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        BlockGTNEWireCoil.CoilType coilType = this.getState(stackState);
        lines.add(I18n.format("tile.wire_coil.tooltip_heat", coilType.coilTemperature));
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

    @Override
    protected boolean isBloomEnabled(BlockGTNEWireCoil.CoilType value) {
        return ConfigHolder.client.coilsActiveEmissiveTextures;
    }

    public enum CoilType implements IStringSerializable, IHeatingCoilBlockStats {
        DRACONIUM("draconium", 18000, 16, 10, 9, GTNEMaterials.Draconium),
        AWAKENEDDRACONIUM("awakeneddraconium", 24000, 20, 12, 10, GTNEMaterials.Awakened_Draconium),
        CELESTIALLIUM("celestiallium", 28000, 24, 14, 11, GTNEMaterials.Celestiallium),
        LUNATIUM("lunatium", 36000, 28, 16, 12, GTNEMaterials.Lunatium),
        SACREDMETAL("sacred", 48000, 32, 18, 13, GTNEMaterials.Sacred_Metal),
        STELLARIUM("stellarium", 56000, 36, 22, 14, GTNEMaterials.Stellarium),
        FRACTALLIUM("fractallium", 64000, 48, 28, 15, GTNEMaterials.Fractallium),
        ENTROPIUM("entropium", 128000, 60, 32, 16, GTNEMaterials.Entropium);



        private final String name;
        private final int coilTemperature;
        private final int level;
        private final int energyDiscount;
        private final int tier;
        private final gregtech.api.unification.material.Material material;

        CoilType(String name, int coilTemperature, int level, int energyDiscount, int tier, gregtech.api.unification.material.Material material) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.tier = tier;
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
            return this.tier;
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
