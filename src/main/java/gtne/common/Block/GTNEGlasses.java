package gtne.common.Block;

import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.block.VariantBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockWireCoil;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import java.util.List;

import static gregtech.api.GTValues.*;

@ParametersAreNonnullByDefault
public class GTNEGlasses extends VariantActiveBlock<GTNEGlasses.GTNEGlassType> {

    public GTNEGlasses() {
        super(Material.IRON);
        setTranslationKey("gtne_glasses");
        setHardness(5.0F);
        setResistance(5.0F);
        setSoundType(SoundType.GLASS);
        setHarvestLevel(ToolClasses.PICKAXE, 1);
        setDefaultState(getState(GTNEGlassType.BorosilicateGlassHV));
        this.useNeighborBrightness = true;
        setRegistryName("gtne_glasses");
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack itemStack, @Nullable World worldIn, List<String> lines, @Nonnull ITooltipFlag tooltipFlag) {
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        VariantItemBlock itemBlock = (VariantItemBlock<GTNEGlasses.GTNEGlassType, GTNEGlasses>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        GTNEGlasses.GTNEGlassType glassType = getState(stackState);

        lines.add(I18n.format("tile.borosilicateglass.tooltip_glasstier", glassType.GlassTier));

        if (TooltipHelper.isShiftDown()) {
            lines.add(I18n.format("tile.borosilicateglass.joke"));
        }
    }

    @Override
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return getState(state)  != GTNEGlassType.BorosilicateGlassHV && getState(state) == GTNEGlassType.BorosilicateGlassHV ? layer == BlockRenderLayer.TRANSLUCENT : super.canRenderInLayer(state, layer);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));

        return sideState.getBlock() == this ?
                getState(sideState) != getState(state) :
                super.shouldSideBeRendered(state, world, pos, side);
    }

    public enum GTNEGlassType implements IStringSerializable {

        BorosilicateGlassHV("borosilicateglass", GTValues.VN[HV]),
        BorosilicateGlassEV("titanium_reinforced_borosilicateglass", GTValues.VN[EV]),
        BorosilicateGlassIV("tungstensteel_reinforced_borosilicateglass", GTValues.VN[IV]),
        BorosilicateGlassLuV("rhodium_plated_palladium_reinforced_borosilicateglass", GTValues.VN[LuV]),
        BorosilicateGlassZPM("iridium_reinforced_borosilicateglass", GTValues.VN[ZPM]),
        BorosilicateGlassUV("osmium_reinforced_borosilicateglass", GTValues.VN[UV]),
        BorosilicateGlassUHV("neutronium_reinforced_borosilicateglass", GTValues.VN[UHV]);

        //Todo UEV+ BorosilicateGlasses
        //BorosilicateGlassUHV("MITEI_Reinforced_BorosilicateGlass", GTValues.VN[UEV]),
        //...

        private final String name;
        private final String  GlassTier;

        GTNEGlassType(String name, String GlassTier) {
            this.name = name;
            this.GlassTier = GlassTier;
        }

        @Nonnull
        public String  getGlassTier() {
            return this.GlassTier;
        }


        @Override
        @Nonnull
        public String getName() {
            return this.name;
        }
    }
}
