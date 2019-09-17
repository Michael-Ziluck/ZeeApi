package com.ziluck.zeeapi.commands.types.commands;

import com.ziluck.zeeapi.commands.CommandPermission;
import com.ziluck.zeeapi.commands.exceptions.CommandCallException;
import org.bukkit.command.CommandSender;

public abstract class TriCommand<T0, T1, T2> extends DiCommand<T0, T1> {
    public TriCommand(String name, String... aliases) {
        super(name, aliases);
    }

    public TriCommand(String name, CommandPermission permission, String... aliases) {
        super(name, permission, aliases);
    }

    public abstract void run(CommandSender sender, T0 arg0, T1 arg1, T2 arg2);

    @Override
    public void run(CommandSender sender, T0 arg0, T1 arg1) {
        throw new CommandCallException(this, "Cannot run " + getClass().getSimpleName() + " with less than " + getArgumentCount() + " arguments.");
    }

    @Override
    public int getArgumentCount() {
        return 3;
    }
}
