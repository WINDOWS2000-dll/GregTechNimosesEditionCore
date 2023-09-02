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
import static gregtech.api.util.GTUtility.gregtechId;
import static gtne.api.unification.material.GTNEElements.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GTNEPlatLineMaterial {

    //24501 ~ 24600
    //₀₁₂₃₄₅₆₇₈₉

    public static void init() {
        //Platinum Metallic Powder
        PLATINUM_METALLIC_POWDER = new Material.Builder(24501, gregtechId("platinum_metallic_powder"))
                .dust()
                .color(0xb4b582)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        PLATINUM_METALLIC_POWDER.setFormula("???PtPdIrOsRhRu???");
        //Platinum Concentrate
        PLATINUM_CONCENTRATE = new Material.Builder(24502, gregtechId("platinum_concentrate"))
                .fluid()
                .color(0xb4b582)
                .fluidTemp(300)
                .build();
        //Platinum Salt Dust
        PLATINUM_SALT = new Material.Builder(24503, gregtechId("platinum_salt"))
                .dust()
                .color(0xa2a683)
                .iconSet(MaterialIconSet.DULL)
                .build();
        //Reprecipitated Platinum
        REPRECIPITATED_PLATINUM = new Material.Builder(24504, gregtechId("reprecipitated_platinum"))
                .dust()
                .color(0xb4b582)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        //Refined Platinum Salt
        REFINED_PLATINUM_SALT = new Material.Builder(24505, gregtechId("refined_platinum_dust"))
                .dust()
                .color(0xb4b582)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        //Platinum Residue
        PLATINUM_RESIDUE = new Material.Builder(24506, gregtechId("platinum_residue"))
                .dust()
                .color(0x55592b)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        PLATINUM_RESIDUE.setFormula("??IrOsRhRu??");
        //Palladium Enriched Ammonia
        PALLADIUM_ENRICHED_AMMONIA = new Material.Builder(24507, gregtechId("palladium_enriched_ammonia"))
                .fluid()
                .color(0x3d3636)
                .fluidTemp(300)
                .build();
        PALLADIUM_ENRICHED_AMMONIA.setFormula("?Pd");
        //Leach Residue
        LEACH_RESIDUE = new Material.Builder(24508, gregtechId("leach_residue"))
                .dust()
                .color(0x4a4729)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        LEACH_RESIDUE.setFormula("??IrOsRu??");
        //Rhodium Sulfate
        RHODIUM_SULFATE = new Material.Builder(24509, gregtechId("rhodium_sulfate"))
                .fluid()
                .color(0x66612e)
                .fluidTemp(300)
                .build();
        //Sodium Ruthenate
        SODIUM_RUTHENATE = new Material.Builder(24510, gregtechId("sodium_ruthenate"))
                .dust()
                .color(0x222fbd)
                .iconSet(MaterialIconSet.SHINY)
                .build();
        SODIUM_RUTHENATE.setFormula("Na₂RuO₃");
        //Rarest Metal Residue
        RAREST_METAL_RESIDUE = new Material.Builder(24511, gregtechId("rarest_metal_residue"))
                .dust()
                .color(0x4a4729)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        RAREST_METAL_RESIDUE.setFormula("??OsIr??");
        //Iridium Metal Residue
        IRIDIUM_METAL_RESIDUE = new Material.Builder(24512, gregtechId("iridium_metal_residue"))
                .dust()
                .color(0x4a4729)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        IRIDIUM_METAL_RESIDUE.setFormula("??Ir??");
        //Acidic Osmium Solution
        ACIDIC_OSMIUM_SOLUTION = new Material.Builder(24513, gregtechId("acidic_osmium_solution"))
                .fluid()
                .color(0x4a4729)
                .fluidTemp(300)
                .build();
        ACIDIC_OSMIUM_SOLUTION.setFormula("???");
        //Sludge Dust Residue
        SLUDGE_DUST_RESIDUE = new Material.Builder(24514, gregtechId("sludge_dust_residue"))
                .dust()
                .color(0x4a4729)
                .iconSet(MaterialIconSet.DULL)
                .build();
        SLUDGE_DUST_RESIDUE.setFormula("(SiO₂)₃Au₂");
        //Iridium Dioxide
        IRIDIUM_DIOXIDE = new Material.Builder(24515, gregtechId("iridium_dioxide"))
                .dust()
                .color(0x4a4729)
                .iconSet(MaterialIconSet.DULL)
                .build();
        IRIDIUM_DIOXIDE.setFormula("IrO₂");
        //Acidic Iridium Solution
        ACIDIC_IRIDIUM_SOLUTION = new Material.Builder(24516, gregtechId("acidic_iridium_solution"))
                .fluid()
                .color(0x4a4729)
                .build();
        ACIDIC_IRIDIUM_SOLUTION.setFormula("???");
        //Iridium Chloride
        IRIDIUM_CHLORIDE = new Material.Builder(24517, gregtechId("iridium_chloride"))
                .dust()
                .color(0x4a4729)
                .iconSet(MaterialIconSet.DULL)
                .build();
        IRIDIUM_CHLORIDE.setFormula("IrCl₃");
        //Metallic Sludge Dust Residue
        METALLIC_SLUDGE_DUST_RESIDUE = new Material.Builder(24518, gregtechId("metallic_sludge_dust_residue"))
                .dust()
                .color(0x4a4729)
                .iconSet(MaterialIconSet.DULL)
                .build();
        METALLIC_SLUDGE_DUST_RESIDUE.setFormula("NiCu");
        //Osmium Solution
        OSMIUM_SOLUTION = new Material.Builder(24519, gregtechId("osmium_solution"))
                .fluid()
                .color(0x4a4729)
                .fluidTemp(300)
                .build();
        OSMIUM_SOLUTION.setFormula("???");
        //Rhodium Sulfate Solution
        RHODIUM_SULFATE_SOLUTION = new Material.Builder(24520, gregtechId("rhodium_sulfate_solution"))
                .fluid()
                .color(0x66612e)
                .fluidTemp(300)
                .build();
        //Zinc Sulfate
        ZINC_SULFATE = new Material.Builder(24521, gregtechId("zinc_sulfate"))
                .dust()
                .color(0x5c4d2b)
                .iconSet(MaterialIconSet.DULL)
                .build();
        ZINC_SULFATE.setFormula("ZnSO₄");
        //Crude Rhodium Metal
        CRUDE_RHODIUM_METAL = new Material.Builder(24522, gregtechId("crude_rhodium_metal"))
                .dust()
                .color(0x302f2b)
                .iconSet(MaterialIconSet.DULL)
                .build();
        CRUDE_RHODIUM_METAL.setFormula("??Rh??");
        //Rhodium Salt
        RHODIUM_SALT = new Material.Builder(24523, gregtechId("rhodium_salt"))
                .dust()
                .color(0x85847f)
                .iconSet(MaterialIconSet.SHINY)
                .build();
        //Rhodium Salt Solution
        RHODIUM_SALT_SOLUTION = new Material.Builder(24524, gregtechId("rhodium_salt_solution"))
                .fluid()
                .color(0x85847f)
                .fluidTemp(300)
                .build();
        //Rhodium Nitrate
        RHODIUM_NITRATE = new Material.Builder(24525, gregtechId("rhodium_nitrate"))
                .dust()
                .color(0x5c4d2b)
                .iconSet(MaterialIconSet.DULL)
                .build();
        //Rhodium Filter Cake
        RHODIUM_FILTER_CAKE = new Material.Builder(24526, gregtechId("rhodium_filter_cake"))
                .dust()
                .color(0x5c4d2b)
                .iconSet(MaterialIconSet.DULL)
                .build();
        //Rhodium Filter Cake Solution
        RHODIUM_FILTER_CAKE_SOLUTION = new Material.Builder(24527, gregtechId("rhodium_filter_cake_solution"))
                .fluid()
                .color(0x85847f)
                .fluidTemp(300)
                .build();
        //Reprecipitated Rhodium
        REPRECIPITATED_RHODIUM = new Material.Builder(24528, gregtechId("reprecipitated_rhodium"))
                .dust()
                .color(0x5c4d2b)
                .iconSet(MaterialIconSet.DULL)
                .build();
        REPRECIPITATED_RHODIUM.setFormula("Rh₂NH₄");
        //Ruthenium Tetroxide Solution
        RUTHENIUM_TETROXIDE_SOLUTION = new Material.Builder(24529, gregtechId("ruthenium_tetroxide_solution"))
                .fluid()
                .color(0xffffff)
                .fluidTemp(300)
                .build();
        RUTHENIUM_TETROXIDE_SOLUTION.setFormula("???");
        //Hot Ruthenium Tetroxide Solution
        HOT_RUTHENIUM_TETROXIDE_SOLUTION = new Material.Builder(24530, gregtechId("hot_ruthenium_tetroxide_solution"))
                .fluid()
                .color(0xffffff)
                .fluidTemp(300)
                .build();
        HOT_RUTHENIUM_TETROXIDE_SOLUTION.setFormula("???");
        //Ruthenium Tetroxide
        RUTHENIUM_TETROXIDE = new Material.Builder(24531, gregtechId("ruthenium_tetroxide"))
                .fluid()
                .dust()
                .color(0xffffff)
                .fluidTemp(300)
                .build();
        //Palladium Metallic Powder
        PALLADIUM_METALLIC_POWDER = new Material.Builder(24532, gregtechId("palladium_metallic_powder"))
                .dust()
                .color(0x3d3636)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        //Palladium Salt
        PALLADIUM_SALT = new Material.Builder(24533, gregtechId("palladium_salt"))
                .dust()
                .color(0x3d3636)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        //Reprecipitated Palladium
        REPRECIPITATED_PALLADIUM = new Material.Builder(24534, gregtechId("reprecipitated_palladium"))
                .dust()
                .color(0x3d3636)
                .iconSet(MaterialIconSet.METALLIC)
                .build();



    }
}
