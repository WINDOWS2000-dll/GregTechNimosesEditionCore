package gtne.loaders.recipes.MultiBlock;

import com.google.common.graph.Graph;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.*;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.*;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.electric.MetaTileEntityBlockBreaker;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityAssemblyLine;
import gtne.api.recipes.GTNERecipeMaps;
import gtne.common.Block.GTNEBlockMetalCasing;
import gtne.common.ConfigHolder;
import gtne.common.metatileentities.GTNEMetaTileEntities;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import cofh.thermalfoundation.init.TFFluids;
import scala.collection.script.End;

import javax.annotation.Nonnull;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.ASSEMBLY_LINE;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gtne.common.Block.GTNEBlockMetalCasing.MetalCasingType.*;
import static gtne.common.Block.GTNEMetaBlock.*;

public class Assembly_Line_Recipe {

    public static void init() {
        APALCasingRecipe();
    }

    private static void APALCasingRecipe() {

        //APAL Recipes
        //APAL Casing
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Europium, 4)
                .input(plate, Osmiridium, 32)
                .input(VOLTAGE_COIL_IV, 8)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(gear, Tungsten, 4)
                .input(CONVEYOR_MODULE_IV, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(pipeTinyFluid, StainlessSteel, 16)
                .input(cableGtSingle, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Lubricant.getFluid(4000))
                .fluidInputs(Polybenzimidazole.getFluid(1440))
                .outputs(GTNE_BLOCK_METAL_CASING.getItemVariant(ADVANCEDPRECISIONASSEMBLYLINECASING, 4))
                .stationResearch(b -> b
                        .researchStack(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.ADVANCED_COMPUTER_CASING))
                        .CWUt(32, 2400000)
                        .EUt(VA[ZPM]))
                .EUt(262144).duration(1600)
                .buildAndRegister();

        //APAL Filter Casing
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 4)
                .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(BlockCleanroomCasing.CasingType.FILTER_CASING, 2))
                .input(BLACKLIGHT, 8)
                .input(EMITTER_ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(rotor, HSSS, 4)
                .input(VOLTAGE_COIL_ZPM, 16)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(cableGtSingle, VanadiumGallium, 4)
                .input(gemExquisite, Emerald, 16)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Lubricant.getFluid(4000))
                .fluidInputs(Polybenzimidazole.getFluid(2880))
                .fluidInputs(Glass.getFluid(14400))
                .outputs(GTNE_BLOCK_METAL_CASING.getItemVariant(ADVANCEDPRECISIONASSEMBLYLINEFILTER, 4))
                .EUt(262144).duration(1600)
                .buildAndRegister();

        //APAL Ctrl Casing
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, IncoloyMA956, 4)
                .inputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ASSEMBLY_CONTROL, 4))
                .input(SENSOR_ZPM, 8)
                .input(EMITTER_ZPM, 8)
                .input(ELECTRIC_MOTOR_ZPM, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(NEURO_PROCESSOR, 4)
                .input(cableGtSingle, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Lubricant.getFluid(4000))
                .fluidInputs(Polybenzimidazole.getFluid(2880))
                .fluidInputs(Americium.getFluid(1152))
                .outputs(GTNE_BLOCK_METAL_CASING.getItemVariant(ADVANCEDPRECISIONASSEMBLYLINECONTROL, 4))
                .EUt(262144).duration(2000)
                .buildAndRegister();

        //APAL
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HastelloyC276, 4)
                .inputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ASSEMBLY_LINE_CASING, 4))
                .input(ROBOT_ARM_ZPM, 8)
                .input(gear, Duranium, 16)
                .input(gearSmall, HSSS, 24)
                .input(CONVEYOR_MODULE_ZPM, 8)
                .input(SENSOR_ZPM, 4)
                .input(EMITTER_ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 8)
                .input(circuit, MarkerMaterials.Tier.UV)
                .input(circuit, MarkerMaterials.Tier.ZPM)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(NEURO_PROCESSOR, 8)
                .input(cableGtSingle, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Lubricant.getFluid(4000))
                .fluidInputs(Polybenzimidazole.getFluid(2880))
                .fluidInputs(UraniumRhodiumDinaquadide.getFluid(1440))
                .outputs(GTNE_BLOCK_METAL_CASING.getItemVariant(ADVANCEDPRECISIONASSEMBLYLINE, 4))
                .EUt(262144).duration(2400)
                .buildAndRegister();

        //APAL Controller
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UV))
                .input(frameGt, NaquadahAlloy, 4)
                .inputs(GTNE_BLOCK_METAL_CASING.getItemVariant(ADVANCEDPRECISIONASSEMBLYLINECONTROL, 4))
                .inputs(GTNE_BLOCK_METAL_CASING.getItemVariant(ADVANCEDPRECISIONASSEMBLYLINE, 4))
                .inputs(ASSEMBLY_LINE.getStackForm(4))
                .inputs(MetaTileEntities.ASSEMBLER[ZPM].getStackForm(32))
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 8)
                .input(TOOL_DATA_ORB, 32)
                .input(ROBOT_ARM_ZPM, 64)
                .input(ELECTRIC_PUMP_ZPM, 64)
                .input(FIELD_GENERATOR_ZPM, 32)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(VOLTAGE_COIL_UV, 16)
                .inputs(GCYMMetaTileEntities.TIERED_HATCH[UV].getStackForm(2))
                .input(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Lubricant.getFluid(4000))
                .fluidInputs(Polybenzimidazole.getFluid(2880))
                .fluidInputs(UraniumRhodiumDinaquadide.getFluid(1440))
                .outputs(GTNEMetaTileEntities.AdvancedPrecisionAssemblyLine.getStackForm(1))
                .stationResearch(b -> b
                        .researchStack(ASSEMBLY_LINE.getStackForm())
                        .CWUt(64, 20_000_000)
                        .EUt(524288))
                .EUt(524288).duration(4800)
                .buildAndRegister();

    }
}
