package gtne.api.capabilities.energy;

public class LongEnergyStorage implements ILongForgeEnergy {

    protected long energy;
    protected long capacity;
    protected long maxReceive;
    protected long maxExtract;

    public LongEnergyStorage(long capacity) {
        this(capacity, capacity, capacity, 0);
    }

    public LongEnergyStorage(long capacity, long maxTransfer)
    {
        this(capacity, maxTransfer, maxTransfer, 0);
    }

    public LongEnergyStorage(long capacity, long maxReceive, long maxExtract)
    {
        this(capacity, maxReceive, maxExtract, 0);
    }

    public LongEnergyStorage(long capacity, long maxReceive, long maxExtract, long energy) {
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.energy = Math.max(0 , Math.min(capacity, energy));
    }

    @Override
    public long receiveEnergy(long maxReceive, boolean simulate)
    {
        if (!canReceive())
            return 0;

        long energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
        if (!simulate)
            energy += energyReceived;
        return energyReceived;
    }

    @Override
    public long extractEnergy(long  maxExtract, boolean simulate)
    {
        if (!canExtract())
            return 0;
        long energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
        if (!simulate)
            energy -= energyExtracted;
        return energyExtracted;
    }

    @Override
    public long getEnergyStored()
    {
        return energy;
    }

    @Override
    public long getMaxEnergyStored() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canReceive()
    {
        return this.maxReceive > 0;
    }

}
