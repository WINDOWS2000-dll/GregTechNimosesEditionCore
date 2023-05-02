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

public class GTNE_windows_material {
    public static void init() {


        //24001 ~ 24500

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
                .fluid()
                .color(0x9b00ff)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .blastTemp(4700, GasTier.HIGH, 16384, 10000)
                .toolStats(new ToolProperty(400F, 100F, 42000, 160))
                .cableProperties(8192L, 16, 16, false)
                .element(Dc)
                .build();

        Awakened_Draconium = new Material.Builder(24003, "draconium_awakened")
                .dust()
                .ingot()
                .plasma()
                .fluid()
                .color(0xff5100)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .blastTemp(9000, GasTier.HIGHEST, 120000, 12000)
                .toolStats(new ToolProperty(700F, 200F, 81920, 500))
                .cableProperties(GTValues.V[9], 32, 16, false)
                .element(DcX)
                .build();

        Highly_Active_Draconium = new Material.Builder(24004, "highly_active_draconium")
                .dust()
                .ingot()
                .fluid()
                .plasma()
                .fluid()
                .fluidTemp(17500)
                .color(0x32064f)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_PLATE, GENERATE_ROUND)
                .blastTemp(17500, GasTier.HIGHEST, 2000000, 9600)
                .toolStats(new ToolProperty(800F, 280F, 96000, 200))
                .cableProperties(UEV, 32, 32, false)
                .element(HADc)
                .build();

        Highly_Active_Awakened_Draconium = new Material.Builder(24005, "highly_active_awakened_draconium")
                .dust()
                .ingot()
                .fluid()
                .plasma()
                .fluid()
                .fluidTemp(23500)
                .color(0x943001)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_PLATE, GENERATE_ROUND)
                .blastTemp(23500, GasTier.HIGHEST, 12000000, 4800)
                .toolStats(new ToolProperty(1000F, 320F, 120000, 600))
                .cableProperties(UIV, 32, 64, false)
                .element(HADcX)
                .build();



    }
}
