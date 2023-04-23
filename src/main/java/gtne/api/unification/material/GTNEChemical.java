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

public class GTNEChemical {

    //24601 ~ 24700

    public static void init() {

        //₀₁₂₃₄₅₆₇₈₉

        //Ammonium Chloride
        AMMONIUM_CHLORIDE = new Material.Builder(24601, "ammonium_chloride")
                .fluid()
                .color(0xd8d9cc)
                .fluidTemp(300)
                .build();

        //Potassium Disulfate
        POTASSIUM_DISULFATE = new Material.Builder(24602, "potassium_disulfate")
                .fluid()
                .dust()
                .color(0x787446)
                .fluidTemp(1123)
                .build();
        POTASSIUM_DISULFATE.setFormula("K₂S₂O₇");
        //Sodium Nitrate
        SODIUM_NITRATE = new Material.Builder(24603, "sodium_nitrate")
                .dust()
                .color(0x4c577d)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        SODIUM_NITRATE.setFormula("NaNO₃");
        //Formic Acid
        FORMIC_ACID = new Material.Builder(24604, "formic_acid")
                .fluid()
                .color(0xbf9341)
                .fluidTemp(300)
                .build();
        FORMIC_ACID.setFormula("CH₂O₂");
        //Sodium Formate
        SODIUM_FORMATE = new Material.Builder(24605, "sodium_formate")
                .fluid()
                .color(0xbf9341)
                .fluidTemp(300)
                .build();
        //Silicon tetrachloride
        SILICON_TETRACHLORIDE = new Material.Builder(24606, "silicon_tetrachloride")
                .fluid()
                .color(0xffffff)
                .fluidTemp(204)
                .build();

    }
}
