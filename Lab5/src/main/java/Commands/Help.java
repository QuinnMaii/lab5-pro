package Commands;

public class Help extends AbstractCommand{
    public boolean execute(){
        System.out.println("help                                     - display help for available commands");
        System.out.println("info                                     - displays information about the collection (type, date of "+
                           "                                           initialization, number of elements, etc.) to standard output");
        System.out.println("show                                     - display all the elements of the collection");
        System.out.println("add {element}                            - add new element to the collection");
        System.out.println("update {id}                              - update the value of the collection item whose id is equal to the\n"+
                           "                                           given");
        System.out.println("remove_by_id {id}                        - remove element has corresponding id from the collection");
        System.out.println("clear                                    - clear collection");
        System.out.println("save                                     - save collection into file");
        System.out.println("execute_script file_name                 - read and execute script from corresponding file. The script\n" +
                           "                                           contains commands in the same form in which the user enters them\n"+
                           "                                           interactively.");
        System.out.println("exit                                     - end the program without saving to file");
        System.out.println("add_if_max {element}                     - add a new item to the collection if its value is greater than the \n"+
                           "                                           value of the largest item in this collection");
        System.out.println("history:                                 - print last 7 command (without argument)");
        System.out.println("print_field_ascending_distance {element} - display the values of the distance field of all elements in ascending order");
        System.out.println("print_unique_distance name               - display the unique values of the distance field of all elements in the collection");
        System.out.println("print_descending                         - print the values of the manufacturer field of all elements in descending\n"+
                           "                                           order");

        return true;
    }
}