package gtne.common.metatileentities.multi.spaceelevator;

import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.IWorkable;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gtne.api.metatileentity.interfaces.ISpaceElevatorProvider;
import gtne.api.metatileentity.interfaces.ISpaceElevatorReceiver;
import gtne.client.GTNETextures;
import gtne.common.Block.GTNEMetaBlock;
import gtne.common.Block.elevator.ElevatorCasing;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class MetaTileEntityModuleBase extends MultiblockWithDisplayBase implements ISpaceElevatorReceiver, IWorkable {

    protected final int tier;

    protected final int moduleTier;

    protected final int minMotorTier;

    protected final long energyConsumption;

    protected ISpaceElevatorProvider spaceElevator;

    protected IEnergyContainer energyContainer;

    protected boolean isActive;

    protected int maxProgress;

    protected int progressTime = 0;

    protected boolean isWorkingEnabled = false;

    public MetaTileEntityModuleBase(ResourceLocation metaTileEntityId, int tier, int moduleTier, int minMotorTier) {
        super(metaTileEntityId);
        this.tier = tier;
        this.moduleTier = moduleTier;
        this.minMotorTier = minMotorTier;
        this.energyConsumption = (long) (Math.pow(4, this.tier + 2) / 2.0);
        this.energyContainer = new EnergyContainerHandler(this, (long) (160008000L * Math.pow(4, this.tier - 9)), this.energyConsumption, 1, 0, 0);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        initializeAbilities();
    }

    @Override
    public void checkStructurePattern() {
        if (getSpaceElevator() != null) {
            if (getSpaceElevator().getMotorTier() >= minMotorTier) {
                super.checkStructurePattern();
            }
        }
    }

    protected abstract void initializeAbilities();

    @Override
    public void updateFormedValid() {
        if (this.getOffsetTimer() % 20 == 0 && getSpaceElevator() != null) {
            if (this.energyContainer.getEnergyCapacity() != this.energyContainer.getEnergyStored() && getSpaceElevator().getEnergyContainerForModules().getEnergyStored() > this.energyConsumption * 20) {
                long energyToDraw = this.energyContainer.getEnergyCapacity() - this.energyContainer.getEnergyStored();
                getSpaceElevator().getEnergyContainerForModules().removeEnergy(energyToDraw);
                this.energyContainer.addEnergy(energyToDraw);
            }
        } else if (getSpaceElevator() == null) {
            setWorkingEnabled(false);
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        setSpaceElevator(null);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("C","C","C","C","C")
                .aisle("C","C","C","S","C")
                .where('S', selfPredicate())
                .where('C', states(GTNEMetaBlock.ELEVATOR_CASING.getState(ElevatorCasing.CasingType.ELEVATOR_BASE_CASING)).or(abilities().setPreviewCount(0)))
                .build();
    }

    protected abstract TraceabilityPredicate abilities();

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.DATA_BANK_OVERLAY;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTNETextures.ELEVATOR_CASING;
    }

    @Override
    public @Nullable ISpaceElevatorProvider getSpaceElevator() {
        return this.spaceElevator;
    }

    @Override
    public void setSpaceElevator(ISpaceElevatorProvider provider) {
        this.spaceElevator = provider;
    }

    public IEnergyContainer getEnergyContainer() {
        if (getSpaceElevator() == null || getSpaceElevator().getEnergyContainerForModules() == null) {
            return new EnergyContainerHandler(this, 0, 0, 0, 0, 0);
        } else
            return this.energyContainer;
    }

    @Override
    public void sentWorkingDisabled() {
        setWorkingEnabled(false);
    }

    @Override
    public void sentWorkingEnabled() {
        setWorkingEnabled(true);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_WORKABLE)
            return GregtechTileCapabilities.CAPABILITY_WORKABLE.cast(this);
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE)
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        return super.getCapability(capability, side);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("progressTime", this.progressTime);
        data.setInteger("maxProgress", this.maxProgress);
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.progressTime   = data.getInteger("progressTime");
        this.maxProgress    = data.getInteger("maxProgress");
        this.isActive       = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buffer) {
        super.writeInitialSyncData(buffer);
        buffer.writeInt(this.progressTime);
        buffer.writeInt(this.maxProgress);
        buffer.writeBoolean(this.isActive);
        buffer.writeBoolean(this.isWorkingEnabled);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buffer) {
        super.receiveInitialSyncData(buffer);
        this.progressTime       = buffer.readInt();
        this.maxProgress        = buffer.readInt();
        setActive(buffer.readBoolean());
        setWorkingEnabled(buffer.readBoolean());
    }

    @Override
    public void receiveCustomData(int dataID, PacketBuffer buffer) {
        super.receiveCustomData(dataID, buffer);
        if (dataID == GregtechDataCodes.WORKABLE_ACTIVE) {
            this.setActive(buffer.readBoolean());
            scheduleRenderUpdate();
        } else if (dataID == GregtechDataCodes.WORKING_ENABLED) {
            this.setWorkingEnabled(buffer.readBoolean());
            scheduleRenderUpdate();
        }
    }

    @Override
    public boolean isActive() {
        return this.isActive && isWorkingEnabled();
    }

    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            this.markDirty();
            World world = this.getWorld();
            if (world != null && !world.isRemote) {
                this.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buffer -> buffer.writeBoolean(active));
            }
        }
    }

    @Override
    public int getProgress() {
        return this.progressTime;
    }

    @Override
    public int getMaxProgress() {
        return this.maxProgress;
    }

    @Override
    public boolean isWorkingEnabled() {
        return this.isWorkingEnabled;
    }

    protected void setMaxProgress(int progress) {
        this.maxProgress = progress;
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        initializeAbilities();
        this.isWorkingEnabled = workingEnabled;
        this.markDirty();
        World world = this.getWorld();
        if (world != null && !world.isRemote) {
            this.writeCustomData(GregtechDataCodes.WORKING_ENABLED,
                    buffer -> buffer.writeBoolean(workingEnabled));
        }
    }

    protected boolean drainEnergy(boolean simulate, long EU) {
        long resultEnergy = energyContainer.getEnergyStored() - EU;
        if (resultEnergy >= 0L && resultEnergy <= energyContainer.getEnergyCapacity()) {
            if (!simulate)
                energyContainer.changeEnergy(-EU);
            return true;
        }
        return false;
    }

    protected boolean drainEnergy(boolean simulate) {
        long resultEnergy = energyContainer.getEnergyStored() - energyContainer.getInputVoltage();
        if (resultEnergy >= 0L && resultEnergy <= energyContainer.getEnergyCapacity()) {
            if (!simulate)
                energyContainer.changeEnergy(-energyContainer.getInputVoltage());
            return true;
        }
        return false;
    }

    @Override
    public String getNameForDisplayCount() {
        return this.getMetaName() + ".display_count";
    }

    public int getProgressPercent() {
        return (int) ((1.0F * getProgress() / getMaxProgress()) * 100);
    }

}
