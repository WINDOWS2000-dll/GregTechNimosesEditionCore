package gtne.common;

import gtne.GTNEValues;
import net.minecraftforge.common.config.Config;

@Config(modid = GTNEValues.MODID)
public class ConfigHolder {

    @Config.Comment("Configuration of various recipes to be modified by GTNE")
    @Config.Name("Recipe Options")
    @Config.RequiresMcRestart
    public static RecipeOption recipeoption = new RecipeOption();

    public static class RecipeOption {

        @Config.Comment({"GregTech : New Horizons PlatLine Recipe [Default = true]"})
        @Config.Name("GTNH PlatLine")
        public boolean GTNHPlatLine = true;

        @Config.Comment("Higher difficulty for various low-level component recipes [Default = true]")
        @Config.Name("Components Assembler")
        public boolean Components_Assembler = true;

        @Config.Comment("Harder Wire Coil Recipes [Default = true]")
        @Config.Name("GTNE Wire Coil Recipe")
        public boolean Harder_Wire_Coil_Recipe = true;

    }
}
