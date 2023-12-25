package gtne.api.util;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;

import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GTNEUtil {

    public static final String[] GTNEMachineRecipeName = new String[] {
            "electric_furnace", "macerator", "alloy_smelter", "arc_furnace", "assembler",
            "autoclave", "bender", "brewery", "canner", "centrifuge",
            "chemical_bath", "chemical_reactor", "compressor", "cutter", "distillery",
            "electrolyzer", "electromagnetic_separator", "extractor", "extruder", "fermenter",
            "fluid_heater", "fluid_solidifier", "forge_hammer", "forming_press", "lathe",
            "scanner", "mixer", "ore_washer", "packer", "gas_collector",
            "polarizer", "laser_engraver", "sifter", "thermal_centrifuge", "wiremill",
            "circuit_assembler", "rock_breaker", "world_accelerator"};

    /**
     * This String part of the bed recipe name.
     */
    public static final String[] BedRecipeName = new String[] {
            "minecraft:yellow_bed_from_", "minecraft:red_bed_from_", "minecraft:purple_bed_from_", "minecraft:pink_bed_from_",
            "minecraft:orange_bed_from_", "minecraft:lime_bed_from_", "minecraft:magenta_bed_from_", "minecraft:light_gray_bed_from_",
            "minecraft:light_blue_bed_from_", "minecraft:green_bed_from_", "minecraft:gray_bed_from_", "minecraft:cyan_bed_from_",
            "minecraft:brown_bed_from_", "minecraft:blue_bed_from_", "minecraft:black_bed_from_"
    };

    /**
     * @implNote This String Array not including Oak Wood Type
     */
    public static final String[] WoodType_1 = new String[] {
            "spruce", "birch", "jungle", "acacia", "dark_oak"
    };

    /**
     * @implNote This String Array including Oak Wood Type
     */
    public static final String[] WoodType_2 = new String[] {
            "oak", "spruce", "birch", "jungle", "acacia", "dark_oak"
    };

    /**
     * @implNote This Array is used GregTechNimosesEdition default Material Flag
     */
    public static MaterialFlag[] DefaultMaterialFlags = new MaterialFlag[] {
            GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
            GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
            GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
            GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE
    };

}
