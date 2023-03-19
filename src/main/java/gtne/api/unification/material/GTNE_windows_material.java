package gtne.api.unification.material;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import gregtech.api.unification.material.properties.FluidProperty;
import gregtech.api.unification.material.properties.PropertyKey;

import static gregtech.api.GTValues.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GTNE_windows_material {
    public static void init() {
        HIGH_PURITY_SILICON = new Material.Builder(24001, "high_purity_silicon")
                .dust()
                .ingot()
                .color(0x2a2a2a)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .blastTemp(2400, GasTier.LOW)
                .build();
    }
}
