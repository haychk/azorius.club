package me.hk.azorius.features.command.commands;

import me.hk.azorius.Azorius;
import me.hk.azorius.features.command.Command;

public class UnloadCommand
        extends Command {
    public UnloadCommand() {
        super("unload", new String[0]);
    }

    @Override
    public void execute(String[] commands) {
        Azorius.unload(true);
    }
}

