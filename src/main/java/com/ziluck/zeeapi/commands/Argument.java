package com.ziluck.zeeapi.commands;

import com.mojang.brigadier.arguments.ArgumentType;

public interface Argument<T> {
    <V> ArgumentType<V> getRawType();

    Class<T> getType();

    boolean isGreedy();

    void setGreedy(boolean greedy);

    int getLength();

    void setLength(int length);

    <V extends Argument<T>> V withPermission(CommandPermission permission);
}
