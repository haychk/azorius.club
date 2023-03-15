/*    */ package me.hk.azorius.mixin;
/*    */ 
/*    */ import java.util.Map;
/*    */ import me.hk.azorius.Azorius;
/*    */ import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
/*    */ import org.spongepowered.asm.launch.MixinBootstrap;
/*    */ import org.spongepowered.asm.mixin.MixinEnvironment;
/*    */ import org.spongepowered.asm.mixin.Mixins;
/*    */ 
/*    */ public class AzoriusLoader
/*    */   implements IFMLLoadingPlugin
/*    */ {
/*    */   private static boolean isObfuscatedEnvironment = false;
/*    */   
/*    */   public AzoriusLoader() {
/* 16 */     Azorius.LOGGER.info("\n\nLoading mixins by Sjnez");
/* 17 */     MixinBootstrap.init();
/* 18 */     Mixins.addConfiguration("mixins.Azorius.json");
/* 19 */     MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
/* 20 */     Azorius.LOGGER.info(MixinEnvironment.getDefaultEnvironment().getObfuscationContext());
/*    */   }
/*    */   
/*    */   public String[] getASMTransformerClass() {
/* 24 */     return new String[0];
/*    */   }
/*    */   
/*    */   public String getModContainerClass() {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   public String getSetupClass() {
/* 32 */     return null;
/*    */   }
/*    */   
/*    */   public void injectData(Map<String, Object> data) {
/* 36 */     isObfuscatedEnvironment = ((Boolean)data.get("runtimeDeobfuscationEnabled")).booleanValue();
/*    */   }
/*    */   
/*    */   public String getAccessTransformerClass() {
/* 40 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\H\Desktop\Azorius-0.0.7-release.jar!\me\sjnez\Azorius\mixin\AzoriusLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */