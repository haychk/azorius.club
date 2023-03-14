/*     */ package me.hk.azorius.mixin.mixins;
/*     */ 
/*     */ import java.util.Random;
/*     */ import me.hk.azorius.event.events.PushEvent;
/*     */ import me.hk.azorius.features.modules.render.NoRender;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.fml.common.eventhandler.Event;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.Redirect;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({Entity.class})
/*     */ public abstract class MixinEntity
/*     */ {
/*     */   @Shadow
/*     */   public double field_70165_t;
/*     */   @Shadow
/*     */   public double field_70163_u;
/*     */   @Shadow
/*     */   public double field_70161_v;
/*     */   @Shadow
/*     */   public double field_70159_w;
/*     */   @Shadow
/*     */   public double field_70181_x;
/*     */   @Shadow
/*     */   public double field_70179_y;
/*     */   @Shadow
/*     */   public float field_70177_z;
/*     */   @Shadow
/*     */   public float field_70125_A;
/*     */   @Shadow
/*     */   public boolean field_70122_E;
/*     */   @Shadow
/*     */   public boolean field_70145_X;
/*     */   @Shadow
/*     */   public float field_70141_P;
/*     */   @Shadow
/*     */   public World field_70170_p;
/*     */   @Shadow
/*     */   @Final
/*     */   private double[] field_191505_aI;
/*     */   @Shadow
/*     */   private long field_191506_aJ;
/*     */   @Shadow
/*     */   protected boolean field_70134_J;
/*     */   @Shadow
/*     */   public float field_70138_W;
/*     */   @Shadow
/*     */   public boolean field_70123_F;
/*     */   @Shadow
/*     */   public boolean field_70124_G;
/*     */   @Shadow
/*     */   public boolean field_70132_H;
/*     */   @Shadow
/*     */   public float field_70140_Q;
/*     */   @Shadow
/*     */   public float field_82151_R;
/*     */   @Shadow
/*     */   private int field_190534_ay;
/*     */   @Shadow
/*     */   private int field_70150_b;
/*     */   @Shadow
/*     */   private float field_191959_ay;
/*     */   @Shadow
/*     */   protected Random field_70146_Z;
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70051_ag();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_184218_aH();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70093_af();
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_174826_a(AxisAlignedBB paramAxisAlignedBB);
/*     */   
/*     */   @Shadow
/*     */   public abstract AxisAlignedBB func_174813_aQ();
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_174829_m();
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_184231_a(double paramDouble, boolean paramBoolean, IBlockState paramIBlockState, BlockPos paramBlockPos);
/*     */   
/*     */   @Shadow
/*     */   protected abstract boolean func_70041_e_();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70090_H();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_184207_aI();
/*     */   
/*     */   @Shadow
/*     */   public abstract Entity func_184179_bs();
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_184185_a(SoundEvent paramSoundEvent, float paramFloat1, float paramFloat2);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_145775_I();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70026_G();
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_180429_a(BlockPos paramBlockPos, Block paramBlock);
/*     */   
/*     */   @Shadow
/*     */   protected abstract SoundEvent func_184184_Z();
/*     */   
/*     */   @Shadow
/*     */   protected abstract float func_191954_d(float paramFloat);
/*     */   
/*     */   @Shadow
/*     */   protected abstract boolean func_191957_ae();
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_85029_a(CrashReportCategory paramCrashReportCategory);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_70081_e(int paramInt);
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_70015_d(int paramInt);
/*     */   
/*     */   @Shadow
/*     */   protected abstract int func_190531_bD();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70027_ad();
/*     */   
/*     */   @Shadow
/*     */   public abstract int func_82145_z();
/*     */   
/*     */   @Redirect(method = {"applyEntityCollision"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;addVelocity(DDD)V"))
/*     */   public void addVelocityHook(Entity entity, double x, double y, double z) {
/* 158 */     PushEvent event = new PushEvent(entity, x, y, z, true);
/* 159 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 160 */     if (!event.isCanceled()) {
/* 161 */       entity.field_70159_w += event.x;
/* 162 */       entity.field_70181_x += event.y;
/* 163 */       entity.field_70179_y += event.z;
/* 164 */       entity.field_70160_al = event.airbone;
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"canRenderOnFire"}, at = {@At("HEAD")}, cancellable = true)
/*     */   public void canRenderOnFireHook(CallbackInfoReturnable<Boolean> cir) {
/* 170 */     if (NoRender.getInstance().isOn() && ((Boolean)(NoRender.getInstance()).entityFire.getValue()).booleanValue()) cir.setReturnValue(Boolean.valueOf(false)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\MixinEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */