/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import me.hk.azorius.event.events.InterpolateEvent;
/*    */ import me.hk.azorius.features.modules.render.NoRender;
/*    */ import me.hk.azorius.util.Util;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.fml.common.eventhandler.Event;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyArg;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({RenderManager.class})
/*    */ public class MixinRenderManager
/*    */   implements Util {
/*    */   private Entity entityIn;
/*    */   
/*    */   @Inject(method = {"renderEntityStatic"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void renderEntityStatic(Entity entityIn, float partialTicks, boolean p_188388_3_, CallbackInfo ci) {
/* 23 */     this.entityIn = entityIn;
/*    */     
/* 25 */     if (entityIn instanceof net.minecraft.entity.passive.EntityParrot && ((Boolean)(NoRender.getInstance()).parrot.getValue()).booleanValue() && NoRender.getInstance().isOn()) {
/* 26 */       ci.cancel();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @ModifyArg(method = {"renderEntityStatic"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderManager;renderEntity(Lnet/minecraft/entity/Entity;DDDFFZ)V"), index = 1)
/*    */   private double renderEntityStaticX(double x) {
/* 34 */     if (this.entityIn == null || mc.field_71441_e == null) {
/* 35 */       return x;
/*    */     }
/* 37 */     InterpolateEvent event = new InterpolateEvent();
/* 38 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 39 */     if (event.isCanceled()) {
/* 40 */       return this.entityIn.field_70165_t - (mc.func_175598_ae()).field_78730_l;
/*    */     }
/* 42 */     return x;
/*    */   }
/*    */ 
/*    */   
/*    */   @ModifyArg(method = {"renderEntityStatic"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderManager;renderEntity(Lnet/minecraft/entity/Entity;DDDFFZ)V"), index = 2)
/*    */   private double renderEntityStaticY(double y) {
/* 48 */     if (this.entityIn == null || mc.field_71441_e == null) {
/* 49 */       return y;
/*    */     }
/* 51 */     InterpolateEvent event = new InterpolateEvent();
/* 52 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 53 */     if (event.isCanceled()) {
/* 54 */       return this.entityIn.field_70163_u - (mc.func_175598_ae()).field_78731_m;
/*    */     }
/* 56 */     return y;
/*    */   }
/*    */   
/*    */   @ModifyArg(method = {"renderEntityStatic"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderManager;renderEntity(Lnet/minecraft/entity/Entity;DDDFFZ)V"), index = 3)
/*    */   private double renderEntityStaticZ(double z) {
/* 61 */     if (this.entityIn == null || mc.field_71441_e == null) {
/* 62 */       return z;
/*    */     }
/* 64 */     InterpolateEvent event = new InterpolateEvent();
/* 65 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 66 */     if (event.isCanceled()) {
/* 67 */       return this.entityIn.field_70161_v - (mc.func_175598_ae()).field_78728_n;
/*    */     }
/* 69 */     return z;
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinRenderManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */