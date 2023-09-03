package gtne.common.metatileentities.multi;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiFluidHatch;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.Block.GTNEBlockMetalCasing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import gtne.common.Block.GTNEMetaBlock;
import gtne.client.GTNETextures;
import net.minecraft.util.math.BlockPos;
import scala.tools.cmd.Meta;

import javax.annotation.Nonnull;
import java.util.function.Function;

public class MetaTileEntityAdvancedPrecisionAssemblyLine extends RecipeMapMultiblockController {

    public MetaTileEntityAdvancedPrecisionAssemblyLine(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTNERecipeMaps.ADVANCED_PRECISION_ASSEMBLY_LINE_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityAdvancedPrecisionAssemblyLine(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("FFFFFFFFF", "F  R R  F", "F  R R  F", "F  FOF  F", "F       F", "F       F", "FF     FF", " FFFFFFF ", "   FFF   ", "         ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFFFFL ", "         ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FEF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "F  R R  F", "F  FFF  F", "FC     CF", "FC     CF", "FC     CF", "F       F", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FEF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "F  R R  F", "F  FFF  F", "FC     CF", "FC     CF", "FC     CF", "F       F", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FEF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "F  R R  F", "F  FFF  F", "FC     CF", "FC     CF", "FC     CF", "F       F", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FEF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "F  R R  F", "F  FFF  F", "FC     CF", "FC     CF", "FC     CF", "F       F", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FEF   ")
                .aisle("VFFFIFFFF", "GF R R FG", "GF FFF FG", "GFA   AFG", "GFA   AFG", "GF  A  FG", "GFF C FFG", "L FFFFF L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFIFFFF", "GPPPPPPPG", "GP FFF PG", "GPB   BPG", "GP     PG", "GP  A  PG", "GPP C PPG", "L PPAPP L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFD ", "   FFF   ")
                .aisle("FFFFFFFFF", "F  R R  F", "F  FFF  F", "FC     CF", "FC     CF", "FC     CF", "F       F", "L       L", " LFFCFFD ", "   FFF   ")
                .aisle("FFFFFFFFF", "F       F", "F  FFF  F", "F       F", "F       F", "F       F", "F       F", "L       L", " LFFCFFD ", "   FFF   ")
                .aisle("FFFFFFFFF", "F  R R  F", "F  R R  F", "F  FFF  F", "F       F", "F       F", "FF FMF FF", " FFFSFFF ", "   FFF   ", "         ")
                .where('S', selfPredicate())
                .where('F', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINECASING)))
                .where('G', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.CLEANROOM_GLASS)))
                .where('R', states(MetaBlocks.FRAMES.get(Materials.TungstenCarbide).getBlock(Materials.TungstenCarbide)))
                .where('A', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState((GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINE))))
                .where('B', states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ASSEMBLY_LINE_CASING)))
                .where('C', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINECONTROL)))
                .where('L', states(getGrateState()))
                .where('I', metaTileEntities(MetaTileEntities.ITEM_IMPORT_BUS[0]))
                .where('V', fluidInputPredicate())
                .where('D', dataHatchPredicate())
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('O', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where('M', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('P', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE)))
                .where(' ', any())
                .build();
    }

    @Nonnull
    protected static IBlockState getGrateState() {
        return GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINEFILTER);
    }

    @Nonnull
    protected static TraceabilityPredicate fluidInputPredicate() {
        if (ConfigHolder.machines.orderedFluidAssembly) {
            return metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.IMPORT_FLUIDS).stream()
                    .filter(mte -> !(mte instanceof MetaTileEntityMultiFluidHatch))
                    .toArray(MetaTileEntity[]::new))
                    .setMinGlobalLimited(10)
                    .setMaxGlobalLimited(10);
        }
        return abilities(MultiblockAbility.IMPORT_FLUIDS);
    }

    @Nonnull
    protected static TraceabilityPredicate dataHatchPredicate() {
        if (ConfigHolder.machines.enableResearch) {
            return abilities(MultiblockAbility.DATA_ACCESS_HATCH, MultiblockAbility.OPTICAL_DATA_RECEPTION)
                    .setExactLimit(1)
                    .or(states(getGrateState()));
        }
        return states(getGrateState());
    }

    @Override
    protected Function<BlockPos, Integer> multiblockPartSorter() {
        return switch (getFrontFacing()) {
            case NORTH -> pos -> -pos.getX();
            case SOUTH -> BlockPos::getX;
            case EAST -> pos ->-pos.getZ();
            case WEST -> BlockPos::getZ;
            default -> BlockPos::hashCode;
        };
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GTNETextures.ADVANCEDPRECISIONASSEMBLYLINECASING;
    }

    protected IBlockState getCasingState() {
        return GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINECASING);
    }
}
