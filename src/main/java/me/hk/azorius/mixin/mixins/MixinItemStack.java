/*    */ package me.hk.azorius.mixin.mixins;
/*    */ 
/*    */ import me.hk.azorius.features.modules.render.NoRender;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin({ItemStack.class})
/*    */ public class MixinItemStack
/*    */ {
/*    */   @Inject(method = {"hasEffect"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void hasEffect(CallbackInfoReturnable<Boolean> cir) {
/* 16 */     if (((Boolean)(NoRender.getInstance()).glint.getValue()).booleanValue() && NoRender.getInstance().isOn())
/* 17 */       cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinItemStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */