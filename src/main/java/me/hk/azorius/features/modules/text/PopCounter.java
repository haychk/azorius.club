 package me.hk.azorius.features.modules.text;
 
 import com.mojang.realmsclient.gui.ChatFormatting;
 import java.util.HashMap;
 import me.hk.azorius.features.command.Command;
 import me.hk.azorius.features.modules.Module;
 import me.hk.azorius.features.modules.client.HUD;
 import me.hk.azorius.features.setting.Setting;
 import net.minecraft.entity.player.EntityPlayer;
 
 public class PopCounter
   extends Module
 {
   public static HashMap<String, Integer> TotemPopContainer = new HashMap<>();
   private static PopCounter INSTANCE = new PopCounter();
   public Setting<PopNotifier> popNotifier = register(new Setting("PopNotifier", PopNotifier.FUTURE));
 
   
   public PopCounter() {
     super("PopCounter", "Counts other players totem pops.", Module.Category.MISC, true, false, false);
     setInstance();
   }
   
   public static PopCounter getInstance() {
     if (INSTANCE == null) {
       INSTANCE = new PopCounter();
     }
     return INSTANCE;
   }
   
   private void setInstance() {
     INSTANCE = this;
   }
 
   
   public void onEnable() {
     TotemPopContainer.clear();
   }
   
   public String death1(EntityPlayer player) {
     int l_Count = (Integer) TotemPopContainer.get(player.func_70005_c_());
     TotemPopContainer.remove(player.func_70005_c_());
     if (l_Count == 1) {
       if (isEnabled()) {
         String text; switch ((PopNotifier)this.popNotifier.getValue()) {
           case FUTURE:
             text = ChatFormatting.RED + "[Future] " + ChatFormatting.GREEN + player.func_70005_c_() + ChatFormatting.GRAY + " died after popping " + ChatFormatting.GREEN + l_Count + ChatFormatting.GRAY + " totem.";
             return text;

           case PHOBOS:
             text = ChatFormatting.GOLD + player.func_70005_c_() + ChatFormatting.RED + " died after popping " + ChatFormatting.GOLD + l_Count + ChatFormatting.RED + " totem.";
             return text;

           case DOTGOD:
             text = ChatFormatting.DARK_PURPLE + "[" + ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + ChatFormatting.DARK_PURPLE + "] " + ChatFormatting.LIGHT_PURPLE + player.func_70005_c_() + " died after popping " + ChatFormatting.GREEN + l_Count + ChatFormatting.LIGHT_PURPLE + " time!";
             return text;

         }


       } else {
         return HUD.getInstance().getCommandMessage() + ChatFormatting.GRAY + player.func_70005_c_() + " died after popping " + ChatFormatting.GREEN + l_Count + ChatFormatting.GRAY + " Totem!";
       }

     }
     else if (isEnabled()) {
       String text; switch ((PopNotifier)this.popNotifier.getValue()) {
         case FUTURE:
           text = ChatFormatting.RED + "[Future] " + ChatFormatting.GREEN + player.func_70005_c_() + ChatFormatting.GRAY + " died after popping " + ChatFormatting.GREEN + l_Count + ChatFormatting.GRAY + " totems.";
           return text;
         
         case PHOBOS:
           text = ChatFormatting.GOLD + player.func_70005_c_() + ChatFormatting.RED + " died after popping " + ChatFormatting.GOLD + l_Count + ChatFormatting.RED + " totems.";
           return text;
         
         case DOTGOD:
           text = ChatFormatting.DARK_PURPLE + "[" + ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + ChatFormatting.DARK_PURPLE + "] " + ChatFormatting.LIGHT_PURPLE + player.func_70005_c_() + " died after popping " + ChatFormatting.GREEN + l_Count + ChatFormatting.LIGHT_PURPLE + " times!";
           return text;

       } 
 
     
     } else {
       return HUD.getInstance().getCommandMessage() + ChatFormatting.GRAY + player.func_70005_c_() + " died after popping " + ChatFormatting.GREEN + l_Count + ChatFormatting.GRAY + " Totems!";
     } 
     
     return null;
   }
   
   public void onDeath(EntityPlayer player) {
     if (fullNullCheck()) {
       return;
     }
     if (getInstance().isDisabled())
       return; 
     if (mc.field_71439_g.equals(player)) {
       return;
     }
     if (TotemPopContainer.containsKey(player.func_70005_c_())) {
       Command.sendSilentMessage(death1(player));
     }
   }
   
   public String pop(EntityPlayer player) {
     int l_Count = 1;
     if (TotemPopContainer.containsKey(player.func_70005_c_())) {
       l_Count = ((Integer)TotemPopContainer.get(player.func_70005_c_())).intValue();
       TotemPopContainer.put(player.func_70005_c_(), Integer.valueOf(++l_Count));
     } else {
       TotemPopContainer.put(player.func_70005_c_(), Integer.valueOf(l_Count));
     } 
     if (l_Count == 1) {
       if (isEnabled()) {
         String text; switch ((PopNotifier)this.popNotifier.getValue()) {
           case FUTURE:
             text = ChatFormatting.RED + "[Future] " + ChatFormatting.GREEN + player.func_70005_c_() + ChatFormatting.GRAY + " just popped " + ChatFormatting.GREEN + l_Count + ChatFormatting.GRAY + " totem.";
             return text;

           case PHOBOS:
             text = ChatFormatting.GOLD + player.func_70005_c_() + ChatFormatting.RED + " popped " + ChatFormatting.GOLD + l_Count + ChatFormatting.RED + " totem.";
             return text;

           case DOTGOD:
             text = ChatFormatting.DARK_PURPLE + "[" + ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + ChatFormatting.DARK_PURPLE + "] " + ChatFormatting.LIGHT_PURPLE + player.func_70005_c_() + " has popped " + ChatFormatting.RED + l_Count + ChatFormatting.LIGHT_PURPLE + " time in total!";
             return text;



       } else{
         return HUD.getInstance().getCommandMessage() + ChatFormatting.GRAY + player.func_70005_c_() + " popped " + ChatFormatting.GREEN + l_Count + ChatFormatting.GRAY + " Totem.";
       }

     } else if (isEnabled()) {
       String text; switch ((PopNotifier)this.popNotifier.getValue()) {
         case FUTURE:
           text = ChatFormatting.RED + "[Future] " + ChatFormatting.GREEN + player.func_70005_c_() + ChatFormatting.GRAY + " just popped " + ChatFormatting.GREEN + l_Count + ChatFormatting.GRAY + " totems.";
           return text;
         
         case PHOBOS:
           text = ChatFormatting.GOLD + player.func_70005_c_() + ChatFormatting.RED + " popped " + ChatFormatting.GOLD + l_Count + ChatFormatting.RED + " totems.";
           return text;
         
         case DOTGOD:
           text = ChatFormatting.DARK_PURPLE + "[" + ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + ChatFormatting.DARK_PURPLE + "] " + ChatFormatting.LIGHT_PURPLE + player.func_70005_c_() + " has popped " + ChatFormatting.RED + l_Count + ChatFormatting.LIGHT_PURPLE + " times in total!";
           return text;
         

       } 
     
     } else {
       return HUD.getInstance().getCommandMessage() + ChatFormatting.GRAY + player.func_70005_c_() + " popped " + ChatFormatting.GREEN + l_Count + ChatFormatting.GRAY + " Totems.";
     } 
     
     return "";
   }
   
   public void onTotemPop(EntityPlayer player) {
     if (fullNullCheck()) {
       return;
     }
     if (getInstance().isDisabled())
       return;
     if (mc.field_71439_g.equals(player)) {
       return;
     }
     Command.sendSilentMessage(pop(player));
   }
   
   public enum PopNotifier {
/* 177 */     PHOBOS,
/* 178 */     FUTURE,
/* 179 */     DOTGOD,
   }
 }
