package dogwaterdev;

public class CommandNotFoundException extends Exception{

    public CommandNotFoundException(String str) {
        super("Command not found. Command entered: " + str);
        System.out.println("Crashing process. Cause: Command not found. Command entered: " + str);
    }
}