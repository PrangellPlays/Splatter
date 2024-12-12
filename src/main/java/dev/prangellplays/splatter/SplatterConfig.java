package dev.prangellplays.splatter;

import eu.midnightdust.lib.config.MidnightConfig;

public class SplatterConfig extends MidnightConfig {
    public static final String client = "client";
    public static final String common = "common";
    //Client
    @Entry(category = client)
    public static boolean inkParticles = true;

    //Common

}