package dogwaterdev.exceptions;

import java.util.ArrayList;

public class UnkownArgumentsException extends Exception{
    public UnkownArgumentsException(String str, ArrayList<String> args, int maxArguments) {
        super("Command not found. Command entered: " + str);
        System.out.println("Crashing process. Cause: Command takes " + maxArguments + " arguments, but " + args.size() + " were given.");
    }
}
