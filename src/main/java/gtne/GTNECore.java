package gtne;

import gregtech.api.GTValues;
import gtne.api.util.GTNELog;
import gtne.common.Block.BlockGTNEWireCoil;
import gtne.common.CommonProxy;
import gtne.common.Block.GTNEMetaBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import static gregtech.api.GregTechAPI.HEATING_COILS;
import static gtne.GTNEValues.MOD_NAME;
import static gtne.GTNEValues.MOD_NAME_SHORT;

@Mod(
        modid = GTNEValues.MODID,
        name = MOD_NAME,
        acceptedMinecraftVersions = "[1.12,1.13)",
        dependencies = GTValues.MOD_VERSION_DEP,
        version = GTNEValues.MOD_VER)

public class GTNECore {

    public static final String LOG_TAG = '[' + MOD_NAME_SHORT + ']';

    @SidedProxy(modId = "gtnecore", clientSide = "gtne.client.ClientProxy", serverSide = "gtne.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static GTNECore instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);

        GTNELog.logger.info("Loading GregTechNimosesEdition-Core Version" + GTNEVersion.DEP_VERSION);

        /* Start Heating Coil Registration */
        for (BlockGTNEWireCoil.CoilType type : BlockGTNEWireCoil.CoilType.values()) {
            HEATING_COILS.put(GTNEMetaBlock.BLOCK_GTNE_WIRE_COIL.getState(type), type);
        }
        GTNELog.logger.info("Successful Heating Coil Registration!!!!");
        /* End Heating Coil Registration */

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
