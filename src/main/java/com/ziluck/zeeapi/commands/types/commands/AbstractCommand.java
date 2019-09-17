package com.ziluck.zeeapi.commands.types.commands;

import com.ziluck.zeeapi.commands.Command;
import com.ziluck.zeeapi.commands.CommandPermission;

public abstract class AbstractCommand implements Command {
    private String name;
    private CommandPermission permission;
    private String[] aliases;

    public AbstractCommand(String name, CommandPermission permission, String... aliases) {
        this.name = name;
        this.permission = CommandPermission.of(permission);
        this.aliases = aliases;
    }

    public AbstractCommand(String name, String... aliases) {
        this.name = name;
        this.permission = CommandPermission.none();
        this.aliases = aliases;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getAliases() {
        return aliases;
    }

    @Override
    public CommandPermission getPermission() {
        return permission;
    }
}
