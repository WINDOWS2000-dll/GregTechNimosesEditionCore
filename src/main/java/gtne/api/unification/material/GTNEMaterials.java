package gtne.api.unification.material;

import gregtech.api.unification.material.Material;

public class GTNEMaterials {
    /*
     * FOR ADDON DEVELOPERS:
     *
     * GTCEu will not take more than 3000 IDs. Anything past ID 2999
     * is considered FAIR GAME, take whatever you like.
     *
     * If you would like to reserve IDs, feel free to reach out to the
     * development team and claim a range of IDs! We will mark any
     * claimed ranges below this comment. Max value is 32767.
     *
     * - Gregicality: 3000-19999
     * - FREE RANGE 20000-20999
     * - HtmlTech: 21000-21499
     * - GregTech Food Option: 21500-21999
     * - PCM's Ore Addon: 22000-23599
     * - MechTech: 23600-23999
     * - FREE RANGE 24000-31999
     * - Reserved for CraftTweaker: 32000-32767
     */
    public static Material HIGH_PURITY_SILICON;
    public static Material Draconium;
    public static Material Awakened_Draconium;


    public static void init() {
        GTNE_windows_material.init();
    }

}
