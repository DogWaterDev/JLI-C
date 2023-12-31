package dogwaterdev;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.util.ArrayList;
import java.util.List;
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
                System.out.println("asdasdasdasde");
                File topDir = new File(workingDir);
                for (int i = 0; i < count; i++) {
                    topDir = topDir.getAbsoluteFile().getParentFile().getAbsoluteFile();
                }

                finishedResult = topDir.getPath() + processedPath;
            }
            else {
                throw new RuntimeException("An error occured trying to find the path. If you think this is a bug, nag author DogWaterDev on GitHub.");
            }

        return finishedResult.replace("/", "\\");
    }

    public static List<String> listDirectory(String workingDir) {
        File file = new File(workingDir);
        List<String> list = new ArrayList<String>();
        if (file.listFiles() != null) {
            for (int i = 0; i < file.listFiles().length; i++) {
                list.add(file.listFiles()[i].getName());
            }
            return list;
        }
        else {
            return null;
        }
    }
}
