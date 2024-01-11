package gtne.loaders.recipes.MultiBlock;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gtne.common.Block.BlockGTNEWireCoil;
import gtne.common.Block.GTNEMetaBlock;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gtne.api.unification.material.GTNEMaterials.*;

public class EBFCoils {

    public static void init() {
        if (ConfigHolder.recipeoption.Harder_Wire_Coil_Recipe) {
            RemoveGEuCoilRecipe();
            ADDGTNECoilRecipes();
            if (gregtech.common.ConfigHolder.machines.highTierContent) {
                if (!gregtech.common.ConfigHolder.machines.enableResearch) {
                    HighTierCoils_Not_Research();
                }
                HighTierCoils();
            }
        }
    }

    private static void RemoveGEuCoilRecipe() {
        //Cupronickel
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Cupronickel, 8), OreDictUnifier.get(foil, Bronze, 8)}, new FluidStack[]{TinAlloy.getFluid(L)});
        //Kanthal
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Kanthal, 8), OreDictUnifier.get(foil, Aluminium, 8)}, new FluidStack[]{Copper.getFluid(L)});
        //Nichrome
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Nichrome, 8), OreDictUnifier.get(foil, StainlessSteel, 8)}, new FluidStack[]{Aluminium.getFluid(L)});
        //TungstenSteel
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, TungstenSteel, 8), OreDictUnifier.get(foil, VanadiumSteel, 8)}, new FluidStack[]{Nichrome.getFluid(L)});
        //HSS-G
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, HSSG, 8), OreDictUnifier.get(foil, TungstenCarbide, 8)}, new FluidStack[]{Tungsten.getFluid(L)});
        //Naquadah
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Naquadah, 8), OreDictUnifier.get(foil, Osmium, 8)}, new FluidStack[]{TungstenSteel.getFluid(L)});
        //Trinium
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Trinium, 8), OreDictUnifier.get(foil, NaquadahEnriched, 8)}, new FluidStack[]{Naquadah.getFluid(L)});
        //Tritanium
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Tritanium, 8), OreDictUnifier.get(foil, Naquadria, 8)}, new FluidStack[]{Trinium.getFluid(L)});
    }

    private static void ADDGTNECoilRecipes() {

        int CoilFluidValues = L * 2;

        //Cupronickel
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Cupronickel, 8)
                .input(wireFine, Copper, 16)
                .input(foil, Bronze, 8)
                .fluidInputs(TinAlloy.getFluid(CoilFluidValues))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.CUPRONICKEL, 1))
                .EUt(VA[LV]).duration(600)
                .buildAndRegister();

        //Kanthal
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Kanthal, 8)
                .input(wireFine, AnnealedCopper, 32)
                .input(foil, Aluminium, 8)
                .fluidInputs(Cupronickel.getFluid(CoilFluidValues))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.KANTHAL, 1))
                .EUt(VA[MV]).duration(900)
                .buildAndRegister();

        //Nichrome
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Nichrome, 8)
                .input(wireFine, Aluminium, 16)
                .input(foil, StainlessSteel, 8)
                .fluidInputs(Kanthal.getFluid(CoilFluidValues))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.NICHROME, 1))
                .EUt(VA[HV]).duration(1200)
                .buildAndRegister();

        //TungstenSteel
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, RTMAlloy, 8)
                .input(wireFine, RTMAlloy, 16)
                .input(foil, VanadiumSteel, 8)
                .fluidInputs(Nichrome.getFluid(CoilFluidValues))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.RTM_ALLOY, 1))
                .EUt(VA[EV]).duration(1500)
                .buildAndRegister();

        //HSS-G
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, HSSG, 8)
                .input(wireFine, HSSG, 16)
                .input(foil, TungstenCarbide, 8)
                .fluidInputs(RTMAlloy.getFluid(CoilFluidValues))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.HSS_G, 1))
                .EUt(VA[IV]).duration(1800)
                .buildAndRegister();

        //Naquadah
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Naquadah, 8)
                .input(wireFine, Osmiridium, 16)
                .input(foil, Osmium, 8)
                .fluidInputs(HSSG.getFluid(CoilFluidValues))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.NAQUADAH, 1))
                .EUt(VA[LuV]).duration(2100)
                .buildAndRegister();

        //Trinium
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Trinium, 8)
                .input(wireFine, Europium, 16)
                .input(foil, NaquadahEnriched, 8)
                .fluidInputs(Naquadah.getFluid(CoilFluidValues))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TRINIUM, 1))
                .EUt(VA[ZPM]).duration(2400)
                .buildAndRegister();

        //Tritanium
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Tritanium, 8)
                .input(wireFine, Americium, 16)
                .input(foil, Naquadria, 8)
                .fluidInputs(Trinium.getFluid(CoilFluidValues))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TRITANIUM, 1))
                .EUt(VA[UV]).duration(2700)
                .buildAndRegister();
    }

    private static void HighTierCoils() {

        int HighTierCoilFluidValues = L * 4;

        //Draconium Coil
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(wireGtDouble, Draconium, 8)
                .input(wireFine, Tritanium, 32)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(foil, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .fluidInputs(Tritanium.getFluid(HighTierCoilFluidValues))
                .fluidInputs(SolderingAlloy.getFluid(9126))
                .outputs(GTNEMetaBlock.BLOCK_GTNE_WIRE_COIL.getItemVariant(BlockGTNEWireCoil.CoilType.DRACONIUM, 1))
                .stationResearch(b -> b
                        .researchStack(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TRITANIUM))
                        .EUt(1000000)
                        .CWUt(32, 400000))
                .EUt(VA[UHV]).duration(3300)
                .buildAndRegister();

        //Awakened Draconium Coil
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(wireGtDouble, Awakened_Draconium, 8)
                .input(wireFine, Draconium, 32)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(foil, RutheniumTriniumAmericiumNeutronate, 16)
                .fluidInputs(Draconium.getFluid(HighTierCoilFluidValues))
                .fluidInputs(SolderingAlloy.getFluid(9126))
                .outputs(GTNEMetaBlock.BLOCK_GTNE_WIRE_COIL.getItemVariant(BlockGTNEWireCoil.CoilType.AWAKENEDDRACONIUM, 1))
                .stationResearch(b -> b
                        .researchStack(GTNEMetaBlock.BLOCK_GTNE_WIRE_COIL.getItemVariant(BlockGTNEWireCoil.CoilType.DRACONIUM))
                        .EUt(4000000)
                        .CWUt(128, 2800000))
                .EUt(VA[UEV]).duration(4800)
                .buildAndRegister();


    }

    private static void HighTierCoils_Not_Research() {

        int HighTierCoilFluidValues = L * 4;

        //Draconium Coil
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(wireGtDouble, Draconium, 8)
                .input(wireFine, Tritanium, 32)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(foil, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .fluidInputs(Tritanium.getFluid(HighTierCoilFluidValues))
                .fluidInputs(SolderingAlloy.getFluid(9126))
                .outputs(GTNEMetaBlock.BLOCK_GTNE_WIRE_COIL.getItemVariant(BlockGTNEWireCoil.CoilType.DRACONIUM, 1))
                .EUt(VA[UHV]).duration(3300)
                .buildAndRegister();

        //Awakened Draconium Coil
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(wireGtDouble, Awakened_Draconium, 8)
                .input(wireFine, Draconium, 32)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(foil, RutheniumTriniumAmericiumNeutronate, 16)
                .fluidInputs(Draconium.getFluid(HighTierCoilFluidValues))
                .fluidInputs(SolderingAlloy.getFluid(9126))
                .outputs(GTNEMetaBlock.BLOCK_GTNE_WIRE_COIL.getItemVariant(BlockGTNEWireCoil.CoilType.AWAKENEDDRACONIUM, 1))
                .EUt(VA[UEV]).duration(4800)
                .buildAndRegister();
    }

}
