package gtne.common.item;

import gregtech.api.items.metaitem.StandardMetaItem;

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
    }
}
