package gtne.mixin;

import gregtech.api.metatileentity.multiblock.RecipeMapPrimitiveMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.multi.MetaTileEntityPrimitiveBlastFurnace;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;

import static gregtech.api.metatileentity.multiblock.MultiblockControllerBase.air;
import static gregtech.api.metatileentity.multiblock.MultiblockControllerBase.states;

@Mixin(MetaTileEntityPrimitiveBlastFurnace.class)
public abstract class MixinMetaTileEntityPrimitiveBlastFurnace extends RecipeMapPrimitiveMultiblockController {

    @Final
    @Shadow
    private static final TraceabilityPredicate SNOW_PREDICATE = new TraceabilityPredicate(
            bws -> GTUtility.isBlockSnow(bws.getBlockState()));


    private MixinMetaTileEntityPrimitiveBlastFurnace(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap) {
        super(metaTileEntityId, recipeMap);
    }


    /**
     * @author Windows2000.exe
     * @reason Delete PBF
     */
    @Overwrite
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "XXX", "XXX", "XXX")
                .aisle("XXX", "X&X", "X#X", "X#X")
                .aisle("XXX", "XYX", "XXX", "XXX")
                .where('X', states((IBlockState) Blocks.BEDROCK))
                .where('#', air())
                .where('&', air().or(SNOW_PREDICATE)) // this won't stay in the structure, and will be broken while
                // running
                .where('Y', selfPredicate())
                .build();
    }

}
