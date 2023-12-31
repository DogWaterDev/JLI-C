package dogwaterdev.commands.misc;

import dogwaterdev.Command;
import dogwaterdev.exceptions.UnkownArgumentsException;

import java.util.ArrayList;

public class QuitCommand extends Command {

    @Override
    public void run(ArrayList<String> params, String workingDir, String path) throws UnkownArgumentsException {
        System.exit(0);
    }
}
