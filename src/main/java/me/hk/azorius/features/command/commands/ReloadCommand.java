package me.hk.azorius.features.command.commands;

import me.hk.azorius.Azorius;
import me.hk.azorius.features.command.Command;

public class ReloadCommand
        extends Command {
    public ReloadCommand() {
        super("reload", new String[0]);
    }

    @Override
    public void execute(String[] commands) {
        Azorius.reload();
    }
}

