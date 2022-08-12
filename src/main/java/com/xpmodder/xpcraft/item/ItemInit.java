package com.xpmodder.xpcraft.item;

import com.xpmodder.xpcraft.Util.Reference;
import com.xpmodder.xpcraft.block.BlockInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);


    public static final RegistryObject<Item> VISUALIZERITEM = ITEMS.register("xp_visualizer_item", () ->
            new Item(new Item.Properties().tab(Reference.CREATIVE_TAB)));

    public static final RegistryObject<Item> XPCOLLECORBLOCKITEM = ITEMS.register("xp_collector_block_item", () ->
            new BlockItem(BlockInit.XPCOLLECTOR.get(), new Item.Properties().tab(Reference.CREATIVE_TAB)));


}
