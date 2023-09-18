package gtne.api.util;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IDataItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.nbtmatch.NBTCondition;
import gregtech.api.recipes.ingredients.nbtmatch.NBTMatcher;
import gregtech.api.util.GTUtility;
import gregtech.common.ConfigHolder;
import gtne.api.recipes.Builders.AdvancedPrecisionAssemblyLineRecipeBuilder;
import net.minecraft.item.ItemStack;
import gregtech.common.items.MetaItems;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AdvancedPrecisionAssemblyLineManager {

    public static final String APAL_RESEARCH_NBT_TAG = "advancedprecisionassemblylineResearch";
    public static final String APAL_RESEARCH_ID_NBT_TAG = "apal_researchId";

    @Nonnull
    public static ItemStack getDefaultScannerItem() {
        return MetaItems.TOOL_DATA_STICK.getStackForm();
    }

    @Nonnull
    public static ItemStack getDefaultResearchStationItem(int cwut) {
        if (cwut > 32) {
            return MetaItems.TOOL_DATA_MODULE.getStackForm();
        }
        return MetaItems.TOOL_DATA_ORB.getStackForm();
    }

    private AdvancedPrecisionAssemblyLineManager() {}

    /**
     * @param stackCompound the compound contained on the ItemStack to write to
     * @param researchId    the research id
     */

    public static void writeResearchToNBT(@Nonnull NBTTagCompound stackCompound, @Nonnull String researchId) {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString(APAL_RESEARCH_NBT_TAG, researchId);
        stackCompound.setTag(APAL_RESEARCH_NBT_TAG, compound);
    }

    /**
     * @param stack the ItemStack to read from
     * @return the research id
     */

    @Nullable
    public static String readResearchId(@Nonnull ItemStack stack) {
        NBTTagCompound compound = stack.getTagCompound();
        if (!hasResearchTag(compound)) return null;

        NBTTagCompound researchCompound = compound.getCompoundTag(APAL_RESEARCH_NBT_TAG);
        String researchId = researchCompound.getString(APAL_RESEARCH_NBT_TAG);
        return researchId.isEmpty() ? null : researchId;
    }

    public static boolean isDtackDataItem(@Nonnull ItemStack stack, boolean isDataBank) {
        if (stack.getItem() instanceof MetaItem<?> metaItem) {
            MetaItem<?>.MetaValueItem valueItem = metaItem.getItem(stack);
            if (valueItem == null) return false;
            for (IItemBehaviour behaviour : valueItem.getBehaviours()) {
                if (behaviour instanceof IDataItem dataItem) {
                    return !dataItem.requireDataBank() || isDataBank;
                }
            }
        }
        return false;
    }

    /**
     * @param stack the stack to check
     * @return if the stack has the research NBTTagCompound
     */

    public static boolean hasResearchTag(@Nonnull ItemStack stack) {
        return hasResearchTag(stack.getTagCompound());
    }

    /**
     * @param compound the compound to check
     * @return if the tag has the research NBTTagCompound
     */

    private static boolean hasResearchTag(@Nullable NBTTagCompound compound){
        if (compound == null || compound.isEmpty()) return false;
        return compound.hasKey(APAL_RESEARCH_NBT_TAG, Constants.NBT.TAG_COMPOUND);
    }

    public static void createDefaultResearchRecipe(@Nonnull AdvancedPrecisionAssemblyLineRecipeBuilder builder) {
        if (!ConfigHolder.machines.enableResearch) return;

        for (AdvancedPrecisionAssemblyLineRecipeBuilder.APAL_ResearchRecipeEntry entry : builder.getRecipeEntries()) {
            createDefaultResearchRecipe(entry.getResearchId(), entry.getResearchStack(), entry.getDataStack(), entry.getDuration(), entry.getEUt(), entry.getCWUt());
        }
    }

    public static void createDefaultResearchRecipe(@Nonnull String researchId, @Nonnull ItemStack researchItem, @Nonnull ItemStack dataItem, int duration, int EUt, int CWUt) {
        if (!ConfigHolder.machines.enableResearch) return;

        NBTTagCompound compound = GTUtility.getOrCreateNbtCompound(dataItem);
        writeResearchToNBT(compound, researchId);

        if (CWUt > 0) {
            RecipeMaps.RESEARCH_STATION_RECIPES.recipeBuilder()
                    .inputNBT(dataItem.getItem(), 1, dataItem.getMetadata(), NBTMatcher.ANY, NBTCondition.ANY)
                    .inputs(researchItem)
                    .outputs(dataItem)
                    .duration(duration)
                    .EUt(EUt)
                    .CWUt(CWUt)
                    .buildAndRegister();
        } else {
            RecipeMaps.SCANNER_RECIPES.recipeBuilder()
                    .inputNBT(dataItem.getItem(), 1, dataItem.getMetadata(), NBTMatcher.ANY, NBTCondition.ANY)
                    .inputs(researchItem)
                    .outputs(dataItem)
                    .duration(duration)
                    .EUt(EUt)
                    .buildAndRegister();
        }
    }
}
