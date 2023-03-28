package gtne.api.pattern;

import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gtne.api.GTNEAPI;
import gtne.api.interfaces.block.IComputerCasingBlockStats;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Supplier;

public class GTNETracebilityPredicate extends TraceabilityPredicate {

    public static Supplier<TraceabilityPredicate> COMPUTER_CASING = () -> (new TraceabilityPredicate((blockWorldState) -> {
        IBlockState blockState = blockWorldState.getBlockState();
        if (GTNEAPI.COMPUTER_CASING.containsKey(blockState)) {
            IComputerCasingBlockStats stats = GTNEAPI.COMPUTER_CASING.get(blockState);
            Object currentComputer = blockWorldState.getMatchContext().getOrPut("CoilType", stats);
            if (!currentComputer.equals(stats)) {
                blockWorldState.setError(new PatternStringError("gregtech.multiblock.pattern.error.coils"));
                return false;
            } else {
                blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList())
                        .add(blockWorldState.getPos());
                return true;
            }
        } else {
            return false;
        }
    }, () -> GTNEAPI.COMPUTER_CASING.entrySet().stream().sorted(Comparator.comparingInt((entry) ->
            entry.getValue().getTier())).map((entry) ->
            new BlockInfo(entry.getKey(), null)).toArray((x$0) ->
            new BlockInfo[x$0]))).addTooltips("gregtech.multiblock.pattern.error.coils");
}
