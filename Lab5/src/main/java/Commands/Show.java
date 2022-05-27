package Commands;

import Helpers.CollectionManager;

/**
 * class for command 'show' to show elements in collection
 */
public class Show extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
/**
 *
 *@return if command successfully executed
 **/
    @Override
    public boolean execute(){
        collectionManager.PrintCollection();
        return true;
    }
}
