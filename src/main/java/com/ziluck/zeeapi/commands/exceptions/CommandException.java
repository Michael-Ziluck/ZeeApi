package com.ziluck.zeeapi.commands.exceptions;

import com.ziluck.zeeapi.commands.Command;

public abstract class CommandException extends RuntimeException {
    private Command command;

    public CommandException() {
        this(null, null);
    }

    public CommandException(String message) {
        this(null, message);
    }

    public CommandException(Command command) {
        this(command, null);
    }

    public CommandException(Command command, String message) {
        super(message);
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
