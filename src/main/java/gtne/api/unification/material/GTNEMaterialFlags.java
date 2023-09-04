package gtne.api.unification.material;

import gregtech.api.unification.material.Materials;

import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_DOUBLE_PLATE;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_ROTOR;

public class GTNEMaterialFlags {

    public static void init() {

        // Iron
        Materials.Iron.addFlags(GENERATE_DOUBLE_PLATE);

        Materials.HSSG.addFlags(GENERATE_ROTOR);

    }

}
