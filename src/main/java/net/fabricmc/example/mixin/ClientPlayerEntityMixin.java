package net.fabricmc.example.mixin;

import net.fabricmc.example.AutoFishing;
import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.HadronMod;
import net.fabricmc.example.VehicleFlyHack;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(CallbackInfo info) {
        AutoFishing.tick();
    }

    @Inject(at=@At("TAIL"), method = "tickRiding")
    public void tickRiding(CallbackInfo info) {
        // HadronMod.LOGGER.info("Riding a vehicle!");
        VehicleFlyHack.tick();
    }

}
