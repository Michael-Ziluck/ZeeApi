package com.ziluck.zeeapi.commands;

public class CommandPermission {
    private static final CommandPermission none = new CommandPermission("");

    private CommandPermission parentPermission;
    private String permission;

    private CommandPermission(String permission) {
        this.permission = permission;
    }

    private CommandPermission(CommandPermission parentPermission, String permission) {
        this.parentPermission = parentPermission;
        this.permission = permission;
    }

    protected String getPermission() {
        return permission;
    }

    protected CommandPermission getParentPermission() {
        return parentPermission;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandPermission)) {
            return false;
        }
        CommandPermission other = (CommandPermission) obj;

        return permission != null && other.permission != null && toString().equals(other.toString());
    }

    @Override
    public String toString() {
        String result = "";
        if (parentPermission != null) {
            result = parentPermission.toString();
        }
        return result + "." + permission;
    }

    public static CommandPermission none() {
        return none;
    }

    /**
     * Creates a clone of the given CommandPermission.
     *
     * @param permission the permission to clone
     * @return the newly created clone
     */
    public static CommandPermission of(CommandPermission permission) {
        return new CommandPermission(permission.toString());
    }

    public static CommandPermission of(String permission) {
        return new CommandPermission(permission);
    }

    public static CommandPermission of(CommandPermission parentPermission, String permission) {
        return new CommandPermission(parentPermission, permission);
    }
}