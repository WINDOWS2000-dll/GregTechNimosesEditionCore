package gtne.api.unification.material.info;

import gregtech.api.unification.material.info.MaterialIconSet;
import gtne.api.items.IItemRenderer;
import gtne.api.items.IItemRendererManager;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MaterialIconSetWithRenderer extends MaterialIconSet implements IItemRenderer, IItemRendererManager {

    private IItemRendererManager rendererManager;

    public MaterialIconSetWithRenderer(@NotNull String name,
                                       IItemRendererManager rendererManager) {
        super(name);
        this.rendererManager = rendererManager;
    }

    public MaterialIconSetWithRenderer(@NotNull String name,
                                       @Nullable MaterialIconSet parentIconSet,
                                       IItemRendererManager rendererManager) {
        super(name, parentIconSet);
        this.rendererManager = rendererManager;
    }

    public MaterialIconSetWithRenderer(@NotNull String name,
                                       @Nullable MaterialIconSet parentIconSet,
                                       boolean isRootIconSet,
                                       IItemRendererManager rendererManager) {
        super(name, parentIconSet, isRootIconSet);
        this.rendererManager = rendererManager;
    }

    @Override
    public IItemRendererManager getRendererManager() {
        return rendererManager;
    }

    @Override
    public void onRendererRegistry(ResourceLocation location) {
        rendererManager.onRendererRegistry(location);
    }
}
