package gtne.api.capabilities.energy;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CapabilityLongEnergy {

    @CapabilityInject(ILongForgeEnergy.class)
    public static Capability<ILongForgeEnergy> ENERGY_LONG = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(ILongForgeEnergy.class, new IStorage<ILongForgeEnergy>() {

            @Override
            public NBTBase writeNBT(Capability<ILongForgeEnergy> capability, ILongForgeEnergy instance, EnumFacing side)
            {
                return new NBTTagLong(instance.getEnergyStored());
            }

            @Override
            public void readNBT(Capability<ILongForgeEnergy> capability, ILongForgeEnergy instance, EnumFacing side, NBTBase nbt)
            {
                if (!(instance instanceof LongEnergyStorage))
                    throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation!!!");
                ((LongEnergyStorage)instance).energy = ((NBTTagLong)nbt).getLong();
            }

        },
                () -> new LongEnergyStorage(1000));
    }

}
