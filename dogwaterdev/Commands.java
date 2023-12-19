package dogwaterdev;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.util.Objects;

public class Commands {
    public static void createDirectory(String path, String directoryName) {
        new File(path + "\\" + directoryName).mkdir();
    }

    public static void deleteDirectory(String path, String directoryName) {
        new File(path + "\\" + directoryName).delete();
    }

    public static String navigateDirectory(String workingDir, String path) {
        String finishedResult;
        String topDir;
        Integer count = 0;
        String processedPath;
        processedPath = path.replace(".", "");
        for (Integer i = 0; i < path.length(); i++) {
            if (Objects.equals(path.charAt(i), ".")) {
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
            }
            else if (count > 1) {
                topDir = new File(workingDir).getParentFile().getAbsolutePath();
                for (int c = 0; c < count-1; c++) {
                    topDir = new File(topDir).getParentFile().getAbsolutePath();
                }
                finishedResult = topDir + processedPath;
            } else if (count == 1) {
                topDir = new File(workingDir).getParentFile().getAbsolutePath();
                finishedResult = topDir + processedPath;


            }
            else {
                throw new RuntimeException("An error occured trying to find the path. If you think this is a bug, nag author DogWaterDev on GitHub.");
            }
        return finishedResult.replace("/", "\\");
    }
}
