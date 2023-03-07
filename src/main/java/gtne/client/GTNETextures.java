package gtne.client;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;

@Mod.EventBusSubscriber(modid = "gtnecore", value = Side.CLIENT)
public class GTNETextures {

    public static SimpleOverlayRenderer ADVANCEDPRECISIONASSEMBLYLINECASING;

    public static void preInit() {
        ADVANCEDPRECISIONASSEMBLYLINECASING = new SimpleOverlayRenderer("advanced_precision_assembly_line_casing");
    }
}
