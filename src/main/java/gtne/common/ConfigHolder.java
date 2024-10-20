package gtne.common;

import gtne.GTNEValues;
import net.minecraftforge.common.config.Config;

@Config(modid = GTNEValues.MODID)
public class ConfigHolder {

    /**
     * GregTechNimosesEditionCoreで追加されるレシピの構成
     */

    @Config.Comment("Configuration of various recipes to be modified by GTNE")
    @Config.Name("Recipe Options")
    @Config.RequiresMcRestart
    public static RecipeOption recipeoption = new RecipeOption();

    /**
     * GTNEが追加する各種MetaTileEntityの構成
     * 注意！！このコンフィグを無効にすると、一部のMetaTileEntityが消滅します！！
     * 注意事項をよく理解した上でコンフィグを操作してください！
     */

    @Config.Comment({"Configuration of various MetaTileEntity to be added by GTNE",
            "Caution!!!Disabling this config will cause some MetaTileEntity to disappear!",
            "Please operate the configurations with a good understanding of the precautions!",})
    @Config.Name("MetaTileEntity Options")
    @Config.RequiresMcRestart
    public static MetaTileEntityOptions metaTileEntityOptions = new MetaTileEntityOptions();

    /**
     * OreDictionaryの構成
     * この設定を変更することは推奨されません!!!!
     * "本当に特別 "な意図を持っている場合のみ変更してください
     * 忠告しましたからね！！！！
     */

    @Config.Comment({"Configuration of OreDictionary",
            "Changing this setting is not recommended!!!!!",
            "Change only if you have a \"really special\" intention"})
    @Config.Name("Ore Dictionary Integration")
    @Config.RequiresMcRestart
    public static OreDictIntegration oreDictIntegration = new OreDictIntegration();

    /**
     * その他のコンフィグです。
     * 基本内部システムに直接関係しません。
     */

    @Config.Comment({"Other configurations.",
            "Not directly related to the basic internal system"})
    @Config.Name("Other")
    @Config.RequiresMcRestart
    public static Other other = new Other();

    public static class RecipeOption {

        /**
         * GregTech : New Horizons準拠の希土類金属精製ライン
         */

        @Config.Comment({"GregTech : New Horizons PlatLine Recipe [Default = true]"})
        @Config.Name("GTNH PlatLine")
        public boolean GTNHPlatLine = true;

        /**
         * 各種低レベル部品レシピの難易度アップ
         * 注意！！この設定を無効にすると、一部のMetaTileEntityが消滅してしまいます！
         * 注意事項をよく理解した上で、このコンフィグを操作してください！
         */

        @Config.Comment({"Higher difficulty for various low-level component recipes",
                "Caution!!!Disabling this config will cause some MetaTileEntity to disappear!",
                "Please operate the configurations with a good understanding of the precautions!",
                "[Default = true]"})
        @Config.Name("Components Assembler")
        public boolean Components_Assembler = true;

        /**
         * 一部EBFレシピの難易度上昇
         */

        @Config.Comment("Higher difficulty for some recipes in EBF [Default = true]")
        @Config.Name("Harder EBF Recipes")
        public boolean Harder_EBF_Recipe = true;

        /**
         * 高炉コイルレシピの高難度化
         */

        @Config.Comment("Harder Wire Coil Recipes [Default = true]")
        @Config.Name("GTNE Wire Coil Recipe")
        public boolean Harder_Wire_Coil_Recipe = true;

        /**
         * GregTech : New Horizons準拠のシリコンライン
         */

        @Config.Comment("GregTech : New Horizons like Silicon Line [Default = true]")
        @Config.Name("GTNH Silicon Line")
        public boolean GTNHSiliconLine = true;

        /**
         * このコンフィグを有効にすると水を使用する一部のレシピの難易度が大幅に上昇します
         */

        @Config.Comment({"GTNE Water System [Default = true]",
        "If this configuration is enabled, the",
        "water-related recipes will become much more difficult."})
        @Config.Name("GTNE Harder Water Recipe")
        public boolean Harder_Water_Recipe = true;

        /**
         * LuV層以上の機械の大幅な高難易度化
         */

        @Config.Comment({"Super HardMode LateGame[Default = true]",
        "Activating this config will require an Assembly Line to create a machine above the LuV Age,",
        "greatly increasing the difficulty of the LateGame."})
        @Config.Name("Super HardMode LateGame")
        public boolean Super_HardMode_LateGame = true;

        /**
         * LuV層以降の各種機械部品の難易度上昇
         */

        @Config.Comment({"Higher difficulty in creating various machine parts after LuV [Default = true]",
        "This configuration is automatically disabled when the Component Assembler configuration is disabled."})
        @Config.Name("Harder LateGame Components Recipe")
        public boolean Harder_LateGame_Components_Recipe = true;

        /**
         * Computation周りの設備のレシピ難易度の上昇
         */

        @Config.Comment({"Activating this config will greatly increase the difficulty of Late Game computer-related recipes! [Default = true]"})
        @Config.Name("Harder_Computation_System_Recipe")
        public boolean Harder_Computation_System_Recipe = true;

        /**
         * バニラレシピの改変
         */
        @Config.Comment("Activating this config will increase the difficulty of the recipe for vanilla items [Default = true]")
        @Config.Name("Harder_Vanilla_Recipe")
        public boolean Harder_Vanilla_Recipe = true;

        /**
         * Neutronium レシピの修正(要AS)
         */
        @Config.Comment("Tweaking of recipes around Neutronium (AS required) [Default = true]")
        @Config.Name("Neutronium Fix")
        public boolean Neutronium_Fix = true;

    }

    public static class MetaTileEntityOptions {

        /**
         * より高いTier(Late UV ~ MAX)のエネルギーハッチ、ダイナモハッチの有無に関する構成
         */

        @Config.Comment("Add Higher Tier Energy Hatch [Default = true]")
        @Config.Name("Higher Tier Energy Hatch")
        public boolean HigherTierEnergyHatch = true;
    }

    public static class OreDictIntegration {

        /**
         * 各種MODのアイテムの鉱石辞書との統合設定です
         * 変更は推奨せず、変更によって生じたいかなる問題も開発者は対応しません
         */

        @Config.Comment({"It is an integrated setting with the ore dictionary of items of various mods",
                "Changes are not recommended and the developer will not address any issues caused by the changes.",
                "[Default = true]"})
        @Config.Name("Ore Dictionary Integration")
        public boolean OreDictIntegration = true;
    }

    /**
     * 休日や記念日などに表示されるログインメッセージの有無の設定です
     */

    public static class Other {
        @Config.Comment({"This is the setting for whether or not login messages are displayed on holidays, anniversaries, etc.",
        "[Default = true]"})
        @Config.Name("Holidays Message")
        public boolean Holidays_Message = true;
    }
}
