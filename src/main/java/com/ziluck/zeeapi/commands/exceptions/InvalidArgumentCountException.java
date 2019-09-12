package com.ziluck.zeeapi.commands.exceptions;

import com.ziluck.zeeapi.commands.Command;

public class InvalidArgumentCountException extends CommandException {
    public InvalidArgumentCountException(Command command, String message) {
        super(command, message);
    }
}
