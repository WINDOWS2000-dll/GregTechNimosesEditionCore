package gtne.api.unification.material;

import gregtech.api.unification.material.Materials;

import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_DOUBLE_PLATE;

public class GTNEMaterialFlags {

    public static void init() {

        // Iron
        Materials.Iron.addFlags(GENERATE_DOUBLE_PLATE);

    }

}
