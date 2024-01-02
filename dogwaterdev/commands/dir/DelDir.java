package dogwaterdev.commands.dir;

import dogwaterdev.Command;
import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.fPrintln;

import java.io.File;
import java.util.ArrayList;

public class DelDir extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir, String path) {
        File file = new File(path);
        boolean success = file.delete();
        if (success) {
            new fPrintln(ConsoleColors.GREEN_BRIGHT, String.valueOf(true));
        } else {
            new fPrintln(ConsoleColors.YELLOW, false + ": Could not delete directory. Is there a directory with this name?");
        }
    }
}
