/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import me.hk.azorius.features.modules.render.Nametags;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({RenderPlayer.class})
/*    */ public class MixinRenderPlayer
/*    */ {
/*    */   @Inject(method = {"renderEntityName"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void renderEntityNameHook(AbstractClientPlayer entityIn, double x, double y, double z, String name, double distanceSq, CallbackInfo info) {
/* 16 */     if (Nametags.getInstance().isOn())
/* 17 */       info.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinRenderPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */