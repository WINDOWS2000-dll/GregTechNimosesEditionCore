package gtne.mixin;

import gregtech.api.metatileentity.multiblock.RecipeMapPrimitiveMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.common.metatileentities.multi.MetaTileEntityPrimitiveBlastFurnace;
import gtne.common.Block.GTNEBlockMetalCasing;
import gtne.common.Block.GTNEMetaBlock;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.*;

@Mixin(value = MetaTileEntityPrimitiveBlastFurnace.class, remap = false)
public abstract class MixinMetaTileEntityPrimitiveBlastFurnace extends RecipeMapPrimitiveMultiblockController {

    @Final
    @Shadow
    private static final TraceabilityPredicate SNOW_PREDICATE = new TraceabilityPredicate(
            bws -> GTUtility.isBlockSnow(bws.getBlockState()));

    private MixinMetaTileEntityPrimitiveBlastFurnace(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.PRIMITIVE_BLAST_FURNACE_RECIPES);
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
                .where('X', states(GTNEMetaBlock.GTNE_BLOCK_METAL_CASING.getState(GTNEBlockMetalCasing.MetalCasingType.GREG_BLOCK)))
                .where('#', air())
                .where('&', air().or(SNOW_PREDICATE)) // this won't stay in the structure, and will be broken while
                // running
                .where('Y', selfPredicate())
                .build();
    }

}
