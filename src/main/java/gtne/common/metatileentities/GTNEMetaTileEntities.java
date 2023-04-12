package gtne.common.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.metatileentities.multi.MetaTileEntityAdvancedPrecisionAssemblyLine;
import net.minecraft.util.ResourceLocation;


import javax.annotation.Nonnull;

import static gregtech.api.GTValues.*;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;
import static gtne.common.metatileentities.single.MetaTileEntityComponentsAssembler.*;


public class GTNEMetaTileEntities {

    public static MetaTileEntityAdvancedPrecisionAssemblyLine AdvancedPrecisionAssemblyLine;

    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_INPUT_HATCH = new MetaTileEntityEnergyHatch[1];
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_INPUT_HATCH_4A = new MetaTileEntityEnergyHatch[5]; // EV, IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_INPUT_HATCH_16A = new MetaTileEntityEnergyHatch[5]; // IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_OUTPUT_HATCH = new MetaTileEntityEnergyHatch[1];
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_OUTPUT_HATCH_4A = new MetaTileEntityEnergyHatch[5]; // EV, IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] GTNE_ENERGY_OUTPUT_HATCH_16A = new MetaTileEntityEnergyHatch[5];

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
        registerSimpleMetaTileEntity(COMPONENTS_ASSEMBLER, 11000, "components_assembler", GTNERecipeMaps.COMPONENTS_ASSEMBLER, Textures.ASSEMBLER_OVERLAY, true, GTNEMetaTileEntities::gtneId, GTUtility.hvCappedTankSizeFunction);
        //MultiBlockMachines 12000~12999
        AdvancedPrecisionAssemblyLine = registerMetaTileEntity(12001, new MetaTileEntityAdvancedPrecisionAssemblyLine(gtneId("advanced_precision_assembly_line")));
        //HighTierEnergyHatch 13000~13500
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
    }

    @Nonnull
    private static ResourceLocation gtneId(String name) {
        return new ResourceLocation("gtnecore", name);
    }
}
