package madeby.common.commands;

import madeby.common.data.data_class.Worker;
import madeby.common.util.CollectionManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;
import madeby.common.util.WorkerCreator;

public class AddCommand extends Command{
    private final CollectionManager collectionManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public AddCommand(CollectionManager collectionManager, InputManager inputManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Worker worker = WorkerCreator.createWorker(inputManager,outputManager,collectionManager);
        collectionManager.add(worker);
        return new CommandResult("Worker create");
    }
}
