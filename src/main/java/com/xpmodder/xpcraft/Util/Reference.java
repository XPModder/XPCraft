package com.xpmodder.xpcraft.Util;

import com.xpmodder.xpcraft.item.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class Reference {

    public static final String MODID = "xpcraft";

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab("mod_creative_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.VISUALIZERITEM.get());
        }
    };

    public static final boolean DEBUG = true;

}
