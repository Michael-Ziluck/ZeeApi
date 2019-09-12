package com.ziluck.zeeapi.commands.types;

import com.ziluck.zeeapi.commands.CommandPermission;

public class BaseCommand extends MonoCommand {
    public BaseCommand(String name, String... aliases) {
        super(name, aliases);
    }

    public BaseCommand(String name, CommandPermission permission, String... aliases) {
        super(name, permission, aliases);
    }
}
