package com.ziluck.zeeapi.commands.types.commands;

import com.ziluck.zeeapi.commands.Command;
import com.ziluck.zeeapi.commands.CommandPermission;
import org.bukkit.plugin.Plugin;

public abstract class AbstractCommand implements Command {
    private final Plugin plugin;
    private final String name;
    private final CommandPermission permission;
    private final String[] aliases;

    public AbstractCommand(Plugin plugin, String name, CommandPermission permission, String... aliases) {
        this.plugin = plugin;
        this.name = name;
        this.permission = CommandPermission.of(permission);
        this.aliases = aliases;
    }

    public AbstractCommand(Plugin plugin, String name, String... aliases) {
        this.plugin = plugin;
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
