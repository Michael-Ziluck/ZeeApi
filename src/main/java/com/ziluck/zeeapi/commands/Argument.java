package com.ziluck.zeeapi.commands;

import com.mojang.brigadier.arguments.ArgumentType;

public interface Argument<T> {
    String getName();

    <V> ArgumentType<V> getRawType();

    Class<T> getType();

    CommandPermission getPermission();

    boolean isGreedy();

    int getLength();
}
