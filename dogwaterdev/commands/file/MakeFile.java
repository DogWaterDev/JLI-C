package dogwaterdev.commands.file;

import dogwaterdev.Command;
import dogwaterdev.Main;
import dogwaterdev.exceptions.UnkownArgumentsException;
import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.fPrintln;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MakeFile  extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir, String path) throws UnkownArgumentsException {
        File file = new File(Main.workingDir + "\\" + params.get(0));
        try {
            boolean success = file.createNewFile();
            if (success) {
                new fPrintln(ConsoleColors.GREEN_BRIGHT, String.valueOf(true));
            } else {
                new fPrintln(ConsoleColors.YELLOW, false + ": Could not create directory. Is there already one with this name?");
            }
        }
        catch (IOException e) {
            new fPrintln(ConsoleColors.RED_BOLD, "An internal error occured: "+ Arrays.toString(e.getStackTrace()));
        }

    }
}
