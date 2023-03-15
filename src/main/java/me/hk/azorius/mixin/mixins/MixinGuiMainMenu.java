/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import java.awt.Desktop;
/*    */ import java.net.URI;
/*    */ import me.hk.azorius.features.gui.alt.AltGui;
/*    */ import me.hk.azorius.features.gui.management.RSManagerGui;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiMainMenu;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({GuiMainMenu.class})
/*    */ public abstract class MixinGuiMainMenu
/*    */   extends GuiScreen
/*    */ {
/*    */   @Inject(method = {"actionPerformed"}, at = {@At("HEAD")})
/*    */   public void actionPerformed(GuiButton button, CallbackInfo ci) {
/* 22 */     if (button.field_146127_k == 1000) {
/*    */       try {
/* 24 */         Desktop.getDesktop().browse(URI.create("https://discord.gg/kncfFHmfc4"));
/* 25 */       } catch (Exception exception) {}
/*    */     }
/*    */ 
/*    */     
/* 29 */     if (button.field_146127_k == 6969) {
/* 30 */       AltGui.isActive = !AltGui.isActive;
/*    */     }
/*    */     
/* 33 */     if (button.field_146127_k == 613) {
/* 34 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new RSManagerGui((GuiScreen)new GuiMainMenu(), Minecraft.func_71410_x()));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"drawScreen"}, at = {@At("RETURN")})
/*    */   private void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
/* 43 */     AltGui.drawScreen(mouseX, mouseY);
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"keyTyped"}, at = {@At("HEAD")})
/*    */   private void keyTyped(char typedChar, int keyCode, CallbackInfo ci) {
/* 49 */     AltGui.keyTyped(typedChar, keyCode);
/*    */   }
/*    */   
/*    */   @Inject(method = {"mouseClicked"}, at = {@At("HEAD")})
/*    */   private void mouseClicked(int mouseX, int mouseY, int mouseButton, CallbackInfo ci) {
/* 54 */     AltGui.mouseClicked(mouseX, mouseY, mouseButton);
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinGuiMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */