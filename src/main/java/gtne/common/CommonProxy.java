package gtne.common;

import gregtech.api.GTValues;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gtne.GTNEValues;
import gtne.api.capabilities.energy.CapabilityLongEnergy;
import gtne.api.util.VirtualEnergyRegistry;
import gtne.common.item.GTNEMetaItems;
import gtne.common.metatileentities.GTNEMetaTileEntities;
import gtne.loaders.recipes.AboveUV.Material.UHV.UHVMaterialsRecipe;
import gtne.loaders.recipes.Adjustment.NeutroniumFix;
import gtne.loaders.recipes.Adjustment.UVSuperConductorCable;
import gtne.loaders.recipes.Adjustment.VoltageController;
import gtne.loaders.recipes.ChemicalChains.PlatLines;
import gtne.loaders.recipes.ChemicalChains.SiliconTech;
import gtne.loaders.recipes.ChemicalChains.WaterLine;
import gtne.loaders.recipes.Components.LateGameComponents;
import gtne.loaders.recipes.LateGameMachines.ComputationRecipes;
import gtne.loaders.recipes.LateGameMachines.LateGameMachines;
import gtne.loaders.recipes.MultiBlock.AlloyBlastFurnaceRecipe;
import gtne.loaders.recipes.MultiBlock.EBFRecipes;
import gtne.loaders.recipes.MultiBlock.*;
import gtne.loaders.recipes.Other.GTNEWoodRecipeLoader;
import gtne.loaders.recipes.Other.VanillaFix;
import gtne.loaders.recipes.RecipeHandler;
import gtne.loaders.recipes.SingleBlocks.ComponentsAssembler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import gtne.api.util.GTNELog;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.function.Function;

import static gtne.common.Block.GTNEMetaBlock.*;

@Mod.EventBusSubscriber(modid = GTNEValues.MODID)
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        GTNELog.logger.info("Registering Items...");
        GTNEMetaItems.init();
        GTNELog.logger.info("Registering MetaTileEntities...");
        GTNEMetaTileEntities.init();

        CapabilityLongEnergy.register(); 
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        GTNELog.logger.info("Registering Blocks...");
        event.getRegistry().register(GTNE_BLOCK_METAL_CASING);
        GTNELog.logger.info("Registering Metal Casing");
        event.getRegistry().register(BLOCK_GTNE_WIRE_COIL);
        GTNELog.logger.info("Registering Wire Coil");
        event.getRegistry().register(GTNE_GLASSES);
        GTNELog.logger.info("Registering Glasses");
        event.getRegistry().register(DHSCT_CASING);
        GTNELog.logger.info("Registering D-HSCT Casing");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GTNELog.logger.info("Registering BlockItem....");
        event.getRegistry().register(createItemBlock(GTNE_BLOCK_METAL_CASING, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(BLOCK_GTNE_WIRE_COIL, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(GTNE_GLASSES, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(DHSCT_CASING, VariantItemBlock::new));
    }

    @SubscribeEvent
    public static void onWorldLoadEvent(WorldEvent.Load event) {
        GTNELog.logger.info("Virtual Energy Storage Initialize...");
        VirtualEnergyRegistry.initializeStorage(event.getWorld());
        GTNELog.logger.info("Initialize Complete");
    }

    private static <T extends Block>  ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GTNELog.logger.info("Start Recipe Registration");
        //Fusion tierをプロパティに書きこみ

        GTNELog.logger.info("Start Fusion Property Registration");
        FusionEUToStartProperty.registerFusionTier(GTValues.UHV, "(MK4)");
        FusionEUToStartProperty.registerFusionTier(GTValues.UEV, "(MK5)");

        //RecipeHandler読み込み
        GTNELog.logger.info("Start RecipeHandler Registration");
        RecipeHandler.initRecipes();
        RecipeHandler.ChemicalChainInit();
        RecipeHandler.AboveUVInit();

        GTNELog.logger.info("End Recipe Registration");
    }
}
