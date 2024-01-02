package dogwaterdev.commands.dir;

import dogwaterdev.Command;
import dogwaterdev.Main;
import dogwaterdev.exceptions.UnkownArgumentsException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListDir extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir, String path) throws UnkownArgumentsException {
        File file = new File(path);
        List<String> list = new ArrayList<String>();
        if (file.listFiles() != null) {
            for (int i = 0; i < Objects.requireNonNull(file.listFiles()).length; i++) {
                list.add(Objects.requireNonNull(file.listFiles())[i].getName());
            }
            for (String el : list) {
                System.out.println(el);
            }
        }

    }
}
