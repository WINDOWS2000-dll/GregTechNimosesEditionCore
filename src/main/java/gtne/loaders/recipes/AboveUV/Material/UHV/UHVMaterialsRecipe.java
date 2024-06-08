package gtne.loaders.recipes.AboveUV.Material.UHV;

import gregtech.api.recipes.RecipeMaps;

import static gregtech.api.unification.material.Materials.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.fluids.store.FluidStorageKeys.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gtne.common.item.GTNEMetaItems.*;

public class UHVMaterialsRecipe {

    public static void init() {
        CosmicNeutronium();
    }

    public static void CosmicNeutronium() {
        //1
        RecipeMaps.VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(NeutronMixture.getFluid(GAS, 600_000))
                .fluidInputs(Helium.getFluid(LIQUID, 120_000))
                .output(dustTiny, Naquadria, 1)
                .fluidOutputs(NeutronMixture.getFluid(480_000))
                .EUt(1_600_000)
                .duration(3000)
                .buildAndRegister();

        //2
        RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(NeutronMixture.getFluid(960_000))
                .notConsumable(NEUTRON_CONCENTRATOR)
                .fluidOutputs(NeutronLiquid.getFluid(LIQUID, 600_000))
                .fluidOutputs(Helium.getFluid(LIQUID, 120_000))
                .fluidOutputs(Hydrogen.getFluid(LIQUID, 120_000))
                .fluidOutputs(Xenon.getFluid(LIQUID, 120_000))
                .EUt(1_600_000)
                .duration(4000)
                .buildAndRegister();

        //3
        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(NeutronLiquid.getFluid(300_000))
                .fluidInputs(Helium.getFluid(LIQUID, 2_000))
                .notConsumable(NEUTRON_CONCENTRATOR)
                .fluidOutputs(EnrichedNeutronLiquid.getFluid(10_000))
                .fluidOutputs(Helium.getFluid(PLASMA, 500))
                .fluidOutputs(Helium.getFluid(GAS, 1500))
                .EUt(2_000_000)
                .duration(2000)
                .buildAndRegister();

        //4
        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(EnrichedNeutronLiquid.getFluid(288))
                .fluidInputs(Neutronium.getFluid(576))
                .fluidOutputs(CosmicNeutronium.getFluid(288))
                .EUToStart(630_000_000)
                .duration(600)
                .EUt(256_000)
                .buildAndRegister();


    }

}
