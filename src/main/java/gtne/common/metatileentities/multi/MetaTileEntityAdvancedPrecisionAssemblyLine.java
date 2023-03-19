package gtne.common.metatileentities.multi;

import codechicken.lib.vec.Vector3;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.client.particle.GTLaserBeamParticle;
import gregtech.client.particle.GTParticleManager;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.GTNEBlockMetalCasing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gtne.api.recipes.machine.RecipeMapAdvancedPrecisionAssemblyLine;
import gtne.common.GTNEMetaBlock;
import gtne.client.GTNETextures;
import gregtech.api.unification.material.Material;
import gtne.api.recipes.*;

import static gregtech.api.util.RelativeDirection.*;

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
                .aisle("FFFFFFFFF", "G       G", "G  FFF  G", "G       G", "G       G", "G       G", "G       G", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "F  R R  F", "F  FFF  F", "FC     CF", "FC     CF", "FC     CF", "F       F", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "F       F", "F  FFF  F", "F       F", "F       F", "F       F", "F       F", "L       L", " LFFCFFL ", "   FFF   ")
                .aisle("FFFFFFFFF", "F  R R  F", "F  R R  F", "F  FFF  F", "F       F", "F       F", "FF FMF FF", " FFFSFFF ", "   FFF   ", "         ")
                .where('S', selfPredicate())
                .where('F', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINECASING)))
                .where('G', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.CLEANROOM_GLASS)))
                .where('R', states(MetaBlocks.FRAMES.get(Materials.TungstenCarbide).getBlock(Materials.TungstenCarbide)))
                .where('A', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState((GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINE))))
                .where('B', states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ASSEMBLY_LINE_CASING)))
                .where('C', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINECONTROL)))
                .where('L', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINEFILTER)))
                .where('I', metaTileEntities(MetaTileEntities.ITEM_IMPORT_BUS[0]))
                .where('V', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('O', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where('M', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('P', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE)))
                .where(' ', any())
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GTNETextures.ADVANCEDPRECISIONASSEMBLYLINECASING;
    }

    protected IBlockState getCasingState() {
        return GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ADVANCEDPRECISIONASSEMBLYLINECASING);
    }
}
