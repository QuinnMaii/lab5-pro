//package Main;

import Commands.*;
import Core.*;


import java.util.Scanner;

public class Main {
    //static final String FILE_PATH = "src/main/java/Files/";
    static String filename;


    public static void main(String[] args) {
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
        collectionManager.readInputFromJSONFile(filename);
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