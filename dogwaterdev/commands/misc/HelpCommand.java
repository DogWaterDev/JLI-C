package dogwaterdev.commands.misc;

import dogwaterdev.Command;
import dogwaterdev.exceptions.UnkownArgumentsException;
import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.fPrint;

import java.util.ArrayList;

public class HelpCommand extends Command {

    @Override
    public void run(ArrayList<String> args) throws UnkownArgumentsException {
        if (args.isEmpty()) {
            new fPrint(ConsoleColors.CYAN_UNDERLINED, "JLI-C HELP");
            new fPrint(ConsoleColors.CYAN_UNDERLINED, "Command List:");
            new fPrint(ConsoleColors.YELLOW,
                    "\n-help: opens the help menu" +
                    "\n-quit: closes the terminal" +
                    "\n-echo: repeats the given arguments" +
                    "\n-cd: sets path as working directory" +
                    "\n-md: creates new directory, taking input for its name" +
                    "\n-dd: deletes a directory, taking input for the specified directory" +
                    "\n-mf: creates an empty file, takes two inputs. 1:file name and 2: file type" +
                    "\n-df: deletes an empty file, takes 1 input, file name" +
                    "\n-lf: lists file contents, takes 1 input, file name");
        }
        else {
            throw new UnkownArgumentsException("'Help' Command takes no arguments, but " + args.size() + " were given.", args, maxArguments);
        }
    }
}
