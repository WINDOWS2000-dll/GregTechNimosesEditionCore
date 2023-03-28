package gtne.common.Block;

import gregtech.api.block.VariantBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.BlockWireCoil;
import gtne.api.interfaces.block.IComputerCasingBlockStats;
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

public class ComputerCasing extends VariantBlock<ComputerCasing.ComputerTier> {

    public ComputerCasing() {
        super(Material.IRON);
        setTranslationKey("computer_casing");
        setHardness(40.0f);
        setResistance(1.14514f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 5);
        setDefaultState(getState(ComputerTier.COMPUTER_TIER_IV));
        setRegistryName("gtne_computer_casing");
    }

    /*
    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack itemStack, @Nullable World worldIn, List<String> lines, @Nonnull ITooltipFlag tooltipFlag) {
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);
        VariantItemBlock itemBlock = (VariantItemBlock)itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        ComputerCasing.ComputerTier computerTier = (ComputerCasing.ComputerTier)this.getState(stackState);
        lines.add(I18n.format("tile.compution_casing.tooltip.operation_speed", new Object[]{computerTier.OperationSpeed}));
        if (!Keyboard.isKeyDown(42) && !Keyboard.isKeyDown(54)) {
            lines.add(I18n.format("gregtech.tooltip.hold_shift"));
        } else {
            int computertier = computerTier.ordinal();
            lines.add(I18n.format("tile.wire_coil.tooltip_energy_smelter", new Object[]{Math.max(1, 16 / computerTier.energyDiscount)}));

        }
    }

     */

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack itemStack, @Nullable World worldIn, List<String> lines, @Nonnull ITooltipFlag tooltipFlag) {
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        // noinspection rawtypes, unchecked
        VariantItemBlock itemBlock = (VariantItemBlock<ComputerCasing.ComputerTier, ComputerCasing>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        ComputerTier computerTier = getState(stackState);

        lines.add(I18n.format("tile.wire_coil.tooltip_heat", computerTier.OperationSpeed));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public static enum ComputerTier implements IStringSerializable, IComputerCasingBlockStats {
        COMPUTER_TIER_IV("computer_iv", 256, 1, 1, null),
        COMPUTER_TIER_LUV("computer_luv", 512, 2, 1, null),
        COMPUTER_TIER_ZPM("computer_zpm", 1024, 3, 2, null),
        COMPUTER_TIER_UV("computer_uv", 2048, 4, 2, null),
        COMPUTER_TIER_UHV("computer_uhv", 4096, 5, 2, null),
        COMPUTER_TIER_UEV("computer_uev", 8192, 6, 3, null),
        COMPUTER_TIER_UIV("computer_uiv", 16384, 7, 3, null),
        COMPUTER_TIER_UXV("computer_uxv", 32768, 8, 3, null),
        COMPUTER_TIER_OPV("computer_opv", 65536, 9, 3, null),
        COMPUTER_TIER_MAX("computer_max", 131072, 10, 4, null);

        private final String name;
        private final int OperationSpeed;
        private final int level;
        private final int energyDiscount;
        private final gregtech.api.unification.material.Material material;

        private ComputerTier(String name, int OperationSpeed, int level, int energyDiscount, gregtech.api.unification.material.Material material) {
            this.name = name;
            this.OperationSpeed = OperationSpeed;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.material = material;
        }

        @Nonnull
        public String getName() {
            return this.name;
        }

        public int getOperationSpeed() {
            return this.OperationSpeed;
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
