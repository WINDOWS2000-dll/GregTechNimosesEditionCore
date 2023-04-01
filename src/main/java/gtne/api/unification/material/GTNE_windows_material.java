package gtne.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import gregtech.api.unification.material.properties.FluidProperty;
import gregtech.api.unification.material.properties.PropertyKey;

import static gregtech.api.GTValues.*;
import static gtne.api.unification.material.GTNEElements.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

/**
 * Material Registration.
 * <p>
 * All Material Builders should follow this general formatting:
 * <p>
 * material = new MaterialBuilder(id, name)
 * .ingot().fluid().ore()                <--- types
 * .color().iconSet()                    <--- appearance
 * .flags()                              <--- special generation
 * .element() / .components()            <--- composition
 * .toolStats()                          <---
 * .oreByProducts()                         | additional properties
 * ...                                   <---
 * .blastTemp()                          <--- blast temperature
 * .build();
 * <p>
 * Use defaults to your advantage! Some defaults:
 * - iconSet: DULL
 * - color: 0xFFFFFF
 */

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

        Draconium = new Material.Builder(24002, "draconium")
                .dust()
                .ingot()
                .plasma()
                .color(0x9b00ff)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME)
                .blastTemp(4700, GasTier.HIGH, 42000, 160)
                .toolStats(400F, 100F, 42000, 160)
                .cableProperties(8192L, 16, 16, false)
                .element(Dc)
                .build();

        Awakened_Draconium = new Material.Builder(24003, "draconium_awakned")
                .dust()
                .ingot()
                .plasma()
                .color(0xff5100)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME)
                .blastTemp(9999, GasTier.HIGHEST, 3200000, 4000)
                .toolStats(700F, 200F, 81920, 500)
                .cableProperties(GTValues.V[9], 32, 16, false)
                .element(DcX)
                .build();



    }
    /*

var draconiumawakened = MaterialBuilder(32008, "draconiumawakened")
    .fluid()
    .ingot()
    .plasma()
    .iconSet("SHINY")
    .flags(["generate_rod", "generate_gear", "generate_long_rod", "generate_bolt_screw", "generate_ring", "generate_spring", "generate_spring_small", "generate_small_gear", "generate_rotor", "generate_frame"])
    .color(0xff5100)
    .toolStats(700,200,81920,500)
    .blastTemp(9999)
    .cableProperties(524288,32,0,false)
    .element("DraconiumAwakened")
    .build();
     */
}
