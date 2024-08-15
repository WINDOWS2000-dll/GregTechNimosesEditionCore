package gtne.client;

import gregtech.api.gui.resources.TextureArea;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;
import gtne.GTNEValues;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;

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
}
