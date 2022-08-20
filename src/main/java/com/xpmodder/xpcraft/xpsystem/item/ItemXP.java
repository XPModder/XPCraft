package com.xpmodder.xpcraft.xpsystem.item;

import com.xpmodder.xpcraft.Util.ConfigHandler;
import com.xpmodder.xpcraft.Util.LogHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class ItemXP {

    private static final List<XPItem> items = new ArrayList<>();

    public static final List<List<String>> BASE_LIST = Arrays.asList(
            //------------------------TAGS------------------------------
            Arrays.asList("minecraft:logs", "30"),
            Arrays.asList("minecraft:leaves", "10"),


            //---------------------BASE BLOCKS--------------------------
            new XPItem(Items.COBBLESTONE, 10).getAsList(),
            new XPItem(Items.COBBLED_DEEPSLATE, 110).getAsList(),

            new XPItem(Items.DIRT, 1).getAsList(),
            new XPItem(Items.COARSE_DIRT, 1).getAsList(),
            new XPItem(Items.GRASS_BLOCK, 2).getAsList(),
            new XPItem(Items.PODZOL, 2).getAsList(),
            new XPItem(Items.MYCELIUM, 2).getAsList(),
            new XPItem(Items.ROOTED_DIRT, 2).getAsList(),

            new XPItem(Items.SAND, 20).getAsList(),
            new XPItem(Items.RED_SAND, 20).getAsList(),
            new XPItem(Items.GRAVEL, 40).getAsList(),
            new XPItem(Items.FLINT, 60).getAsList(),

            new XPItem(Items.NETHERRACK, 5).getAsList(),
            new XPItem(Items.SOUL_SAND, 10).getAsList(),
            new XPItem(Items.SOUL_SOIL, 15).getAsList(),
            new XPItem(Items.BLACKSTONE, 30).getAsList(),


            //----------------------PLANTS--------------------------------
            new XPItem(Items.NETHER_WART, 2400).getAsList(),

            new XPItem(Items.SUGAR_CANE, 1120).getAsList(),

            new XPItem(Items.BEETROOT_SEEDS, 800).getAsList(),

            new XPItem(Items.WHEAT, 1200).getAsList(),
            new XPItem(Items.WHEAT_SEEDS, 800).getAsList(),

            new XPItem(Items.POTATO, 1200).getAsList(),
            new XPItem(Items.POISONOUS_POTATO, 800).getAsList(),

            new XPItem(Items.CARROT, 1200).getAsList(),

            new XPItem(Items.MELON_SEEDS, 800).getAsList(),
            new XPItem(Items.PUMPKIN_SEEDS, 800).getAsList(),
            new XPItem(Items.MELON, 1200).getAsList(),
            new XPItem(Items.PUMPKIN, 1200).getAsList(),
            new XPItem(Items.MELON_SLICE, 300).getAsList(),
            new XPItem(Items.CARVED_PUMPKIN, 1250).getAsList(),

            new XPItem(Items.KELP, 200).getAsList(),
            new XPItem(Items.BAMBOO, 200).getAsList(),

            new XPItem(Items.OAK_SAPLING, 2000).getAsList(),
            new XPItem(Items.BIRCH_SAPLING, 2000).getAsList(),
            new XPItem(Items.SPRUCE_SAPLING, 2000).getAsList(),
            new XPItem(Items.JUNGLE_SAPLING, 2000).getAsList(),
            new XPItem(Items.ACACIA_SAPLING, 2000).getAsList(),
            new XPItem(Items.DARK_OAK_SAPLING, 2000).getAsList(),
            new XPItem(Items.AZALEA, 2000).getAsList(),
            new XPItem(Items.FLOWERING_AZALEA, 2000).getAsList(),

            new XPItem(Items.BROWN_MUSHROOM, 2000).getAsList(),
            new XPItem(Items.RED_MUSHROOM, 2000).getAsList(),
            new XPItem(Items.CRIMSON_FUNGUS, 2000).getAsList(),
            new XPItem(Items.WARPED_FUNGUS, 2000).getAsList(),

            new XPItem(Items.VINE, 200).getAsList(),
            new XPItem(Items.TWISTING_VINES, 200).getAsList(),
            new XPItem(Items.WEEPING_VINES, 200).getAsList(),
            new XPItem(Items.GLOW_BERRIES, 300).getAsList(),

            new XPItem(Items.CRIMSON_ROOTS, 400).getAsList(),
            new XPItem(Items.WARPED_ROOTS, 400).getAsList(),
            new XPItem(Items.HANGING_ROOTS, 400).getAsList(),
            new XPItem(Items.NETHER_SPROUTS, 400).getAsList(),

            new XPItem(Items.SEAGRASS, 400).getAsList(),
            new XPItem(Items.GRASS, 400).getAsList(),
            new XPItem(Items.TALL_GRASS, 800).getAsList(),
            new XPItem(Items.FERN, 400).getAsList(),
            new XPItem(Items.LARGE_FERN, 800).getAsList(),
            new XPItem(Items.GLOW_LICHEN, 400).getAsList(),
            new XPItem(Items.LILY_PAD, 400).getAsList(),
            new XPItem(Items.DEAD_BUSH, 1).getAsList(),
            new XPItem(Items.SWEET_BERRIES, 300).getAsList(),

            new XPItem(Items.SPORE_BLOSSOM, 5000).getAsList(),
            new XPItem(Items.MOSS_BLOCK, 2000).getAsList(),
            new XPItem(Items.SMALL_DRIPLEAF, 1500).getAsList(),
            new XPItem(Items.BIG_DRIPLEAF, 1500).getAsList(),


            //-----------------------DYES----------------------------------
            new XPItem(Items.LILY_OF_THE_VALLEY, 1200).getAsList(),
            new XPItem(Items.BONE, 3600).getAsList(),

            new XPItem(Items.DANDELION, 1200).getAsList(),
            new XPItem(Items.SUNFLOWER, 2400).getAsList(),

            new XPItem(Items.ORANGE_TULIP, 1200).getAsList(),

            new XPItem(Items.POPPY, 1200).getAsList(),
            new XPItem(Items.RED_TULIP, 1200).getAsList(),
            new XPItem(Items.ROSE_BUSH, 2400).getAsList(),
            new XPItem(Items.BEETROOT, 1200).getAsList(),

            new XPItem(Items.PINK_TULIP, 1200).getAsList(),
            new XPItem(Items.PEONY, 2400).getAsList(),

            new XPItem(Items.ALLIUM, 1200).getAsList(),
            new XPItem(Items.LILAC, 2400).getAsList(),

            //No new Items for color Purple

            new XPItem(Items.BLUE_ORCHID, 1200).getAsList(),

            new XPItem(Items.LAPIS_LAZULI, 1200).getAsList(),
            new XPItem(Items.CORNFLOWER, 1200).getAsList(),

            //No new Items for color Cyan

            new XPItem(Items.SEA_PICKLE, 1120).getAsList(),

            new XPItem(Items.CACTUS, 1120).getAsList(),

            new XPItem(Items.COCOA_BEANS, 1200).getAsList(),

            new XPItem(Items.AZURE_BLUET, 1200).getAsList(),
            new XPItem(Items.OXEYE_DAISY, 1200).getAsList(),
            new XPItem(Items.WHITE_TULIP, 1200).getAsList(),

            //No new Items for color Gray

            new XPItem(Items.INK_SAC, 1200).getAsList(),
            new XPItem(Items.WITHER_ROSE, 20000).getAsList(),


            //---------------------GROUND BLOCKS------------------------
            new XPItem(Items.ANDESITE, 450).getAsList(),
            new XPItem(Items.DIORITE, 500).getAsList(),
            new XPItem(Items.GRANITE, 450).getAsList(),
            new XPItem(Items.CALCITE, 900).getAsList(),
            new XPItem(Items.TUFF, 800).getAsList(),
            new XPItem(Items.OBSIDIAN, 5000).getAsList(),
            new XPItem(Items.GILDED_BLACKSTONE, 5000).getAsList(),
            new XPItem(Items.CRYING_OBSIDIAN, 6000).getAsList(),

            new XPItem(Items.CLAY_BALL, 60).getAsList(),

            new XPItem(Items.WARPED_WART_BLOCK, 21600).getAsList(),


            //-------------------------ORES-----------------------------
            new XPItem(Items.COAL_ORE, 200).getAsList(),
            new XPItem(Items.DEEPSLATE_COAL_ORE, 300).getAsList(),

            new XPItem(Items.COPPER_ORE, 400).getAsList(),
            new XPItem(Items.DEEPSLATE_COPPER_ORE, 500).getAsList(),

            new XPItem(Items.IRON_ORE, 600).getAsList(),
            new XPItem(Items.DEEPSLATE_IRON_ORE, 700).getAsList(),

            new XPItem(Items.GOLD_ORE, 1000).getAsList(),
            new XPItem(Items.DEEPSLATE_GOLD_ORE, 1100).getAsList(),
            new XPItem(Items.NETHER_GOLD_ORE, 600).getAsList(),

            new XPItem(Items.REDSTONE_ORE, 1200).getAsList(),
            new XPItem(Items.DEEPSLATE_REDSTONE_ORE, 1300).getAsList(),

            new XPItem(Items.LAPIS_ORE, 1400).getAsList(),
            new XPItem(Items.DEEPSLATE_LAPIS_ORE, 1500).getAsList(),

            new XPItem(Items.DIAMOND_ORE, 2100).getAsList(),
            new XPItem(Items.DEEPSLATE_DIAMOND_ORE, 1800).getAsList(),

            new XPItem(Items.EMERALD_ORE, 1600).getAsList(),
            new XPItem(Items.DEEPSLATE_EMERALD_ORE, 1700).getAsList(),

            new XPItem(Items.NETHER_QUARTZ_ORE, 800).getAsList(),

            new XPItem(Items.GLOWSTONE_DUST, 900).getAsList(),
            new XPItem(Items.AMETHYST_SHARD, 1100).getAsList(),

            new XPItem(Items.ANCIENT_DEBRIS, 18000).getAsList(),

            //------------------Mob Drops---------------------------------
            new XPItem(Items.STRING, 3000).getAsList(),
            new XPItem(Items.SPIDER_EYE, 5000).getAsList(),
            new XPItem(Items.GUNPOWDER, 4000).getAsList(),
            new XPItem(Items.ROTTEN_FLESH, 2500).getAsList(),
            new XPItem(Items.SLIME_BALL, 5000).getAsList(),
            new XPItem(Items.HONEY_BOTTLE, 11250).getAsList(),
            new XPItem(Items.HONEYCOMB, 11250).getAsList(),
            new XPItem(Items.GLOW_INK_SAC, 1500).getAsList(),
            new XPItem(Items.ENDER_PEARL, 5500).getAsList(),
            new XPItem(Items.BLAZE_ROD, 5500).getAsList(),
            new XPItem(Items.PORKCHOP, 12000).getAsList(),
            new XPItem(Items.COD, 15000).getAsList(),
            new XPItem(Items.SALMON, 15000).getAsList(),
            new XPItem(Items.TROPICAL_FISH, 15000).getAsList(),
            new XPItem(Items.PUFFERFISH, 15000).getAsList(),
            new XPItem(Items.BEEF, 15000).getAsList(),
            new XPItem(Items.CHICKEN, 15000).getAsList(),
            new XPItem(Items.RABBIT, 15000).getAsList(),
            new XPItem(Items.MUTTON, 15000).getAsList(),
            new XPItem(Items.APPLE, 1100).getAsList(),
            new XPItem(Items.FEATHER, 14000).getAsList(),
            new XPItem(Items.EGG, 1100).getAsList(),
            new XPItem(Items.LEATHER, 14000).getAsList(),

            new XPItem(Items.SHULKER_SHELL, 15000).getAsList(),

            new XPItem(Items.NETHER_STAR, 25000).getAsList()
    );

    public static void initialize(){

        LogHelper.info("initialize!");

        for(List<? extends String> list : ConfigHandler.DEFAULT_ITEM_VALUES.get()){

            if(list.size() != 2){
                continue;
            }

            if(ForgeRegistries.ITEMS.getValue(new ResourceLocation(list.get(0))) == Items.AIR){

                LogHelper.info("Not an item: " + list.get(0));

                ITagManager<Item> manager = Objects.requireNonNull(ForgeRegistries.ITEMS.tags());
                TagKey<Item> key = manager.createTagKey(new ResourceLocation(list.get(0)));

                for (Item item : Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(key)) {
                    addItem(item, Integer.parseInt(list.get(1)));
                }

            }
            else {
                XPItem xpItem = XPItem.createFromList(list);
                if (xpItem != null) {
                    addItem(xpItem);
                }
            }

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

        items.removeIf(xpItem -> xpItem.item == item);

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
