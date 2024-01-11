package gtne.api.unification.material;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregtech.api.util.GTUtility.gregtechId;
import static gtne.api.unification.material.GTNEMaterials.*;

//24701~24750

public class Water {
    public static void init() {

        Purified_Water_Grade_H = new Material.Builder(24701, gregtechId("purified_water_grade_h"))
                .liquid(new FluidBuilder().temperature(293))
                .color(0x100763)
                .build();

        Purified_Water_Grade_G = new Material.Builder(24702, gregtechId("purified_water_grade_g"))
                .liquid(new FluidBuilder().temperature(293))
                .color(0x190f73)
                .build();

        Purified_Water_Grade_F = new Material.Builder(24703, gregtechId("purified_water_grade_f"))
                .liquid(new FluidBuilder().temperature(293))
                .color(0x281d8e)
                .build();

        Purified_Water_Grade_E = new Material.Builder(24704, gregtechId("purified_water_grade_e"))
                .liquid(new FluidBuilder().temperature(293))
                .color(0x5045b4)
                .build();

        Purified_Water_Grade_D = new Material.Builder(24705, gregtechId("purified_water_grade_d"))
                .liquid(new FluidBuilder().temperature(293))
                .color(0x5c4edf)
                .build();

        Purified_Water_Grade_C = new Material.Builder(24706, gregtechId("purified_water_grade_c"))
                .liquid(new FluidBuilder().temperature(293))
                .color(0x27c3c8)
                .build();

        Purified_Water_Grade_B = new Material.Builder(24707, gregtechId("purified_water_grade_b"))
                .liquid(new FluidBuilder().temperature(293))
                .color(0x79ecf0)
                .build();

        Purified_Water_Grade_A = new Material.Builder(24708, gregtechId("purified_water_grade_a"))
                .liquid(new FluidBuilder().temperature(293))
                .color(0xb7fdff)
                .build();

    }
}
