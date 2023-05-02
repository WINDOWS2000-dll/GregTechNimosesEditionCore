package gtne.common;

import gregtech.api.GregTechAPI;
import gregtech.api.block.VariantItemBlock;
import gtne.GTNEValues;
import gtne.common.item.GTNEMetaItems;
import gtne.common.metatileentities.GTNEMetaTileEntities;
import gtne.loaders.recipes.ChemicalChains.Chemical;
import gtne.loaders.recipes.ChemicalChains.PlatLines;
import gtne.loaders.recipes.ChemicalChains.SiliconTech;
import gtne.loaders.recipes.ChemicalChains.WaterLine;
import gtne.loaders.recipes.DragonForgeRecipeLoader;
import gtne.loaders.recipes.MultiBlock.Advanced_Precision_Assembly_Line;
import gtne.loaders.recipes.MultiBlock.Assembly_Line_Recipe;
import gtne.loaders.recipes.MultiBlock.EBFCoils;
import gtne.loaders.recipes.SingleBlocks.ComponentsAssembler;
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

import static gtne.common.Block.GTNEMetaBlock.*;

@Mod.EventBusSubscriber(modid = GTNEValues.MODID)
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        GTNELog.logger.info("Registering Items...");
        GTNEMetaItems.init();
        GTNELog.logger.info("Registering MetaTileEntities...");
        GTNEMetaTileEntities.init();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        GTNELog.logger.info("Registering Blocks...");
        event.getRegistry().register(GTNE_BLOCK_METAL_CASING);
        event.getRegistry().register(BLOCK_GTNE_WIRE_COIL);
        event.getRegistry().register(GTNE_GLASSES);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GTNELog.logger.info("Registering BlockItem....");
        event.getRegistry().register(createItemBlock(GTNE_BLOCK_METAL_CASING, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(BLOCK_GTNE_WIRE_COIL, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(GTNE_GLASSES, VariantItemBlock::new));
        DragonForgeRecipeLoader.preInit();
    }

    private static <T extends Block>  ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterial(GregTechAPI.MaterialEvent event) {
        GTNELog.logger.info("Registering Materials...");
        GTNEMaterials.init();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GTNELog.logger.info("Registering Recipes...");
        //常時読みこみ
        Assembly_Line_Recipe.init();
        Advanced_Precision_Assembly_Line.init();
        Chemical.init();
        //コンフィグ有効時のみ読み込み
        if (ConfigHolder.recipeoption.Components_Assembler) {
            ComponentsAssembler.init();
            GTNELog.logger.info("Registering ComponentsAssembler...");
        }
        if (ConfigHolder.recipeoption.Harder_Wire_Coil_Recipe) {
            EBFCoils.init();
            GTNELog.logger.info("Registering EBFCoils...");
        }
        if (ConfigHolder.recipeoption.GTNHPlatLine) {
            PlatLines.init();
            GTNELog.logger.info("Registering PlatLines...");
        }
        if (ConfigHolder.recipeoption.GTNHSiliconLine) {
            SiliconTech.init();
            GTNELog.logger.info("Registering SiliconTech...");
        }
        if (ConfigHolder.recipeoption.Harder_Water_Recipe) {
            WaterLine.init();
            GTNELog.logger.info("Registering WaterLine...");
        }
    }
}
