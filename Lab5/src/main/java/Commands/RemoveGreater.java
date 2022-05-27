package Commands;

import Helpers.CollectionManager;
import Helpers.InputChecker;
/**
 * class for command remove greater: remove from the collection all elements greater than the given
 * @return if command successfully executed
 */
public class RemoveGreater extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;

    public RemoveGreater(CollectionManager c, InputChecker i){
        this.collectionManager = c;
        this.inputChecker = i;
    }
    public boolean execute(String argument){
        if(inputChecker.integerValidChecker(argument, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            Integer input = Integer.parseInt(argument);
            if(collectionManager.removeGreater(input))
                return true;
        }
        return true;
    }
}
