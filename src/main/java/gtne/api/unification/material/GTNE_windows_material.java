package gtne.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import gregtech.api.unification.material.properties.FluidProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import static gregtech.api.util.GTUtility.gregtechId;
import gregtech.api.unification.material.properties.ToolProperty;
import gtne.api.unification.material.info.GTNEMaterialIconSet;

import static gregtech.api.GTValues.*;
import static gtne.api.unification.material.GTNEElements.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GTNE_windows_material {
    public static void init() {


        //24001 ~ 24500

        HIGH_PURITY_SILICON = new Material.Builder(24001, gregtechId("high_purity_silicon"))
                .dust()
                .ingot()
                .color(0x2a2a2a)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .blastTemp(2400, GasTier.LOW)
                .build();

        Draconium = new Material.Builder(24002, gregtechId("draconium"))
                .dust()
                .ingot()
                .plasma()
                .fluid(FluidTypes.LIQUID, false)
                .color(0x9b00ff)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .blastTemp(4700, GasTier.HIGH, 16384, 10000)
                .toolStats(new ToolProperty(400F, 100F, 42000, 160))
                .cableProperties(8192L, 16, 16, false)
                .element(Dc)
                .build();

        Awakened_Draconium = new Material.Builder(24003, gregtechId("draconium_awakened"))
                .dust()
                .ingot()
                .plasma()
                .fluid(FluidTypes.LIQUID, false)
                .color(0xff5100)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .blastTemp(9000, GasTier.HIGHEST, 120000, 12000)
                .toolStats(new ToolProperty(700F, 200F, 81920, 500))
                .cableProperties(GTValues.V[9], 32, 16, false)
                .element(DcX)
                .build();

        Highly_Active_Draconium = new Material.Builder(24004, gregtechId("highly_active_draconium"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .fluidTemp(17500)
                .color(0x32064f)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_PLATE, GENERATE_ROUND)
                .blastTemp(17500, GasTier.HIGHEST, 2000000, 9600)
                .toolStats(new ToolProperty(800F, 280F, 96000, 200))
                .cableProperties(V[UEV], 32, 32, false)
                .element(HADc)
                .build();

        Highly_Active_Awakened_Draconium = new Material.Builder(24005, gregtechId("highly_active_awakened_draconium"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .fluidTemp(23500)
                .color(0x943001)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_PLATE, GENERATE_ROUND)
                .blastTemp(23500, GasTier.HIGHEST, 12000000, 4800)
                .toolStats(new ToolProperty(1000F, 320F, 120000, 600))
                .cableProperties(V[UIV], 32, 64, false)
                .element(HADcX)
                .build();

        Infinity = new Material.Builder(24006, gregtechId("infinity"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .color(0xFFFFFF)
                .fluidTemp(2000000000)
                .iconSet(GTNEMaterialIconSet.INFINITY)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .blastTemp(200_000_000)
                .toolStats(new ToolProperty(6000F, 1800F, 8192000, 999))
                .cableProperties(V[UEV], 32, 0, false)
                .element(If)
                .build();

        Celestiallium = new Material.Builder(24007, gregtechId("celestiallium"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .color(0xFFFFFF)
                .fluidTemp(16)
                .iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .blastTemp(200_000_000)
                .toolStats(new ToolProperty(8000F, 2000F, 16384000, 999))
                .cableProperties(V[UIV], 32, 0, false)
                .element(CLS)
                .build();

        Lunatium = new Material.Builder(24008, gregtechId("lunatium"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .color(0xFFFFFF)
                .fluidTemp(666666666)
                .iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .blastTemp(200_000_000)
                .toolStats(new ToolProperty(8000F, 2000F, 16384000, 999))
                .cableProperties(V[UIV], 524288, 600000, false)
                .element(LNT)
                .build();

        Sacred_Metal = new Material.Builder(24009, gregtechId("sacred_metal"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .color(0xFFFFFF)
                .fluidTemp(77777777)
                .iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .blastTemp(200_000_000)
                .toolStats(new ToolProperty(9000F, 3000F, 32768000, 999))
                .cableProperties(V[UIV], 64, 0, false)
                .element(SCR)
                .build();

        Stellarium = new Material.Builder(24010, gregtechId("stellarium"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .color(0xFFFFFF)
                .fluidTemp(0)
                .iconSet(GTNEMaterialIconSet.STELLARIUM)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .blastTemp(200_000_000)
                .toolStats(new ToolProperty(10000F, 4000F, 65536000, 999))
                .cableProperties(V[UXV], 64, 0, false)
                .element(STL)
                .build();

        Fractallium = new Material.Builder(24011, gregtechId("fractallium"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .color(0xFFFFFF)
                .fluidTemp(0)
                .iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .toolStats(new ToolProperty(20000F, 8000F, 131072000, 999))
                .cableProperties(V[OpV], 64, 0, false)
                .element(FTL)
                .build();

        Entropium = new Material.Builder(24012, gregtechId("entropium"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .plasma()
                .color(0xFFFFFF)
                .fluidTemp(0)
                .iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .toolStats(new ToolProperty(2147483647F, 10000000F, 2147483647, 999))
                .cableProperties(V[MAX], 128, 0, false)
                .element(ETP)
                .build();

        Indalloy_140 = new Material.Builder(24013, gregtechId("indalloy_140"))
                .dust()
                .ingot()
                .fluid(FluidTypes.LIQUID, false)
                .fluidTemp(5475)
                .color(0x66477a)
                .build();

        Indalloy_140.setFormula("Bi47Pb25Sn13Cd10In5", true);

        StoneIngot = new Material.Builder(24014, gregtechId("stone_ingot"))
                .dust()
                .ingot()
                .color(0x696969)
                .iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_PLATE, GENERATE_BOLT_SCREW, GENERATE_ROD, GENERATE_FRAME)
                .toolStats(new ToolProperty(1.5F, 1.25F, 64, 1))
                .build();

        Antimatter = new Material.Builder(24015, gregtechId("antimatter"))
                .dust()
                .ingot()
                .color(0x14018a)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
                        GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
                        GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .toolStats(new ToolProperty(2147483647F, 5000000F, 2147483647, 999))
                .cableProperties(V[MAX], 1, 0, true)
                .element(AM)
                .build();

    }
}
