package gtne.common.metatileentities.multi.spaceelevator;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gtne.api.metatileentity.interfaces.ISpaceElevatorProvider;
import gtne.api.metatileentity.interfaces.ISpaceElevatorReceiver;
import gtne.client.GTNETextures;
import gtne.common.Block.GTNEMetaBlock;
import gtne.common.Block.elevator.ElevatorCasing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class MetaTileEntityModuleRecipeBase extends RecipeMapMultiblockController implements ISpaceElevatorReceiver {

    protected final int tier;

    protected final int moduleTier;

    protected final int minMotorTier;

    protected final long energyConsumption;

    protected ISpaceElevatorProvider spaceElevator;

    public MetaTileEntityModuleRecipeBase(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, int tier, int moduleTier, int minMotorTier) {
        super(metaTileEntityId, recipeMap);
        this.moduleTier = moduleTier;
        this.minMotorTier = minMotorTier;
        this.tier = tier;
        this.energyConsumption = (long) (Math.pow(4, this.tier + 2) / 2.0);
        this.energyContainer = new EnergyContainerHandler(this, (long) (160008000L * Math.pow(4, this.tier - 9)), this.energyConsumption, 1, 0, 0);

    }

    @Override
    public void checkStructurePattern() {
        if(getSpaceElevator() != null) {
            if(getSpaceElevator().getMotorTier() >= minMotorTier) {
                super.checkStructurePattern();
            }
        }
    }

    @Override
    public abstract void initializeAbilities();

    @Override
    public void updateFormedValid() {
        super.updateFormedValid();
        if(this.getOffsetTimer() % 20 == 0 && getSpaceElevator() != null) {
            if (this.energyContainer.getEnergyCapacity() != this.energyContainer.getEnergyStored() && getSpaceElevator().getEnergyContainerForModules().getEnergyStored() > this.energyConsumption * 20) {
                long energyToDraw = this.energyContainer.getEnergyCapacity() - this.energyContainer.getEnergyStored();
                getSpaceElevator().getEnergyContainerForModules().removeEnergy(energyToDraw);
                this.energyContainer.addEnergy(energyToDraw);
            }
        } else if (getSpaceElevator() == null) {
            this.recipeMapWorkable.setWorkingEnabled(false);
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

    @Override
    public IEnergyContainer getEnergyContainer() {
        if(getSpaceElevator() == null || getSpaceElevator().getEnergyContainerForModules() == null) {
            return new EnergyContainerHandler(this, 0, 0, 0, 0, 0);
        }
        else
            return this.energyContainer;
    }

    @Override
    public void sentWorkingDisabled() {
        this.recipeMapWorkable.setWorkingEnabled(false);
    }

    @Override
    public void sentWorkingEnabled() {this.recipeMapWorkable.setWorkingEnabled(true);}

    @Override
    public String getNameForDisplayCount() {
        return this.getMetaName() + ".display_count";
    }


}
