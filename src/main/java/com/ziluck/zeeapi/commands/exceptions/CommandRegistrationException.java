package com.ziluck.zeeapi.commands.exceptions;

import com.ziluck.zeeapi.commands.Command;

public class CommandRegistrationException extends CommandException {
    public CommandRegistrationException(String message) {
        super(message);
    }

    public CommandRegistrationException(Command command) {
        super(command);
    }

    public CommandRegistrationException(Command command, String message) {
        super(command, message);
    }
}
