package me.hk.azorius.mixin.mixins;

import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({FontRenderer.class})
public interface IFontRenderer {
  @Invoker("renderSplitString")
  void invokeRenderSplitString(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\IFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */