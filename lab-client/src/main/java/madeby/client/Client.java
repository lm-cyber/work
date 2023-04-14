package madeby.client;

import com.google.gson.JsonSyntaxException;
import madeby.client.util.Console;
import madeby.common.util.CollectionManager;
import madeby.common.util.CommandManager;
import madeby.common.util.FileManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;

import java.io.IOException;
import java.util.NoSuchElementException;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {

        final OutputManager outputManager = new OutputManager();

        if (args.length == 0) {
            outputManager.println("This program needs a file in argument to work with.");
            return;
        }

        if (!args[0].endsWith(".json")) {
            outputManager.println("This program can only work with .json file.");
            return;
        }
        try (InputManager inputManager = new InputManager()) {

            final CollectionManager collectionManager = new CollectionManager();
            final FileManager fileManager = new FileManager(args[0]);
            final CommandManager commandManager = new CommandManager(fileManager, inputManager, collectionManager, outputManager);
            final Console console = new Console(fileManager,
                    inputManager, collectionManager, outputManager,
                    commandManager);
            try {
                console.start();
            } catch (IOException e) {
                outputManager.println("Could not read the file. Check if it is available.");
            } catch (JsonSyntaxException | IllegalArgumentException e) {
                outputManager.println("The file does not keep data in correct format.");
            } catch (NoSuchElementException e) {
                outputManager.println("EOF");
            }
        }
    }
}
