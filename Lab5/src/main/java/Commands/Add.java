package Commands;

import Helpers.CollectionManager;
import Helpers.CommandAsker;
/**
 * class for command 'add' to add elements to collection
 */
public class Add extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final CommandAsker commandAsker;

    public Add(CollectionManager cm, CommandAsker ca){
        this.collectionManager = cm;
        this.commandAsker = ca;
    }

    @Override
    public boolean execute() {
        collectionManager.add(commandAsker.createDragon());
        return true;
    }
}