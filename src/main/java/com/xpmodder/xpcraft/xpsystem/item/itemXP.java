package com.xpmodder.xpcraft.xpsystem.item;

import com.xpmodder.xpcraft.Util.LogHelper;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public final class itemXP {

    private static final List<XPItem> items = new ArrayList<>();

    public static void initialize(){

        LogHelper.info("initialize!");

        addItem(Items.COBBLESTONE, 10);

        try {

            for (Item item : ForgeRegistries.ITEMS.tags().getTag(ItemTags.LOGS)) {
                addItem(item, 30);
            }

        }
        catch(NullPointerException ex){
            LogHelper.error("Encoutered NullPointerException in itemXP.initialize!");
        }

    }

    public static int getItemCount(){
        return items.size();
    }

    public static int getXPForItem(Item item){

        for(XPItem currentItem : items){
            if(currentItem.item == item){
                return currentItem.xp;
            }
        }

        return -1;
    }

    public static Item getItemForXP(int XP){

        for(XPItem currentItem : items){
            if(currentItem.xp == XP){
                return currentItem.item;
            }
        }

        return null;

    }

    public static void addItem(XPItem item){
        items.add(item);
    }

    public static void addItem(Item item, int xp){
        items.add(new XPItem(item, xp));
    }

    public static void printItems(){
        LogHelper.info("Items with xp values:");
        for(XPItem item : items){
            LogHelper.info(item.item.getRegistryName() + " xp: " + item.xp);
        }
        LogHelper.info("---------End of List----------");
    }

}
