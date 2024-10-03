package gtne.loaders.recipes.MultiBlock.spaceelevator;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.item.ItemStack;
import org.eclipse.xtext.xbase.lib.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static gtne.common.item.GTNEMetaItems.*;

public class SpaceMiningRecipes {

    public static final int STICK_INPUT_STACK_SIZE = 4;

    public static final int DRILL_HEAD_INPUT_STACK_SIZE = 4;

    public static Object2ObjectMap<Integer, List<SpaceMiningRecipePartTwo>> SPACE_MINING_RECIPES = new Object2ObjectOpenHashMap<>();

    public static Object2ObjectMap<Integer, List<ItemStack>> HASH_TO_ITEMS = new Object2ObjectOpenHashMap<>();

    public static SpaceMiningRecipePartTwo makeSpaceMiningRecipePart(int EUt, int duration, int minModuleTier, int minDistance, int maxDistance, int minSize, int maxSize,
                                                                     int CWUt, int weight, Object... outputsAndWeights) {
        return new SpaceMiningRecipePartTwo(generateListOfPairs(outputsAndWeights), EUt, CWUt, weight, minSize, maxSize, duration, minDistance, maxDistance, minModuleTier);
    }

    public static void addNewRecipeForDroneAndMaterial(int droneTier, Material material, SpaceMiningRecipePartTwo recipe) {

        ItemStack droneStack = getDroneByTier(droneTier);

        if(SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()) == null) {
            SPACE_MINING_RECIPES.put(new SpaceMiningRecipePartOne(droneStack, material).hashCode(), new ArrayList<>());
        }

        SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()).add(recipe);

        if(HASH_TO_ITEMS.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()) == null)
            HASH_TO_ITEMS.put(new SpaceMiningRecipePartOne(droneStack, material).hashCode(), Arrays.asList(droneStack, OreDictUnifier.get(OrePrefix.stick, material, STICK_INPUT_STACK_SIZE),
                    OreDictUnifier.get(OrePrefix.toolHeadDrill, material, DRILL_HEAD_INPUT_STACK_SIZE)));
    }


    public static void addNewRecipesForDroneAndMaterial(int droneTier, Material material, List<SpaceMiningRecipePartTwo> list) {

        ItemStack droneStack = getDroneByTier(droneTier);

        if(SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()) == null) {
            SPACE_MINING_RECIPES.put(new SpaceMiningRecipePartOne(droneStack, material).hashCode(), new ArrayList<>());
        }

        SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()).addAll(list);

        if(HASH_TO_ITEMS.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()) == null)
            HASH_TO_ITEMS.put(new SpaceMiningRecipePartOne(droneStack, material).hashCode(), Arrays.asList(droneStack, OreDictUnifier.get(OrePrefix.stick, material, STICK_INPUT_STACK_SIZE),
                    OreDictUnifier.get(OrePrefix.toolHeadDrill, material, DRILL_HEAD_INPUT_STACK_SIZE)));
    }

    public static void removeRecipeForDroneAndMaterial(int droneTier, Material material, SpaceMiningRecipePartTwo recipe) {

        ItemStack droneStack = getDroneByTier(droneTier);

        if(SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()) == null) {
            throw new RuntimeException("No matching Drone and Material found!");
        }

        if(!SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()).remove(recipe)) {
            throw new RuntimeException("No matching Recipe found for Drone and Material!");
        }

        if(SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()).isEmpty())
            HASH_TO_ITEMS.remove(new SpaceMiningRecipePartOne(droneStack, material).hashCode());

    }

    public static void removeAllRecipesForDroneAndMaterial(int droneTier, Material material) {

        ItemStack droneStack = getDroneByTier(droneTier);

        if(SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()) == null) {
            throw new RuntimeException("No matching Drone and Material found!");
        }

        SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()).clear();

        HASH_TO_ITEMS.remove(new SpaceMiningRecipePartOne(droneStack, material).hashCode());
    }

    public static List<SpaceMiningRecipePartTwo> upTierAllRecipes(int droneTier, Material material, int tier) {

        ItemStack droneStack = getDroneByTier(droneTier);

        if(SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode()) == null) {
            throw new RuntimeException("No matching Drone and Material found!");
        }

        List<SpaceMiningRecipePartTwo> recipes = SPACE_MINING_RECIPES.get(new SpaceMiningRecipePartOne(droneStack, material).hashCode());
        List<SpaceMiningRecipePartTwo> recipesUp = new ArrayList<>();

        for(SpaceMiningRecipePartTwo recipe : recipes) {
            recipesUp.add(recipe.copyAndUpTierRecipe(tier));
        }

        return recipesUp;
    }

    private static ItemStack getDroneByTier(int tier) {
        return switch (tier) {
            case (1) -> MINING_DRONE_1.getStackForm();
            case (2) -> MINING_DRONE_2.getStackForm();
            case (3) -> MINING_DRONE_3.getStackForm();
            case (4) -> MINING_DRONE_4.getStackForm();
            case (5) -> MINING_DRONE_5.getStackForm();
            case (6) -> MINING_DRONE_6.getStackForm();
            case (7) -> MINING_DRONE_7.getStackForm();
            case (8) -> MINING_DRONE_8.getStackForm();
            case (9) -> MINING_DRONE_9.getStackForm();
            case (10) -> MINING_DRONE_10.getStackForm();
            case (11) -> MINING_DRONE_11.getStackForm();
            case (12) -> MINING_DRONE_12.getStackForm();
            case (13) -> MINING_DRONE_13.getStackForm();
            case (14) -> MINING_DRONE_14.getStackForm();
            default -> null;
        };
    }

    public static List<Pair<Material, Integer>> generateListOfPairs(Object... objects) {
        List<Pair<Material, Integer>> stuff = new ArrayList<>();
        for (int i = 0; i < objects.length; i += 2) {
            if (!(objects[i] instanceof Material material) || !(objects[i + 1] instanceof Integer weight))
                return null;

            stuff.add(new Pair<>(material, weight));
        }

        return stuff;
    }

    public static class SpaceMiningRecipePartOne {

        private final int drone;

        private final Material rodAndDrill;

        public SpaceMiningRecipePartOne(@Nullable ItemStack drone, Material rodAndDrill) {
            this.drone = drone != null ? drone.getMetadata() : 0;
            this.rodAndDrill = rodAndDrill;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object)
                return true;
            if (object == null || getClass() != object.getClass())
                return false;
            SpaceMiningRecipePartOne that = (SpaceMiningRecipePartOne) object;
            return Objects.equals(drone, that.drone) && Objects.equals(rodAndDrill, that.rodAndDrill);
        }

        @Override
        public int hashCode() {
            return Objects.hash(drone, rodAndDrill);
        }

    }

    public static class SpaceMiningRecipePartTwo {
        private final List<Pair<Material, Integer>> outputs;
        private final int computation;
        private final int weight;
        private final int minSize;
        private final int maxSize;
        private final int minDistance;
        private final int maxDistance;
        private final long EUt;
        private final int duration;
        private final int minModuleTier;

        private SpaceMiningRecipePartTwo(List<Pair<Material, Integer>> outputs, long EUt, int computation, int weight,
                                         int minSize, int maxSize, int duration,  int minDistance, int maxDistance, int minModuleTier) {
            this.outputs        = outputs;
            this.computation    = computation;
            this.weight         = weight;
            this.minSize        = minSize;
            this.maxSize        = maxSize;
            this.duration       = duration;
            this.minDistance    = minDistance;
            this.maxDistance    = maxDistance;
            this.EUt            = EUt;
            this.minModuleTier  = minModuleTier;
        }

        public SpaceMiningRecipePartTwo copyAndUpTierRecipe(int tier) {
            return new SpaceMiningRecipePartTwo(this.outputs, this.EUt, this.computation, this.weight, this.minSize + tier * 4,
                    this.maxSize + tier * 8, (int) (this.duration - (this.duration * .1 * tier)), this.minDistance, this.maxDistance, this.minModuleTier);
        }


        public List<Pair<Material, Integer>> getOutputs() {
            return outputs;
        }

        public int getComputation() {
            return computation;
        }

        public int getWeight() {
            return weight;
        }

        public int getDuration() {
            return duration;
        }

        public int getMinSize() {
            return minSize;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public int getMinDistance() {
            return minDistance;
        }

        public int getMaxDistance() {
            return maxDistance;
        }

        public long getEUt() {
            return EUt;
        }

        public int getMinModuleTier() {
            return minModuleTier;
        }
    }
}
