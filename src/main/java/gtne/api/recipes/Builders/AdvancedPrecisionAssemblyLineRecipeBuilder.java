package gtne.api.recipes.Builders;

import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IDataItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.AssemblyLineRecipeBuilder;
import gregtech.api.recipes.recipeproperties.ResearchProperty;
import gregtech.api.recipes.recipeproperties.ResearchPropertyData;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTStringUtils;
import gregtech.common.ConfigHolder;
import gtne.api.util.AdvancedPrecisionAssemblyLineManager;
import gtne.api.util.GTNELog;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

import static gregtech.api.GTValues.*;

public class AdvancedPrecisionAssemblyLineRecipeBuilder extends RecipeBuilder<AdvancedPrecisionAssemblyLineRecipeBuilder> {

    public static final int DEFAULT_APAL_SCANNER_DURATION = 4800; //240sec

    public static final int DEFAULT_APAL_SCANNER_EUT      = GTValues.VA[LuV]; //32768

    public static final int DEFAULT_APAL_STATION_DURATION = 16000; //800sec

    public static final int DEFAULT_APAL_STATION_EUT           = GTValues.VA[UHV];//2097152

    private final Collection<APAL_ResearchRecipeEntry> recipeEntries = new ArrayList<>();

    private boolean generatingRecipes = true;

    public AdvancedPrecisionAssemblyLineRecipeBuilder() {/**/}

    @SuppressWarnings("unused")
    public AdvancedPrecisionAssemblyLineRecipeBuilder(Recipe recipe, RecipeMap<AdvancedPrecisionAssemblyLineRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public AdvancedPrecisionAssemblyLineRecipeBuilder(@Nonnull AdvancedPrecisionAssemblyLineRecipeBuilder builder) {
        super(builder);
        this.recipeEntries.addAll(builder.getRecipeEntries());
        this.generatingRecipes = builder.generatingRecipes;
    }

    @Override
    public AdvancedPrecisionAssemblyLineRecipeBuilder copy() {
        return new AdvancedPrecisionAssemblyLineRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, @Nullable Object value) {
        if (key.equals(ResearchProperty.KEY)) {
            if (value instanceof ItemStack itemStack) {
                research(itemStack);
                return true;
            }
        }
        return super.applyProperty(key, value);
    }

    private boolean applyResearchProperty(ResearchPropertyData.ResearchEntry researchEntry) {
        if (!ConfigHolder.machines.enableResearch) return false;
        if (researchEntry == null) {
            GTNELog.logger.error("Advanced Precision Assembly Line Research Entry cannot be empty.", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
            return false;
        }

        if (!generatingRecipes) {
            GTNELog.logger.error("Cannot generate recipes when using researchWithoutRecipe()", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
            return false;
        }

        if (recipePropertyStorage != null && recipePropertyStorage.hasRecipeProperty(ResearchProperty.getInstance())) {
            ResearchPropertyData property = recipePropertyStorage.getRecipePropertyValue(ResearchProperty.getInstance(), null);
            if (property == null) throw new IllegalStateException("Property storage has a null property");
            property.add(researchEntry);
            return true;
        }

        return false;
    }

    public AdvancedPrecisionAssemblyLineRecipeBuilder researchWithoutRecipe(@Nonnull String researchId) {
        return researchWithoutRecipe(researchId, AdvancedPrecisionAssemblyLineManager.getDefaultScannerItem());
    }

    public AdvancedPrecisionAssemblyLineRecipeBuilder researchWithoutRecipe(@Nonnull String researchId, @Nonnull ItemStack dataStack) {
        applyResearchProperty(new ResearchPropertyData.ResearchEntry(researchId, dataStack));
        this.generatingRecipes = false;
        return this;
    }

    public AdvancedPrecisionAssemblyLineRecipeBuilder research(UnaryOperator<APAL_ResearchBuilder> research) {
        APAL_ResearchRecipeEntry entry = research.apply(new APAL_ResearchBuilder()).build();
        if (applyResearchProperty(new ResearchPropertyData.ResearchEntry(entry.researchId, entry.dataStack))) {
            this.recipeEntries.add(entry);
        }
        return this;
    }

    public AdvancedPrecisionAssemblyLineRecipeBuilder research(@Nonnull ItemStack researchStack) {
        return research(h -> new APAL_ResearchBuilder().researchStack(researchStack));
    }

    @Nonnull
    public Collection<APAL_ResearchRecipeEntry> getRecipeEntries() {
        return this.recipeEntries;
    }

    public static class APAL_ResearchRecipeEntry {
        private final String researchId;
        private final ItemStack researchStack;
        private final ItemStack dataStack;
        private final int duration;
        private final int EUt;
        private final int CWUt;

        /**
         * @param researchId the id of the research to store
         * @param researchStack the stack to scan for research
         * @param dataStack the stack to contain the data
         * @param duration the duration of the recipe
         * @param EUt the EUt of the recipe
         * @param CWUt how much computation per tick this recipe needs if in Research Station
         */

        public APAL_ResearchRecipeEntry(String researchId, ItemStack researchStack, ItemStack dataStack, int duration, int EUt, int CWUt) {
            this.researchId = researchId;
            this.researchStack = researchStack;
            this.dataStack = dataStack;
            this.duration = duration;
            this.EUt = EUt;
            this.CWUt = CWUt;
        }

        @Nonnull
        public String getResearchId() {
            return researchId;
        }
        @Nonnull
        public ItemStack getResearchStack() {
            return researchStack;
        }

        @Nonnull
        public ItemStack getDataStack() {
            return dataStack;
        }

        public int getDuration() {
            return duration;
        }

        public int getEUt() {
            return EUt;
        }

        public int getCWUt() {
            return CWUt;
        }
    }

    public static class APAL_ResearchBuilder {
        private ItemStack researchStack;
        private ItemStack dataStack;
        private String researchId;
        private int duration;
        private int eut;
        private int cwut;

        private APAL_ResearchBuilder() {/**/}

        public APAL_ResearchBuilder researchStack(@Nonnull ItemStack researchStack) {
            if (!researchStack.isEmpty()) {
                this.researchStack = researchStack;
            }
            return this;
        }

        public APAL_ResearchBuilder dataStack(@Nonnull ItemStack dataStack) {
            if (!dataStack.isEmpty()){
                this.researchStack= dataStack;
            }
            return this;
        }

        public APAL_ResearchBuilder researchId(String researchId) {
            this.researchId = researchId;
            return this;
        }

        public APAL_ResearchBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public APAL_ResearchBuilder EUt(int eut) {
            this.eut = eut;
            return this;
        }

        public APAL_ResearchBuilder CWUt(int cwut) {
            this.cwut = cwut;
            return this;
        }

        private APAL_ResearchRecipeEntry build() {
            if (researchStack == null) {
                throw new IllegalArgumentException("Research stack cannot be null or empty!");
            }

            if (researchId == null) {
                researchId = GTStringUtils.itemStackToString(researchStack);
            }

            if (dataStack == null) {
                dataStack = cwut > 0
                        ? AdvancedPrecisionAssemblyLineManager.getDefaultResearchStationItem(cwut)
                        : AdvancedPrecisionAssemblyLineManager.getDefaultScannerItem();
            }

            boolean foundBehavior = false;
            if (dataStack.getItem() instanceof MetaItem<?> metaItem) {
                for (IItemBehaviour behaviour : metaItem.getBehaviours(dataStack)) {
                    if (behaviour instanceof IDataItem) {
                        foundBehavior = true;
                        dataStack = dataStack.copy();
                        dataStack.setCount(1);
                        break;
                    }
                }
            }
            if (!foundBehavior) {
                throw new IllegalArgumentException("Data ItemStack must have the IDataItem behavior");
            }

            if (duration <= 0) {
                duration = cwut > 0
                        ? DEFAULT_APAL_STATION_DURATION
                        : DEFAULT_APAL_SCANNER_DURATION;
            }

            if (eut <= 0) {
                eut = cwut > 0
                        ? DEFAULT_APAL_STATION_EUT
                        :DEFAULT_APAL_SCANNER_EUT;
            }
            return new APAL_ResearchRecipeEntry(researchId, researchStack, dataStack, duration, eut, cwut);
        }
    }
}
