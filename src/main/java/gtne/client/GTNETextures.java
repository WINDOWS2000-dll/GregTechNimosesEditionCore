package gtne.client;

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

    public static OrientedOverlayRenderer COSMIC_RAY_DETECTOR;

    public static void preInit() {
        ADVANCEDPRECISIONASSEMBLYLINECASING = new SimpleOverlayRenderer("casing/multiblockcasings/advancedprecisionassemblyline/advanced_precision_assembly_line_casing");
        DIMENTIONALLY_TRANSCENDENT_CASING = new SimpleOverlayRenderer("casing/multiblockcasings/highdimentionalstructureconstructiontesseract/dimentionally_transcendent_casing");
        COSMIC_RAY_DETECTOR = new OrientedOverlayRenderer("machines/cosmic_ray_detector");
    }
}
