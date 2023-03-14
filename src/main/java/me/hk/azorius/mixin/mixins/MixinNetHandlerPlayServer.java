/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import net.minecraft.network.NetHandlerPlayServer;
/*    */ import net.minecraft.network.play.client.CPacketUseEntity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({NetHandlerPlayServer.class})
/*    */ public class MixinNetHandlerPlayServer
/*    */ {
/*    */   @Inject(method = {"processUseEntity"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/network/NetHandlerPlayServer;disconnect(Lnet/minecraft/util/text/ITextComponent;)V")}, cancellable = true)
/*    */   private void processUseEntity(CPacketUseEntity packetIn, CallbackInfo ci) {
/* 15 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinNetHandlerPlayServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */