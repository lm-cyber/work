package madeby.client.util;

import com.google.gson.JsonSyntaxException;
import madeby.common.Exception.DontCorrectJsonException;
import madeby.common.commands.CommandResult;
import madeby.common.data.data_class.Vehicle;
import madeby.common.util.CollectionManager;
import madeby.common.util.CommandManager;
import madeby.common.util.FileManager;
import madeby.common.util.InputManager;
import madeby.common.util.JsonParser;
import madeby.common.util.OutputManager;
import madeby.common.util.ParserToNameAndArg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Console {

    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final InputManager inputManager;
    private final CommandManager commandManager;

    public Console(FileManager fileManager, InputManager inputManager,
                   CollectionManager collectionManager, OutputManager outputManager, CommandManager commandManager) {
        this.fileManager = fileManager;
        this.inputManager = inputManager;
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
        this.commandManager = commandManager;
    }

    public void start() throws IllegalArgumentException, JsonSyntaxException, IOException, DontCorrectJsonException {
        StringBuilder stringData = fileManager.read();

        ArrayList<Vehicle> vehicles = JsonParser.toData(String.valueOf(stringData));
        collectionManager.initData(vehicles);
        startCommandCycle();
    }

    private String readNextCommand() {
        outputManager.print(">>>");
        return inputManager.nextLine();
    }

    private void startCommandCycle() {
        CommandResult commandResult;
        do {
            String input = readNextCommand();
            ParserToNameAndArg parserToNameAndArg = new ParserToNameAndArg(input);
            commandResult = commandManager.executeCommand(parserToNameAndArg.getName(), parserToNameAndArg.getArg());
            outputManager.println(commandResult.getResult());
        } while (!Objects.requireNonNull(commandResult).isExit());
    }
}
