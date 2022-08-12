package com.xpmodder.xpcraft;

import com.xpmodder.xpcraft.Util.LogHelper;
import com.xpmodder.xpcraft.Util.Reference;
import com.xpmodder.xpcraft.block.BlockInit;
import com.xpmodder.xpcraft.item.ItemEventHandler;
import com.xpmodder.xpcraft.item.ItemInit;
import com.xpmodder.xpcraft.tileentity.TileInit;
import com.xpmodder.xpcraft.xpsystem.item.itemXP;
import com.xpmodder.xpcraft.xpsystem.item.itemXPHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Reference.MODID)
public class XPCraft
{

    public XPCraft()
    {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the setup method for modloading
        eventBus.addListener(this::setup);

        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);

        ItemInit.ITEMS.register(eventBus);
        BlockInit.BLOCKS.register(eventBus);
        TileInit.TILEENTITIES.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.addListener(itemXPHandler::onServerStarted);

        MinecraftForge.EVENT_BUS.register(new ItemEventHandler());

    }


    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LogHelper.info("HELLO FROM PREINIT");
        LogHelper.info("DIRT BLOCK >> " + Blocks.DIRT.getRegistryName());
    }


    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo(Reference.MODID, "helloworld", () -> { LogHelper.info("Hello world from the MDK"); return "Hello world";});
    }


    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LogHelper.info("Got IMC {}" + event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

}
