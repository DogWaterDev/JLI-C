package dogwaterdev.commands.dir;

import dogwaterdev.Command;
import dogwaterdev.exceptions.UnkownArgumentsException;

import java.io.File;
import java.util.ArrayList;

public class DelDir extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir) throws UnkownArgumentsException {
        String directoryName = params.get(0);
        new File(workingDir + "\\" + directoryName).delete();
    }
}
