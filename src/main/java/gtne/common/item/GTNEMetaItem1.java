package gtne.common.item;

import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.common.items.MetaItems.WETWARE_PROCESSOR_LUV;
import static gtne.common.item.GTNEMetaItems.*;

public class GTNEMetaItem1 extends StandardMetaItem {

    public GTNEMetaItem1() {
        super();
    }

    @Override
    public void registerSubItems() {
        STAINLESS_STEEL_BARS = addItem(0, "stainless_steel_bars");
        ANTI_SPACE_RADIATION_ALLOY = addItem(1, "anti_space_radioation_alloy");
        ANTI_SPACE_RADIATION_ALLOY_PLATE = addItem(2, "anti_space_radioation_alloy_plate");
        EUROPIUM_BOULE = addItem(3, "europium_boule");
        EUROPIUM_DOPED_WAFER = addItem(4, "europium_doped_wafer");
        //Circuit 5 ~ 24
        //T8 Bioware
        BIOWARE_PROCESSOR_ZPM = addItem(5, "circuit.bioware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        BIOWARE_PROCESSOR_ASSEMBLY_UV = addItem(6, "circuit.bioware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        BIOWARE_COMPUTER_UHV = addItem(7, "circuit.bioware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        BIOWARE_MAINFRAME_UEV = addItem(8, "circuit.bioware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        //T9 Optical
        OPTICAL_PROCESSOR_UV = addItem(9, "circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        OPTICAL_PROCESSOR_ASSEMBLY_UHV = addItem(10, "circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        OPTICAL_COMPUTER_UEV = addItem(11, "circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_MAINFRAME_UIV = addItem(12, "circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        //T10 Exotic
        EXOTIC_PROCESSOR_UHV = addItem(13, "circuit.exotic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        EXOTIC_PROCESSOR_ASSEMBLY_UEV = addItem(14, "circuit.exotic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        EXOTIC_COMPUTER_UIV = addItem(15, "circuit.exotic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        EXOTIC_MAINFRAME_UXV = addItem(16, "circuit.exotic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        //T11 Cosmic
        COSMIC_PROCESSOR_UEV = addItem(17, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        COSMIC_PROCESSOR_ASSEMBLY_UIV = addItem(18, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        COSMIC_COMPUTER_UXV = addItem(19, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_MAINFRAME_OPV = addItem(20, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        //T12 Temporally
        TEMPORALLY_PROCESSOR_UIV = addItem(21, "circuit.temporally_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        TEMPORALLY_PROCESSOR_ASSEMBLY_UXV = addItem(22, "circuit.temporally_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        TEMPORALLY_COMPUTER_OPV = addItem(23, "circuit.temporally_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        TEMPORALLY_MAINFRAME_MAX = addItem(24, "circuit.temporally_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);
        //Circuit End
        ADVANCED_HIGH_SPEED_PROCESSING_UNIT = addItem(25, "advanced_highspeed_processing_unit");
        IMPROVED_HIGH_SPEED_ARITHMETIC_INTEGRATED_PROCESSOR = addItem(26, "improved_high_speed_arithmetic_integrated_processor");
        BRICK_COMPOUND = addItem(27, "brick_compound");
        ADVANCED_STORAGE_HOUSING = addItem(28, "advanced_storage_housing");
        FLUID_STORAGE_HOUSING = addItem(29, "fluid_storage_housing");
        STEEL_REINFORCED_WIRE = addItem(30, "steel_reinforced_wire");
        SILICON_CRYSTAL = addItem(31, "silicon_crystal");
        VANADIUM_STEEL_REINFORCED_WIRE = addItem(32, "vanadium_steel_reinforced_wire");
        TUNGSTEN_CARBIDE_REINFORCED_WIRE = addItem(33, "tungsten_carbide_reinforced_wire");

    }
}
