package gtne.api.unification.material.info;

import gregtech.api.unification.material.info.MaterialIconSet;
import gtne.client.GTNETextures;
import gtne.common.item.behaviors.render.HaloRenderItemBehavior;

public class GTNEMaterialIconSet{

    public static final MaterialIconSet INFINITY = new MaterialIconSetWithRenderer("infinity", null, true, new HaloRenderItemBehavior(10, 0xFF000000, () -> GTNETextures.HALO, true));

    public static final MaterialIconSet STELLARIUM = new MaterialIconSet("stellarium", null, true);

}
