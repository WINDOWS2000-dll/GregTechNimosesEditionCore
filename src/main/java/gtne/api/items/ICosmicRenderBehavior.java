package gtne.api.items;

import gtne.api.items.metaitem.stats.renderer.IItemRendererManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public interface ICosmicRenderBehavior extends IItemRendererManager {

    /**
     * コズミックオーバーレイのマスクの指定
     *
     * @param stack コズミックオーバーレイをレンダリングするItemStack
     * @param player コズミックオーバーレイが適応されたアイテムをEntityが保持しているか否か
     *               値がNullの場合はインベントリ内部化地面に落ちているかの判定に使われる
     * @return コズミックオーバーレイのマスク領域
     */
    @SideOnly(Side.CLIENT)
    TextureAtlasSprite getMaskTexture(ItemStack stack, @Nullable EntityLivingBase player);

    /**
     *
     * @param stack コズミックオーバーレイをレンダリングするItemStack
     * @param player コズミックオーバーレイが適応されたアイテムをEntityが保持しているか否か
     *               値がNullの場合はインベントリ内部化地面に落ちているかの判定に使われる
     * @return コズミックオーバーレイの不透明度(Float型)
     */
    @SideOnly(Side.CLIENT)
    float getMaskOpacity(ItemStack stack, @Nullable EntityLivingBase player);

}
