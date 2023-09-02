package gtne.api.metatileentities;

import gregtech.api.metatileentity.MetaTileEntity;

import java.math.BigInteger;

public interface IMetaTileEntityChangeableBattery<T extends MetaTileEntity> {

    BigInteger getCapacity();
    long getPassiveLoss();

    BigInteger updateCapacity();

    long updatePassiveLoss();

}
