package gtne.common.item;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;

public final class GTNEMetaItems {

    private GTNEMetaItems() {
    }

    public static MetaItem<?>.MetaValueItem STAINLESS_STEEL_BARS;
    public static MetaItem<?>.MetaValueItem ANTI_SPACE_RADIATION_ALLOY;
    public static MetaItem<?>.MetaValueItem ANTI_SPACE_RADIATION_ALLOY_PLATE;
    public static MetaItem<?>.MetaValueItem EUROPIUM_BOULE;
    public static MetaItem<?>.MetaValueItem EUROPIUM_DOPED_WAFER;

    public static MetaItem<?>.MetaValueItem BIOWARE_PROCESSOR_ZPM;
    public static MetaItem<?>.MetaValueItem BIOWARE_PROCESSOR_ASSEMBLY_UV;
    public static MetaItem<?>.MetaValueItem BIOWARE_COMPUTER_UHV;
    public static MetaItem<?>.MetaValueItem BIOWARE_MAINFRAME_UEV;

    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR_UV;
    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR_ASSEMBLY_UHV;
    public static MetaItem<?>.MetaValueItem OPTICAL_COMPUTER_UEV;
    public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME_UIV;

    public static MetaItem<?>.MetaValueItem EXOTIC_PROCESSOR_UHV;
    public static MetaItem<?>.MetaValueItem EXOTIC_PROCESSOR_ASSEMBLY_UEV;
    public static MetaItem<?>.MetaValueItem EXOTIC_COMPUTER_UIV;
    public static MetaItem<?>.MetaValueItem EXOTIC_MAINFRAME_UXV;

    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR_UEV;
    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR_ASSEMBLY_UIV;
    public static MetaItem<?>.MetaValueItem COSMIC_COMPUTER_UXV;
    public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME_OPV;

    public static MetaItem<?>.MetaValueItem TEMPORALLY_PROCESSOR_UIV;
    public static MetaItem<?>.MetaValueItem TEMPORALLY_PROCESSOR_ASSEMBLY_UXV;
    public static MetaItem<?>.MetaValueItem TEMPORALLY_COMPUTER_OPV;
    public static MetaItem<?>.MetaValueItem TEMPORALLY_MAINFRAME_MAX;

    public static void init() {
        GTNEMetaItem1 metaItem1 = new GTNEMetaItem1();
        metaItem1.setRegistryName("meta_item_1");
    }
}
