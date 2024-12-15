package gtne.client;

import gtne.client.renderer.utils.shaderUtils;
import gtne.common.CommonProxy;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import gtne.common.Block.GTNEMetaBlock;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        GTNETextures.preInit();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GTNEMetaBlock.registerItemModels();
    }

    public void preLoad() {
        super.preLoad();
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        shaderUtils.initShaders();
    }

}
