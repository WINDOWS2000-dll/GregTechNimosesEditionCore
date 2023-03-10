package gtne.api.recipes;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.*;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.recipes.machines.*;
import gregtech.api.sound.GTSounds;
import gregtech.api.unification.material.Materials;
import gtne.api.gui.GTNEGuiTextures;
import net.minecraft.init.SoundEvents;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;
import gtne.api.recipes.machine.RecipeMapAdvancedPrecisionAssemblyLine;
import gtne.common.metatileentities.single.MetaTileEntityComponentsAssembler;

import static gregtech.api.GTValues.*;

public class GTNERecipeMaps {

    @ZenProperty
    public static final RecipeMapAdvancedPrecisionAssemblyLine<SimpleRecipeBuilder> ADVANCED_PRECISION_ASSEMBLY_LINE_RECIPES = (RecipeMapAdvancedPrecisionAssemblyLine<SimpleRecipeBuilder>) new RecipeMapAdvancedPrecisionAssemblyLine<>("advanced_precision_assembly_line", 1, 20, 1, 1, 0, 10, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
            .setSound(GTSounds.ASSEMBLER);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENTS_ASSEMBLER = new RecipeMap<>("components_assembler", 1, 9, 1, 1, 1, 3, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GTNEGuiTextures.PREGRESSBAR_CONPONENTS_ASSEMBLER, MoveType.HORIZONTAL)
            .setSound(GTSounds.ASSEMBLER);
}
