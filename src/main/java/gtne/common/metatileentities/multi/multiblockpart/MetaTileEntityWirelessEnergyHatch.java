package gtne.common.metatileentities.multi.multiblockpart;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.utils.PipelineUtil;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import gtne.api.util.VirtualEnergyRegistry;
import gtne.client.GTNETextures;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

import static gtne.common.metatileentities.GTNEMetaTileEntities.*;

public class MetaTileEntityWirelessEnergyHatch extends MetaTileEntityEnergyHatch {

    private UUID playerUUID = null;

    private VirtualEnergyRegistry.VirtualEnergyContainer energyContainerWireless;

    private boolean initialize = true;

    public MetaTileEntityWirelessEnergyHatch(ResourceLocation metaTileEntity, int tier, int amperage, boolean isExportHatch) {
        super(metaTileEntity, tier, amperage, isExportHatch);
        this.initialize = true;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityWirelessEnergyHatch(metaTileEntityId, getTier(), amperage, isExportHatch);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.LIGHT_PURPLE + I18n.format("gtne.wireless_energy_hatch.tooltip.1"));
        tooltip.add(TooltipHelper.BLINKING_RED + I18n.format("gtne.wireless_energy_hatch.tooltip.2"));
        super.addInformation(stack, world, tooltip, advanced);
    }

    @Override
    public void update() {

        super.update();

        if (!this.initialize && !this.getWorld().isRemote) {

            if (this.isExportHatch) {

                long energy = this.energyContainer.getEnergyStored();
                this.energyContainer.removeEnergy(energy);
                this.energyContainerWireless.addEnergy(energy);

            } else {

                if (this.energyContainer.getEnergyStored() != this.energyContainer.getEnergyCapacity()) {
                    long energy = this.energyContainer.getEnergyCapacity() - this.energyContainer.getEnergyStored() > this.energyContainerWireless.getEnergyStored() ? this.energyContainerWireless.getEnergyStored() : this.energyContainer.getEnergyCapacity() - this.energyContainer.getEnergyStored();
                    this.energyContainerWireless.removeEnergy(energy);
                    this.energyContainer.addEnergy(energy);

                }

            }

        }

    }

    @Override
    public boolean onScrewdriverClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
                                      CuboidRayTraceResult hitResult) {

        if (!getWorld().isRemote) {

            if (this.initialize) {

                if (playerIn.isSneaking()) {

                    this.playerUUID = playerIn.getUniqueID();
                    this.energyContainerWireless = VirtualEnergyRegistry.getContainerCreate(makeEnergyContainerName(), this.playerUUID);
                    this.initialize = false;
                    playerIn.sendStatusMessage(new TextComponentTranslation("gtne.wireless_initialized_private"), false);

                } else {

                    this.playerUUID = new UUID(0, 0);
                    this.energyContainerWireless = VirtualEnergyRegistry.getContainerCreate(makeEnergyContainerName(), this.playerUUID);
                    this.initialize = false;
                    playerIn.sendStatusMessage(new TextComponentTranslation("gtne.wireless_initialized_public"), false);

                }

            }

        }

        return true;

    }

    @Override
    public void getSubItems(CreativeTabs creativeTabs, NonNullList<ItemStack> subItems) {

        for (MetaTileEntityWirelessEnergyHatch hatch : WIRELESS_ENERGY_HATCH_INPUT) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (MetaTileEntityWirelessEnergyHatch hatch : WIRELESS_ENERGY_HATCH_INPUT_4A) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (MetaTileEntityWirelessEnergyHatch hatch : WIRELESS_ENERGY_HATCH_INPUT_16A) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (MetaTileEntityWirelessEnergyHatch hatch : WIRELESS_ENERGY_HATCH_INPUT_64A) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());

        }

        for (MetaTileEntityWirelessEnergyHatch hatch : WIRELESS_ENERGY_HATCH_OUTPUT) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());

        }

    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);

        if (shouldRenderOverlay()) {
            getOverlay().renderSided(getFrontFacing(), renderState, translation,
                    PipelineUtil.color(pipeline, GTValues.VC[getTier()]));
        }
    }

    @NotNull
    private SimpleOverlayRenderer getOverlay() {
        return switch (this.amperage) {
            case 4 -> GTNETextures.WIRELESS_ENERGY_HATCH_4A;
            case 16 -> GTNETextures.WIRELESS_ENERGY_HATCH_16A;
            default -> GTNETextures.WIRELESS_ENERGY_HATCH;
        };
    }

    @Override
    public void writeInitialSyncData(PacketBuffer packetBuffer) {
        super.writeInitialSyncData(packetBuffer);
        packetBuffer.writeBoolean(this.initialize);
        packetBuffer.writeString(this.playerUUID == null ? "null" : this.playerUUID.toString());
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer packetBuffer) {
        super.receiveInitialSyncData(packetBuffer);
        this.initialize = packetBuffer.readBoolean();
        String uuidString = packetBuffer.readString(36);
        this.playerUUID = uuidString.equals("null") ? null : UUID.fromString(uuidString);
        updateEnergyLink();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("Initialized", initialize);
        data.setString("PlacedUUID", playerUUID == null ? "null" : playerUUID.toString());
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        String uuidString = data.getString("PlacedUUID");
        this.playerUUID = uuidString.equals("null") ? null : UUID.fromString(uuidString);
        this.initialize = data.getBoolean("Initialized");
        updateEnergyLink();
    }

    protected void updateEnergyLink() {
        this.energyContainerWireless = VirtualEnergyRegistry.getContainerCreate(makeEnergyContainerName(), this.playerUUID);
        this.markDirty();
    }

    private String makeEnergyContainerName() {
        return "EContainer#";
    }

}
