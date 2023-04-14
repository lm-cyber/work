package madeby.common.util;

import madeby.common.commands.AddCommand;
import madeby.common.commands.AddIfMaxCommand;
import madeby.common.commands.ClearCommand;
import madeby.common.commands.Command;
import madeby.common.commands.CommandResult;
import madeby.common.commands.ExecuteScriptCommand;
import madeby.common.commands.ExitCommand;
import madeby.common.commands.FilterByPositionCommand;
import madeby.common.commands.GroupCountingByCreationDateCommand;
import madeby.common.commands.HelpCommand;
import madeby.common.commands.InfoCommand;
import madeby.common.commands.NameHaventCommand;
import madeby.common.commands.RemoveAllByPositionCommand;
import madeby.common.commands.RemoveByIdCommand;
import madeby.common.commands.RemoveFirstCommand;
import madeby.common.commands.RemoveGreaterCommand;
import madeby.common.commands.SaveCommand;
import madeby.common.commands.ShowCommand;
import madeby.common.commands.UpdateCommand;

import java.util.HashMap;

public class CommandManager {
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final HashMap<String, Command> commands;

    public CommandManager(FileManager fileManager, InputManager inputManager, CollectionManager collectionManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.commands = new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand(collectionManager));
        commands.put("exit", new ExitCommand());
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("add", new AddCommand(collectionManager, inputManager, outputManager));
        commands.put("update", new UpdateCommand(collectionManager, inputManager, outputManager));
        commands.put("remove_by_id", new RemoveByIdCommand(collectionManager, inputManager, outputManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("save", new SaveCommand(collectionManager, fileManager));
        commands.put("execute_script", new ExecuteScriptCommand(inputManager));
        commands.put("remove_first", new RemoveFirstCommand(collectionManager));
        commands.put("add_if_max", new AddIfMaxCommand(collectionManager, inputManager, outputManager));
        commands.put("remove_greater", new RemoveGreaterCommand(collectionManager, inputManager, outputManager));
        commands.put("remove_all_by_position", new RemoveAllByPositionCommand(collectionManager));
        commands.put("group_counting_by_creation_date", new GroupCountingByCreationDateCommand(collectionManager));
        commands.put("filter_by_position", new FilterByPositionCommand(collectionManager));

    }


    public CommandResult executeCommand(String name, String arg) {
        return commands.getOrDefault(name, new NameHaventCommand()).execute(arg);
    }


}
