package com.zkryle.tridentrevisionreforged;

import com.zkryle.tridentrevisionreforged.config.Config;
import com.zkryle.tridentrevisionreforged.events.ModEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.zkryle.tridentrevisionreforged.items.ItemInit.ITEMS;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tridentrevisionreforged")
public class TridentRevisionReforged{

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "tridentrevisionreforged";

    public TridentRevisionReforged() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register( bus );

        ModLoadingContext.get().registerConfig( ModConfig.Type.COMMON, Config.SPEC, "trident-revision-reforged-common.toml" );
        MinecraftForge.EVENT_BUS.register(new ModEvents());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
