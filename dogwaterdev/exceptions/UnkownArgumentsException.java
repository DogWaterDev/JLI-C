package dogwaterdev.exceptions;

import java.util.ArrayList;

public class UnkownArgumentsException extends Exception{
    public UnkownArgumentsException(String str, ArrayList<String> args, ArrayList<Integer> maxArguments) {
        super("Error parsing command: " + str);
        if (maxArguments.isEmpty()) {
            System.out.println("Crashing process. Cause: Command takes 0 arguments, but " + args.size() + " were given.");
        }
        else if (maxArguments.size() == 1) {
            System.out.println("Crashing process. Cause: Command takes " + maxArguments.get(0) + " arguments, but " + args.size() + " were given.");
        } else if (maxArguments.size() == 2) {
            System.out.println("Crashing process. Cause: Command takes " + maxArguments.get(0) + " or " + maxArguments.get(1) + "arguments, but " + args.size() + " were given.");
        }
        else {
            System.out.println("Crashing process. Cause: Command '" + str + "' does not take " + args.size() + " arguments.");
        }
    }
}
