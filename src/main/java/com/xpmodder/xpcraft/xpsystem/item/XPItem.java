package com.xpmodder.xpcraft.xpsystem.item;

import net.minecraft.world.item.Item;

public class XPItem {
    public Item item;
    public int xp;

    public XPItem(Item item, int xp){
        this.item = item;
        this.xp = xp;
    }

}
