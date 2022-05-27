package Commands;

import Helpers.CollectionManager;
/**
 * class for command 'save' to save
 * @return if command successfully executed
 */
public class Save extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Save(CollectionManager C){
        this.collectionManager = C;
    }
    @Override
    public boolean execute(String filename) {
        collectionManager.save(filename);
        return true;
    }
}