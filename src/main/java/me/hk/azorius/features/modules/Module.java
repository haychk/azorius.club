package me.hk.azorius.features.modules;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.hk.azorius.Azorius;
import me.hk.azorius.event.events.ClientEvent;
import me.hk.azorius.event.events.Render2DEvent;
import me.hk.azorius.event.events.Render3DEvent;
import me.hk.azorius.features.Feature;
import me.hk.azorius.features.command.Command;
import me.hk.azorius.features.modules.client.HUD;
import me.hk.azorius.features.modules.client.ModuleTools;
import me.hk.azorius.features.setting.Bind;
import me.hk.azorius.features.setting.Setting;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;

public class Module extends Feature {

    private static Module INSTANCE;
    private final String description;
    private final Category category;

    public Setting<Boolean> enabled = this.register(new Setting<Boolean>("Enabled", false));
    public Setting<Boolean> drawn = this.register(new Setting<Boolean>("Drawn", true));
    public Setting<Bind> bind = this.register(new Setting<Bind>("Keybind", new Bind(-1)));
    public Setting<String> displayName;
    public boolean hasListener;
    public boolean alwaysListening;
    public boolean hidden;
    public float arrayListOffset = 0.0f;
    public float arrayListVOffset = 0.0f;
    public float offset;
    public float vOffset;
    public boolean sliding;

    public Module(String name, String description, Category category, boolean hasListener, boolean hidden, boolean alwaysListening) {
        super(name);
        this.displayName = this.register(new Setting<String>("DisplayName", name));
        this.description = description;
        this.category = category;
        this.hasListener = hasListener;
        this.hidden = hidden;
        this.alwaysListening = alwaysListening;
    }


    public boolean isSliding() {
        return this.sliding;
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onToggle() {
    }

    public void onLoad() {
    }

    public void onTick() {
    }

    public void onLogin() {
    }

    public void onLogout() {
    }

    public void onUpdate() {
    }

    public void onRender2D(Render2DEvent event) {
    }

    public void onRender3D(Render3DEvent event) {
    }

    public void onUnload() {
    }

    public String getDisplayInfo() {
        return null;
    }

    public boolean isOn() {
        return this.enabled.getValue();
    }

    public boolean isOff() {
        return this.enabled.getValue() == false;
    }

    public void setEnabled(boolean enabled) {
        if (enabled) {
            this.enable();
        } else {
            this.disable();
        }
    }


    public TextComponentString getNotifierOn() {
        if (ModuleTools.getInstance().isEnabled()) {
            switch (ModuleTools.getInstance().notifier.getValue()) {
                case FUTURE: {
                    TextComponentString text = new TextComponentString(ChatFormatting.RED + "[Future] " + ChatFormatting.GRAY + this.getDisplayName() + " toggled " + ChatFormatting.GREEN + "on" + ChatFormatting.GRAY + ".");
                    return text;
                }
                case DOTGOD: {
                    TextComponentString text = new TextComponentString(ChatFormatting.DARK_PURPLE + "[" + ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + ChatFormatting.DARK_PURPLE + "] " + ChatFormatting.DARK_AQUA + this.getDisplayName() + ChatFormatting.LIGHT_PURPLE + " was " + ChatFormatting.GREEN + "enabled.");
                    return text;

                }
                case PHOBOS: {
                    TextComponentString text = new TextComponentString((HUD.getInstance().getCommandMessage()) + ChatFormatting.BOLD + " " + this.getDisplayName() + ChatFormatting.RESET + ChatFormatting.GREEN + " enabled.");
                    return text;

                }
                case TROLLGOD: {
                    TextComponentString text = new TextComponentString((HUD.getInstance().getCommandMessage()) + ChatFormatting.DARK_PURPLE + " " + this.getDisplayName() + ChatFormatting.LIGHT_PURPLE + " was " + ChatFormatting.GREEN + "enabled.");
                    return text;
                }
            }
        }
        TextComponentString text = new TextComponentString(HUD.getInstance().getCommandMessage() + ChatFormatting.GREEN + " " + this.getDisplayName() + " toggled on.");
        return text;
    }

    public TextComponentString getNotifierOff() {
        if (ModuleTools.getInstance().isEnabled()) {
            switch (ModuleTools.getInstance().notifier.getValue()) {
                case FUTURE: {
                    TextComponentString text = new TextComponentString(ChatFormatting.RED + "[Future] " + ChatFormatting.GRAY + this.getDisplayName() + " toggled " + ChatFormatting.RED + "off" + ChatFormatting.GRAY + ".");
                    return text;
                }
                case DOTGOD: {
                    TextComponentString text = new TextComponentString(ChatFormatting.DARK_PURPLE + "[" + ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + ChatFormatting.DARK_PURPLE + "] " + ChatFormatting.DARK_AQUA + this.getDisplayName() + ChatFormatting.LIGHT_PURPLE + " was " + ChatFormatting.RED + "disabled.");
                    return text;

                }
                case PHOBOS: {
                    TextComponentString text = new TextComponentString((HUD.getInstance().getCommandMessage()) + ChatFormatting.BOLD + this.getDisplayName() + ChatFormatting.RESET + ChatFormatting.RED + " disabled.");
                    return text;

                }
                case TROLLGOD: {
                    TextComponentString text = new TextComponentString((HUD.getInstance().getCommandMessage()) + ChatFormatting.DARK_PURPLE + " " + this.getDisplayName() + ChatFormatting.LIGHT_PURPLE + " was " + ChatFormatting.RED + "disabled.");
                    return text;
                }
            }
        }
        TextComponentString text = new TextComponentString(HUD.getInstance().getCommandMessage() + ChatFormatting.RED + " " + this.getDisplayName() + " toggled off.");
        return text;
    }


    public void enable() {
        this.enabled.setValue(Boolean.TRUE);
        this.onToggle();
        this.onEnable();
        if (HUD.getInstance().notifyToggles.getValue().booleanValue()) {
            Module.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(getNotifierOn(), 1);
            if (this.isOn() && this.hasListener && !this.alwaysListening) {
                MinecraftForge.EVENT_BUS.register(this);
            }
        }
    }


    public void disable() {
        if (this.hasListener && !this.alwaysListening) {
            MinecraftForge.EVENT_BUS.unregister(this);
        }
        this.enabled.setValue(false);
        if (HUD.getInstance().notifyToggles.getValue().booleanValue()) {
            Module.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(getNotifierOff(), 1);
        }

        this.onToggle();
        this.onDisable();
    }

    public void toggle() {
        ClientEvent event = new ClientEvent(!this.isEnabled() ? 1 : 0, this);
        MinecraftForge.EVENT_BUS.post(event);
        if (!event.isCanceled()) {
            this.setEnabled(!this.isEnabled());
        }
    }

    public String getDisplayName() {
        return this.displayName.getValue();
    }

    public void setDisplayName(String name) {
        Module module = Azorius.moduleManager.getModuleByDisplayName(name);
        Module originalModule = Azorius.moduleManager.getModuleByName(name);
        if (module == null && originalModule == null) {
            Command.sendMessage(this.getDisplayName() + ", name: " + this.getName() + ", has been renamed to: " + name);
            this.displayName.setValue(name);
            return;
        }
        Command.sendMessage(ChatFormatting.RED + "A module of this name already exists.");
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDrawn() {
        return this.drawn.getValue();
    }

    public void setDrawn(boolean drawn) {
        this.drawn.setValue(drawn);
    }

    public Category getCategory() {
        return this.category;
    }

    public String getInfo() {
        return null;
    }

    public Bind getBind() {
        return this.bind.getValue();
    }

    public void setBind(int key) {
        this.bind.setValue(new Bind(key));
    }

    public boolean listening() {
        return this.hasListener && this.isOn() || this.alwaysListening;
    }

    public String getFullArrayString() {
        return this.getDisplayName() + ChatFormatting.GRAY + (this.getDisplayInfo() != null ? " [" + ChatFormatting.WHITE + this.getDisplayInfo() + ChatFormatting.GRAY + "]" : "");
    }

    public enum Category {
        COMBAT("Combat"),
        MISC("Misc"),
        RENDER("Render"),
        MOVEMENT("Movement"),
        PLAYER("Player"),
        CLIENT("Client");

        private final String name;

        Category(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
