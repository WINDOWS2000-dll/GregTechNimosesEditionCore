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

    public static void init() {
        GTNEMetaItem1 metaItem1 = new GTNEMetaItem1();
        metaItem1.setRegistryName("meta_item_1");
    }
}
