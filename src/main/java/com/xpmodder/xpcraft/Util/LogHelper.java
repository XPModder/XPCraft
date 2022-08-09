package com.xpmodder.xpcraft.Util;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public final class LogHelper {

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void info(Object object){
        LOGGER.info(object.toString());
    }

    public static void warn(Object object){
        LOGGER.warn(object.toString());
    }

    public static void error(Object object){
        LOGGER.error(object.toString());
    }

    public static void debug(Object object){
        LOGGER.debug(object.toString());
    }


}
