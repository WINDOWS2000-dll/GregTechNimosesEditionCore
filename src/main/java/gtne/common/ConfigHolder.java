package gtne.common;

import gtne.GTNEValues;
import net.minecraftforge.common.config.Config;

@Config(modid = GTNEValues.MODID)
public class ConfigHolder {

    @Config.Comment("Configuration of various recipes to be modified by GTNE")
    @Config.Name("Recipe Options")
    @Config.RequiresMcRestart
    public static RecipeOption recipeoption = new RecipeOption();

    @Config.Comment({"Configuration of various MetaTileEntity to be added by GTNE",
            "Caution!!!Disabling this config will cause some MetaTileEntity to disappear!",
            "Please operate the configurations with a good understanding of the precautions!",})
    @Config.Name("MetaTileEntity Options")
    @Config.RequiresMcRestart
    public static MetaTileEntityOptions metaTileEntityOptions = new MetaTileEntityOptions();

    public static class RecipeOption {

        @Config.Comment({"GregTech : New Horizons PlatLine Recipe [Default = true]"})
        @Config.Name("GTNH PlatLine")
        public boolean GTNHPlatLine = true;

        @Config.Comment({"Higher difficulty for various low-level component recipes",
                "Caution!!!Disabling this config will cause some MetaTileEntity to disappear!",
                "Please operate the configurations with a good understanding of the precautions!",
                "[Default = true]"})
        @Config.Name("Components Assembler")
        public boolean Components_Assembler = true;

        @Config.Comment("Harder Wire Coil Recipes [Default = true]")
        @Config.Name("GTNE Wire Coil Recipe")
        public boolean Harder_Wire_Coil_Recipe = true;

        @Config.Comment("GregTech : New Horizons like Silicon Line [Default = true]")
        @Config.Name("GTNH Silicon Line")
        public boolean GTNHSiliconLine = true;

        @Config.Comment({"GTNE Water System [Default = true]",
        "If this configuration is enabled, the",
        "water-related recipes will become much more difficult."})
        @Config.Name("GTNE Harder Water Recipe")
        public boolean Harder_Water_Recipe = true;

    }

    public static class MetaTileEntityOptions {
        @Config.Comment("Add Higher Tier Energy Hatch [Default = true]")
        @Config.Name("Higher Tier Energy Hatch")
        public boolean HigherTierEnergyHatch = true;
    }
}
