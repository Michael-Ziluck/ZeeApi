package com.ziluck.zeeapi.commands;

import com.mojang.brigadier.arguments.ArgumentType;

public interface Argument<T> {
    String getName();

    <V> ArgumentType<V> getRawType();

    Class<T> getType();

    boolean isGreedy();

    void setGreedy(boolean greedy);

    int getLength();

    void setLength(int length);

    CommandPermission getPermission();

    void setPermission(CommandPermission permission);
}
