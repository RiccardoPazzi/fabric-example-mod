package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HadronMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("hadron_hackz");
    public static boolean autoFishingEnabled;
    public static boolean vehicleFlyingEnabled;
    public static AutoFishing fishingHack;
    public static VehicleFlyHack vehicleFly;


    public HadronMod()
    {
        autoFishingEnabled = true;
        vehicleFlyingEnabled = false;
        fishingHack = new AutoFishing();
        vehicleFly = new VehicleFlyHack();
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Fish Hooked!");
    }

}
