package gtne.client;

import gtne.common.CommonProxy;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import gtne.common.GTNEMetaBlock;
import gtne.common.metatileentities.multi.MetaTileEntityAdvancedPrecisionAssemblyLine;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import gtne.client.GTNETextures;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        GTNETextures.preInit();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GTNEMetaBlock.registerItemModels();
    }

}
