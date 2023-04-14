package madeby.common.commands;

import madeby.common.data.data_class.Position;
import madeby.common.util.CollectionManager;

public class FilterByPositionCommand extends Command {
    private final CollectionManager collectionManager;

    public FilterByPositionCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            Position position = "".equals(arg) ? null : Position.valueOf(arg);
            return new CommandResult("group " + collectionManager.getAllByPosition(position).toString());
        } catch (IllegalArgumentException e) {
            return new CommandResult("position don't correct");
        }
    }
}
