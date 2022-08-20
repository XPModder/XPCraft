package com.xpmodder.xpcraft.Util;

import com.xpmodder.xpcraft.xpsystem.item.ItemXP;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;
import java.util.function.Predicate;

public class ConfigHandler {

    public static ForgeConfigSpec CONFIG;

    public static ForgeConfigSpec.BooleanValue DEBUG_INFO;

    public static ForgeConfigSpec.ConfigValue<List<? extends List<? extends String>>> DEFAULT_ITEM_VALUES;



    static{
        generateConfig();
    }

    public static void generateConfig(){

        Predicate<Object> validator = o -> o instanceof List<?>;

        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General Settings");
        builder.push("general");

        DEBUG_INFO = builder.comment("Enable debug info in log").define("enableDebugInfo", false);

        builder.pop();

        builder.comment("XP Values");
        builder.push("xpValues");

        DEFAULT_ITEM_VALUES = builder.comment("XP values for base items - used to calculate xp for all other items")
                .defineList("baseItemValues", ItemXP.BASE_LIST, validator);

        builder.pop();



        CONFIG = builder.build();


    }

}
