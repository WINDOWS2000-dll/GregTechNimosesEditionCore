package gtne.common.metatileentities.multi;


import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.world.DummyWorld;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gtne.Utils.GTNEUtil;
import gtne.api.blocks.ITiredGlasses;
import gtne.api.metatileentities.Energy.BigIntegerBufferLogic;
import gtne.api.metatileentities.IMetaTileEntityChangeableBattery;
import gtne.client.GTNETextures;
import gtne.common.Block.EnergyContainmentUnit;
import gtne.common.Block.GTNEGlasses;
import gtne.common.Block.GTNEMetaBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class MetaTileEntityEnergyContainmentField extends MultiBlockWithUpdatable<BigIntegerBufferLogic<MetaTileEntityEnergyContainmentField>>
            implements IMetaTileEntityChangeableBattery<MetaTileEntityEnergyContainmentField> {

    BigIntegerBufferLogic<MetaTileEntityEnergyContainmentField> logic = new BigIntegerBufferLogic<>(this);

    public MetaTileEntityEnergyContainmentField(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    protected void updateFormedValid() {
        if (!getWorld().isRemote){
            logic.update();
        }
    }
    @Override
    public void update() {
        super.update();
    }

    @Override
    public BigIntegerBufferLogic<MetaTileEntityEnergyContainmentField> getLogic() {
        return logic;
    }

    @Override
    public boolean isActive() {
        return super.isActive() && logic.isWorkingEnabled();
    }

    @SuppressWarnings("SpellCheckingInspection")
    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("   F   ", "  FEF  ", " FEGEF ", "FEGGGEF", " FEGEF ", "  FEF  ", "   F   ")
                .aisle("  FEF  ", " FBBBF ", "FBBBBBF", "EBBBBBE", "FBBBBBF", " FBBBF ", "  FEF  ")
                .aisle(" FEGEF ", "FBBBBBF", "EBBBBBE", "GBBBBBG", "EBBBBBE", "FBBBBBF", " FEGEF ")
                .aisle("FEGGGEF", "EBBBBBE", "GBBBBBG", "GBBBBBG", "GBBBBBG", "EBBBBBE", "FEGGGEF")
                .aisle(" FEGEF ", "FBBBBBF", "EBBBBBE", "GBBBBBG", "EBBBBBE", "FBBBBBF", " FEGEF ")
                .aisle("  FEF  ", " FBBBF ", "FBBBBBF", "EBBBBBE", "FBBBBBF", " FBBBF ", "  FEF  ")
                .aisle("   F   ", "  FEF  ", " FEGEF ", "FEGSGEF", " FEGEF ", "  FEF  ", "   F   ")
                .where('S', selfPredicate())
                .where('F', states(getCasingState()))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY).setPreviewCount(56)
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY).setPreviewCount(56))
                        .or(glass()))
                .where('B', Battery())
                .where('G', glass())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitCasing);
    }

    private static TraceabilityPredicate Battery() {
        return states(GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitEmpty))
                .or(states(GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitEV)))
                .or(states(GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitIV)))
                .or(states(GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitLuV)))
                .or(states(GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitZPM)))
                .or(states(GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitUV)))
                .or(states(GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitUHV)))
                .or(states(GTNEMetaBlock.ENERGY_CONTAINMENT_UNIT.getState(EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitUEV)))
                );
    }

    private static TraceabilityPredicate glass() {
        return states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS))
                .or(states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS)))
                .or(states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.CLEANROOM_GLASS)))
                .or(states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS)))
                .or(states(GTNEMetaBlock.GTNE_GLASSES.getState(GTNEGlasses.GTNEGlassType.BorosilicateGlassEV)))
                .or(states(GTNEMetaBlock.GTNE_GLASSES.getState(GTNEGlasses.GTNEGlassType.BorosilicateGlassIV)))
                .or(states(GTNEMetaBlock.GTNE_GLASSES.getState(GTNEGlasses.GTNEGlassType.BorosilicateGlassLuV)))
                .or(states(GTNEMetaBlock.GTNE_GLASSES.getState(GTNEGlasses.GTNEGlassType.BorosilicateGlassZPM)))
                .or(states(GTNEMetaBlock.GTNE_GLASSES.getState(GTNEGlasses.GTNEGlassType.BorosilicateGlassUV)))
                .or(states(GTNEMetaBlock.GTNE_GLASSES.getState(GTNEGlasses.GTNEGlassType.BorosilicateGlassUHV)))
                .or(blocks(Blocks.GLASS))
                .or(blocks(Blocks.STAINED_GLASS));
    }

    @Override
    public void checkStructurePattern() {
        if (!this.isStructureFormed()) {
            World world = this.getWorld();
            if (!(world instanceof DummyWorld)) {
                int minGlassTier = 8;
                int maxCapacitorTier = 0;
                int emptyCount = 0;
                int capacitorCount = 0;

                for (BlockPos pos : getAllGlassAndCapacitor()) {
                    IBlockState state = world.getBlockState(pos);
                    if (EnergyContainmentUnit.isEnergyContainmentUnit(state)) {
                        EnergyContainmentUnit.EnergyContainmentUnitType type = EnergyContainmentUnit.getType(state);
                        if (type == EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitEmpty) emptyCount++;
                        if (type != EnergyContainmentUnit.EnergyContainmentUnitType.EnergyContainmentUnitCasing) capacitorCount++;
                        maxCapacitorTier = Math.max(maxCapacitorTier, type.ordinal()+2);
                    }
                    if (isGlass(state)) {
                        minGlassTier = Math.min(minGlassTier, getGlassTier(state));
                    }
                }
                if ((float)emptyCount / (float) capacitorCount > 0.5F || (maxCapacitorTier > (minGlassTier + 1))) {
                    this.invalidateStructure();
                    return;
                }
            }
        }
        super.checkStructurePattern();
    }

    public static boolean isGlass (IBlockState state) {
        return state.getBlock() == MetaBlocks.TRANSPARENT_CASING;
    }

    public static int getGlassTier(IBlockState state) {
        return ITiredGlasses.getGlassTier(state);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        textList.add(new TextComponentTranslation("gtne.multi.e-c-f.stored", getLogic().getStored().toString()));
        textList.add(new TextComponentTranslation("gtne.multi.e-c-f.capacity", getCapacity().toString()));
        textList.add(new TextComponentTranslation("gtne.multi.e-c-f.passive_loss", getPassiveLoss()));
        textList.add(new TextComponentTranslation("gtne.multi.active_transformer.percent",
                getCapacity().equals(BigInteger.ZERO) ? 0 : new BigDecimal(getLogic().getStored()).divide(new BigDecimal(getCapacity()),6, RoundingMode.HALF_DOWN).floatValue()*100f));
        textList.add(new TextComponentTranslation("gtne.multi.active_transformer.current.input", getLogic().getLastInput() / 20));
        textList.add(new TextComponentTranslation("gtne.multi.active_transformer.current.output", getLogic().getLastOutput() / 20));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, @NotNull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("gtne.multi.e-c-f.tooltip1"));

        if (TooltipHelper.isShiftDown()) {
            tooltip.add(I18n.format("gtne.multi.e-c-f.press_shift.tooltip1"));
            tooltip.add(I18n.format("gtne.multi.e-c-f.press_shift.tooltip2"));
            tooltip.add(I18n.format("gtne.multi.e-c-f.press_shift.tooltip3"));
        } else {
            tooltip.add(I18n.format("gtne.multi.e-c-f.press_shift"));
        }
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTNETextures.EnergyContainmentUnitCasing;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTNETextures.ECF_Overlay;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), isActive(), this.logic.isWorkingEnabled());
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityEnergyContainmentField(metaTileEntityId);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE)
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        return super.getCapability(capability, side);
    }

    @Override
    public BigInteger getCapacity() {
        return logic.getCapacity();
    }

    @Override
    public long getPassiveLoss() {
        return logic.getPassiveLoss();
    }

    @Override
    public BigInteger updateCapacity() {
        World world = this.getWorld();
        BigInteger result = BigInteger.ZERO;
        for (BlockPos pos : getAllCapacitors()) {
            result = result.add(BigInteger.valueOf(EnergyContainmentUnit.getCapacity(world.getBlockState(pos))));
        }
        return result;
    }

    @Override
    public long updatePassiveLoss() {
        World world = this.getWorld();
        long result = 0;
        for (BlockPos pos : getAllCapacitors()) {
            result = result + EnergyContainmentUnit.getPassiveLoss(world.getBlockState(pos));
        }
        return result;
    }

    private Iterable<BlockPos.MutableBlockPos> getAllCapacitors() {
        World world = this.getWorld();
        BlockPos pos = this.getPos();
        EnumFacing facing = this.getFrontFacing().getOpposite();
        BlockPos startPos = pos.offset(facing, 1).offset(GTNEUtil.getCounterClockWise(facing)).offset(EnumFacing.UP, 2);
        BlockPos.MutableBlockPos searchPos = new BlockPos.MutableBlockPos(startPos);
        int height = 0;
        while (height <= 50) {
            if (EnergyContainmentUnit.isEnergyContainmentUnit(world.getBlockState(searchPos))) {
                height++;
                searchPos = searchPos.move(EnumFacing.UP);
                continue;
            }
            break;
        }
        BlockPos endPos = searchPos.move(facing, 2).move(GTNEUtil.getClockWise(facing), 2).offset(EnumFacing.UP, 2).toImmutable();
        return BlockPos.getAllInBoxMutable(searchPos, endPos);
    }

    private Iterable<BlockPos.MutableBlockPos> getAllGlassAndCapacitor(){
        World world = this.getWorld();
        BlockPos pos = this.getPos();
        EnumFacing facing = this.getFrontFacing().getOpposite();
        BlockPos startPos = pos.offset(facing,1).offset(GTNEUtil.getCounterClockWise(facing)).offset(EnumFacing.UP,2);
        BlockPos.MutableBlockPos searchPos = new BlockPos.MutableBlockPos(startPos);
        startPos = pos.offset(GTNEUtil.getClockWise(facing),2).offset(EnumFacing.UP,2);
        int height = 0;
        while (height <= 50){
            if(EnergyContainmentUnit.isEnergyContainmentUnit(world.getBlockState(searchPos))){
                height++;
                searchPos = searchPos.move(EnumFacing.UP);
                continue;
            }
            break;
        }
        BlockPos endPos = searchPos.move(facing,3).move(GTNEUtil.getCounterClockWise(facing),3).toImmutable();
        return BlockPos.getAllInBoxMutable(startPos,endPos);
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

}
