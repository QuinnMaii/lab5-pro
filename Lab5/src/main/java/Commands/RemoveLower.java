package Commands;

import Core.CollectionManager;
import Core.InputChecker;

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

