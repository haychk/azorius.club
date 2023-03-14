/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.Objects;
/*    */ import me.hk.azorius.features.modules.client.MontageEnder;
/*    */ import me.hk.azorius.features.modules.client.NickHider;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.client.network.NetworkPlayerInfo;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({NetworkPlayerInfo.class})
/*    */ public abstract class MixinNetworkPlayerInfo
/*    */ {
/*    */   @Shadow
/*    */   public abstract GameProfile func_178845_a();
/*    */   
/*    */   @Inject(method = {"getLocationSkin"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void getLocationSkin(CallbackInfoReturnable<ResourceLocation> cir) {
/* 29 */     ResourceLocation old = (ResourceLocation)cir.getReturnValue();
/*    */     
/* 31 */     NetworkPlayerInfo info = ((NetHandlerPlayClient)Objects.<NetHandlerPlayClient>requireNonNull(Minecraft.func_71410_x().func_147114_u())).func_175104_a(Minecraft.func_71410_x().func_110432_I().func_111285_a());
/* 32 */     if (info != null && func_178845_a().equals(info.func_178845_a())) {
/* 33 */       String s = ((String)(NickHider.getInstance()).skinFile.getValue()).toLowerCase();
/* 34 */       ResourceLocation mark = new ResourceLocation("minecraft", "skins/" + s + ".png");
/* 35 */       if (NickHider.getInstance().isOn() && ((Boolean)(NickHider.getInstance()).skinChanger.getValue()).booleanValue()) {
/* 36 */         cir.setReturnValue(mark);
/* 37 */       } else if (old != null) {
/* 38 */         cir.setReturnValue(old);
/*    */       } 
/*    */     } 
/* 41 */     NetworkPlayerInfo networkplayerinfo = ((NetHandlerPlayClient)Objects.<NetHandlerPlayClient>requireNonNull(Minecraft.func_71410_x().func_147114_u())).func_175104_a((String)(MontageEnder.getInstance()).nameString.getValue());
/* 42 */     if (networkplayerinfo != null && func_178845_a().equals(networkplayerinfo.func_178845_a())) {
/* 43 */       String s = ((String)(MontageEnder.getInstance()).skinFile.getValue()).toLowerCase();
/* 44 */       ResourceLocation mark = new ResourceLocation("minecraft", "skins/" + s + ".png");
/* 45 */       if (MontageEnder.getInstance().isOn()) {
/* 46 */         cir.setReturnValue(mark);
/* 47 */       } else if (old != null) {
/* 48 */         cir.setReturnValue(old);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinNetworkPlayerInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */