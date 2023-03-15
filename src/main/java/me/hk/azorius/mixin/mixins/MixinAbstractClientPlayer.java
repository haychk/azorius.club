/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import javax.annotation.Nullable;
/*    */ import me.hk.azorius.features.command.Command;
/*    */ import me.hk.azorius.features.modules.Module;
/*    */ import me.hk.azorius.features.modules.client.MontageEnder;
/*    */ import me.hk.azorius.features.modules.client.NickHider;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
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
/*    */ @Mixin({AbstractClientPlayer.class})
/*    */ public abstract class MixinAbstractClientPlayer
/*    */ {
/*    */   @Shadow
/*    */   @Nullable
/*    */   protected abstract NetworkPlayerInfo func_175155_b();
/*    */   
/*    */   @Inject(method = {"getLocationSkin()Lnet/minecraft/util/ResourceLocation;"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void getLocationSkin(CallbackInfoReturnable<ResourceLocation> cir) {
/* 30 */     ResourceLocation old = (ResourceLocation)cir.getReturnValue();
/*    */     
/* 32 */     NetworkPlayerInfo info = ((NetHandlerPlayClient)Objects.<NetHandlerPlayClient>requireNonNull(Minecraft.func_71410_x().func_147114_u())).func_175104_a(Minecraft.func_71410_x().func_110432_I().func_111285_a());
/* 33 */     if (func_175155_b() != null && info != null && 
/* 34 */       info.equals(func_175155_b())) {
/* 35 */       ResourceLocation mark = new ResourceLocation("minecraft", "skins/" + (NickHider.getInstance()).skinFile.getValueAsString() + ".png");
/* 36 */       if (NickHider.getInstance().isOn() && ((Boolean)(NickHider.getInstance()).skinChanger.getValue()).booleanValue()) {
/* 37 */         if (((Boolean)(NickHider.getInstance()).debug.getValue()).booleanValue() && NickHider.debugTimer.passedMs(((Integer)(NickHider.getInstance()).debugDelay.getValue()).intValue())) {
/* 38 */           Command.sendDebugMessage("Path: " + mark.toString(), (Module)NickHider.getInstance());
/* 39 */           NickHider.debugTimer.reset();
/*    */         } 
/* 41 */         cir.setReturnValue(mark);
/* 42 */       } else if (old != null) {
/* 43 */         cir.setReturnValue(old);
/*    */       } 
/*    */     } 
/*    */     
/* 47 */     NetworkPlayerInfo networkplayerinfo = ((NetHandlerPlayClient)Objects.<NetHandlerPlayClient>requireNonNull(Minecraft.func_71410_x().func_147114_u())).func_175104_a((String)(MontageEnder.getInstance()).nameString.getValue());
/* 48 */     if (networkplayerinfo != null && func_175155_b() != null && 
/* 49 */       networkplayerinfo.equals(func_175155_b())) {
/* 50 */       String s = (MontageEnder.getInstance()).skinFile.getValueAsString();
/* 51 */       ResourceLocation mark = new ResourceLocation("minecraft", "skins/" + s + ".png");
/* 52 */       if (MontageEnder.getInstance().isOn()) {
/* 53 */         cir.setReturnValue(mark);
/* 54 */       } else if (old != null) {
/* 55 */         cir.setReturnValue(old);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"getLocationCape"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void getLocationCape(CallbackInfoReturnable<ResourceLocation> cir) {
/* 65 */     ResourceLocation old = (ResourceLocation)cir.getReturnValue();
/*    */     
/* 67 */     NetworkPlayerInfo networkplayerinfo = ((NetHandlerPlayClient)Objects.<NetHandlerPlayClient>requireNonNull(Minecraft.func_71410_x().func_147114_u())).func_175104_a((String)(MontageEnder.getInstance()).nameString.getValue());
/* 68 */     if (networkplayerinfo != null && func_175155_b() != null && 
/* 69 */       networkplayerinfo.equals(func_175155_b())) {
/* 70 */       String s = ((MontageEnder.Cape)(MontageEnder.getInstance()).cape.getValue()).equals(MontageEnder.Cape.MINECON) ? "minecon" : (((MontageEnder.Cape)(MontageEnder.getInstance()).cape.getValue()).equals(MontageEnder.Cape.NONE) ? "none" : (MontageEnder.getInstance()).capeFile.getValueAsString());
/* 71 */       ResourceLocation mark = new ResourceLocation("minecraft", "skins/" + s + ".png");
/* 72 */       if (MontageEnder.getInstance().isOn()) {
/* 73 */         cir.setReturnValue(mark);
/* 74 */       } else if (old != null) {
/* 75 */         cir.setReturnValue(old);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinAbstractClientPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */