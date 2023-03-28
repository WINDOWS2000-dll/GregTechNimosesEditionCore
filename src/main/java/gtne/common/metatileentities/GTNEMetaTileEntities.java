package gtne.common.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.client.GTNETextures;
import gtne.common.metatileentities.multi.MetaTileEntityAdvancedPrecisionAssemblyLine;
import gtne.common.metatileentities.multi.MetaTileEntityProtoTypeSuperComputer;
import net.minecraft.util.ResourceLocation;
import gtne.common.metatileentities.single.MetaTileEntityComponentsAssembler;


import javax.annotation.Nonnull;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;
import static gtne.common.metatileentities.single.MetaTileEntityComponentsAssembler.*;


public class GTNEMetaTileEntities {

    public static MetaTileEntityAdvancedPrecisionAssemblyLine AdvancedPrecisionAssemblyLine;
    public static MetaTileEntityProtoTypeSuperComputer ProtoTypeSuperComputer;

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

        //blocks :11000~
        registerSimpleMetaTileEntity(COMPONENTS_ASSEMBLER, 11000, "components_assembler", GTNERecipeMaps.COMPONENTS_ASSEMBLER, Textures.ASSEMBLER_OVERLAY, true, GTNEMetaTileEntities::gtneId, GTUtility.hvCappedTankSizeFunction);
        //MultiBlockMachines 12000~
        AdvancedPrecisionAssemblyLine = registerMetaTileEntity(12001, new MetaTileEntityAdvancedPrecisionAssemblyLine(gtneId("advanced_precision_assembly_line")));
        ProtoTypeSuperComputer = registerMetaTileEntity(12000, new MetaTileEntityProtoTypeSuperComputer(gtneId("prototype_supercomputer")));
    }

    @Nonnull
    private static ResourceLocation gtneId(String name) {
        return new ResourceLocation("gtnecore", name);
    }
}
