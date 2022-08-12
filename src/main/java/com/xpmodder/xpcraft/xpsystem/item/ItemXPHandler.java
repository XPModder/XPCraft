package com.xpmodder.xpcraft.xpsystem.item;

import com.xpmodder.xpcraft.Util.LogHelper;
import com.xpmodder.xpcraft.Util.Reference;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public final class ItemXPHandler {

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event){

        LogHelper.info("ServerStartedEvent!");

        ItemXP.initialize();

        event.getServer().sendMessage(new TextComponent("XPCraft: Calculating item xp values..."), Util.NIL_UUID);

        RecipeManager manager = event.getServer().getRecipeManager();

        int oldCount, currentCount;

        do{

            oldCount = ItemXP.getItemCount();

            for(Recipe recipe : manager.getRecipes()){

                int totalXP = 0;
                boolean foundAll = true;

                if(ItemXP.getXPForItem(recipe.getResultItem().getItem()) != -1){
                    continue;
                }

                for(Object ingred : recipe.getIngredients()){
                    Ingredient ingredient = (Ingredient) ingred;

                    for(ItemStack stack : ingredient.getItems()){

                        Item item = stack.getItem();

                        int xp = ItemXP.getXPForItem(item);
                        if(xp == -1){
                            foundAll = false;
                            break;
                        }
                        totalXP += xp;


                    }

                }

                if(!foundAll){
                    continue;
                }
                if(totalXP <= 0){
                    continue;
                }

                if(recipe.getType() == RecipeType.SMELTING){
                    totalXP += 50;
                    Item resultItem = recipe.getResultItem().getItem();
                    ItemXP.addItem(resultItem, totalXP / (recipe.getResultItem().getCount()>0 ? recipe.getResultItem().getCount() : 1));
                }
                else if(recipe.getType() == RecipeType.CRAFTING){
                    Item resultItem = recipe.getResultItem().getItem();
                    ItemXP.addItem(resultItem, totalXP / (recipe.getResultItem().getCount()>0 ? recipe.getResultItem().getCount() : 1));
                }

            }

            currentCount = ItemXP.getItemCount();

        }while(oldCount != currentCount);

        if(Reference.DEBUG){
            ItemXP.printItems();
        }

        event.getServer().sendMessage(new TextComponent("XPCraft: Calculations done!"), Util.NIL_UUID);

    }



}
