package Main;

import Commands.*;
import Helpers.*;


import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Main method to run the program
 */
public class Main {
    static String filename;


    public static void main(String[] args) throws FileNotFoundException {
        try{
            System.out.println("START");
            filename = args[0];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("THIS PROGRAM USING COMMAND LINE ARGUMENT");
            System.exit(-1);
        }
        System.out.println("write 'help' to know the available commands");
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.readInputFromCSVFile(filename);
        InputChecker inputChecker = new InputChecker();
        CommandAsker commandAsker = new CommandAsker(inputChecker);
        CommandManager commandManager = new CommandManager(
                new Add(collectionManager, commandAsker),
                new Clear(collectionManager),
                new RemoveGreater(collectionManager, inputChecker),
                new RemoveLower(collectionManager, inputChecker),
                new Exit(),
                new PrintUniqueColor(collectionManager, inputChecker),
                new Help(),
                new Info(collectionManager),
                new RemoveById(collectionManager, inputChecker),
                new Save(collectionManager),
                new Show(collectionManager),
                new Update(collectionManager, inputChecker, commandAsker)
        );
        Commander commander = new Commander(commandManager, new Scanner(System.in), filename);
        commander.interactiveMode();
    }
}