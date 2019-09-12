package com.ziluck.zeeapi.commands.types;

import com.ziluck.zeeapi.commands.CommandPermission;
import com.ziluck.zeeapi.commands.exceptions.InvalidArgumentCountException;
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
        throw new InvalidArgumentCountException(this, "Cannot run " + getClass().getSimpleName() + " with less than " + argumentCount() + " arguments.");
    }

    @Override
    public int argumentCount() {
        return 3;
    }
}
