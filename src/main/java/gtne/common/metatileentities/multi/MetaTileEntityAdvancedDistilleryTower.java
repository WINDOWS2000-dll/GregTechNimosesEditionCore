package gtne.common.metatileentities.multi;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.core.sound.GTSoundEvents;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.Block.GTNEBlockMetalCasing;
import gtne.common.Block.GTNEMetaBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class MetaTileEntityAdvancedDistilleryTower extends RecipeMapMultiblockController {

    public MetaTileEntityAdvancedDistilleryTower(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTNERecipeMaps.ADVANCED_DISTILLATION_TOWER);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityAdvancedDistilleryTower(metaTileEntityId);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            FluidStack stackInTank = importFluids.drain(Integer.MAX_VALUE, false);
            if (stackInTank != null && stackInTank.amount > 0) {
                TextComponentTranslation fluidName = new TextComponentTranslation(stackInTank.getFluid().getUnlocalizedName(stackInTank));
                textList.add(new TextComponentTranslation("gregtech.multiblock.distillation_tower.distilling_fluid", fluidName));

            }
        }
        super.addDisplayText(textList);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()                                                                                                                                     /*return Point                                                                                                            End Point*/
                .aisle("  XXXEEEXXX       ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ")
                .aisle("  XFFFFFFFX       ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ")
                .aisle("XXXFXXXXXFXXX     ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ")
                .aisle("XFFFXXXXXFFFX     ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "    B   B         ")
                .aisle("XFXXXXXXXXXFX XXX ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B       ", "  BBBXXXBBB       ")
                .aisle("XFXXXXXXXXXFXXXXXX", "   X#####X    FFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   X#####X    FFFB", "  FX#####XF  BFFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   X#####X    FFFB", "  FX#####XF  BFFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   X#####X    FFFB", "  FX#####XF  BFFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   X#####X    FFFB", "  FX#####XF  BFFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   X#####X    FFFB", "  FX#####XF  BFFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   X#####X    FFFB", "  FX#####XF  BFFFB", "   XPPPPPX    FFFB", "   X#####X    FFFB", "   XPPPPPX    FFFB", "   X#####X    FFF ", "   X#####X    FFF ", "  FX#####XF   FFF ", "   XPPPPPX   FFFF ", "   X#####FFFFFFF  ", "   XPPPPPFFFFFF   ", "   X#####FFFFF    ", "   X#####X        ", "  FX#####XF       ", "    XFFFX         ")
                .aisle("XFXXXXXXXXXFPPPPXX", "   O#####X    FPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   X#####X    FPF ", "  FX#####XFBBBFPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   X#####X    FPF ", "  FX#####XFBBBFPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   X#####X    FPF ", "  FX#####XFBBBFPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   X#####X    FPF ", "  FX#####XFBBBFPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   X#####X    FPF ", "  FX#####XFBBBFPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   X#####X    FPF ", "  FX#####XFBBBFPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   XPPPPPX    FPF ", "   O#####X    FPF ", "   X#####X    FPF ", "  FX#####XF   FPF ", "   XPPPPPX   FFPF ", "   O#####FFFFFPF  ", "   XPPPPPPPPPPF   ", "   O#####FFFFF    ", "   X#####X        ", "  FX#####XF       ", "    XFFFX         ")
                .aisle("XFXXXXXXXXXXXXXXXX", "   X#####X    FFF ", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   X#####X    FFF ", "  FX#####XF  BFFFB", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   X#####X    FFF ", "  FX#####XF  BFFFB", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   X#####X    FFF ", "  FX#####XF  BFFFB", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   X#####X    FFF ", "  FX#####XF  BFFFB", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   X#####X    FFF ", "  FX#####XF  BFFFB", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   X#####X    FFF ", "  FX#####XF  BFFFB", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   XPPPPPX    FPF ", "   X#####X    FFF ", "   X#####X    FFF ", "  FX#####XF   FFF ", "   XPPPPPX   FFFF ", "   X#####FFFFFFF  ", "   XPPPPPFFFFFF   ", "   X#####FFFFF    ", "   X#####X        ", "  FX#####XF       ", "    XFFFX         ")
                .aisle("XFXXXXXXXXXFX XCX ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B  BBBBB", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B XPPPX B       ", "  B X###X B       ", "  B X###X B       ", "  B X###X B       ", "  BBBXXXBBB       ")
                .aisle("XFFFXXXXXFFFX     ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "     XXX          ", "   F XXX F        ", "    B   B         ")
                .aisle("XXXFXXXXXFXXX     ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    B   B         ", "    BFFFB         ", "    B   B         ")
                .aisle("  XFFFFFFFX       ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ")
                .aisle("  XXXISMXXX       ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ", "                  ")
                .where('S', selfPredicate())
                .where('X', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCED_DISTILLATION_TOWER_CASING)))
                .where('F', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCED_DISTILLATION_TOWER_BASE_CASING)))
                .where('P', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCED_DISTILLATION_TOWER_PIPE_CASING)))
                .where('B', states(MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel)))
                .where('I', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('O', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .where('M', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('C', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where(' ', any())
                .where('#', air())
                .build();
    }

    @Override
    protected boolean allowSameFluidFillForOutputs() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.DISTILLATION_TOWER_OVERLAY;
    }

    @Override
    public int getFluidOutputLimit() {
        return getOutputFluidInventory().getTanks();
    }

}
