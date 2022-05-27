package Commands;

import Helpers.CollectionManager;

/**
 * class for command 'info' to print information about collection
 */
public class Info extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    /**
     * @return if command successfully executed
     */
    @Override
    public boolean execute(){
        System.out.println("Collection's type: ArrayDeque");
        System.out.println("Initialization date: " + collectionManager.getCreationDate());
        System.out.println("Number of elements " + collectionManager.size());

        return true;
    }
}
