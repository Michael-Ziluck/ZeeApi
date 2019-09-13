package com.ziluck.zeeapi.commands;

public class CommandAPI {
    private static CommandHandler commandHandler;

    public static void register(Command command) {
        commandHandler.register(command);
    }
}
