package dogwaterdev.commands.misc;

import dogwaterdev.Command;
import dogwaterdev.Main;
import dogwaterdev.exceptions.UnkownArgumentsException;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class CDCommand extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir) throws UnkownArgumentsException {
        String path = params.get(0);
        String finishedResult;
        int count = 0;
        String processedPath;
        processedPath = path.replace(".", "");
        for (int i = 0; i < path.length(); i++) {
            if (Objects.equals(path.charAt(i), '.')) {
                count++;
            }
        }
        if (path.length() > 2 && Main.possibleStarters.contains(path.substring(0, 2))) {
            workingDir = path;
            finishedResult = workingDir;
        } else if (count == 0) {
            if (path.charAt(0) == '/') {
                workingDir = workingDir + path;
            }
            else {
                workingDir = workingDir + "/" + path;
            }
            finishedResult = workingDir;
        } else if (count > 0) {
            File topDir = new File(workingDir);
            for (int i = 0; i < count; i++) {
                topDir = topDir.getAbsoluteFile().getParentFile().getAbsoluteFile();
            }

            finishedResult = topDir.getPath() + processedPath;
        }
        else {
            throw new RuntimeException("An error occured trying to find the path. If you think this is a bug, nag author DogWaterDev on GitHub.");
        }

        Main.workingDir = finishedResult.replace("/", "\\");
    }
}
