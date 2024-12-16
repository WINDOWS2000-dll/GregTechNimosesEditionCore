package gtne.common.item.behaviors.render;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import gtne.api.items.IHaloRenderBehavior;
import gtne.client.renderer.HaloItemRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

public class HaloRenderItemBehavior implements IHaloRenderBehavior {

    private final int haloSize;

    private final int haloColor;

    private final Supplier supplier;

    private final boolean drawPulse;

    public HaloRenderItemBehavior(int haloSize, int haloColor,
                                  Supplier supplier, boolean drawPulse) {
        this.haloSize   = haloSize;
        this.haloColor = haloColor;
        this.supplier   = supplier;
        this.drawPulse  = drawPulse;
    }

    @Override
    public boolean isDrawHalo() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getHaloTexture() {
        return (TextureAtlasSprite) supplier.get();
    }

    @Override
    public int getHaloColor() {
        return haloColor;
    }

    @Override
    public int getHaloSize() {
        return haloSize;
    }

    @Override
    public boolean isDrawPulse() {
        return drawPulse;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onRendererRegistry(ResourceLocation location) {
        ModelRegistryHelper.register(new ModelResourceLocation(location, "inventory"), new HaloItemRenderer(TransformUtils.DEFAULT_ITEM, modelRegistry ->
                modelRegistry.getObject(new ModelResourceLocation(location, "inventory"))));
    }



}
