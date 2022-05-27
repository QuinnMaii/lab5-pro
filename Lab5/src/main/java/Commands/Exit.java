package Commands;
/**
 * class for command 'exit' to exit from the program
 */
/**
 *
 * @return if command successfully executed
 */
public class Exit extends AbstractCommand{
    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }
}
