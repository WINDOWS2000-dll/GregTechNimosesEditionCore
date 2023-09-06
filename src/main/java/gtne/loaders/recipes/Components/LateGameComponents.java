package gtne.loaders.recipes.Components;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;

public class LateGameComponents {

    //ToDo Late IVの各種コンポーネントレシピのZenScriptからの移行
    public static void init() {
        if (ConfigHolder.recipeoption.Harder_LateGame_Components_Recipe) {
            RemoveLuVComponentsRecipe();
            LuVComponents();
        }
    }

    private static void RemoveLuVComponentsRecipe() {
        //Motor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, SamariumMagnetic, 1), OreDictUnifier.get(stickLong, HSSS, 2), OreDictUnifier.get(ring, HSSS, 2), OreDictUnifier.get(round, HSSS, 4), OreDictUnifier.get(wireFine, Ruridit, 64), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250)});
        //Pump
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_LuV.getStackForm(1), OreDictUnifier.get(pipeSmallFluid, NiobiumTitanium, 1), OreDictUnifier.get(plate, HSSS, 2), OreDictUnifier.get(screw, HSSS, 8), OreDictUnifier.get(ring, SiliconeRubber, 4), OreDictUnifier.get(rotor, HSSS, 1), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250)});
        //Conveyor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_LuV.getStackForm(2), OreDictUnifier.get(plate, HSSS, 2), OreDictUnifier.get(ring, HSSS, 4), OreDictUnifier.get(round, HSSS, 16), OreDictUnifier.get(screw, HSSS, 4), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250), StyreneButadieneRubber.getFluid(1152)});
        //Piston
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{ELECTRIC_MOTOR_LuV.getStackForm(1), OreDictUnifier.get(plate, HSSS, 4), OreDictUnifier.get(ring, HSSS, 4), OreDictUnifier.get(round, HSSS, 16), OreDictUnifier.get(stick, HSSS, 4), OreDictUnifier.get(gear, HSSS, 1), OreDictUnifier.get(gearSmall, HSSS, 2), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)}, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250)});
        //Robot Arm
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, HSSS, 4), OreDictUnifier.get(gear, HSSS, 1), OreDictUnifier.get(gearSmall, HSSS, 3), ELECTRIC_MOTOR_LuV.getStackForm(2), ELECTRIC_PISTON_LUV.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV, 2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.EV, 4), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(576), Lubricant.getFluid(250)});
        //Field Generator
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, HSSS, 1), OreDictUnifier.get(plate, HSSS, 6), QUANTUM_STAR.getStackForm(1), EMITTER_LuV.getStackForm(2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 2), OreDictUnifier.get(wireFine, IndiumTinBariumTitaniumCuprate, 64), OreDictUnifier.get(wireFine, IndiumTinBariumTitaniumCuprate, 64), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(576)});
        //Emitter
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, HSSS, 1), ELECTRIC_MOTOR_LuV.getStackForm(1), OreDictUnifier.get(stickLong, Ruridit, 4), QUANTUM_STAR.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 2), OreDictUnifier.get(foil, Palladium, 64), OreDictUnifier.get(foil, Palladium, 32), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(288)});
        //Sensor
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, HSSS, 1), ELECTRIC_MOTOR_LuV.getStackForm(1), OreDictUnifier.get(plate, Ruridit, 4), QUANTUM_STAR.getStackForm(1), OreDictUnifier.get(circuit, MarkerMaterials.Tier.LuV, 2), OreDictUnifier.get(foil, Palladium, 64), OreDictUnifier.get(foil, Palladium, 32), OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)}, new FluidStack[]{SolderingAlloy.getFluid(288)});
    }

    private static void LuVComponents() {

        //Motor
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 1)
                .input(stickLong, HSSS, 2)
                .input(ring, HSSS, 2)
                .input(round, HSSS, 4)
                .input(wireFine, Ruridit, 64)
                .input(wireFine, Ruridit, 64)
                .input(cableGtSingle, NiobiumTitanium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .fluidInputs(Lubricant.getFluid(250))
                .output(ELECTRIC_MOTOR_LuV, 1)
                .research(b -> b
                        .researchStack(ELECTRIC_MOTOR_IV.getStackForm())
                        .EUt(1920)
                        .duration(6000))
                .EUt(8000).duration(600)
                .buildAndRegister();


    }


}
