package gtne.common.metatileentities.multi;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import com.google.common.collect.Lists;
import gregtech.api.GTValues;
import gregtech.api.capability.*;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.core.sound.GTSoundEvents;
import gtne.api.unification.material.GTNEMaterials;
import gtne.client.GTNETextures;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

//ToDo 構造物のマテリアルを考える

/*
public class MetaTileEntityCosmicLayDetector extends MultiblockWithDisplayBase implements IControllable {

    public boolean isWorkingEnabled = false;
    public boolean isActive = false;
    public IMultipleTankHandler exportFluidHandler;
    private long maxVoltage = 0;
    private  boolean canSeeSky = false;
    private boolean hasEnoughEnergy = false;
    private IEnergyContainer energyContainer;
    private int amount = 0;

    public MetaTileEntityCosmicLayDetector(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        reinitializeStructurePattern();
    }


    @Override
    protected void updateFormedValid() {
        if (!getWorld().isRemote && this.getNumMaintenanceProblems() < 1 && isWorkingEnabled()) {

            if (getOffsetTimer() % 20 == 4) {
                canSeeSky = canSeeSky();
            }

            if (canSeeSky && !hasEnoughEnergy) {
                if (getOffsetTimer() % 20 == 8) {
                    hasEnoughEnergy = drainEnergy(true);
                }
            }

            if (canSeeSky && hasEnoughEnergy) {
                setActive(true);
                drainEnergy(false);
            } else
                setActive(false);
        } else
            //別にこれと言ってこのreturnに意味があるわけではないし何かをreturnしているわけではない
            return;
    }

    private boolean canSeeSky() {
        BlockPos result = this.getPos().up(5);
        Vec3i dirVec = this.getFrontFacing().getOpposite().getDirectionVec();
        Vec3i resVec = new Vec3i(dirVec.getX() * 3, 0, dirVec.getZ() * 3);
        result = result.add(resVec);
        return this.getWorld().canSeeSky(result);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        initializeAbilities();
        amount = getAmount();
    }

    private int getAmount() {
        double amount = Math.min(((double) this.getPos().getY()) / (256 - 5), 1);
        amount = Math.max(amount, 0);
        amount *= 35;
        amount *= getOverclock();
        amount += 15;
        return (int) amount;
    }

    private void initializeAbilities() {
        this.exportFluidHandler = new FluidTankList(true, getAbilities(MultiblockAbility.EXPORT_FLUIDS));
        this.energyContainer = new EnergyContainerList(getAbilities(MultiblockAbility.INPUT_ENERGY));
    }

    private void resetTileAbilities() {
        this.exportFluidHandler = new FluidTankList(true);
        this.energyContainer = new EnergyContainerList(Lists.newArrayList());
    }

    private boolean drainEnergy(boolean simulate) {
        if (maxVoltage >= getVoltage() && energyContainer.getEnergyStored() >= getVoltage() &&
                exportFluidHandler.fill(GTNEMaterials.NeutronMixture.getFluid(1), false) > 0) {
            if (!simulate) {
                energyContainer.removeEnergy(getVoltage() * getOverclock());
                exportFluidHandler.fill(GTNEMaterials.NeutronMixture.getFluid(this.amount), true);
            }
            return true;
        }
        return false;
    }

    public long getOverclock() {
        int tireDifference = GTUtility.getTierByVoltage(energyContainer.getInputVoltage()) - GTValues.UV;
        return (long) Math.floor(Math.pow(4, tireDifference));
    }

    private long getVoltage() {
        return 500_000;
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.maxVoltage = 0;
        this.resetTileAbilities();
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.isActive(), this.isWorkingEnabled);
    }

    @SideOnly(Side.CLIENT)
    @Override
    protected @NotNull ICubeRenderer getFrontOverlay() {
        return GTNETextures.COSMIC_RAY_DETECTOR;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityCosmicLayDetector(metaTileEntityId);
    }

    @Override
    public boolean isWorkingEnabled() {
        return isWorkingEnabled;
    }

    @Override
    public void setWorkingEnabled(boolean isWorkingAllowed) {
        this.isWorkingEnabled = isWorkingAllowed;
        markDirty();
        World world = getWorld();
        if (world != null && !world.isRemote) {
            writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(isWorkingEnabled));
        }
    }

    @Override
    public boolean isActive() {
        return super.isActive() && this.isWorkingEnabled;
    }

    protected void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            markDirty();
            World world = getWorld();
            if (world != null && !world.isRemote) {
                writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buf -> buf.writeBoolean(active));
            }
        }
    }

    @Override
    public SoundEvent getSound() {
        return GTSoundEvents.ARC;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE) {
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        }
        return super.getCapability(capability, side);
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GregtechDataCodes.WORKABLE_ACTIVE) {
            this.isActive = buf.readBoolean();
            scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.isWorkingEnabled = buf.readBoolean();
            scheduleRenderUpdate();
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        this.isActive = buf.readBoolean();
        this.isWorkingEnabled = buf.readBoolean();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
    }





}
 */
