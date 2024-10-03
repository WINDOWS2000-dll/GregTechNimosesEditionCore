package gtne.api.capabilities;

import gtne.api.util.GTNELog;

import java.math.BigInteger;
import java.util.UUID;

public class WirelessEnergyNetWorkManager {

    private WirelessEnergyNetWorkManager() {
        /**/
    }

    public static void strongCheckOrAddUser(UUID uuid) {
        if (!GlobalVariableStorage.WirelessEnergy.containsKey(uuid)) {
            GlobalVariableStorage.WirelessEnergy.put(uuid, BigInteger.ZERO);
        }
    }

    public static boolean addEUToWirelessEnergyNetWork(UUID uuid, BigInteger energy) {
        try {
            WirelessEnergyNetWorkWorldSaveData.INSTANCE.markDirty();
        } catch (Exception exception) {
            /**/
        }

        BigInteger totalEnergy = (BigInteger) GlobalVariableStorage.WirelessEnergy.getOrDefault(uuid, BigInteger.ZERO);
        totalEnergy = totalEnergy.add(energy);
        if (totalEnergy.signum() >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean addEUToWirelessEnergyNetWork(UUID uuid, long energy) {
        return addEUToWirelessEnergyNetWork(uuid, BigInteger.valueOf(energy));
    }

    public static boolean addEUToWirelessEnergyNetWork(UUID uuid, int energy) {
        return addEUToWirelessEnergyNetWork(uuid, BigInteger.valueOf((long) energy));
    }

    public static BigInteger getUserEU(UUID uuid) {
        return (BigInteger) GlobalVariableStorage.WirelessEnergy.getOrDefault(uuid, BigInteger.ZERO);
    }

    public static void setUserEU(UUID uuid, BigInteger energy) {
        try {
            WirelessEnergyNetWorkWorldSaveData.INSTANCE.markDirty();
        } catch (Exception exception) {
            GTNELog.logger.warn("Could not mark global energy as dirty in set EU");
        }

        GlobalVariableStorage.WirelessEnergy.put(uuid, energy);
    }

    public static void clearWirelessEnergyInformation() {
        GlobalVariableStorage.WirelessEnergy.clear();
    }

}
