package gtne.api;

import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gtne.api.interfaces.block.IComputerCasingBlockStats;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.state.IBlockState;

public class GTNEAPI extends GregTechAPI {

    public static final Object2ObjectOpenHashMap<IBlockState, IComputerCasingBlockStats> COMPUTER_CASING = new Object2ObjectOpenHashMap();

}
