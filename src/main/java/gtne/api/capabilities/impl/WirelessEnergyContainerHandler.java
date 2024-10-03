package gtne.api.capabilities.impl;

import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gtne.api.capabilities.BigIntCalc;
import gtne.api.capabilities.WirelessEnergyNetWorkManager;

import java.math.BigInteger;
import java.util.UUID;

public class WirelessEnergyContainerHandler extends EnergyContainerHandler {

    public UUID uuid = null;

    public WirelessEnergyContainerHandler(MetaTileEntity metaTileEntity, long maxCapacity, long maxInputVoltage, long maxInputAmperage, long maxOutputVoltage, long maxOutputAmperage) {
        super(metaTileEntity, maxCapacity, maxInputVoltage, maxInputAmperage, maxOutputVoltage, maxOutputAmperage);
    }

    public static WirelessEnergyContainerHandler emitterContainer(MetaTileEntity metaTileEntity, long maxCapacity, long maxOutputVoltage, long maxOutputAmperage) {
        return new WirelessEnergyContainerHandler(metaTileEntity, maxCapacity, 0L, 0L, maxOutputVoltage, maxOutputAmperage);
    }

    public static WirelessEnergyContainerHandler receiverContainer(MetaTileEntity metaTileEntity, long maxCapacity, long maxInputVoltage, long maxInputAmperage) {
        return new WirelessEnergyContainerHandler(metaTileEntity, maxCapacity, maxInputVoltage, maxInputAmperage, 0, 0);
    }

    public void update() {

        if (!this.getMetaTileEntity().getWorld().isRemote && this.metaTileEntity.getOffsetTimer() % 20 == 0L && this.uuid != null) {
            WirelessEnergyNetWorkManager.strongCheckOrAddUser(this.uuid);
            if (this.getInputVoltage() == 0L) {
                if (this.getEnergyStored() > 0L) {
                    WirelessEnergyNetWorkManager.addEUToWirelessEnergyNetWork(this.uuid, this.getEnergyStored());
                    this.removeEnergy(this.getEnergyStored());
                }
            } else {
                long consumeEnergy = this.getEnergyCapacity() - this.getEnergyStored();
                BigInteger pseudoUserEnergy = BigIntCalc.min(WirelessEnergyNetWorkManager.getUserEU(this.uuid), BigInteger.valueOf(consumeEnergy));
                long actuallyUserEnergy = pseudoUserEnergy.longValue();
                this.addEnergy(actuallyUserEnergy);
                WirelessEnergyNetWorkManager.addEUToWirelessEnergyNetWork(this.uuid, -actuallyUserEnergy);
            }
        }
    }

    public long getEnergyCanBeInserted() {
        return 0L;
    }

}
