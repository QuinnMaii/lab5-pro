package Commands;

import Helpers.CollectionManager;
/**
 * class for command claer all the element from the collection
 * @return if command successfully executed
 */
public class Clear extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Clear(CollectionManager C){
        this.collectionManager = C;
    }
    @Override
    public boolean execute(){
        collectionManager.clear();
        return true;
    }
}
