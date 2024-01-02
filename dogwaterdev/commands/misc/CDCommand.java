package dogwaterdev.commands.misc;

import dogwaterdev.Command;
import dogwaterdev.Main;
import dogwaterdev.exceptions.UnkownArgumentsException;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class CDCommand extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir, String path) throws UnkownArgumentsException {

        Main.workingDir = path.replace("/", "\\");
    }
}
