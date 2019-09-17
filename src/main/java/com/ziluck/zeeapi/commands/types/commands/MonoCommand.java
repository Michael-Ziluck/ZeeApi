package com.ziluck.zeeapi.commands.types.commands;

import com.ziluck.zeeapi.commands.CommandPermission;
import org.bukkit.command.CommandSender;

public abstract class MonoCommand<T0> extends AbstractCommand {
    public MonoCommand(String name, String... aliases) {
        super(name, aliases);
    }

    public MonoCommand(String name, CommandPermission permission, String... aliases) {
        super(name, permission, aliases);
    }

    public abstract void run(CommandSender sender, T0 arg0);

    @Override
    public int getArgumentCount() {
        return 1;
    }
}
