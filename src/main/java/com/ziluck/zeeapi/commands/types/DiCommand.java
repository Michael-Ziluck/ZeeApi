package com.ziluck.zeeapi.commands.types;

import com.ziluck.zeeapi.commands.CommandPermission;
import com.ziluck.zeeapi.commands.exceptions.InvalidArgumentCountException;
import org.bukkit.command.CommandSender;

public abstract class DiCommand<T0, T1> extends MonoCommand<T0> {
    public DiCommand(String name, String... aliases) {
        super(name, aliases);
    }

    public DiCommand(String name, CommandPermission permission, String... aliases) {
        super(name, permission, aliases);
    }

    public abstract void run(CommandSender sender, T0 arg0, T1 arg1);

    @Override
    public void run(CommandSender sender, T0 arg0) {
        throw new InvalidArgumentCountException(this, "Cannot run " + getClass().getSimpleName() + " with less than " + argumentCount() + " arguments.");
    }

    @Override
    public boolean hasSubCommands() {
        return false;
    }

    @Override
    public int argumentCount() {
        return 2;
    }
}
