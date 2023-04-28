package gtne.api.unification.material;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gtne.api.unification.material.GTNEMaterials.*;

//24701~24750

public class Water {
    public static void init() {

        Purified_Water_Grade_H = new Material.Builder(24701, "purified_water_grade_h")
                .fluid()
                .color(0x100763)
                .fluidTemp(293)
                .build();

        Purified_Water_Grade_G = new Material.Builder(24702, "purified_water_grade_g")
                .fluid()
                .color(0x190f73)
                .fluidTemp(293)
                .build();

        Purified_Water_Grade_F = new Material.Builder(24703, "purified_water_grade_f")
                .fluid()
                .color(0x281d8e)
                .fluidTemp(293)
                .build();

        Purified_Water_Grade_E = new Material.Builder(24704, "purified_water_grade_e")
                .fluid()
                .color(0x5045b4)
                .fluidTemp(293)
                .build();

        Purified_Water_Grade_D = new Material.Builder(24705, "purified_water_grade_d")
                .fluid()
                .color(0x5c4edf)
                .fluidTemp(293)
                .build();

        Purified_Water_Grade_C = new Material.Builder(24706, "purified_water_grade_c")
                .fluid()
                .color(0x27c3c8)
                .fluidTemp(293)
                .build();

        Purified_Water_Grade_B = new Material.Builder(24707, "purified_water_grade_b")
                .fluid()
                .color(0x79ecf0)
                .fluidTemp(293)
                .build();

        Purified_Water_Grade_A = new Material.Builder(24708, "purified_water_grade_a")
                .fluid()
                .color(0xb7fdff)
                .fluidTemp(293)
                .build();

    }
}
