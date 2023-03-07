package gtne;

import gregtech.api.GTValues;
import gtne.api.unification.material.GTNEMaterials;
import gtne.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import codechicken.lib.CodeChickenLib;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "gtnecore",
        acceptedMinecraftVersions = "[1.12,1.13)",
        dependencies = GTValues.MOD_VERSION_DEP)

public class GTNECore {

    @SidedProxy(modId = "gtnecore", clientSide = "gtne.client.ClientProxy", serverSide = "gtne.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static GTNECore instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
