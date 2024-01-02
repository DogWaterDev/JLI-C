package dogwaterdev.commands.misc;

import dogwaterdev.Command;
import dogwaterdev.exceptions.UnkownArgumentsException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class EchoCommand extends Command {
    @Override
    public void run(ArrayList<String> params, String workingDir, String path) throws UnkownArgumentsException {
        maxArguments = new ArrayList<Integer>();
        maxArguments.add(1);
        maxArguments.add(3);
        if (params.size() == 1) {
            System.out.println(params.toString().replace("[", "").replace("]", ""));
        } else if (params.size() == 2) {
            throw new UnkownArgumentsException("echo", args, maxArguments);
        } else if (params.size() == 3 && Objects.equals(params.get(1), ">>")) {
            System.out.println("Writing input '" + params.get(0) + "' >> " + params.get(2));
            try {
                FileWriter writer = new FileWriter(params.get(2));
                writer.write(params.get(0));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
