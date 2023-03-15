/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import me.hk.azorius.RenoSense;
/*    */ import me.hk.azorius.features.modules.render.Swing;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({EntityLivingBase.class})
/*    */ public class MixinEntityLivingBase
/*    */ {
/*    */   @Inject(method = {"getArmSwingAnimationEnd"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void getArmSwingAnimationEnd(CallbackInfoReturnable<Integer> info) {
/* 16 */     if (RenoSense.moduleManager.isModuleEnabled("Swing") && ((Boolean)(Swing.getINSTANCE()).slowSwing.getValue()).booleanValue())
/* 17 */       info.setReturnValue(Integer.valueOf(15)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinEntityLivingBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */