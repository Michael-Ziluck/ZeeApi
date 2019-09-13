package com.ziluck.zeeapi.commands.types;

import com.ziluck.zeeapi.commands.CommandPermission;
import com.ziluck.zeeapi.commands.exceptions.CommandCallException;
import org.bukkit.command.CommandSender;

public abstract class PentaCommand<T0, T1, T2, T3, T4> extends TetraCommand<T0, T1, T2, T3> {
    public PentaCommand(String name, String... aliases) {
        super(name, aliases);
    }

    public PentaCommand(String name, CommandPermission permission, String... aliases) {
        super(name, permission, aliases);
    }

    public abstract void run(CommandSender sender, T0 arg0, T1 arg1, T2 arg2, T3 arg3, T4 arg4);

    @Override
    public void run(CommandSender sender, T0 arg0, T1 arg1, T2 arg2, T3 arg3) {
        throw new CommandCallException(this, "Cannot run " + getClass().getSimpleName() + " with less than " + getArgumentCount() + " arguments.");
    }

    @Override
    public int getArgumentCount() {
        return 5;
    }
}
