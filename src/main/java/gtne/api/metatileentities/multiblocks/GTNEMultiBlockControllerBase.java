package gtne.api.metatileentities.multiblocks;

import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.pattern.TraceabilityPredicate;
import gtne.api.pattern.GTNETracebilityPredicate;
import net.minecraft.util.ResourceLocation;

public abstract class GTNEMultiBlockControllerBase extends MultiblockControllerBase {

    public GTNEMultiBlockControllerBase(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    public static GTNETracebilityPredicate computercasing() {
        return (GTNETracebilityPredicate) GTNETracebilityPredicate.COMPUTER_CASING.get();
    }

}
