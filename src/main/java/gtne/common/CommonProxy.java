package gtne.common;

import gregtech.api.GTValues;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gtne.GTNEValues;
import gtne.api.capabilities.energy.CapabilityLongEnergy;
import gtne.common.item.GTNEMetaItems;
import gtne.common.metatileentities.GTNEMetaTileEntities;
import gtne.loaders.recipes.Adjustment.UVSuperConductorCable;
import gtne.loaders.recipes.Adjustment.VoltageController;
import gtne.loaders.recipes.ChemicalChains.Chemical;
import gtne.loaders.recipes.ChemicalChains.PlatLines;
import gtne.loaders.recipes.ChemicalChains.SiliconTech;
import gtne.loaders.recipes.ChemicalChains.WaterLine;
import gtne.loaders.recipes.Components.LateGameComponents;
import gtne.loaders.recipes.LateGameMachines.LateGameMachines;
import gtne.loaders.recipes.Material.AlloyBlastFurnaceRecipe;
import gtne.loaders.recipes.Material.EBFRecipes;
import gtne.loaders.recipes.MultiBlock.*;
import gtne.loaders.recipes.Other.GTNEWoodRecipeLoader;
import gtne.loaders.recipes.Other.VanillaFix;
import gtne.loaders.recipes.SingleBlocks.ComponentsAssembler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import gtne.api.util.GTNELog;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
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

    private static <T extends Block>  ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GTNELog.logger.info("Start Recipe Registration");
        //Fusion tierをプロパティに書きこみ
        FusionEUToStartProperty.registerFusionTier(GTValues.UHV, "(MK4)");
        FusionEUToStartProperty.registerFusionTier(GTValues.UEV, "(MK5)");
        //常時読みこみ
        Assembly_Line_Recipe.init();
        Advanced_Precision_Assembly_Line.init();
        Chemical.init();
        HDSCT_Recipe.init();
        VoltageController.init();
        UVSuperConductorCable.init();
        //各種MOD読み込み時動作
        if (Loader.isModLoaded("twilightforest")) {
            GTNEWoodRecipeLoader.registerRecipes();
            GTNEWoodRecipeLoader.registerUnificationInfo();
        }
        //コンフィグ有効時のみ読み込み
        if (ConfigHolder.recipeoption.Harder_Vanilla_Recipe) {
            VanillaFix.init();
            GTNELog.logger.info("Registering Harder Vanilla Recipes...");
        }
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
        if (ConfigHolder.recipeoption.Harder_Computation_System_Recipe) {
            ComputationRecipes.init();
            GTNELog.logger.info("Registering Harder Computation System Recipe...");
        }
        if (ConfigHolder.recipeoption.Super_HardMode_LateGame) {
            LateGameMachines.init();
            GTNELog.logger.info("Registering LateGameMachineRecipes...");
        }
        if (ConfigHolder.recipeoption.Harder_EBF_Recipe) {
            EBFRecipes.init();
            GTNELog.logger.info("Registering Harder EBF Recipes...");
        }
        if (ConfigHolder.recipeoption.Harder_LateGame_Components_Recipe && ConfigHolder.recipeoption.Components_Assembler) {
            LateGameComponents.init();
            AlloyBlastFurnaceRecipe.init();
            GTNELog.logger.info("Registering Harder LateGame Components Recipes...");
        }
        GTNELog.logger.info("End Recipe Registration");
    }
}
