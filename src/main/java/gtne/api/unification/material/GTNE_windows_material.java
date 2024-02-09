package gtne.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.fluids.FluidBuilder;
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
import static gtne.api.util.GTNEUtil.DefaultMaterialFlags;

public class GTNE_windows_material {
    public static void init() {

        //Add Material Flags
        //Enriched Naquadah
        NaquadahEnriched.addFlags(GENERATE_DOUBLE_PLATE);
        //UraniumRhodiumDinaquadide
        UraniumRhodiumDinaquadide.addFlags(GENERATE_SPRING);

        //24001 ~ 24500

        HIGH_PURITY_SILICON = new Material.Builder(24001, gregtechId("high_purity_silicon"))
                .dust()
                .ingot()
                .color(0x2a2a2a)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .blast(b -> b
                        .temp(2400, GasTier.LOW)
                )
                .build();

        Draconium = new Material.Builder(24002, gregtechId("draconium"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(4800))
                .color(0x9b00ff)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .blast(b -> b
                        .temp(4700, GasTier.HIGH)
                        .blastStats(8192, 10000)
                        .vacuumStats(VA[EV], 750))
                .toolStats(new ToolProperty(400F, 100F, 42000, 160))
                .cableProperties(8192L, 16, 16, false)
                .element(Dc)
                .build();

        Awakened_Draconium = new Material.Builder(24003, gregtechId("draconium_awakened"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(9001))
                .color(0xff5100)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .blast(b -> b
                        .temp(9000, GasTier.HIGHEST)
                        .blastStats(120000, 12000)
                        .vacuumStats(VA[ZPM], 750))
                .toolStats(new ToolProperty(700F, 200F, 81920, 500))
                .cableProperties(GTValues.V[9], 32, 16, false)
                .element(DcX)
                .build();

        Highly_Active_Draconium = new Material.Builder(24004, gregtechId("highly_active_draconium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(17500))
                .plasma()
                .color(0x32064f)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_PLATE, GENERATE_ROUND)
                .blast(b -> b
                        .temp(17500, GasTier.HIGHEST)
                        .blastStats(2000000, 9600)
                        .vacuumStats(VA[UV], 1000))
                .toolStats(new ToolProperty(800F, 280F, 96000, 200))
                .cableProperties(V[UEV], 32, 32, false)
                .element(HADc)
                .build();

        Highly_Active_Awakened_Draconium = new Material.Builder(24005, gregtechId("highly_active_awakened_draconium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(23500))
                .plasma()
                .color(0x943001)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_PLATE, GENERATE_ROUND)
                .blast(b -> b
                        .temp(23500, GasTier.HIGHEST)
                        .blastStats(12000000, 4800)
                        .vacuumStats(VA[UEV], 1200))
                .toolStats(new ToolProperty(1000F, 320F, 120000, 600))
                .cableProperties(V[UIV], 32, 64, false)
                .element(HADcX)
                .build();

        Infinity = new Material.Builder(24006, gregtechId("infinity"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2000000000).textures(true, false))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(GTNEMaterialIconSet.INFINITY)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(new ToolProperty(6000F, 1800F, 8192000, 999))
                .cableProperties(V[UEV], 32, 0, false)
                .element(If)
                .build();

        Celestiallium = new Material.Builder(24007, gregtechId("celestiallium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(16))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(new ToolProperty(8000F, 2000F, 16384000, 999))
                .cableProperties(V[UIV], 32, 0, false)
                .element(CLS)
                .build();

        Lunatium = new Material.Builder(24008, gregtechId("lunatium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(666666666))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(new ToolProperty(8000F, 2000F, 16384000, 999))
                .cableProperties(V[UIV], 524288, 600000, false)
                .element(LNT)
                .build();

        Sacred_Metal = new Material.Builder(24009, gregtechId("sacred_metal"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(77777777))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(new ToolProperty(9000F, 3000F, 32768000, 999))
                .cableProperties(V[UIV], 64, 0, false)
                .element(SCR)
                .build();

        Stellarium = new Material.Builder(24010, gregtechId("stellarium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2147483647).textures(true, false))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(GTNEMaterialIconSet.STELLARIUM)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(new ToolProperty(10000F, 4000F, 65536000, 999))
                .cableProperties(V[UXV], 64, 0, false)
                .element(STL)
                .build();

        Fractallium = new Material.Builder(24011, gregtechId("fractallium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2147483647))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(new ToolProperty(20000F, 8000F, 131072000, 999))
                .cableProperties(V[OpV], 64, 0, false)
                .element(FTL)
                .build();

        Entropium = new Material.Builder(24012, gregtechId("entropium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2147483647))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(new ToolProperty(2147483647F, 10000000F, 2147483647, 999))
                .cableProperties(V[MAX], 128, 0, false)
                .element(ETP)
                .build();

        Indalloy_140 = new Material.Builder(24013, gregtechId("indalloy_140"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(5475))
                .color(0x66477a)
                .build();

        Indalloy_140.setFormula("Bi47Pb25Sn13Cd10In5", true);

        StoneIngot = new Material.Builder(24014, gregtechId("stone_ingot"))
                .dust()
                .ingot()
                .color(0x696969)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .toolStats(new ToolProperty(4F, 4F, 32, 1))
                .build();

        Antimatter = new Material.Builder(24015, gregtechId("antimatter"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2147483647))
                .color(0x14018a)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(new ToolProperty(2147483647F, 5000000F, 2147483647, 999))
                .cableProperties(V[MAX], 1, 0, true)
                .element(AM)
                .build();

        Terrasteel = new Material.Builder(24016, gregtechId("terrasteel"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(10946))
                .color(0x0ffa32)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .toolStats(new ToolProperty(100F,18F,38000,120))
                .cableProperties(32768,4,2,false)
                .element(TS)
                .build();

        Manasteel = new Material.Builder(24017, gregtechId("manasteel"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(1597))
                .color(0x0f65fa)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .toolStats(new ToolProperty(35F,6F,1024,20))
                .cableProperties(128, 4, 0, false)
                .element(MS)
                .build();


        Elementium = new Material.Builder(24018, gregtechId("elementium"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(4181))
                .color(0xfb54ae)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .toolStats(new ToolProperty(50F, 12F, 18000, 40))
                .cableProperties(32768, 8, 0, false)
                .element(EL)
                .build();

        Thaumium = new Material.Builder(24019, gregtechId("thaumium"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(666))
                .color(0x4e4177)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .toolStats(new ToolProperty(38F,8.25F,1280,21))
                .cableProperties(128, 4, 2, false)
                .element(TH)
                .build();

        VoidMetal = new Material.Builder(24020, gregtechId("void"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(6666))
                .color(0x110422)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .toolStats(new ToolProperty(66F, 29.59704F, 13332, 66))
                .cableProperties(2048, 4, 4, false)
                .element(Vid)
                .build();




    }
}
