package com.ziluck.zeeapi.commands;

import com.ziluck.zeeapi.commands.types.DiCommand;
import com.ziluck.zeeapi.commands.types.MonoCommand;
import com.ziluck.zeeapi.commands.exceptions.UnknownCommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler implements CommandExecutor {
    private Map<String, Command> commandMap = new HashMap<>();

    private Map<Integer, Class<? extends Command>> countMapping = new HashMap<>();

    public CommandHandler() {
        countMapping.put(1, MonoCommand.class);
        countMapping.put(2, DiCommand.class);
    }

    public void register(Command command) {
        commandMap.put(command.getName(), command);
        for (String alias : command.getAliases()) {
            commandMap.put(alias, command);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command bukkitCommand, String label, String[] args) {
        Command command = commandMap.get(label);

        if (command == null) {
            throw new UnknownCommandException("Could not find command using alias " + label);
        }


        return true;
    }
}
