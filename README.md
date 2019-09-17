# ZeeApi

A group of APIs used with Spigot plugins written by Michael Ziluck (aka Doctor
Zee). It is important to note that this plugin is *not* useful to server owners
unless you have a plugin that uses this system.

## Command API
The command API is designed to be incredibly modular and fully customizable
while still being very simple to use. Everything is broken up into the
following categories:

### Commands
A `Command` is where all the other pieces below are stored and referenced. Each
command should have a concrete declaration. Some other command frameworks use
the builder pattern, but that has the serious limitation of requiring
developers to cast Objects to their desired type. This API overcomes that
limitation by having a different class depending on the number of arguments
desired, with a maximum of 5. If desired, a command that can accept 6 arguments
can be added, it is unlikely it will be needed.

Each of the abstract classes are named using their corresponding Greek roots
and are listed below:

#### NullaryCommand
A command without any arguments

#### MonoCommand
A command with a single argument.

#### DiCommand
A command with two arguments.

#### TriCommand
A command with 3 arguments.

#### TetraCommand
A command with 4 arguments.

#### PentaCommand
A command with 5 arguments.

### Arguments
An `Argument` contains much of what a `Command` contains. It can be validated,
have permissions, and be overridden easily.

### Constraints
Commands and Arguments both have certain constraints to be considered valid
when they are registered.

Commands must have the following:
 - A non-null name
 - A non-null list of arguments (an empty list is valid)
 - A non-null permission (Use `CommandPermission.none()` instead of null)
 - A valid number of arguments (must match the number identified by
 `getArgumentCount()`)
 
 Arguments must have the following:
  - A non-null name
  - A non-null raw type
  - A non-null type
  - Any greedy arguments last in the list
  - Length of 1 if flagged as greedy
  - A non-null permission