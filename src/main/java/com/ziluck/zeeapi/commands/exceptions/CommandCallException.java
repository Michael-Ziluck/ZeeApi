package com.ziluck.zeeapi.commands.exceptions;

import com.ziluck.zeeapi.commands.Command;

public class CommandCallException extends CommandException {
    public CommandCallException(Command command, String message) {
        super(command, message);
    }
}
