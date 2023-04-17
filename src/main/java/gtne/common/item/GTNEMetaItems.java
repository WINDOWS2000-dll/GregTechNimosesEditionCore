package gtne.common.item;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;

public class GTNEMetaItems {

    private GTNEMetaItems() {
    }

    public static MetaItem<?>.MetaValueItem STAINLESS_STEEL_BARS;
    public static MetaItem<?>.MetaValueItem ANTI_SPACE_RADIATION_ALLOY;
    public static MetaItem<?>.MetaValueItem ANTI_SPACE_RADIATION_ALLOY_PLATE;

    public static void init() {
        GTNEMetaItem1 metaItem1 = new GTNEMetaItem1();
        metaItem1.setRegistryName("meta_item_1");
    }
}
