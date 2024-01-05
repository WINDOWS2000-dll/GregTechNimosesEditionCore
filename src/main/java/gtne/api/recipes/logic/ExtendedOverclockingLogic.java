package gtne.api.recipes.logic;

import gregtech.common.ConfigHolder;

import javax.annotation.Nonnull;

/**
 * A class for holding all the various Extended Overclocking logics
 */
public class ExtendedOverclockingLogic {

    public static final double EXTENDED_STANDARD_OVERCLOCK_VOLTAGE_MULTIPLIER = 4.0D;
    public static final double EXTENDED_STANDARD_OVERCLOCK_DURATION_DIVISOR = ConfigHolder.machines.overclockDivisor;
    public static final double EXTENDED_PERFECT_OVERCLOCK_DURATION_DIVISOR = 4.0D;

    public static final long EXTENDED_COIL_EUT_DISCOUNT_TEMPERATURE = 900L;

    /**
     *
     * @param recipeEUt           the EU/t of the recipe to overclock
     * @param maxVoltage          the maximum voltage the recipe is allowed to be run at
     * @param recipeDuration      the duration of the recipe to overclock
     * @param numberOfOCs         the maximum amount of overclocks allowed
     * @param durationDivisor     the value to divide the duration by for each overclock
     * @param voltageMultiplier   the value to multiply the voltage by for each overclock
     * @return an int array of {OverclockedEUt, OverclockedDuration}
     */
    @Nonnull
    public static long[] extendedOverclockingLogic(long recipeEUt, long maxVoltage, int recipeDuration, long numberOfOCs, double durationDivisor, double voltageMultiplier) {
        double resultDuration = recipeDuration;
        double resultVoltage = recipeEUt;

        for (; numberOfOCs > 0; numberOfOCs--) {
            //make sure that duration is not already as low sa it can do
            if (resultDuration == 1) break;

            //it is important to do voltage first
            // so overclocking voltage does not go above the limit before changing duration

            double potentialVoltage = resultVoltage * voltageMultiplier;
            if (potentialVoltage > maxVoltage) break;

            double potentialDuration = recipeDuration / durationDivisor;
            // do not allow duration to go below one tick
            if (potentialDuration < 1) potentialDuration = 1;
            // update the duration for the next iteration
            resultDuration = potentialDuration;

            // update the voltage for the next iteration after everything else
            // in case duration overclocking would waste energy
            resultVoltage = potentialVoltage;
        }

        return new long[]{
                (long) resultVoltage,
                (int) recipeDuration
        };
    }

    /**
     *
     * @param providedTemp the temperate provided by the machine
     * @param requiredTemp the required temperature of the recipe
     * @return the amount of EU/t discounts to apply
     */
    private static long extendedCalculateAmountCoilEUtDiscount(int providedTemp, int requiredTemp) {
        return Math.max(0, (providedTemp - requiredTemp) / EXTENDED_COIL_EUT_DISCOUNT_TEMPERATURE);
    }

    /**
     *
     * @param recipeEUt the EU/t of the recipe
     * @param providedTemp the temperate provided by the machine
     * @param requiredTemp the required temperature of the recipe
     * @return the discounted EU/t
     */
    public static long extendedApplyCoilDiscount(long recipeEUt, int providedTemp, int requiredTemp) {
        if (requiredTemp < EXTENDED_COIL_EUT_DISCOUNT_TEMPERATURE) return recipeEUt;
        long amountEUtDiscount = extendedCalculateAmountCoilEUtDiscount(providedTemp, requiredTemp);
        if (amountEUtDiscount < 1) return recipeEUt;
        return (long) (recipeEUt * Math.min(1, Math.pow(0.95, amountEUtDiscount)));
    }

    @Nonnull
    public static long[] extendedHeatingCoilOverclockingLogic(long recipeEUt, long maximumVoltage, int recipeDuration, long maxOverclocks, int currentTemp, int recipeRequiredTemp) {
        long amountPerfectOC = extendedCalculateAmountCoilEUtDiscount(currentTemp, recipeRequiredTemp) / 2;

        //Perfect overclock for every 1800k over recipe temperature
        if (amountPerfectOC > 0) {
            // use the normal overclock logic to do perfect OCs up to as many times as calculated
            long[] overclock = extendedOverclockingLogic(recipeEUt, maximumVoltage, recipeDuration, amountPerfectOC, EXTENDED_PERFECT_OVERCLOCK_DURATION_DIVISOR, EXTENDED_STANDARD_OVERCLOCK_VOLTAGE_MULTIPLIER);

            // overclock normally as much as possible after perfects are exhausted
            return extendedOverclockingLogic(overclock[0], maximumVoltage, (int) overclock[1], maxOverclocks - amountPerfectOC, EXTENDED_STANDARD_OVERCLOCK_DURATION_DIVISOR, EXTENDED_STANDARD_OVERCLOCK_VOLTAGE_MULTIPLIER);
        }

        return extendedOverclockingLogic(recipeEUt, maximumVoltage, recipeDuration, maxOverclocks, EXTENDED_STANDARD_OVERCLOCK_DURATION_DIVISOR, EXTENDED_STANDARD_OVERCLOCK_VOLTAGE_MULTIPLIER);
    }
}
