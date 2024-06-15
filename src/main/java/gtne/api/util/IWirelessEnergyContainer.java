package gtne.api.util;

public interface IWirelessEnergyContainer {

    long changeEnergy(long diffAmount);

    default long addEnergy(long energyToAdd) {
        return changeEnergy(energyToAdd);
    }

    default long removeEnergy(long energyToRemove) {
        return changeEnergy(-energyToRemove);
    }

    long getEnergyStored();

}
