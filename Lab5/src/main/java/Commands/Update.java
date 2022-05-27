package Commands;

import Helpers.CollectionManager;
import Helpers.CommandAsker;
import Helpers.InputChecker;
/**
 * class for command 'update' to update element in collection by id
 */
public class Update extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;
    private final CommandAsker commandAsker;
    public Update(CollectionManager C, InputChecker checker, CommandAsker asker){
        this.collectionManager = C;
        this.inputChecker = checker;
        this.commandAsker = asker;
    }

    /**
     *@return if command successfully executed
     * @param argument
     */
    @Override
    public boolean execute(String argument) {
        if(inputChecker.integerValidChecker(argument,0,Integer.MAX_VALUE)){
            Integer id = Integer.parseInt(argument);
            if(collectionManager.removeById(id)){
                System.out.println("Id doesn't exist. Please insert the existing id!");
                return false;
            }
            collectionManager.add(commandAsker.createDragon());
            return true;
        }
        System.out.println("The inserting ID is not in valid range! Please insert Id greater than 0!");
        return false;
    }
}