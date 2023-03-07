package gtne.common;

import gregtech.api.GregTechAPI;
import gregtech.api.block.VariantItemBlock;
import gtne.common.metatileentities.GTNEMetaTileEntities;
import gtne.common.metatileentities.multi.MetaTileEntityAdvancedPrecisionAssemblyLine;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import gtne.api.util.GTNELog;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.function.Function;
import gtne.api.unification.material.GTNEMaterials;
import static gtne.common.GTNEMetaBlock.*;

@Mod.EventBusSubscriber(modid = "gtnecore")
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        GTNELog.logger.info("Registering MetaTileEntities...");
        GTNEMetaTileEntities.init();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(GTNE_BLOCK_METAL_CASING);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(createItemBlock(GTNE_BLOCK_METAL_CASING, VariantItemBlock::new));
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterial(GregTechAPI.MaterialEvent event) {
        GTNELog.logger.info("Registering Materials...");
        GTNEMaterials.init();
    }
}
