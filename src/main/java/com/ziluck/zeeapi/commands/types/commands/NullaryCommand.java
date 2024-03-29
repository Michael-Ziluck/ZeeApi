package com.ziluck.zeeapi.commands.types.commands;

import com.ziluck.zeeapi.commands.CommandPermission;

public abstract class NullaryCommand extends AbstractCommand {
    public NullaryCommand(String name, String... aliases) {
        super(name, aliases);
    }

    public NullaryCommand(String name, CommandPermission permission, String... aliases) {
        super(name, permission, aliases);
    }
}
