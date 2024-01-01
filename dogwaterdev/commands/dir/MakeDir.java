package dogwaterdev.commands.dir;

import dogwaterdev.Command;
import dogwaterdev.Main;
import dogwaterdev.exceptions.UnkownArgumentsException;

import java.io.File;
import java.util.ArrayList;

public class MakeDir extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir) throws UnkownArgumentsException {
        new File(Main.workingDir + "\\" + params.get(0)).mkdir();
    }
}
