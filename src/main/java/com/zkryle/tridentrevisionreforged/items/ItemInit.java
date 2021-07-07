package com.zkryle.tridentrevisionreforged.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import static com.zkryle.tridentrevisionreforged.TridentRevisionReforged.MOD_ID;

public class ItemInit{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister
            .create( ForgeRegistries.ITEMS,  MOD_ID);

    public static final RegistryObject<Item> ELDER_FRAGMENT = ITEMS.register( "elder_fragment",
            () -> new Item( new Item.Properties().tab( ItemGroup.TAB_MISC ) ) );
}
