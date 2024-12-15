package gtne.api.items;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IHaloRenderBehavior extends IItemRendererManager {

    @SideOnly(Side.CLIENT)
    boolean isDrawHalo();

    @SideOnly(Side.CLIENT)
    TextureAtlasSprite getHaloTexture();

    @SideOnly(Side.CLIENT)
    int getHaloColor();

    @SideOnly(Side.CLIENT)
    int getHaloSize();

    @SideOnly(Side.CLIENT)
    boolean isDrawPulse();

}
