package gtne.api.recipes.RecipeLogic;

import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gtne.api.interfaces.RecipeLogic.IOperationSpeed;
import gtne.api.recipes.recipeproperties.OperationSpeedproperty;
import net.minecraft.util.Tuple;

import javax.annotation.Nonnull;

import static gregtech.api.recipes.logic.OverclockingLogic.heatingCoilOverclockingLogic;

/**
 * RecipeLogic for multiblocks that use temperature for raising speed and lowering energy usage
 * Used with RecipeMaps that run recipes using the {@link TemperatureProperty}
 */
public class ComputerRecipeLogic extends MultiblockRecipeLogic {

    public ComputerRecipeLogic(RecipeMapMultiblockController metaTileEntity) {
        super(metaTileEntity);
    }

    @Override
    protected int[] runOverclockingLogic(@Nonnull IRecipePropertyStorage propertyStorage, int recipeEUt, long maxVoltage, int duration, int amountOC) {
        // apply maintenance penalties
        Tuple<Integer, Double> maintenanceValues = getMaintenanceValues();

        return heatingCoilOverclockingLogic(
                Math.abs(recipeEUt),
                maxVoltage,
                (int) Math.round(duration * maintenanceValues.getSecond()),
                amountOC,
                ((IOperationSpeed) metaTileEntity).getCurrentOperationSpeed(),
                propertyStorage.getRecipePropertyValue(OperationSpeedproperty.getInstance(), 0)
        );
    }


}