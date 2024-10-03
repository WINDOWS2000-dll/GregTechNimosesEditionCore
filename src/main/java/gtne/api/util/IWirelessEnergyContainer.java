package gtne.api.util;

@Deprecated(since = "Wireless Energy ReBuild")
public interface IWirelessEnergyContainer {

    /**
     *
     * @param diffAmount Returns the value of the difference between energy input and output
     * @return I/O difference
     */
    long changeEnergy(long diffAmount);

    default long addEnergy(long energyToAdd) {
        return changeEnergy(energyToAdd);
    }

    default long removeEnergy(long energyToRemove) {
        return changeEnergy(-energyToRemove);
    }

    long getEnergyStored();

}
