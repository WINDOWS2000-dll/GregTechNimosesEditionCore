package gtne.common.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.ConfigHolder;
import gtne.common.metatileentities.multi.*;
import gtne.common.metatileentities.multi.miner.MetaTileEntitySuperDeepMiner;
import gtne.common.metatileentities.multi.multiblockpart.MetaTileEntityWirelessEnergyHatch;
import gtne.common.metatileentities.multi.spaceelevator.MetaTileEntitySpaceElevator;
import gtne.common.metatileentities.multi.spaceelevator.modules.MetaTileEntityAssemblerModule;
import gtne.common.metatileentities.multi.spaceelevator.modules.MetaTileEntityMiningModule;
import net.minecraft.util.ResourceLocation;


import javax.annotation.Nonnull;

import static gregtech.api.GTValues.*;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;
import static gtne.api.recipes.GTNERecipeMaps.*;


public class GTNEMetaTileEntities {

    //Single Machine Register
    public static final SimpleMachineMetaTileEntity[] COMPONENTS_ASSEMBLER = new SimpleMachineMetaTileEntity[GTValues.IV];

    //MultiBlock
    public static MetaTileEntityAdvancedPrecisionAssemblyLine AdvancedPrecisionAssemblyLine;
    public static MetaTileEntityHighEnergyElectromagneticImplosionMachine HighEnergyElectromagneticImplosionMachine;
    public static final MetaTileLateGameEntityFusionReactor[] LGFUSION_REACTOR = new MetaTileLateGameEntityFusionReactor[2];
    public static MetaTileEntityHighDimensionalStructureConstructionTesseract HIGH_DIMENSIONAL_STRUCTURE_CONSTRUCTION_TESSERACT;
    public static MetaTileEntityAdvancedDistilleryTower AdvancedDistillationTower;
    public static MetaTileEntitySiliconMonocrystallineRefiningFurnace SiliconMonocrystallineRefiningFurnace;
    public static MetaTileEntityCosmicLayDetector COSMIC_RAY_DETECTOR;
    public static MetaTileEntitySuperDeepMiner SUPER_DEEP_MINER;

    //Hatches
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_INPUT_HATCH = new MetaTileEntityEnergyHatch[1];
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_INPUT_HATCH_4A = new MetaTileEntityEnergyHatch[5]; // EV, IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_INPUT_HATCH_16A = new MetaTileEntityEnergyHatch[5]; // IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_OUTPUT_HATCH = new MetaTileEntityEnergyHatch[1];
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_OUTPUT_HATCH_4A = new MetaTileEntityEnergyHatch[5]; // EV, IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_OUTPUT_HATCH_16A = new MetaTileEntityEnergyHatch[5];
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_INPUT_HATCH_32A = new MetaTileEntityEnergyHatch[5];
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_OUTPUT_HATCH_32A = new MetaTileEntityEnergyHatch[5];

    //////////////////////////////////////////////////////
    public static MetaTileEntityWirelessEnergyHatch[] WIRELESS_ENERGY_HATCH_INPUT = new MetaTileEntityWirelessEnergyHatch[V.length];

    public static MetaTileEntityWirelessEnergyHatch[] WIRELESS_ENERGY_HATCH_INPUT_4A = new MetaTileEntityWirelessEnergyHatch[V.length - 4];

    public static MetaTileEntityWirelessEnergyHatch[] WIRELESS_ENERGY_HATCH_INPUT_16A = new MetaTileEntityWirelessEnergyHatch[V.length - 5];

    public static MetaTileEntityWirelessEnergyHatch[] WIRELESS_ENERGY_HATCH_INPUT_64A = new MetaTileEntityWirelessEnergyHatch[V.length - 5];

    public static MetaTileEntityWirelessEnergyHatch[] WIRELESS_ENERGY_HATCH_OUTPUT = new MetaTileEntityWirelessEnergyHatch[V.length];

    //////////////////////////////////////////////////////////////
    public static MetaTileEntitySpaceElevator SPACE_ELEVATOR;

    public static MetaTileEntityMiningModule[] MINING_MODULE = new MetaTileEntityMiningModule[3];

    public static MetaTileEntityAssemblerModule[] ASSEMBLER_MODULE = new MetaTileEntityAssemblerModule[3];

