package gtne.api.unification.material.info;

import gregtech.api.unification.material.info.MaterialIconSet;

import javax.annotation.Nonnull;

import static gregtech.api.unification.material.info.MaterialIconSet.DULL;

public class GTNEMaterialIconSet extends MaterialIconSet{

    public static final MaterialIconSet INFINITY = new MaterialIconSet("infinity", DULL, true);

    public GTNEMaterialIconSet(@Nonnull String name) {
        super(name);
    }
}
