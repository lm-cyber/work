package madeby.common.commands;

import madeby.common.util.CollectionManager;

public class GroupCountingByCreationDateCommand extends Command{
    private final CollectionManager collectionManager;

    public GroupCountingByCreationDateCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        return null;
    }
}
