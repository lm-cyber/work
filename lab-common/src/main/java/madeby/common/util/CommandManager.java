package madeby.common.util;

import madeby.common.commands.*;

import java.util.HashMap;

public class CommandManager {
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final  InputManager inputManager;
    private final OutputManager outputManager;
    private final HashMap<String, Command> commands;
    public CommandManager(FileManager fileManager, InputManager inputManager, CollectionManager collectionManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.commands = new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
    }




    public CommandResult executeCommand(String name, String arg) {
        return commands.getOrDefault(name, new NameHaventCommand()).execute(arg);
    }


}
