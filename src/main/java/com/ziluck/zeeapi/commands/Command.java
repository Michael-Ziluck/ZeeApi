package com.ziluck.zeeapi.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface Command extends Validatable<CommandSender>, Validator<CommandSender> {
    /**
     * Returns the number of arguments this command should have. This does not necessarily reflect the result of calling
     * {@code getArguments().size()} if the command has not yet been registered.
     *
     * @return the number of arguments this command should have
     */
    int getArgumentCount();

    void call(CommandSender sender, String[] args);

    String getName();

    default String[] getAliases() {
        return new String[0];
    }

    List<Argument> getArguments();

    CommandPermission getPermission();
}
