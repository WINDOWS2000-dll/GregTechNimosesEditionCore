package gtne.loaders.recipes.ChemicalChains;

import gregtech.api.GTValues;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gtne.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gtne.api.unification.material.GTNEMaterials.*;
import static gregtech.api.GTValues.*;

public class PlatLines {

    //レシピの初期化
    public static void init() {
        if (ConfigHolder.recipeoption.GTNHPlatLine) {
            PlatLine_Platinum();
        } else {
            DummyRecipe();
        }
    }

    private static void DummyRecipe() {
        //Fuckin Recipe
        RecipeMaps.WIREMILL_RECIPES.recipeBuilder()
                .input(ingot, Iron, 1)
                .output(ingot, Iron, 1)
                .EUt(GTValues.MAX).duration(2147483647)
                .buildAndRegister();
    }

    private static void PlatLine_Platinum() {
        //GregTechCE: Unofficial純正のPlatinum_PlatLineの削除
        //Platinum Grope Sludgeレシピの削除
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, PlatinumGroupSludge, 6)}, new FluidStack[]{Materials.AquaRegia.getFluid(1200)});
        //Platinum Dust加工レシピ削除
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, OreDictUnifier.get(dust, PlatinumRaw, 3));
        //シェルドナイト分離レシピ削除
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, OreDictUnifier.get(dust, Cooperite, 6));
        //ニッケルからのプラチナ分離ライン削除
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_BATH_RECIPES, new ItemStack[]{OreDictUnifier.get(crushed, Nickel, 1)}, new FluidStack[]{Materials.Mercury.getFluid(100)});
        //GregTech : New Horizons準拠のPlatLine作成
        //Platinum Concentrate抽出(通常)
        //シェルドナイト
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Cooperite, 1)
                .fluidInputs(AquaRegia.getFluid(150))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(150))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();
        //四面銅鉱
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Tetrahedrite, 1)
                .fluidInputs(AquaRegia.getFluid(150))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(150))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();
        //ペントランド鉱
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Pentlandite, 1)
                .fluidInputs(AquaRegia.getFluid(150))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(150))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();
        //黄銅鉱
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Chalcopyrite, 1)
                .fluidInputs(AquaRegia.getFluid(150))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(150))
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();
        //残留物抽出
        //Platinum Metallic Powder
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PLATINUM_METALLIC_POWDER, 1)
                .fluidInputs(AquaRegia.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1000))
                .output(dustTiny, PLATINUM_RESIDUE, 1)
                .EUt(VA[LV]).duration(250)
                .buildAndRegister();
        //9xPlatinum Metallic Powder
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PLATINUM_METALLIC_POWDER, 1)
                .fluidInputs(AquaRegia.getFluid(9000))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(9000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //四面銅鉱(Platinum Metallic Powder)
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Tetrahedrite, 9)
                .input(dust, PLATINUM_METALLIC_POWDER, 9)
                .fluidInputs(AquaRegia.getFluid(10000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(10000))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //ペントランド鉱
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Pentlandite, 9)
                .fluidInputs(AquaRegia.getFluid(1350))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1350))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //四面銅鉱
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Tetrahedrite, 9)
                .fluidInputs(AquaRegia.getFluid(1350))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1350))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //シェルドナイト
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Cooperite, 9)
                .fluidInputs(AquaRegia.getFluid(1350))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1350))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //黄銅鉱
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Chalcopyrite, 9)
                .fluidInputs(AquaRegia.getFluid(1350))
                .circuitMeta(9)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(1350))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //各種鉱石抽出
        //ペントランド鉱
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Pentlandite, 9)
                .input(dust, PLATINUM_METALLIC_POWDER, 9)
                .fluidInputs(AquaRegia.getFluid(10000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(10000))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //黄銅鉱
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Chalcopyrite, 9)
                .input(dust, PLATINUM_METALLIC_POWDER, 9)
                .fluidInputs(AquaRegia.getFluid(10000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(10000))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //シェルドナイト
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(crushedPurified, Cooperite, 9)
                .input(dust, PLATINUM_METALLIC_POWDER, 9)
                .fluidInputs(AquaRegia.getFluid(10000))
                .output(dust, PLATINUM_RESIDUE, 1)
                .fluidOutputs(PLATINUM_CONCENTRATE.getFluid(10000))
                .EUt(VA[LV]).duration(2250)
                .buildAndRegister();
        //Platinum Concentrate処理
        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PLATINUM_CONCENTRATE.getFluid(2000))
                .fluidInputs(AMMONIUM_CHLORIDE.getFluid(400))
                .circuitMeta(1)
                .fluidOutputs(PALLADIUM_ENRICHED_AMMONIA.getFluid(400))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .output(dustTiny, PLATINUM_SALT, 16)
                .output(dustTiny, REPRECIPITATED_PLATINUM, 4)
                .EUt(VA[LV]).duration(1200)
                .buildAndRegister();
        //9xPlatinum Concentrate処理
        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PLATINUM_CONCENTRATE.getFluid(18000))
                .fluidInputs(AMMONIUM_CHLORIDE.getFluid(3600))
                .circuitMeta(1)
                .fluidOutputs(PALLADIUM_ENRICHED_AMMONIA.getFluid(3600))
                .fluidOutputs(NitrogenDioxide.getFluid(9000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(9000))
                .output(dust, PLATINUM_SALT, 16)
                .output(dust, REPRECIPITATED_PLATINUM, 4)
                .EUt(240).duration(1400)
                .buildAndRegister();
        //Platinum Salt処理
        RecipeMaps.SIFTER_RECIPES.recipeBuilder()
                .input(dust, PLATINUM_SALT, 1)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1300, 20)
                .chancedOutput(dust, REFINED_PLATINUM_SALT, 1, 1500, 20)
                .EUt(VA[LV]).duration(600)
                .buildAndRegister();



    }
}
