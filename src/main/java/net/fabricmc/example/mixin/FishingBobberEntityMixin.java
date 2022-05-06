package net.fabricmc.example.mixin;

import net.fabricmc.example.AutoFishing;
import net.fabricmc.example.HadronMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin {

    @Shadow private boolean caughtFish;

    @Inject(at = @At("TAIL"), method = "onTrackedDataSet")
    public void onTrackedDataset(TrackedData<?> data, CallbackInfo info)
    {
        MinecraftClient client = MinecraftClient.getInstance();
        if(caughtFish && HadronMod.autoFishingEnabled)
        {
            assert client.interactionManager != null;
            client.interactionManager.interactItem(client.player, client.world, Hand.MAIN_HAND);
            HadronMod.fishingHack.setRecastRod(20);
        }



    }
}
