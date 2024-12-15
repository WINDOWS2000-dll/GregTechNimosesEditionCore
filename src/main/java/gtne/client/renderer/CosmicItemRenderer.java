package gtne.client.renderer;

import codechicken.lib.model.ItemQuadBakery;
import codechicken.lib.model.bakedmodels.ModelProperties;
import codechicken.lib.model.bakedmodels.PerspectiveAwareBakedModel;
import codechicken.lib.util.ResourceUtils;
import codechicken.lib.util.TransformUtils;
import com.google.common.collect.ImmutableList;
import gregtech.api.items.metaitem.MetaItem;
import gtne.api.items.ICosmicRenderBehavior;
import gtne.api.items.IItemRenderer;
import gtne.client.renderer.handler.WrappedItemRenderer;
import gtne.client.renderer.shader.CosmicShaderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.model.IModelState;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.List;

public class CosmicItemRenderer extends WrappedItemRenderer {

    private static final HashMap<TextureAtlasSprite, IBakedModel> spriteQuadCache = new HashMap<>();

    static {
        ResourceUtils.registerReloadListener(resourceManager -> spriteQuadCache.clear());
    }

    public CosmicItemRenderer(IModelState state, IBakedModel wrapped) {
        super(state, wrapped);

    }

    public CosmicItemRenderer(IModelState state, IWrappedModelGetter getter) {
        super(state, getter);
    }

    /**
     * @param stack          Item stack, should check if it in gregtech's {@link MetaItem} class, otherwise cause crash when it in AE2 Pattern (please see: {@link appeng.items.misc.ItemEncodedPattern}).
     * @param transformType  Transform type, used to check if it in GUI.
     */
    @Override
    public void renderItem(ItemStack stack, ItemCameraTransforms.TransformType transformType) {
        if (stack.getItem() instanceof MetaItem) {
            progressLightLevel(transformType);
            if (transformType == ItemCameraTransforms.TransformType.GUI) {
                renderInventory(stack, renderEntity);
            } else {
                renderSimple(stack, renderEntity);
            }
        }
    }

    protected void renderSimple(ItemStack stack, EntityLivingBase player) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1F, 1F, 1F, 1F);

        World world = player != null ? player.world : null;
        IBakedModel model = wrapped.getOverrides().handleItemState(wrapped, stack, world, player);

        renderModel(model, stack);

        MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>)stack.getItem()).getItem(stack);
        ICosmicRenderBehavior cosmicRenderItems = null;
        if (valueItem != null) {
            cosmicRenderItems = (ICosmicRenderBehavior) ((IItemRenderer) valueItem).getRendererManager();
        }

        if (cosmicRenderItems != null) {
            GlStateManager.disableAlpha();
            GlStateManager.depthFunc(GL11.GL_EQUAL);

            TextureAtlasSprite cosmicSprite = cosmicRenderItems.getMaskTexture(stack, player);

            IBakedModel cosmicModel = spriteQuadCache.computeIfAbsent(cosmicSprite, CosmicItemRenderer::computeModel);

            CosmicShaderHelper.cosmicOpacity = cosmicRenderItems.getMaskOpacity(stack, player);
            CosmicShaderHelper.useShader();

            renderModel(cosmicModel, stack);

            CosmicShaderHelper.releaseShader();

            GlStateManager.depthFunc(GL11.GL_LEQUAL);
            GlStateManager.enableAlpha();
        }
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    protected void renderInventory(ItemStack stack, EntityLivingBase player) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();

        World world = player != null ? player.world : null;
        IBakedModel model = wrapped.getOverrides().handleItemState(wrapped, stack, world, player);
        renderModel(model, stack);

        MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>)stack.getItem()).getItem(stack);
        ICosmicRenderBehavior cosmicRenderItems = null;
        if (valueItem != null) {
            cosmicRenderItems = (ICosmicRenderBehavior) ((IItemRenderer) valueItem).getRendererManager();
        }

        if (cosmicRenderItems != null) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

            GlStateManager.disableAlpha();
            GlStateManager.disableDepth();

            TextureAtlasSprite sprite = cosmicRenderItems.getMaskTexture(stack, player);
            IBakedModel cosmicModel = spriteQuadCache.computeIfAbsent(sprite, CosmicItemRenderer::computeModel);

            GlStateManager.color(1F, 1F, 1F, 1F);
            CosmicShaderHelper.cosmicOpacity = cosmicRenderItems.getMaskOpacity(stack, player);
            CosmicShaderHelper.isInventoryRender = true;
            CosmicShaderHelper.useShader();

            renderModel(cosmicModel, stack);

            CosmicShaderHelper.releaseShader();
            CosmicShaderHelper.isInventoryRender = false;
            GlStateManager.popMatrix();
        }

        GlStateManager.enableAlpha();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableDepth();

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private static IBakedModel computeModel(TextureAtlasSprite sprite) {
        List<BakedQuad> quads = ItemQuadBakery.bakeItem(ImmutableList.of(sprite));
        return new PerspectiveAwareBakedModel(quads, TransformUtils.DEFAULT_ITEM, new ModelProperties(true, false));
    }

    protected void progressLightLevel(ItemCameraTransforms.TransformType transformType) {
        switch (transformType) {
            case GROUND :
                if (entityPos != null) {
                    CosmicShaderHelper.setLightFromLocation(world, entityPos);
                    return;
                }
                break;
            case THIRD_PERSON_LEFT_HAND:
            case THIRD_PERSON_RIGHT_HAND:
            case FIRST_PERSON_LEFT_HAND:
            case FIRST_PERSON_RIGHT_HAND:
            case HEAD:
                if (renderEntity != null) {
                    CosmicShaderHelper.setLightFromLocation(world, entityPos);
                    return;
                }
                break;
            case GUI:
                CosmicShaderHelper.setLightLevel(1.2F);
                return;
            default:
                break;
        }
        CosmicShaderHelper.setLightLevel(1.0F);
    }
}