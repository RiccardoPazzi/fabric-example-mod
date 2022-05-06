package net.fabricmc.example.GUI;

import net.fabricmc.example.HadronMod;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class ModScreen extends Screen {

    private final Screen parent;

    public ModScreen(Screen parent, GameOptions gameOptions) {
        super(new LiteralText("Hadron Hackz"));
        this.parent = parent;
    }

    LiteralText autoFishingText() {
        if(HadronMod.autoFishingEnabled)
            return new LiteralText("Autofishing enabled");
        else
            return new LiteralText("Autofishing disabled");
    }

    LiteralText vehicleFlyText() {
        if(HadronMod.vehicleFlyingEnabled)
            return new LiteralText("Flying enabled");
        else
            return new LiteralText("Flying disabled");
    }

    protected void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100,
                this.height / 6 + 90, 200, 20, autoFishingText(),
                (button) -> {
            HadronMod.autoFishingEnabled = !HadronMod.autoFishingEnabled;
            button.setMessage(autoFishingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100,
                this.height / 6 + 60, 200, 20, vehicleFlyText(),
                (button) -> {
                    HadronMod.vehicleFlyingEnabled = !HadronMod.vehicleFlyingEnabled;
                    button.setMessage(vehicleFlyText());
                }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100,
                this.height * 5 / 6 , 200, 20, ScreenTexts.BACK,
                (button) -> {
                    assert this.client != null;
                    this.client.setScreen(this.parent);
                            }
                ));
    }
}
