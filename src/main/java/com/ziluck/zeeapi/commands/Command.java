package com.ziluck.zeeapi.commands;

import org.bukkit.command.CommandSender;

public interface Command extends Validatable<CommandSender>, Validator<CommandSender> {
    int argumentCount();

    void call(CommandSender sender, String[] args);

    String getName();

    String[] getAliases();

    boolean hasSubCommands();

    CommandPermission getPermission();
}
