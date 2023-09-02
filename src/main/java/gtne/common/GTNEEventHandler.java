package gtne.common;

import gregtech.api.unification.material.event.MaterialEvent;
import gtne.GTNEValues;
import gtne.api.unification.material.GTNEMaterials;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = GTNEValues.MODID)
public class GTNEEventHandler {

    public GTNEEventHandler() {}

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterialHigh(MaterialEvent event) {
        GTNEMaterials.registerMaterialHigh();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerMaterialLow(MaterialEvent event) {
        GTNEMaterials.registerMaterialLow();
    }

}
