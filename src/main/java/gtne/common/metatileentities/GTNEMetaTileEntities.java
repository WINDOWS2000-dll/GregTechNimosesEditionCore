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

    public static int wirelessids = 13032;
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

        //blocks :11000~11999
        if (ConfigHolder.recipeoption.Components_Assembler) {
            registerSimpleMetaTileEntity(COMPONENTS_ASSEMBLER, 11000, "components_assembler", GTNERecipeMaps.COMPONENTS_ASSEMBLER, Textures.ASSEMBLER_OVERLAY, true, GTNEMetaTileEntities::gtneId, GTUtility.hvCappedTankSizeFunction);
        }
        //MultiBlockMachines 12000~12999
        HighEnergyElectromagneticImplosionMachine = registerMetaTileEntity(12000, new MetaTileEntityHighEnergyElectromagneticImplosionMachine(gtneId("high_energy_electromagnetic_implosion_compressor")));
        AdvancedPrecisionAssemblyLine = registerMetaTileEntity(12001, new MetaTileEntityAdvancedPrecisionAssemblyLine(gtneId("advanced_precision_assembly_line")));
        LGFUSION_REACTOR[0] = registerMetaTileEntity(12002, new MetaTileLateGameEntityFusionReactor(gtneId("fusion_reactor.uhv"), UHV));
        LGFUSION_REACTOR[1] = registerMetaTileEntity(12003, new MetaTileLateGameEntityFusionReactor(gtneId("fusion_reactor.uev"), UEV));
        HIGH_DIMENSIONAL_STRUCTURE_CONSTRUCTION_TESSERACT = registerMetaTileEntity(12004, new MetaTileEntityHighDimensionalStructureConstructionTesseract(gtneId("high_dimensional_structure_construction_tesseract")));
        AdvancedDistillationTower = registerMetaTileEntity(12005, new MetaTileEntityAdvancedDistilleryTower(gtneId("advanced_distillation_tower")));
        SiliconMonocrystallineRefiningFurnace = registerMetaTileEntity(12006, new MetaTileEntitySiliconMonocrystallineRefiningFurnace(gtneId("silicon_monocrystalline_refining_furnace")));
        COSMIC_RAY_DETECTOR = registerMetaTileEntity(12007, new MetaTileEntityCosmicLayDetector(gtneId("cosmic_ray_detector")));
        SUPER_DEEP_MINER = registerMetaTileEntity(12008, new MetaTileEntitySuperDeepMiner(gtneId("super_deep_miner"), SUPER_DEEP_MINER_RECIPES, false));


        //HighTierEnergyHatch 13000~13031
        if (ConfigHolder.metaTileEntityOptions.HigherTierEnergyHatch) {
            GTNE_ENERGY_INPUT_HATCH[0] = registerMetaTileEntity(13000, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input." + GTValues.VN[MAX]), 14, 2, false));
            GTNE_ENERGY_OUTPUT_HATCH[0] = registerMetaTileEntity(13001, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output." + GTValues.VN[MAX]), 14, 2, true));
            GTNE_ENERGY_INPUT_HATCH_4A[0] = registerMetaTileEntity(13002, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[UEV]), 10, 4, false));
            GTNE_ENERGY_INPUT_HATCH_4A[1] = registerMetaTileEntity(13003, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[UIV]), 11, 4, false));
            GTNE_ENERGY_INPUT_HATCH_4A[2] = registerMetaTileEntity(13004, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[UXV]), 12, 4, false));
            GTNE_ENERGY_INPUT_HATCH_4A[3] = registerMetaTileEntity(13005, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[OpV]), 13, 4, false));
            GTNE_ENERGY_INPUT_HATCH_4A[4] = registerMetaTileEntity(13006, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_4a." + GTValues.VN[MAX]), 14, 4, false));
            GTNE_ENERGY_OUTPUT_HATCH_4A[0] = registerMetaTileEntity(13007, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[UEV]), 10, 4, true));
            GTNE_ENERGY_OUTPUT_HATCH_4A[1] = registerMetaTileEntity(13008, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[UIV]), 11, 4, true));
            GTNE_ENERGY_OUTPUT_HATCH_4A[2] = registerMetaTileEntity(13009, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[UXV]), 12, 4, true));
            GTNE_ENERGY_OUTPUT_HATCH_4A[3] = registerMetaTileEntity(13010, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[OpV]), 13, 4, true));
            GTNE_ENERGY_OUTPUT_HATCH_4A[4] = registerMetaTileEntity(13011, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_4a." + GTValues.VN[MAX]), 14, 4, true));
            GTNE_ENERGY_INPUT_HATCH_16A[0] = registerMetaTileEntity(13012, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[UEV]), 10, 16, false));
            GTNE_ENERGY_INPUT_HATCH_16A[1] = registerMetaTileEntity(13013, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[UIV]), 11, 16, false));
            GTNE_ENERGY_INPUT_HATCH_16A[2] = registerMetaTileEntity(13014, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[UXV]), 12, 16, false));
            GTNE_ENERGY_INPUT_HATCH_16A[3] = registerMetaTileEntity(13015, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[OpV]), 13, 16, false));
            GTNE_ENERGY_INPUT_HATCH_16A[4] = registerMetaTileEntity(13016, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_16a." + GTValues.VN[MAX]), 14, 16, false));
            GTNE_ENERGY_OUTPUT_HATCH_16A[0] = registerMetaTileEntity(13017, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[UEV]), 10, 16, true));
            GTNE_ENERGY_OUTPUT_HATCH_16A[1] = registerMetaTileEntity(13018, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[UIV]), 11, 16, true));
            GTNE_ENERGY_OUTPUT_HATCH_16A[2] = registerMetaTileEntity(13019, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[UXV]), 12, 16, true));
            GTNE_ENERGY_OUTPUT_HATCH_16A[3] = registerMetaTileEntity(13020, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[OpV]), 13, 16, true));
            GTNE_ENERGY_OUTPUT_HATCH_16A[4] = registerMetaTileEntity(13021, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_16a." + GTValues.VN[MAX]), 14, 16, true));
            GTNE_ENERGY_INPUT_HATCH_32A[0] = registerMetaTileEntity(13022, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[UEV]), 10, 32, false));
            GTNE_ENERGY_INPUT_HATCH_32A[1] = registerMetaTileEntity(13023, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[UIV]), 11, 32, false));
            GTNE_ENERGY_INPUT_HATCH_32A[2] = registerMetaTileEntity(13024, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[UXV]), 12, 32, false));
            GTNE_ENERGY_INPUT_HATCH_32A[3] = registerMetaTileEntity(13025, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[OpV]), 13, 32, false));
            GTNE_ENERGY_INPUT_HATCH_32A[4] = registerMetaTileEntity(13026, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.input_32a." + GTValues.VN[MAX]), 14, 32, false));
            GTNE_ENERGY_OUTPUT_HATCH_32A[0] = registerMetaTileEntity(13027, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[UEV]), 10, 32, true));
            GTNE_ENERGY_OUTPUT_HATCH_32A[1] = registerMetaTileEntity(13028, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[UIV]), 11, 32, true));
            GTNE_ENERGY_OUTPUT_HATCH_32A[2] = registerMetaTileEntity(13029, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[UXV]), 12, 32, true));
            GTNE_ENERGY_OUTPUT_HATCH_32A[3] = registerMetaTileEntity(13030, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[OpV]), 13, 32, true));
            GTNE_ENERGY_OUTPUT_HATCH_32A[4] = registerMetaTileEntity(13031, new MetaTileEntityEnergyHatch(gtneId("energy_hatch.output_32a." + GTValues.VN[MAX]), 14, 32, true));
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
