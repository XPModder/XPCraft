package com.xpmodder.xpcraft.item;

import com.xpmodder.xpcraft.Util.LogHelper;
import com.xpmodder.xpcraft.xpsystem.item.itemXP;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;
import java.util.Set;

public class ItemEventHandler {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onTooltipEvent(ItemTooltipEvent event){

        boolean hasItem;

        if(event.getPlayer() == null){
            return;
        }

        hasItem = event.getPlayer().getInventory().hasAnyOf(Set.of(ItemInit.VISUALIZERITEM.get()));

        if(hasItem){

            int xp = itemXP.getXPForItem(event.getItemStack().getItem());

            if(xp > 0){
                event.getToolTip().add(new TextComponent("XP: " + xp));
            }

        }

    }

}
