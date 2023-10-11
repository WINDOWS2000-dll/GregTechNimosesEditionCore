package gtne.loaders.recipes.Adjustment;

import gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.metatileentities.MetaTileEntities;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;
import static gtne.api.unification.material.GTNEMaterials.*;
public class VoltageController {

    public static void init() {
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(plateDense, RhodiumPlatedPalladium, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 16)
                .input(FIELD_GENERATOR_LuV, 16)
                .inputs(MetaTileEntities.ASSEMBLER[LuV].getStackForm())
                .fluidInputs(Indalloy_140.getFluid(576))
                .outputs(GCYMMetaTileEntities.TIERED_HATCH[LuV].getStackForm(1))
                .research(b -> b
                        .researchStack(GCYMMetaTileEntities.TIERED_HATCH[IV].getStackForm())
                        .EUt(30720)
                        .duration(4000))
                .EUt(12000).duration(7200)
                .buildAndRegister();

        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(plateDense, NaquadahAlloy, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 16)
                .input(circuit, MarkerMaterials.Tier.ZPM, 32)
                .input(FIELD_GENERATOR_ZPM, 16)
                .inputs(MetaTileEntities.ASSEMBLER[ZPM].getStackForm())
                .fluidInputs(Indalloy_140.getFluid(2304))
                .outputs(GCYMMetaTileEntities.TIERED_HATCH[ZPM].getStackForm(1))
                .research(b -> b
                        .researchStack(GCYMMetaTileEntities.TIERED_HATCH[LuV].getStackForm())
                        .EUt(12000)
                        .duration(4000)
                        .CWUt(16))
                .EUt(262000).duration(7200)
                .buildAndRegister();

    }

}
