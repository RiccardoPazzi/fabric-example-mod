package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoFishing {

    public static int recastRod = -1;
    public static MinecraftClient client = MinecraftClient.getInstance();
    // public static final Logger LOGGER = LoggerFactory.getLogger("auto-fish");

    public static void tick()
    {
        // LOGGER.info("" + recastRod);
        if(recastRod > 0)
        {
            recastRod--;
        }
        if(recastRod==0  && HadronMod.autoFishingEnabled)
        {
            assert client.interactionManager != null;
            client.interactionManager.interactItem(client.player, client.world, Hand.MAIN_HAND);
            recastRod = -1;
        }
    }

    public void setRecastRod(int value)
    {
        recastRod = value;
    }

}
