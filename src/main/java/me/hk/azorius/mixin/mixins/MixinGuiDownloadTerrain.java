/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.gui.GuiDownloadTerrain;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({GuiDownloadTerrain.class})
/*    */ public abstract class MixinGuiDownloadTerrain
/*    */   extends GuiScreen
/*    */ {
/*    */   @Inject(method = {"drawScreen"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) throws IOException {
/* 19 */     func_146278_c(0);
/*    */     
/* 21 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinGuiDownloadTerrain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */