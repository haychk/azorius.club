package me.hk.azorius.mixin.mixins;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiIngameMenu.class})
public class MixinGuiInGameMenu {
  @Inject(method = {"actionPerformed"}, at = {@At("HEAD")})
  public void actionPerformed(GuiButton button, CallbackInfo ci) {}
}


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinGuiInGameMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */