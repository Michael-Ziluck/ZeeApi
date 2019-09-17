package com.ziluck.zeeapi.commands.types.arguments;

import com.ziluck.zeeapi.commands.Argument;
import com.ziluck.zeeapi.commands.CommandPermission;

public abstract class AbstractArgument<T> implements Argument<T> {
    private final String name;
    private final Class<T> type;
    private final CommandPermission permission;
    private final boolean greedy;
    private final int length;

    public AbstractArgument(String name, Class<T> type) {
        this(name, type, CommandPermission.none(), false, 1);
    }

    public AbstractArgument(String name, Class<T> type, CommandPermission permission) {
        this(name, type, permission, false, 1);
    }

    public AbstractArgument(String name, Class<T> type, CommandPermission permission, boolean greedy) {
        this(name, type, permission, greedy, 1);
    }

    public AbstractArgument(String name, Class<T> type, CommandPermission permission, int length) {
        this(name, type, permission, false, length);
    }

    public AbstractArgument(String name, Class<T> type, boolean greedy) {
        this(name, type, CommandPermission.none(), greedy, 1);
    }

    public AbstractArgument(String name, Class<T> type, int length) {
        this(name, type, CommandPermission.none(), false, length);
    }

    public AbstractArgument(String name, Class<T> type, CommandPermission permission, boolean greedy, int length) {
        this.name = name;
        this.type = type;
        this.permission = permission;
        this.greedy = greedy;
        this.length = length;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<T> getType() {
        return type;
    }

    @Override
    public boolean isGreedy() {
        return greedy;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public CommandPermission getPermission() {
        return permission;
    }
}
