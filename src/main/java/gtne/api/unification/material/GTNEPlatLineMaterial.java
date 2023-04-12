package gtne.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import gregtech.api.unification.material.properties.FluidProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.ToolProperty;

import static gregtech.api.GTValues.*;
import static gtne.api.unification.material.GTNEElements.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GTNEPlatLineMaterial {

    //24501 ~ 24600

    public static void init() {
        //Platinum Metallic Powder
        PLATINUM_METALLIC_POWDER = new Material.Builder(24501, "platinum_metallic_powder")
                .dust()
                .color(0xb4b582)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        PLATINUM_METALLIC_POWDER.setFormula("???PtPdIrOsRhRu???");
        //Platinum Concentrate
        PLATINUM_CONCENTRATE = new Material.Builder(24502, "platinum_concentrate")
                .fluid()
                .color(0xb4b582)
                .fluidTemp(300)
                .build();
        //Platinum Salt Dust
        PLATINUM_SALT = new Material.Builder(24503, "platinum_salt")
                .dust()
                .color(0xa2a683)
                .iconSet(MaterialIconSet.DULL)
                .build();
        //Reprecipitated Platinum
        REPRECIPITATED_PLATINUM = new Material.Builder(24504, "reprecipitated_platinum")
                .dust()
                .color(0xb4b582)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        //Refined Platinum Salt
        REFINED_PLATINUM_SALT = new Material.Builder(24505, "refined_platinum_dust")
                .dust()
                .color(0xb4b582)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        //Platinum Residue
        PLATINUM_RESIDUE = new Material.Builder(24506, "platinum_residue")
                .dust()
                .color(0x55592b)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        PLATINUM_RESIDUE.setFormula("??IrOsRhRu??");
        //Palladium Enriched Ammonia
        PALLADIUM_ENRICHED_AMMONIA = new Material.Builder(24507, "palladium_enriched_ammonia")
                .fluid()
                .color(0x3d3636)
                .fluidTemp(300)
                .build();
    }
}
