package gtne.api.capabilities;

import gregtech.api.GTValues;
import gtne.api.util.GTNELog;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class WirelessEnergyNetWorkWorldSaveData extends WorldSavedData {

    public static WirelessEnergyNetWorkWorldSaveData INSTANCE;
    public static final String DATA_ID = GTValues.MODID + ".energy_data";
    private static final String NBT_TAG = "WirelessEnergyNBTTag";

    public WirelessEnergyNetWorkWorldSaveData() {
        super("gregtech.energy_data");
    }

    public WirelessEnergyNetWorkWorldSaveData(String name) {
        super(name);
    }

    public static void initializeWirelessEnergy(World world) {
        GlobalVariableStorage.WirelessEnergy.clear();
        MapStorage storage = world.getMapStorage();
        INSTANCE = (WirelessEnergyNetWorkWorldSaveData) storage.getOrLoadData(WirelessEnergyNetWorkWorldSaveData.class, "gregtech.energy_data");
        if (INSTANCE == null) {
            INSTANCE = new WirelessEnergyNetWorkWorldSaveData();
            storage.setData("gregtech.energy_data", INSTANCE);
        }

        INSTANCE.markDirty();
    }

    /*
    Initialize Event
    WirelessEnergyNetWorkWorldSaveData.java -> CommonProxy.java #96
    @SubscribeEvent
    public void registerWorldLoadEvent(WorldEvent.Load event) {
        if (!event.getWorld().isRemote && event.getWorld().provider.getDimension() == 0) {
            init(event.getWorld());
        }
    }

     */

    public void readFromNBT(NBTTagCompound tag) {
        try {
            byte[] byteArray = tag.getByteArray("WirelessEnergyNBTTag");
            InputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object data = objectInputStream.readObject();
            HashMap<Object, BigInteger> hashData = (HashMap) data;
            Iterator energyMap = hashData.entrySet().iterator();

            while (energyMap.hasNext()) {
                Map.Entry<Object, BigInteger> entry = (Map.Entry) energyMap.next();
                GlobalVariableStorage.WirelessEnergy.put(UUID.fromString(entry.getKey().toString()), entry.getValue());
            }
        } catch (ClassNotFoundException | IOException exception) {
            GTNELog.logger.fatal("Loaded WirelessEnergyNBTTag failed.");
        }
    }

    public @NotNull NBTTagCompound writeToNBT(NBTTagCompound tag) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(GlobalVariableStorage.WirelessEnergy);
            objectOutputStream.flush();
            byte[] data = byteArrayOutputStream.toByteArray();
            tag.setByteArray("WirelessEnergyNBTTag", data);
        } catch (IOException exception) {
            GTNELog.logger.fatal("Saved WirelessEnergyNBTTag failed.");
        }
        return tag;
    }

}
