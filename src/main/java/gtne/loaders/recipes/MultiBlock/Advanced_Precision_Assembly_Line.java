package gtne.loaders.recipes.MultiBlock;

import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.metatileentities.MetaTileEntities;
import gtne.api.recipes.GTNERecipeMaps;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ROBOT_ARM_UHV;
import static gregtech.common.items.MetaItems.ROBOT_ARM_UV;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class Advanced_Precision_Assembly_Line {

    public static void init() {
        //Fusion Reactor Mk.3 Test Recipe
        GTNERecipeMaps.ADVANCED_PRECISION_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[ZPM])
                .input(circuit, MarkerMaterials.Tier.UHV, 64)
                .fluidInputs(SolderingAlloy.getFluid(18432))
                .fluidInputs(NaquadahAlloy.getFluid(114514))
                .outputs(MetaTileEntities.FUSION_REACTOR[2].getStackForm())
                .research(b -> b
                        .researchStack(ROBOT_ARM_UHV.getStackForm())
                        .EUt(114514)
                        .CWUt(1024)
                        .duration(114514))
                .duration(600).EUt(VA[UHV])
                .buildAndRegister();
    }
}
