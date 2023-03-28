package gtne.api.interfaces.block;

import gregtech.api.unification.material.Material;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface IComputerCasingBlockStats {

    @Nonnull
    String getName();

    int getOperationSpeed ();

    int getEnergyDiscount();

    int getLevel();

    int getTier();

    @Nullable
    Material getMaterial();
}
