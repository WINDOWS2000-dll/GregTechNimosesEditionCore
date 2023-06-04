package gtne.common.metatileentities.multi;

import net.minecraft.util.text.ITextComponent;
import gregtech.api.capability.IControllable;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gtne.api.metatileentities.IUpdatable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.List;

public abstract class MultiBlockWithUpdatable<T extends IUpdatable> extends MultiblockWithDisplayBase implements IControllable {

    public MultiBlockWithUpdatable(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    public abstract T getLogic();

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        return this.getLogic().writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.getLogic().readFromNBT(data);
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        this.getLogic().writeInitialSyncData(buf);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.getLogic().receiveInitialSyncData(buf);
    }

    @Override
    public boolean isWorkingEnabled() {
        return this.getLogic().isWorkingEnabled();
    }

    @Override
    public void setWorkingEnabled(boolean b) {
        this.getLogic().setWorkingEnabled(b);
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        this.getLogic().receiveCustomData(dataId,buf);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (!isActive()) textList.add(new TextComponentTranslation("gtne.multi.data.remind"));
    }

}
