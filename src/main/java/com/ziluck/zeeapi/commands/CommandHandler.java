package com.ziluck.zeeapi.commands;

import com.ziluck.zeeapi.commands.exceptions.CommandRegistrationException;
import com.ziluck.zeeapi.commands.exceptions.UnknownCommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler implements CommandExecutor {
    private Map<String, Command> commandMap = new HashMap<>();

    /**
     * Registers a {@link Command} to be used by the API. All validation to ensure the {@link Command} is in a valid
     * state is also done here. If something is invalid about the {@link Command}, a
     * {@link CommandRegistrationException} is thrown with the reason why.
     *
     * @param command the command to register
     */
    public void register(Command command) {
        // validate command
        validateCommand(command);

        // validate each argument
        for (int i = 0; i < command.getArgumentCount(); i++) {
            validateArgument(command, command.getArguments().get(i), i);
        }

        commandMap.put(command.getName(), command);
        for (String alias : command.getAliases()) {
            commandMap.put(alias, command);
        }
    }

    /**
     * Check the validity of the given command. This does not check the arguments of the command.
     *
     * @param command the command being validated
     */
    private void validateCommand(Command command) {
        // check the command has a name
        if (command.getName() == null || command.getName().trim().length() == 0) {
            throw new CommandRegistrationException("Command has no name.");
        }
        // check the arguments list is not null
        if (command.getArguments() == null) {
            throw new CommandRegistrationException("Command '" + command.getName() + "' has a null argument List");
        }
        // check the command has a permission
        if (command.getPermission() == null) {
            throw new CommandRegistrationException("Command '" + command.getName() + "' has no permission. Use CommandPermission.none() for no permission.");
        }
        // check the argument list size matches the command argument count
        if (command.getArguments().size() != command.getArgumentCount()) {
            throw new CommandRegistrationException("Added " + command.getArguments() + " arguments but expected " + command.getArgumentCount());
        }
    }

    /**
     * Check the validity of the given argument.
     *
     * @param command  the command being validated
     * @param argument the argument being validated
     * @param index    the index at which the argument appears in the command
     */
    private void validateArgument(Command command, Argument argument, int index) {
        // check the argument has a name
        if (argument.getName() == null || command.getName().trim().length() == 0) {
            throw new CommandRegistrationException("Argument at index " + index + " does not have a name.");
        }
        // check the raw type is set
        if (argument.getRawType() == null) {
            throw new CommandRegistrationException("Argument '" + argument.getName() + "' does not have a raw type.");
        }
        // check the parsed type is set
        if (argument.getType() == null) {
            throw new CommandRegistrationException("Argument '" + argument.getName() + "' does not have a parsed type.");
        }
        // check the command does not have a greedy last argument
        if (index != command.getArgumentCount() - 1 && argument.isGreedy()) {
            throw new CommandRegistrationException("Argument '" + argument.getName() + "' marked as greedy but is not last.");
        }
        // check if length and greedy are both set
        if (argument.getLength() != 1 && argument.isGreedy()) {
            throw new CommandRegistrationException("Argument '" + argument.getName() + "' is greedy and has a length set.");
        }
        // check the argument has a permission set
        if (argument.getPermission() == null) {
            throw new CommandRegistrationException("Argument '" + argument.getName() + "' does not have a permission. " +
                    "Use CommandPermission.none() for no permission.");
        }
    }

    /**
     * An override for Bukkit's
     * {@link CommandExecutor#onCommand(CommandSender, org.bukkit.command.Command, String, String[])}. This does not do
     * any of the validation of the arguments. That is performed by {@link Command#call(CommandSender, String, String[])}
     *
     * @param sender
     * @param bukkitCommand
     * @param label
     * @param args
     * @return
     */
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command bukkitCommand, String label, String[] args) {
        Command command = commandMap.get(label);

        if (command == null) {
            throw new UnknownCommandException("Could not find command using alias '" + label + "'.");
        }

        command.call(sender, label, args);

        return true;
    }
}
