package com.ziluck.zeeapi.commands.types;

import com.ziluck.zeeapi.commands.AbstractCommand;
import com.ziluck.zeeapi.commands.CommandPermission;

public abstract class OidoCommand extends AbstractCommand {
    public OidoCommand(String name, String... aliases) {
        super(name, aliases);
    }

    public OidoCommand(String name, CommandPermission permission, String... aliases) {
        super(name, permission, aliases);
    }
}
