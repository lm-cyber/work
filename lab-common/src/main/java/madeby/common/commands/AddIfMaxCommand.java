package madeby.common.commands;

import madeby.common.data.data_class.Worker;
import madeby.common.util.CollectionManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;
import madeby.common.util.WorkerCreator;

public class AddIfMaxCommand extends Command {
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final InputManager inputManager;

    public AddIfMaxCommand(CollectionManager collectionManager, InputManager userInputManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {

        Worker worker = WorkerCreator.createWorker(inputManager, outputManager, collectionManager);
        if (collectionManager.addIfMax(worker)) {
            return new CommandResult("add success");
        }
        return new CommandResult("not max salary value");

    }

}
