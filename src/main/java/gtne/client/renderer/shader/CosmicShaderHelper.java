package gtne.client.renderer.shader;

import gtne.client.ClientEventHandler;
import gtne.client.renderer.utils.shaderUtils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.opengl.ARBShaderObjects;

public class CosmicShaderHelper {

    public static final ShaderCallback shaderCallback;

    public static float[] lightlevel = new float[3];

    public static boolean isInventoryRender = false;

    public static float cosmicOpacity = 1.0F;

    static {
        shaderCallback = new ShaderCallback() {
            @Override
            public void call(int shader) {
                Minecraft minecraft = Minecraft.getMinecraft();

                float yaw = 0;
                float pitch = 0;
                float scale = 1.0F;

                if (!isInventoryRender) {
                    yaw = (float) ((minecraft.player.rotationYaw * 2 * Math.PI) / 360);
                    pitch = -(float) ((minecraft.player.rotationPitch * 2 * Math.PI) / 360);
                } else {
                    scale = 25.0F;
                }

                int x = ARBShaderObjects.glGetUniformLocationARB(shader, "yaw");
                ARBShaderObjects.glUniform1fARB(x, yaw);

                int z = ARBShaderObjects.glGetUniformLocationARB(shader, "pitch");
                ARBShaderObjects.glUniform1fARB(z, pitch);

                int light = ARBShaderObjects.glGetUniformLocationARB(shader, "lightlevel");
                ARBShaderObjects.glUniform3fARB(light, lightlevel[0], lightlevel[1], lightlevel[2]);

                int lightmix = ARBShaderObjects.glGetUniformLocationARB(shader, "lightmix");
                ARBShaderObjects.glUniform1fARB(lightmix, 0.2F);

                int uvs = ARBShaderObjects.glGetUniformLocationARB(shader, "cosmicuvs");
                ARBShaderObjects.glUniformMatrix2ARB(uvs, false, ClientEventHandler.cosmicUVs);

                int scale_ = ARBShaderObjects.glGetUniformLocationARB(shader, "externalScale");
                ARBShaderObjects.glUniform1fARB(scale_, scale);

                int opacity = ARBShaderObjects.glGetUniformLocationARB(shader, "opacity");
                ARBShaderObjects.glUniform1fARB(opacity, cosmicOpacity);


            }
        };
    }

    public static void useShader() {
        shaderUtils.useShader(shaderUtils.cosmicShader, shaderCallback);
    }

    public static void releaseShader() {
        shaderUtils.releaseShader();
    }

    public static void setLightFromLocation(World world, BlockPos pos) {
        if (world == null) {
            setLightLevel(1.0F);
            return;
        }

        int coord = world.getCombinedLight(pos, 0);

        int[] map = Minecraft.getMinecraft().entityRenderer.lightmapColors;
        if (map == null) {
            setLightLevel(1.0F);
            return;
        }

        int mx = (coord % 65536) / 16;
        int my = (coord / 65536) / 16;

        int lightcolor = map[my * 16 + mx];

        setLightLevel(((lightcolor >> 16) & 0xFF) / 256.0f, ((lightcolor >> 8) & 0xFF) / 256.0f, ((lightcolor) & 0xFF) / 256.0f);

    }

    public static void setLightLevel(float level) {
        setLightLevel(level, level, level);
    }

    public static void setLightLevel(float r, float g, float b) {
        lightlevel[0] = Math.max(0.0f, Math.min(1.0f, r));
        lightlevel[1] = Math.max(0.0f, Math.min(1.0f, g));
        lightlevel[2] = Math.max(0.0f, Math.min(1.0f, b));
    }

}
