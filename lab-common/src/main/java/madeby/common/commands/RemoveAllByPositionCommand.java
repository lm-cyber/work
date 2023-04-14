package madeby.common.commands;

import madeby.common.data.data_class.Position;
import madeby.common.util.CollectionManager;

public class RemoveAllByPositionCommand extends Command{
    private final CollectionManager collectionManager;

    public RemoveAllByPositionCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            Position position = "".equals(arg)?null : Position.valueOf(arg);
            return new CommandResult("remove count "+Long.toString(collectionManager.removeAllByPosition(position)));
        } catch (IllegalArgumentException e) {
            return new CommandResult("position don't correct");
        }
    }
}
