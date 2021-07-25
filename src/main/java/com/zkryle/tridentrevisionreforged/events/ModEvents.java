package com.zkryle.tridentrevisionreforged.events;

import com.zkryle.tridentrevisionreforged.config.Config;
import com.zkryle.tridentrevisionreforged.items.ItemInit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents{


    // Trident Repairing Recipe

    private int getEnchantmentCost( ItemStack stack){
        return stack.getEnchantmentTags().size()*2;
    }

    @SubscribeEvent
    public void onAnvilUpdated( AnvilUpdateEvent event){
        if(Config.repair_recipe.get()){
            if(event.getLeft().getItem() == Items.TRIDENT && event.getLeft().isDamaged() && event.getRight().getItem() == ItemInit.ELDER_FRAGMENT.get()){
                ItemStack stack = event.getLeft().copy();
                int additionalcost = getEnchantmentCost( stack );
                if(event.getLeft().getDamageValue() > 0 && event.getLeft().getDamageValue() <= 30){
                    stack.setDamageValue( event.getLeft().getDamageValue() - 85 );
                    event.setMaterialCost( 1 );
                    event.setCost( 2 + additionalcost );
                }else if(event.getLeft().getDamageValue() >= 30 && event.getLeft().getDamageValue() <= 100){
                    stack.setDamageValue( event.getLeft().getDamageValue() - 85 );
                    event.setMaterialCost( 1 );
                    event.setCost( 5 + additionalcost );
                }else if(event.getLeft().getDamageValue() >= 100 && event.getLeft().getDamageValue() <= 200){
                    stack.setDamageValue( event.getLeft().getDamageValue() - 170 );
                    event.setMaterialCost( 2 );
                    event.setCost( 7 + additionalcost );
                }else if(event.getLeft().getDamageValue() >= 200){
                    event.setMaterialCost( 3 );
                    stack.setDamageValue( event.getLeft().getDamageValue() - 250 );
                    event.setCost( 10 + additionalcost );
                }
                event.setOutput( stack );
            }
        }
    }
}
