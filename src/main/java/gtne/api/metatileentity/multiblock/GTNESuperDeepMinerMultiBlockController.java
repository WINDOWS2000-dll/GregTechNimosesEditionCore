package gtne.api.metatileentity.multiblock;

import gregicality.multiblocks.api.capability.impl.GCYMMultiblockRecipeLogic;
import gregicality.multiblocks.api.metatileentity.GCYMMultiblockAbility;
import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMap;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public abstract class GTNESuperDeepMinerMultiBlockController extends GCYMRecipeMapMultiblockController {

    private boolean isParallel;

    public GTNESuperDeepMinerMultiBlockController(ResourceLocation metaTileEntity, RecipeMap<?> recipeMap, boolean isParallel) {
        this(metaTileEntity, new RecipeMap<?>[]{recipeMap}, isParallel);
    }

    public GTNESuperDeepMinerMultiBlockController(ResourceLocation metaTileEntity, RecipeMap<?>[] recipeMaps, boolean isParallel) {
        super(metaTileEntity, recipeMaps);
        this.recipeMapWorkable = new GCYMMultiblockRecipeLogic(this);
        this.isParallel = isParallel;
    }

    @Override
    public boolean isTiered() {
        return true;
    }

    @Override
    public boolean isParallel() {
        return this.isParallel;
    }

    public static @NotNull TraceabilityPredicate tieredCasing() {
        return new TraceabilityPredicate(abilities(GCYMMultiblockAbility.TIERED_HATCH));
    }

}
