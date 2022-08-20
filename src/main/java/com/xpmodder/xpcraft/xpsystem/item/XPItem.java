package com.xpmodder.xpcraft.xpsystem.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class XPItem {
    public Item item;
    public int xp;

    public XPItem(Item item, int xp){
        this.item = item;
        this.xp = xp;
    }

    public List<String> getAsList(){
        return Arrays.asList(Objects.requireNonNull(item.getRegistryName()).toString(), String.valueOf(xp));
    }

    public static XPItem createFromList(List<? extends String> list){
        if(list.size() != 2){
            return null;
        }
        int nXP = Integer.parseInt(list.get(1));
        Item nItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(list.get(0)));
        return new XPItem(nItem, nXP);
    }

}
