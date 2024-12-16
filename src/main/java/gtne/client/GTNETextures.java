package gtne.client;

import codechicken.lib.texture.TextureUtils;
import gregtech.api.gui.resources.TextureArea;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;
import gtne.GTNEValues;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;
import static gtne.Utils.GTNEUtil.gtneID;

@Mod.EventBusSubscriber(modid = GTNEValues.MODID, value = Side.CLIENT)
public class GTNETextures {

    public static SimpleOverlayRenderer ADVANCEDPRECISIONASSEMBLYLINECASING;

    public static SimpleOverlayRenderer DIMENTIONALLY_TRANSCENDENT_CASING;

    public static SimpleOverlayRenderer QUANTIUM_CASING;

    public static OrientedOverlayRenderer COSMIC_RAY_DETECTOR;
    ///////////////////////////////////////////////////////////////////
    public static SimpleOverlayRenderer WIRELESS_ENERGY_HATCH;
    public static SimpleOverlayRenderer WIRELESS_ENERGY_HATCH_4A;
    public static SimpleOverlayRenderer WIRELESS_ENERGY_HATCH_16A;
    public static SimpleOverlayRenderer WIRELESS_ENERGY_HATCH_OFF;
    ///////////////////////////////////////////////////////////////////
    public static SimpleOverlayRenderer ELEVATOR_CASING;
    public static SimpleOverlayRenderer ASSEMBLER_MODULE_OVERLAY;
    public static SimpleOverlayRenderer PUMP_MODULE_OVERLAY;
    public static SimpleOverlayRenderer MINING_MODULE_OVERLAY;

    //Gui Widget
    public static final TextureArea BUTTON_ELEVATOR_EXTENSION = TextureArea.fullImage("textures/gui/widget/space_elevator_extension.png");
    public static final TextureArea BUTTON_ELEVATOR_TELEPORT = TextureArea.fullImage("textures/gui/widget/planet_teleport.png");
    public static final TextureArea BUTTON_ENABLE_STATIC = TextureArea.fullImage("textures/gui/widget/button_power_enable_static.png");
    public static final TextureArea BUTTON_DISABLE_STATIC = TextureArea.fullImage("textures/gui/widget/button_power_disable_static.png");
    public static final TextureArea BUTTON_CYCLE = TextureArea.fullImage("textures/gui/widget/button_cycle.png");
    public static final TextureArea BUTTON_WHITE_BLACK_LIST = TextureArea.fullImage("textures/gui/widget/button_white_black_list.png");

    //Multi Render
    public static TextureAtlasSprite HALO_NOISE;
    public static TextureAtlasSprite HALO;
    public static TextureAtlasSprite[] COSMIC;
    public static TextureAtlasSprite COSMIC_0;
    public static TextureAtlasSprite COSMIC_1;
    public static TextureAtlasSprite COSMIC_2;
    public static TextureAtlasSprite COSMIC_3;
    public static TextureAtlasSprite COSMIC_4;
    public static TextureAtlasSprite COSMIC_5;
    public static TextureAtlasSprite COSMIC_6;
    public static TextureAtlasSprite COSMIC_7;
    public static TextureAtlasSprite COSMIC_8;
    public static TextureAtlasSprite COSMIC_9;



    public static void preInit() {
        ADVANCEDPRECISIONASSEMBLYLINECASING = new SimpleOverlayRenderer("casing/multiblockcasings/advancedprecisionassemblyline/advanced_precision_assembly_line_casing");
        DIMENTIONALLY_TRANSCENDENT_CASING = new SimpleOverlayRenderer("casing/multiblockcasings/highdimentionalstructureconstructiontesseract/dimentionally_transcendent_casing");
        QUANTIUM_CASING = new SimpleOverlayRenderer("casing/metalcasing/quantium_casing");
        //Overlay
        COSMIC_RAY_DETECTOR = new OrientedOverlayRenderer("machines/cosmic_ray_detector");
        //Wireless Overlay
        WIRELESS_ENERGY_HATCH = new SimpleOverlayRenderer("overlay/machine/overlay_wireless_energy");
        WIRELESS_ENERGY_HATCH_4A = new SimpleOverlayRenderer("overlay/machine/overlay_wireless_energy_4a");
        WIRELESS_ENERGY_HATCH_16A = new SimpleOverlayRenderer("overlay/machine/overlay_wireless_energy_16a");
        WIRELESS_ENERGY_HATCH_OFF = new SimpleOverlayRenderer("overlay/machine/overlay_wireless_energy_off");
        //SpaceElevator
        ELEVATOR_CASING = new SimpleOverlayRenderer("casing/multiblockcasings/spaceelevator/elevator_base");
        ASSEMBLER_MODULE_OVERLAY = new SimpleOverlayRenderer("gtnecore:overlay/elevator/assembler");
        PUMP_MODULE_OVERLAY = new SimpleOverlayRenderer("gtnecore:overlay/elevator/pump");
        MINING_MODULE_OVERLAY = new SimpleOverlayRenderer("gtnecore:overlay/elevator/mining");
    }

    public static void register(TextureMap textureMap) {
        HALO = textureMap.registerSprite(gtneID("items/halo"));
        HALO_NOISE = textureMap.registerSprite(gtneID("items/halo_noise"));
        COSMIC_0 = textureMap.registerSprite(gtneID("shader/cosmic_0"));
        COSMIC_1 = textureMap.registerSprite(gtneID("shader/cosmic_1"));
        COSMIC_2 = textureMap.registerSprite(gtneID("shader/cosmic_2"));
        COSMIC_3 = textureMap.registerSprite(gtneID("shader/cosmic_3"));
        COSMIC_4 = textureMap.registerSprite(gtneID("shader/cosmic_4"));
        COSMIC_5 = textureMap.registerSprite(gtneID("shader/cosmic_5"));
        COSMIC_6 = textureMap.registerSprite(gtneID("shader/cosmic_6"));
        COSMIC_7 = textureMap.registerSprite(gtneID("shader/cosmic_7"));
        COSMIC_8 = textureMap.registerSprite(gtneID("shader/cosmic_8"));
        COSMIC_9 = textureMap.registerSprite(gtneID("shader/cosmic_9"));
        COSMIC = new TextureAtlasSprite[] {
                COSMIC_0,
                COSMIC_1,
                COSMIC_2,
                COSMIC_3,
                COSMIC_4,
                COSMIC_5,
                COSMIC_6,
                COSMIC_7,
                COSMIC_8,
                COSMIC_9
        };
    }

    public static void preShaderInit() {
        TextureUtils.addIconRegister(GTNETextures::register);
    }

}
