package Commands;

import Helpers.CollectionManager;
import Helpers.InputChecker;
/**
 * class for command remove lower: remove from the collection all elements lower than the given
 * @return if command successfully executed
 */
public class RemoveLower extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;

    public RemoveLower(CollectionManager c, InputChecker i){
        this.collectionManager = c;
        this.inputChecker = i;
    }
    public boolean execute(String argument){
        if(inputChecker.integerValidChecker(argument, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            Integer input = Integer.parseInt(argument);
            if(collectionManager.removeLower(input))
                return true;
        }
        return true;
    }
}

