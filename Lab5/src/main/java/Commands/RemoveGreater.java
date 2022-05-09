package Commands;

import Core.CollectionManager;
import Core.InputChecker;

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
