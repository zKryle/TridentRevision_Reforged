package com.zkryle.tridentrevisionreforged.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


import static com.zkryle.tridentrevisionreforged.TridentRevisionReforged.MOD_ID;

public class ItemInit{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister
            .create( ForgeRegistries.ITEMS,  MOD_ID);

    public static final RegistryObject <Item> ELDER_FRAGMENT = ITEMS.register( "elder_fragment",
            () -> new Item( new Item.Properties().tab( CreativeModeTab.TAB_MISC ) ) );
}
