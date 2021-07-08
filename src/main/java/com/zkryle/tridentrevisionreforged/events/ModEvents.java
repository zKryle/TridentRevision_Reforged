package com.zkryle.tridentrevisionreforged.events;

import com.zkryle.tridentrevisionreforged.items.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class ModEvents{


    // Trident Repairing Recipe

    private int getEnchantmentCost(ItemStack stack){
        return stack.getEnchantmentTags().size()*2;
    }

    @SubscribeEvent
    public void onAnvilUpdated( AnvilUpdateEvent event){
        if (event.getLeft().getItem() == Items.TRIDENT && event.getLeft().isDamaged() && event.getRight().getItem() == ItemInit.ELDER_FRAGMENT.get()){
            ItemStack stack = event.getLeft().copy();
            int additionalcost = getEnchantmentCost( stack );
            if (event.getLeft().getDamageValue() > 0 && event.getLeft().getDamageValue() <= 30){
                event.setCost( 2 + additionalcost );
            } else if (event.getLeft().getDamageValue() >= 30 && event.getLeft().getDamageValue() <= 100){
                event.setCost( 5 + additionalcost);
            } else if (event.getLeft().getDamageValue() >= 100 && event.getLeft().getDamageValue() <= 200){
                event.setCost( 7 + additionalcost);
            } else if (event.getLeft().getDamageValue() >= 200){
                event.setCost( 10 + additionalcost);
            }
            stack.setDamageValue(  event.getLeft().getDamageValue() - 85 );
            event.setOutput( stack );
        }
    }
}