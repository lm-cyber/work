package madeby.common.commands;

import madeby.common.util.CollectionManager;
import madeby.common.util.FileManager;
import madeby.common.util.JsonParser;

import java.io.IOException;

public class SaveCommand extends Command {
    private final CollectionManager collectionManager;
    private final FileManager fileManager;

    public SaveCommand(CollectionManager collectionManager, FileManager fileManager) {
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            fileManager.write(JsonParser.toJson(collectionManager.getCopyOfData()));
        } catch (IOException e) {
            return new CommandResult("There was a problem saving a file. Please restart the program with another one");
        }
        return new CommandResult("The data was saved successfully");
    }
}
