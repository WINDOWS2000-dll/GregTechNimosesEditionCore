package gtne.api.unification.material;

import gregtech.api.unification.material.Materials;

import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GTNEMaterialFlags {

    public static void init() {

        // Iron
        Materials.Iron.addFlags(GENERATE_DOUBLE_PLATE);

        Materials.HSSG.addFlags(GENERATE_ROTOR);

        Materials.Naquadah.addFlags(GENERATE_GEAR, GENERATE_SMALL_GEAR);

    }

}
