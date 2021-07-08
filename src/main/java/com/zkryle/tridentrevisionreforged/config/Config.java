package com.zkryle.tridentrevisionreforged.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class Config{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> repair_recipe;

    static{
        BUILDER.push( "Trident Revision Reforged Config" );

        repair_recipe = BUILDER.comment( "Determines if the repair recipe should be enabled. Default value is true" )
                .define( "Repair Recipe", true );

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}