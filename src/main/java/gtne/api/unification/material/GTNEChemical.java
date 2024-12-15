package gtne.api.unification.material;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import net.minecraftforge.fluids.Fluid;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.N;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static gtne.api.util.GTNEUtil.DefaultMaterialFlags;

public class GTNEChemical {

    //24601 ~ 24700

    private static int chemicalIDs = 24600;

    public static void init() {

        //₀₁₂₃₄₅₆₇₈₉

        //Ammonium Chloride
        AMMONIUM_CHLORIDE = new Material.Builder(++chemicalIDs, gregtechId("ammonium_chloride"))
                .liquid(new FluidBuilder().temperature(611))
                .color(0xd8d9cc)
                .build();

        //Potassium Disulfate
        POTASSIUM_DISULFATE = new Material.Builder(++chemicalIDs, gregtechId("potassium_disulfate"))
                .liquid(new FluidBuilder().temperature(598))
                .dust()
                .color(0x787446)
                .build();
        POTASSIUM_DISULFATE.setFormula("K2S2O7", true);
        //Sodium Nitrate
        SODIUM_NITRATE = new Material.Builder(++chemicalIDs, gregtechId("sodium_nitrate"))
                .dust()
                .color(0x4c577d)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
        SODIUM_NITRATE.setFormula("NaNO3", true);
        //Formic Acid
        FORMIC_ACID = new Material.Builder(++chemicalIDs, gregtechId("formic_acid"))
                .liquid(new FluidBuilder().temperature(300))
                .color(0xbf9341)
                .build();
        FORMIC_ACID.setFormula("CH2O2", true);
        //Sodium Formate
        SODIUM_FORMATE = new Material.Builder(++chemicalIDs, gregtechId("sodium_formate"))
                .liquid(new FluidBuilder().temperature(300))
                .color(0xbf9341)
                .build();
        //Silicon tetrachloride
        SILICON_TETRACHLORIDE = new Material.Builder(++chemicalIDs, gregtechId("silicon_tetrachloride"))
                .liquid(new FluidBuilder().temperature(204))
                .color(0xffffff)
                .build();
        ////Kevlar Chain////
        //Liquid Crystal Kevlar [-CO-C6H4-CO-NH-C6H4-NH-]n
        LIQUID_CRYSTAL_KEVLAR = new Material.Builder(++chemicalIDs, gregtechId("liquid_crystal_kevlar"))
                .liquid(new FluidBuilder().temperature(295))
                .color(0xc9cc16)
                .build();
        LIQUID_CRYSTAL_KEVLAR.setFormula("[-CO-C6H4-CO-NH-C6H4-NH-]n", true);
        //para-Phenylenediamine C6H8N2
        PARA_PHENYLENEDIAMINE = new Material.Builder(++chemicalIDs, gregtechId("para_phenylenediamine"))
                .dust()
                .color(0xf7ed5e)
                .build();
        PARA_PHENYLENEDIAMINE.setFormula("C6H8N2", true);
        //4-Nitroaniline C6H6N2O2
        FOUR_NITROANILINE = new Material.Builder(++chemicalIDs, gregtechId("four_nitroaniline"))
                .liquid(new FluidBuilder().temperature(420))
                .color(0xf78f39)
                .build();
        FOUR_NITROANILINE.setFormula("C6H6N2O2", true);
        //Acetic Anhydride (CH3CO)2O
        ACETIC_ANHYDRIDE = new Material.Builder(++chemicalIDs, gregtechId("acetic_anhydride"))
                .liquid(new FluidBuilder().temperature(200))
                .color(0xf7ed5e)
                .build();
        ACETIC_ANHYDRIDE.setFormula("(CH3CO)2O", true);
        //Methyl Acetate C3H6O2
        METHYL_ACETATE = new Material.Builder(++chemicalIDs, gregtechId("methyl_acetate"))
                .liquid(new FluidBuilder().temperature(295))
                .color(0xa78c6c)
                .build();
        METHYL_ACETATE.setFormula("C3H6O2", true);
        //Terephthaloyl Chloride C8H4Cl2O2
        TEREPHTHALOYL_CHLORIDE = new Material.Builder(++chemicalIDs, gregtechId("terephthaloyl_chloride"))
                .dust()
                .color(0x02cd00)
                .build();
        TEREPHTHALOYL_CHLORIDE.setFormula("C8H4Cl2O2", true);
        //Cobalt II Naphthenate CoC22H14O4
        COBALT_II_NAPHTHENATE = new Material.Builder(++chemicalIDs, gregtechId("cobalt_ii_naphthenate"))
                .dust()
                .color(0x462c18)
                .build();
        COBALT_II_NAPHTHENATE.setFormula("CoC22H14O4", true);
        //Cobalt II Hydroxide Co(OH)2
        COBALT_II_HYDROXIDE = new Material.Builder(++chemicalIDs, gregtechId("cobalt_ii_hydroxide"))
                .dust()
                .color(0xdc82ca)
                .build();
        COBALT_II_HYDROXIDE.setFormula("Co(OH)2", true);
        //Cobalt II Nitrate Co(NO3)2
        COBALT_II_NITRATE = new Material.Builder(++chemicalIDs, gregtechId("cobalt_ii_nitrate"))
                .dust()
                .color(0xb20008)
                .build();
        COBALT_II_NITRATE.setFormula("Co(NO3)2", true);
        //Dimethyl Terephthalate C10H10O4
        DIMETHYL_TEREPHTHALATE = new Material.Builder(++chemicalIDs, gregtechId("dimethyl_terephthalate"))
                .liquid(new FluidBuilder().temperature(415))
                .color(0xaaaaaf)
                .build();
        DIMETHYL_TEREPHTHALATE.setFormula("C10H10O4", true);
        //Thionyl Chloride SOCl2
        THIONYL_CHLORIDE = new Material.Builder(++chemicalIDs, gregtechId("thionyl_chloride"))
                .liquid(new FluidBuilder().temperature(295))
                .color(0xaaaaaf)
                .build();
        THIONYL_CHLORIDE.setFormula("SOCl2", true);
        //Sulfur Dichloride SCl2
        SULFUR_DICHLORIDE = new Material.Builder(++chemicalIDs, gregtechId("sulfur_dichloride"))
                .liquid(new FluidBuilder().temperature(295))
                .color(0xb20008)
                .build();
        SULFUR_DICHLORIDE.setFormula("SCl2", true);
        //Terephthalic Acid C8H6O4
        TEREPHTHALIC_ACID = new Material.Builder(++chemicalIDs, gregtechId("terephthalic_acid"))
                .liquid(new FluidBuilder().temperature(480))
                .color(0xaaaaaf)
                .build();
        TEREPHTHALIC_ACID.setFormula("C8H6O4", true);
        //Naphthenic Acid
        NAPHTHENIC_ACID = new Material.Builder(++chemicalIDs, gregtechId("naphthenic_acid"))
                .liquid(new FluidBuilder().temperature(295))
                .color(0xaaaaaf)
                .build();
        //1,4-Dimethylbenzene C8H10
        ONE_FOUR_DIMETHYLBENZENE = new Material.Builder(++chemicalIDs, gregtechId("one_four_dimethylbenzene"))
                .liquid(new FluidBuilder().temperature(480))
                .color(0x3c6a42)
                .build();
        ONE_FOUR_DIMETHYLBENZENE.setFormula("C8H10", true);
        //N-Methyl-2-pyrrolidone C5H9NO
        N_METHYL_TWO_PYRROLIDONE = new Material.Builder(++chemicalIDs, gregtechId("n_methyl_two_pyrrolidone"))
                .liquid(new FluidBuilder().temperature(249))
                .color(0xaaaaaf)
                .build();
        N_METHYL_TWO_PYRROLIDONE.setFormula("C5H9NO", true);
        //Methylamine CH5N
        METHYLAMINE = new Material.Builder(++chemicalIDs, gregtechId("methylamine"))
                .liquid(new FluidBuilder().temperature(295))
                .color(0x2b2b57)
                .build();
        METHYLAMINE.setFormula("CH5N", true);
        //gamma-Butyrolactone C4H6O2
        GAMMA_BUTYROLACTONE = new Material.Builder(++chemicalIDs, gregtechId("gamma_butyrolactone"))
                .liquid(new FluidBuilder().temperature(229))
                .color(0xf7ed5e)
                .build();
        GAMMA_BUTYROLACTONE.setFormula("C4H6O2", true);
        //1,4-Butanediol HO(CH2)4OH
        ONE_FOUR_BUTANEDIOL = new Material.Builder(++chemicalIDs, gregtechId("one_four_butanediol"))
                .liquid(new FluidBuilder().temperature(300))
                .color(0x7c2d27)
                .build();
        ONE_FOUR_BUTANEDIOL.setFormula("HO(CH2)4OH", true);
        //Acetylene C2H2
        ACETYLENE = new Material.Builder(++chemicalIDs, gregtechId("acetylene"))
                .liquid(new FluidBuilder().temperature(295))
                .color(0xaaaaaf)
                .build();
        ACETYLENE.setFormula("C2H2", true);
        //Formaldehyde CH2O
        FORMALDEHYDE = new Material.Builder(++chemicalIDs, gregtechId("formaldehyde"))
                .liquid(new FluidBuilder().temperature(185))
                .color(0x9239af)
                .build();

        FORMALDEHYDE.setFormula("CH2O", true);
        //2-Butin-1,4-diol C4H6O2
        TWO_BUTIN_ONE_FOUR_DIOL = new Material.Builder(++chemicalIDs, gregtechId("two_butin_one_four_diol"))
                .dust()
                .color(0xf7ed5e)
                .build();
        TWO_BUTIN_ONE_FOUR_DIOL.setFormula("C4H6O2", true);
        //Raney Nickel NiAl
        RANEY_NICKEL = new Material.Builder(++chemicalIDs, gregtechId("raney_nickel"))
                .dust()
                .color(0xd7f7f5)
                .build();
        RANEY_NICKEL.setFormula("NiAl", true);
        //Bismuth Oxide Bi2O3
        BISMUTH_OXIDE = new Material.Builder(++chemicalIDs, gregtechId("bismuth_oxide"))
                .dust()
                .color(0x131c27)
                .build();
        BISMUTH_OXIDE.setFormula("Bi2O3", true);
        //Nickel Aluminide Ingot NiAl3
        NICKEL_ALUMINIDE = new Material.Builder(++chemicalIDs, gregtechId("nickel_aluminide"))
                .ingot()
                .dust()
                .liquid(new FluidBuilder().temperature(1668))
                .color(0xb0bcbc)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DefaultMaterialFlags)
                .components(Nickel, 1, Aluminium, 3)
                .blast(builder -> builder
                        .temp(1688)
                        .blastStats(VA[HV], 900)
                        .vacuumStats(VA[MV], 102))
                .build();

        ////Aluminium Chain////
        //Alumina Al2O3
        ALUMINA = new Material.Builder(++chemicalIDs, gregtechId("alumina"))
                .dust()
                .color(0xb0bcbc)
                .build();
        ALUMINA.setFormula("Al2O3", true);
        //Cryolite Na3AlF6



    }
}
