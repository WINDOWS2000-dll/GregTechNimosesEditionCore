package gtne.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.fluids.fluidType.FluidTypes;
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
import static gregtech.api.util.GTUtility.gregtechId;

public class GTNEChemical {

    //24601 ~ 24700

    public static void init() {

        //₀₁₂₃₄₅₆₇₈₉

        //Ammonium Chloride
        AMMONIUM_CHLORIDE = new Material.Builder(24601, gregtechId("ammonium_chloride"))
                .fluid(FluidTypes.LIQUID, false)
                .color(0xd8d9cc)
                .fluidTemp(300)
                .build();

        //Potassium Disulfate
        POTASSIUM_DISULFATE = new Material.Builder(24602, gregtechId("potassium_disulfate"))
                .fluid(FluidTypes.LIQUID, false)
                .dust()
                .color(0x787446)
                .fluidTemp(1123)
                .build();
        POTASSIUM_DISULFATE.setFormula("K2S2O7", true);
        //Sodium Nitrate
        SODIUM_NITRATE = new Material.Builder(24603, gregtechId("sodium_nitrate"))
                .dust()
                .color(0x4c577d)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        SODIUM_NITRATE.setFormula("NaNO3", true);
        //Formic Acid
        FORMIC_ACID = new Material.Builder(24604, gregtechId("formic_acid"))
                .fluid(FluidTypes.LIQUID, false)
                .color(0xbf9341)
                .fluidTemp(300)
                .build();
        FORMIC_ACID.setFormula("CH2O2", true);
        //Sodium Formate
        SODIUM_FORMATE = new Material.Builder(24605, gregtechId("sodium_formate"))
                .fluid(FluidTypes.LIQUID, false)
                .color(0xbf9341)
                .fluidTemp(300)
                .build();
        //Silicon tetrachloride
        SILICON_TETRACHLORIDE = new Material.Builder(24606, gregtechId("silicon_tetrachloride"))
                .fluid(FluidTypes.LIQUID, false)
                .color(0xffffff)
                .fluidTemp(204)
                .build();

    }
}
