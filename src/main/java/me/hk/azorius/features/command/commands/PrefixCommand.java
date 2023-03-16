package me.hk.azorius.features.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.hk.azorius.Azorius;
import me.hk.azorius.features.command.Command;

public class PrefixCommand
        extends Command {
    public PrefixCommand() {
        super("prefix", new String[]{"<char>"});
    }

    @Override
    public void execute(String[] commands) {
        if (commands.length == 1) {
            Command.sendMessage(ChatFormatting.GREEN + "Current prefix is " + Azorius.commandManager.getPrefix());
            return;
        }
        Azorius.commandManager.setPrefix(commands[0]);
        Command.sendMessage("Prefix changed to " + ChatFormatting.GRAY + commands[0]);
    }
}

