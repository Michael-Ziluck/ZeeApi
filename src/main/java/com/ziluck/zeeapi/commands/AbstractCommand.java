package com.ziluck.zeeapi.commands;

import org.bukkit.command.CommandSender;

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
    public void call(CommandSender sender, String[] args) {

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

    @Override
    public Validator<CommandSender> getValidator() {
        return this;
    }

    @Override
    public boolean isValid(CommandSender sender) {
        return true;
    }
}
