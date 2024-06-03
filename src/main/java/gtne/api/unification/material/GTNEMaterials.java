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
    //Windows Material
    public static Material HIGH_PURITY_SILICON;
    public static Material Draconium;
    public static Material Awakened_Draconium;
    public static Material Highly_Active_Draconium;
    public static Material Highly_Active_Awakened_Draconium;
    public static Material Infinity;
    //PlatLine
    public static Material PLATINUM_METALLIC_POWDER;
    public static Material PLATINUM_CONCENTRATE;
    public static Material PLATINUM_SALT;
    public static Material REPRECIPITATED_PLATINUM;
    public static Material REFINED_PLATINUM_SALT;
    public static Material PLATINUM_RESIDUE;
    public static Material PALLADIUM_ENRICHED_AMMONIA;
    public static Material LEACH_RESIDUE;
    //public static Material RHODIUM_SULFATE;
    public static Material SODIUM_RUTHENATE;
    public static Material RAREST_METAL_RESIDUE;
    public static Material IRIDIUM_METAL_RESIDUE;
    //public static Material ACIDIC_OSMIUM_SOLUTION;
    public static Material SLUDGE_DUST_RESIDUE;
    public static Material IRIDIUM_DIOXIDE;
    public static Material ACIDIC_IRIDIUM_SOLUTION;
    public static Material IRIDIUM_CHLORIDE;
    public static Material METALLIC_SLUDGE_DUST_RESIDUE;
    public static Material OSMIUM_SOLUTION;
    public static Material RHODIUM_SULFATE_SOLUTION;
    public static Material ZINC_SULFATE;
    public static Material CRUDE_RHODIUM_METAL;
    public static Material RHODIUM_SALT;
    public static Material RHODIUM_SALT_SOLUTION;
    public static Material RHODIUM_NITRATE;
    public static Material RHODIUM_FILTER_CAKE;
    public static Material RHODIUM_FILTER_CAKE_SOLUTION;
    public static Material REPRECIPITATED_RHODIUM;
    public static Material RUTHENIUM_TETROXIDE_SOLUTION;
    public static Material HOT_RUTHENIUM_TETROXIDE_SOLUTION;
    public static Material RUTHENIUM_TETROXIDE;
    public static Material PALLADIUM_METALLIC_POWDER;
    public static Material PALLADIUM_SALT;
    public static Material REPRECIPITATED_PALLADIUM;
    //Chemical
    public static Material AMMONIUM_CHLORIDE;
    public static Material POTASSIUM_DISULFATE;
    public static Material SODIUM_NITRATE;
    public static Material FORMIC_ACID;
    public static Material SODIUM_FORMATE;
    public static Material SILICON_TETRACHLORIDE;
    //Water
    public static Material Purified_Water_Grade_H;
    public static Material Purified_Water_Grade_G;
    public static Material Purified_Water_Grade_F;
    public static Material Purified_Water_Grade_E;
    public static Material Purified_Water_Grade_D;
    public static Material Purified_Water_Grade_C;
    public static Material Purified_Water_Grade_B;
    public static Material Purified_Water_Grade_A;
    public static Material Indalloy_140;
    public static Material Celestiallium;
    public static Material Lunatium;
    public static Material Stellarium;
    public static Material Fractallium;
    public static Material Entropium;
    public static Material Sacred_Metal;
    public static Material StoneIngot;
    public static Material Antimatter;
    public static Material Terrasteel;
    public static Material Manasteel;
    public static Material Elementium;
    public static Material Thaumium;
    public static Material VoidMetal;
    public static Material RawNeutronium;
    public static Material SamariumEuropiumNeodymiumTrinaquadide;
    public static Material SamariumEuropiumNeodymiumTrinaquadideMagnetic;
    public static Material NeutronMixture;

    public static Material Enderium_Base;


    public static void registerMaterialHigh() {
        GTNEMaterialFlags.init();
    }


    public static void registerMaterialLow() {
        GTNE_windows_material.init();
        GTNEPlatLineMaterial.init();
        GTNEChemical.init();
        Water.init();
    }

}
