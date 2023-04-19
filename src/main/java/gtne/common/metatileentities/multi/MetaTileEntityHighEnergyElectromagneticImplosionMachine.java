package gtne.common.metatileentities.multi;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockCompressed;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gtne.common.Block.GTNEBlockMetalCasing;
import gtne.common.Block.GTNEMetaBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import static gtne.api.recipes.GTNERecipeMaps.*;

public class MetaTileEntityHighEnergyElectromagneticImplosionMachine extends RecipeMapMultiblockController {

    public MetaTileEntityHighEnergyElectromagneticImplosionMachine(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, HighEnergyElectromagneticImplosionMachine);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityHighEnergyElectromagneticImplosionMachine(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEE", "CCC", "CCC", "BBB", "BBB", "BBB", "CCC", "CCC", "DFG")
                .aisle("FFF", "CMC", "CMC", "BBB", "BBB", "BBB", "CMC", "CMC", "DLG")
                .aisle("AZV", "CCC", "CSC", "BBB", "BBB", "BBB", "CCC", "CCC", "DFG")
                .where('S', selfPredicate())
                .where('F', states(getCasingState()))
                .where('Z', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('M', states(materialBlockState(Materials.SamariumMagnetic)))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('A', abilities(MultiblockAbility.IMPORT_ITEMS))
                .where('V', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where('D', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('G', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .where('B', states(materialBlockState(Materials.Tritanium)))
                .where('C', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.ELECTRO_MAGNETIC_IMPLOSION_COIL)))
                .where('L', abilities(MultiblockAbility.MUFFLER_HATCH))
                .build();

    }

    private IBlockState materialBlockState(Material material) {
        BlockCompressed block = MetaBlocks.COMPRESSED.get(material);
        if (block == null)
            return Blocks.AIR.getDefaultState();
        return block.getBlock(material);
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

}
