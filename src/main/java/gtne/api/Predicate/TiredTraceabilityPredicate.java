package gtne.api.Predicate;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.pattern.BlockWorldState;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gtne.api.blocks.ITired;
import gtne.api.blocks.ITiredGlasses;
import gtne.common.Block.GTNEGlasses;
import gtne.common.Block.GTNEMetaBlock;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TiredTraceabilityPredicate extends TraceabilityPredicate {

    static {
        MAP_GLASS = new Object2ObjectOpenHashMap<>();

        for (GTNEGlasses.GTNEGlassType type : GTNEGlasses.GTNEGlassType.values()) {
            TiredTraceabilityPredicate.MAP_GLASS.put(GTNEMetaBlock.GTNE_GLASSES.getState(type), type);
        }

        TiredTraceabilityPredicate.MAP_GLASS.put(Blocks.GLASS.getDefaultState(), (ITired) Blocks.GLASS);
        for(int i = 0; i< EnumDyeColor.values().length; i++){
            IBlockState defaultState = Blocks.STAINED_GLASS.getDefaultState();
            TiredTraceabilityPredicate.MAP_GLASS.put(defaultState.cycleProperty(BlockStainedGlass.COLOR), (ITired) Blocks.STAINED_GLASS);
        }
    }

    public static final Object2ObjectOpenHashMap<IBlockState, ITired> MAP_GLASS;

    public static TraceabilityPredicate GLASS = new TiredTraceabilityPredicate(MAP_GLASS,
            Comparator.comparing((s) -> ((ITiredGlasses)MAP_GLASS.get(s)).getGlassTier()),"Glass",null);

    private final Object2ObjectOpenHashMap<IBlockState, ITired> map;
    private final String name;

    private final String errorKey;

    private Supplier<BlockInfo[]> candidatesCache;

    private final Comparator<IBlockState> comparator;

    public TiredTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ITired> map,String name,@Nullable String errorKey){
        this(map,Comparator.comparing((s) -> map.get(s).getName()),name,errorKey);
    }

    public TiredTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ITired> map,Comparator<IBlockState> comparator,String name,@Nullable String errorKey){
        super();
        this.map = map;
        this.name = name;
        if(errorKey == null){
            this.errorKey = "gregtech.multiblock.pattern.error.casing";
        }
        else{
            this.errorKey = errorKey;
        }
        this.common.add(new SimplePredicate(predicate(), candidates()));
        this.comparator = comparator;

    }

    private Predicate<BlockWorldState> predicate(){
        return  (blockWorldState) -> {
            IBlockState blockState = blockWorldState.getBlockState();
            if (map.containsKey(blockState)) {
                ITired stats = map.get(blockState);
                Object tier = stats.getTire();
                Object current = blockWorldState.getMatchContext().getOrPut(name, tier);
                if (!current.equals(tier)) {
                    blockWorldState.setError(new PatternStringError(errorKey));
                    return false;
                } else {
                    blockWorldState.getMatchContext().getOrPut(name+"TiredStats",stats);
                    if(blockState.getBlock() instanceof VariantActiveBlock){
                        (blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>())).add(blockWorldState.getPos());
                    }
                    return true;
                }
            } else {
                return false;
            }
        };
    }

    private Supplier<BlockInfo[]> candidates(){
        if(candidatesCache == null) {
            candidatesCache = () -> map.keySet().stream()
                    .sorted(comparator)
                    .map(type -> new BlockInfo(type, null,map.get(type).getInfo()))
                    .toArray(BlockInfo[]::new);
        }
        return candidatesCache;
    }

}
