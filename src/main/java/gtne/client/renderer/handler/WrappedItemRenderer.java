package gtne.client.renderer.handler;

import codechicken.lib.model.ModelRegistryHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.common.model.IModelState;

import java.util.LinkedList;
import java.util.List;

public abstract class WrappedItemRenderer extends PerspectiveAwareItemRenderer {

    protected IBakedModel wrapped;

    public WrappedItemRenderer(IModelState state, IBakedModel model) {
        super(state);
        wrapped = model;
    }

    public WrappedItemRenderer(IModelState state, IWrappedModelGetter getter) {
        super(state);
        ModelRegistryHelper.registerPreBakeCallback(modelRegistry -> wrapped = getter.getWrappedModel(modelRegistry));
    }

    public interface IWrappedModelGetter {

        /**
         * This Interface from Avaritia
         * A callback from the model load event to grab the wrapped model.
         *
         * @param modelRegistry Registry
         * @return The wrapped model
         */
        IBakedModel getWrappedModel(IRegistry<ModelResourceLocation, IBakedModel> modelRegistry);

    }

    /**
     * Renders a model basically the same as RenderItem does.
     *
     * @param model The model to render.
     * @param stack The stack being rendered. Used for quad tinting.
     */
    public static void renderModel(IBakedModel model, ItemStack stack) {
        renderModel(model, stack, 1.0F);
    }

    /**
     * Minecraftのレンダリングエンジンのalpha値のOverride用
     *
     * @param model モデルレンダラー
     * @param stack レンダラーの対象スタック、ここではQuad Tintingを使用する
     * @param alphaOverride アルファ値を1.0から0.0に限定的置き換え
     */
    public static void renderModel(IBakedModel model, ItemStack stack, float alphaOverride) {

        ItemColors itemColorProvider = Minecraft.getMinecraft().getItemColors();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(0x07, DefaultVertexFormats.ITEM);
        List<BakedQuad> quads = new LinkedList<>();

        for (EnumFacing facing : EnumFacing.VALUES) {
            quads.addAll(model.getQuads(null, facing, 0));
        }
        quads.addAll(model.getQuads(null, null, 0));

        int alpha = (int) (alphaOverride * 255F) & 0xFF;
        for (BakedQuad quad : quads) {
            int color = -1;

            if (quad.hasTintIndex()) {
                color = itemColorProvider.colorMultiplier(stack, quad.getTintIndex());

                if (EntityRenderer.anaglyphEnable) {
                    color = TextureUtil.anaglyphColor(color);
                }

            }

            color |= (alpha << 24);
            LightUtil.renderQuadColor(buffer, quad, color);
        }

        tessellator.draw();

    }

}
