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
