package gtne.common.metatileentities.multi;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.metatileentities.MetaTileEntities;
import gtne.api.GTNEAPI;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.client.GTNETextures;
import gtne.common.Block.ComputerMachineCasing;
import gtne.common.GTNEMetaBlock;
import gtne.common.metatileentities.GTNEMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static gtne.api.metatileentities.multiblocks.GTNEMultiBlockControllerBase.computercasing;
import static gtne.api.recipes.GTNERecipeMaps.ProtTypeSuperComputer;

public class MetaTileEntityProtoTypeSuperComputer extends RecipeMapMultiblockController {

    public MetaTileEntityProtoTypeSuperComputer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, ProtTypeSuperComputer);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityProtoTypeSuperComputer(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("VVV", "FFF", "FFF", "FFF", "FFF", "FFF")
                .aisle("FFF", "FEF", "FEI", "FEF", "FEF", "FFF")
                .aisle("FFB", "FHF", "FHF", "FHF", "FHF", "FHF")
                .aisle("DFF", "DFF", "FFF", "FFF", "FFF", "FFF")
                .aisle("FFF", "FHF", "FHF", "FHF", "FHF", "FHF")
                .aisle("CFA", "CEF", "FEI", "FEF", "FEF", "FFF")
                .aisle("FMF", "FSF", "FFF", "FFF", "FFF", "FFF")
                .where('S', selfPredicate())
                .where('M', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('I', metaTileEntities(MetaTileEntities.ITEM_IMPORT_BUS[0]))
                .where('V', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('A', metaTileEntities(MetaTileEntities.ITEM_IMPORT_BUS[2]))
                .where('B', metaTileEntities(MetaTileEntities.ITEM_EXPORT_BUS[0]))
                .where('C', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('D', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .where('E', computercasing())
                .where('H', states(getCasingState2()))
                .where('F', states(GTNEMetaBlock.COMPUTER_MACHINE_CASING.getState(ComputerMachineCasing.ComputerMachineCasingType.PROTOTYPESUPERCOMPUTERMACHINECASING)))
                .build();

    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("VVV", "FFF", "FFF", "FFF", "FFF", "FFF")
                .aisle("FFF", "FEF", "FEI", "FEF", "FEF", "FFF")
                .aisle("FFB", "FHF", "FHF", "FHF", "FHF", "FHF")
                .aisle("DFF", "DFF", "FFF", "FFF", "FFF", "FFF")
                .aisle("FFF", "FHF", "FHF", "FHF", "FHF", "FHF")
                .aisle("CFA", "CEF", "FEI", "FEF", "FEF", "FFF")
                .aisle("FMF", "FSF", "FFF", "FFF", "FFF", "FFF")
                .where('S', GTNEMetaTileEntities.ProtoTypeSuperComputer, EnumFacing.SOUTH)
                .where('M', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.SOUTH)
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.ULV], EnumFacing.EAST)
                .where('V', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.IV], EnumFacing.NORTH)
                .where('A', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.MV], EnumFacing.EAST)
                .where('B', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.ULV], EnumFacing.EAST)
                .where('C', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.IV], EnumFacing.WEST)
                .where('D', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.IV], EnumFacing.WEST)
                .where('H', getCasingState2())
                .where('F', getCasingState());

        GTNEAPI.COMPUTER_CASING.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                .forEach(entry -> shapeInfo.add(builder.where('E', entry.getKey()).build()));
        return shapeInfo;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GTNETextures.PROTOTYPESUPERCOMPUTERMACHINECASING;
    }

    private static IBlockState getCasingState() {
        return GTNEMetaBlock.COMPUTER_MACHINE_CASING.getState(ComputerMachineCasing.ComputerMachineCasingType.PROTOTYPESUPERCOMPUTERMACHINECASING);
    }

    private static IBlockState getCasingState2() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }
}
