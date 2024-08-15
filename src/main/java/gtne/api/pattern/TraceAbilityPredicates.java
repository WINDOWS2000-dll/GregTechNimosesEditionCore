package gtne.api.pattern;

import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gtne.api.GTNEAPI;
import gtne.api.blocks.IElevatorMotorTier;
import net.minecraft.block.state.IBlockState;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Supplier;

public class TraceAbilityPredicates {

    private static final Supplier<TraceabilityPredicate> ELEVATOR_MOTOR_PREDICATE =
            () ->
                    new TraceabilityPredicate(blockWorldState -> {
                        IBlockState blockState = blockWorldState.getBlockState();
                        if (GTNEAPI.ELEVATOR_MOTORS.containsKey(blockState)) {
                            IElevatorMotorTier tier = GTNEAPI.ELEVATOR_MOTORS.get(blockState);
                            Object casing = blockWorldState.getMatchContext().getOrPut("ElevatorMotorTier", tier);
                            if (!casing.equals(tier)) {
                                blockWorldState.setError(new PatternStringError("gregtech.multiblock.pattern.error.elevator_motor_tier"));
                                return false;
                            }
                            blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
                            return true;
                        }
                        return false;
                    }, () ->
                            GTNEAPI.ELEVATOR_MOTORS.entrySet().stream()
                                    .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                                    .map(entry -> new BlockInfo(entry.getKey(), null))
                                    .toArray(BlockInfo[]::new))
                                    .addTooltips("gtne.multiblock.pattern.error.elevator_motor_tier");

    public static TraceabilityPredicate elevatorMotors() {
        return ELEVATOR_MOTOR_PREDICATE.get();
    }

}
