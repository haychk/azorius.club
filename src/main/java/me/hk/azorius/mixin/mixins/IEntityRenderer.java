package me.hk.azorius.mixin.mixins;

import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({EntityRenderer.class})
public interface IEntityRenderer {
  @Invoker("renderHand")
  void invokeRenderHand(float paramFloat, int paramInt);
  
  @Invoker("setupCameraTransform")
  void setupCameraTransformInvoker(float paramFloat, int paramInt);
}


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\IEntityRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */