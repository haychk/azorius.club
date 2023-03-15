package me.hk.azorius.mixin.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({Minecraft.class})
public interface IMinecraft {
  @Accessor("session")
  void setSession(Session paramSession);
}


/* Location:              C:\Users\H\Desktop\renosense-0.0.7-release.jar!\me\sjnez\renosense\mixin\mixins\IMinecraft.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */