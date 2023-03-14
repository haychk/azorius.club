package me.hk.azorius.features.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.hk.azorius.Azorius;
import me.hk.azorius.features.command.Command;

public class HelpCommand
        extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public void execute(String[] commands) {
        HelpCommand.sendMessage("Commands: ");
        for (Command command : Azorius.commandManager.getCommands()) {
            HelpCommand.sendMessage(ChatFormatting.GRAY + Azorius.commandManager.getPrefix() + command.getName());
        }
    }
}

