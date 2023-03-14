/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import java.util.UUID;
/*    */ import me.hk.azorius.features.modules.client.MontageEnder;
/*    */ import me.hk.azorius.util.PlayerUtil;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.client.network.NetworkPlayerInfo;
/*    */ import net.minecraft.client.resources.DefaultPlayerSkin;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({DefaultPlayerSkin.class})
/*    */ public class MixinDefaultPlayerSkin
/*    */ {
/*    */   @Inject(method = {"getSkinType"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void getSkinType(UUID playerUUID, CallbackInfoReturnable<String> cir) {
/* 26 */     NetworkPlayerInfo networkplayerinfo = ((NetHandlerPlayClient)Objects.<NetHandlerPlayClient>requireNonNull(Minecraft.func_71410_x().func_147114_u())).func_175104_a((String)(MontageEnder.getInstance()).nameString.getValue());
/* 27 */     if (networkplayerinfo != null && playerUUID.equals(PlayerUtil.getUUIDFromName((String)(MontageEnder.getInstance()).nameString.getValue())))
/*    */     {
/* 29 */       cir.setReturnValue(((MontageEnder.skinType)(MontageEnder.getInstance()).skinTypeSetting.getValue()).equals(MontageEnder.skinType.NORMAL) ? "default" : "slim");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinDefaultPlayerSkin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */