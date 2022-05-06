package net.fabricmc.example.mixin;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.GUI.ModScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {

    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "initWidgets", require = 1)
    void initWidgets(CallbackInfo ci) {

        this.addDrawableChild(new ButtonWidget(10, 10, 100, 20,
                new LiteralText("HadronHackz"),
                btn -> {
                    assert this.client != null;
                    this.client.setScreen(new ModScreen(this, this.client.options));
                }));
}
}
