package dogwaterdev.commands.dir;

import dogwaterdev.Command;
import dogwaterdev.Main;
import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.fPrintln;

import java.io.File;
import java.util.ArrayList;

public class MakeDir extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir, String path) {
        File file = new File(Main.workingDir + "\\" + params.get(0));
        boolean success = file.mkdir();
        if (success) {
            new fPrintln(ConsoleColors.GREEN_BRIGHT, String.valueOf(true));
        } else {
            new fPrintln(ConsoleColors.YELLOW, false + ": Could not create directory. Is there already one with this name?");
        }
    }
}
