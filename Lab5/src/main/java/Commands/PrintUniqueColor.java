package Commands;

import Helpers.CollectionManager;
import Helpers.InputChecker;

public class PrintUniqueColor extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;

    public PrintUniqueColor(CollectionManager c, InputChecker i){
        this.collectionManager = c;
        this.inputChecker = i;
    }
    public  boolean execute(){
            collectionManager.printUniqueColor();
                return true;
    }
}
