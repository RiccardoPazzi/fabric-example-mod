package net.fabricmc.example;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class VehicleFlyHack {
    public static MinecraftClient client = MinecraftClient.getInstance();
    public static Entity vehicle;
    public static Vec3d vel;
    public static int tickCounter = 0;
    public VehicleFlyHack()
    {
        //Empty constructor
    }
    public static void tick()
    {
        assert client.player != null;
        vehicle = client.player.getVehicle();
        if(vehicle != null && HadronMod.vehicleFlyingEnabled)
        {
            tickCounter++;
            vel = vehicle.getVelocity();
            boolean jumping = client.options.jumpKey.isPressed();
            boolean lowering = client.options.sprintKey.isPressed();
            double motionY =  jumping ? 0.5 : 0;
            motionY = lowering ? -0.5 : motionY;
            if (tickCounter > 30 && jumping) {
                vehicle.setVelocity(vel.x, -0.04, vel.z);
                HadronMod.LOGGER.info("Flown down");
                tickCounter = 0;
            }
            else
                vehicle.setVelocity(vel.x, motionY, vel.z);
        }
    }
}