    public static int wirelessids = 332;
    public static void init() {
        /*
         * FOR ADDON DEVELOPERS:
         *
         * GTCEu will not take more than 2000 IDs. Anything past ID 1999
         * is considered FAIR GAME, take whatever you like.
         *
         * If you would like to reserve IDs, feel free to reach out to the
         * development team and claim a range of IDs! We will mark any
         * claimed ranges below this comment. Max value is 32767.
         *
         * - Gregicality / Shadows of Greg: 2000-3999
         * - Gregification: 4000-4499
         * - GregTech Food Option: 8500-8999
         * - HtmlTech: 9000-9499
         * - PCM's Ore Addon: 9500-9999
         * - GCM: 10000-10099
         * - MechTech: 10100-10499
         * - MBT 10500 - 10999
         * - CT(MBT) 32000 - ~
         * - FREE RANGE 11000-32767
         */

        //blocks :1～
        if (ConfigHolder.recipeoption.Components_Assembler) {
            registerSimpleMetaTileEntity(COMPONENTS_ASSEMBLER, 1, "components_assembler", GTNERecipeMaps.COMPONENTS_ASSEMBLER, Textures.ASSEMBLER_OVERLAY, true, GTNEMetaTileEntities::gtneId, GTUtility.hvCappedTankSizeFunction);
        }
        //MultiBlockMachines 200～
        HighEnergyElectromagneticImplosionMachine = registerMetaTileEntity(200, new MetaTileEntityHighEnergyElectromagneticImplosionMachine(gtneId("high_energy_electromagnetic_implosion_compressor")));
        AdvancedPrecisionAssemblyLine = registerMetaTileEntity(201, new MetaTileEntityAdvancedPrecisionAssemblyLine(gtneId("advanced_precision_assembly_line")));
        LGFUSION_REACTOR[0] = registerMetaTileEntity(202, new MetaTileLateGameEntityFusionReactor(gtneId("fusion_reactor.uhv"), UHV));
        LGFUSION_REACTOR[1] = registerMetaTileEntity(203, new MetaTileLateGameEntityFusionReactor(gtneId("fusion_reactor.uev"), UEV));
        HIGH_DIMENSIONAL_STRUCTURE_CONSTRUCTION_TESSERACT = registerMetaTileEntity(204, new MetaTileEntityHighDimensionalStructureConstructionTesseract(gtneId("high_dimensional_structure_construction_tesseract")));
        AdvancedDistillationTower = registerMetaTileEntity(205, new MetaTileEntityAdvancedDistilleryTower(gtneId("advanced_distillation_tower")));
        SiliconMonocrystallineRefiningFurnace = registerMetaTileEntity(206, new MetaTileEntitySiliconMonocrystallineRefiningFurnace(gtneId("silicon_monocrystalline_refining_furnace")));
        COSMIC_RAY_DETECTOR = registerMetaTileEntity(207, new MetaTileEntityCosmicLayDetector(gtneId("cosmic_ray_detector")));
        SUPER_DEEP_MINER = registerMetaTileEntity(208, new MetaTileEntitySuperDeepMiner(gtneId("super_deep_miner"), SUPER_DEEP_MINER_RECIPES, false));
        //Space Elevator & Modules
        SPACE_ELEVATOR = registerMetaTileEntity(209, new MetaTileEntitySpaceElevator(gtneId("space_elevator")));
        MINING_MODULE[0] = registerMetaTileEntity(210, new MetaTileEntityMiningModule(gtneId("mining_module_1"), 9, 1, 1, 2));
        MINING_MODULE[1] = registerMetaTileEntity(211, new MetaTileEntityMiningModule(gtneId("mining_module_2"), 11, 2, 2, 4));
        MINING_MODULE[2] = registerMetaTileEntity(212, new MetaTileEntityMiningModule(gtneId("mining_module_3"), 13, 3, 3, 8));
        ASSEMBLER_MODULE[0] = registerMetaTileEntity(213, new MetaTileEntityAssemblerModule(gtneId("assembler_module_1"), ASSEMBLER_MODULE_RECIPES, 9, 1, 1));
        ASSEMBLER_MODULE[1] = registerMetaTileEntity(214, new MetaTileEntityAssemblerModule(gtneId("assembler_module_2"), ASSEMBLER_MODULE_RECIPES, 11, 2, 3));
        ASSEMBLER_MODULE[2] = registerMetaTileEntity(215, new MetaTileEntityAssemblerModule(gtneId("assembler_module_3"), ASSEMBLER_MODULE_RECIPES, 13, 3, 5));


        //HighTierEnergyHatch 300~331
        if (ConfigHolder.metaTileEntityOptions.HigherTierEnergyHatch) {
            GTNE_ENERGY_INPUT_HATCH[0] = registerMetaTileEntity(300, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input." + GTValues.VN[MAX]), 14, 2, false));
            GTNE_ENERGY_OUTPUT_HATCH[0] = registerMetaTileEntity(301, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output." + GTValues.VN[MAX]), 14, 2, true));
            GTNE_ENERGY_INPUT_HATCH_4A[0] = registerMetaTileEntity(302, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[UEV]), 10, 4, false));
            GTNE_ENERGY_INPUT_HATCH_4A[1] = registerMetaTileEntity(303, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[UIV]), 11, 4, false));
            GTNE_ENERGY_INPUT_HATCH_4A[2] = registerMetaTileEntity(304, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[UXV]), 12, 4, false));
            GTNE_ENERGY_INPUT_HATCH_4A[3] = registerMetaTileEntity(305, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[OpV]), 13, 4, false));
            GTNE_ENERGY_INPUT_HATCH_4A[4] = registerMetaTileEntity(306, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[MAX]), 14, 4, false));
            GTNE_ENERGY_OUTPUT_HATCH_4A[0] = registerMetaTileEntity(307, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[UEV]), 10, 4, true));
            GTNE_ENERGY_OUTPUT_HATCH_4A[1] = registerMetaTileEntity(308, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[UIV]), 11, 4, true));
            GTNE_ENERGY_OUTPUT_HATCH_4A[2] = registerMetaTileEntity(309, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[UXV]), 12, 4, true));
            GTNE_ENERGY_OUTPUT_HATCH_4A[3] = registerMetaTileEntity(310, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[OpV]), 13, 4, true));
            GTNE_ENERGY_OUTPUT_HATCH_4A[4] = registerMetaTileEntity(311, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[MAX]), 14, 4, true));
            GTNE_ENERGY_INPUT_HATCH_16A[0] = registerMetaTileEntity(312, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[UEV]), 10, 16, false));
            GTNE_ENERGY_INPUT_HATCH_16A[1] = registerMetaTileEntity(313, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[UIV]), 11, 16, false));
            GTNE_ENERGY_INPUT_HATCH_16A[2] = registerMetaTileEntity(314, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[UXV]), 12, 16, false));
            GTNE_ENERGY_INPUT_HATCH_16A[3] = registerMetaTileEntity(315, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[OpV]), 13, 16, false));
            GTNE_ENERGY_INPUT_HATCH_16A[4] = registerMetaTileEntity(316, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[MAX]), 14, 16, false));
            GTNE_ENERGY_OUTPUT_HATCH_16A[0] = registerMetaTileEntity(317, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[UEV]), 10, 16, true));
            GTNE_ENERGY_OUTPUT_HATCH_16A[1] = registerMetaTileEntity(318, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[UIV]), 11, 16, true));
            GTNE_ENERGY_OUTPUT_HATCH_16A[2] = registerMetaTileEntity(319, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[UXV]), 12, 16, true));
            GTNE_ENERGY_OUTPUT_HATCH_16A[3] = registerMetaTileEntity(320, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[OpV]), 13, 16, true));
            GTNE_ENERGY_OUTPUT_HATCH_16A[4] = registerMetaTileEntity(321, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[MAX]), 14, 16, true));
            GTNE_ENERGY_INPUT_HATCH_32A[0] = registerMetaTileEntity(322, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[UEV]), 10, 32, false));
            GTNE_ENERGY_INPUT_HATCH_32A[1] = registerMetaTileEntity(323, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[UIV]), 11, 32, false));
            GTNE_ENERGY_INPUT_HATCH_32A[2] = registerMetaTileEntity(324, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[UXV]), 12, 32, false));
            GTNE_ENERGY_INPUT_HATCH_32A[3] = registerMetaTileEntity(325, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[OpV]), 13, 32, false));
            GTNE_ENERGY_INPUT_HATCH_32A[4] = registerMetaTileEntity(326, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[MAX]), 14, 32, false));
            GTNE_ENERGY_OUTPUT_HATCH_32A[0] = registerMetaTileEntity(327, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[UEV]), 10, 32, true));
            GTNE_ENERGY_OUTPUT_HATCH_32A[1] = registerMetaTileEntity(328, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[UIV]), 11, 32, true));
            GTNE_ENERGY_OUTPUT_HATCH_32A[2] = registerMetaTileEntity(329, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[UXV]), 12, 32, true));
            GTNE_ENERGY_OUTPUT_HATCH_32A[3] = registerMetaTileEntity(330, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[OpV]), 13, 32, true));
            GTNE_ENERGY_OUTPUT_HATCH_32A[4] = registerMetaTileEntity(331, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[MAX]), 14, 32, true));
        }

        for (int i = 0; i < WIRELESS_ENERGY_HATCH_OUTPUT.length; i++) {
            String voltageName = VN[i].toLowerCase();
            WIRELESS_ENERGY_HATCH_INPUT[i] = registerMetaTileEntity(++wirelessids, new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input." + voltageName), i, 1, false));

            if (i > 3) {
                WIRELESS_ENERGY_HATCH_INPUT_4A[i - 4] = registerMetaTileEntity(++wirelessids, new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input." + voltageName + ".4a"), i, 4, false));
            }

            if (i > 4) {
                WIRELESS_ENERGY_HATCH_INPUT_16A[i - 5] = registerMetaTileEntity(++wirelessids, new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input." + voltageName + ".16a"), i, 16, false));
                WIRELESS_ENERGY_HATCH_INPUT_64A[i - 5] = registerMetaTileEntity(++wirelessids, new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input." + voltageName + ".64a"), i, 64, false));
            }

            WIRELESS_ENERGY_HATCH_OUTPUT[i] = registerMetaTileEntity(++wirelessids, new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output." + voltageName), i, 1, true));

        }

    }

    @Nonnull
    private static ResourceLocation gtneId(String name) {
        return new ResourceLocation("gtnecore", name);
    }
}
