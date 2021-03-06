package Commands;

import Helpers.CollectionManager;
import Helpers.InputChecker;

/**
 * class for command 'remove_by_id
 * @return if command successfully executed
 */
public class RemoveById extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;
    public RemoveById(CollectionManager C, InputChecker checker){
        this.collectionManager = C;
        this.inputChecker = checker;
    }
    @Override
    public boolean execute(String argument) {
        if (inputChecker.integerValidChecker(argument, 0, Integer.MAX_VALUE)) {
            int id = Integer.parseInt(argument);
            if (collectionManager.removeById(id)) {
                System.out.println("Id doesn't exist. Please insert the existing Id!");
                return false;
            }
            return true;
        }
        System.out.println("The inserted ID is not in valid range! Please insert Id greater than 0!");
        return false;
    }
}
