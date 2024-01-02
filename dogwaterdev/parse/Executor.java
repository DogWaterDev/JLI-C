package dogwaterdev.parse;

import dogwaterdev.Command;
import dogwaterdev.Main;
import dogwaterdev.commands.dir.DelDir;
import dogwaterdev.commands.dir.ListDir;
import dogwaterdev.commands.dir.MakeDir;
import dogwaterdev.commands.file.*;
import dogwaterdev.commands.misc.CDCommand;
import dogwaterdev.commands.misc.EchoCommand;
import dogwaterdev.commands.misc.HelpCommand;
import dogwaterdev.commands.misc.QuitCommand;
import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.fPrintln;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Executor {

    /**
     * <p>IMPORTANT: THE COMMANDS IN THE SWITCH STATEMENT MUST ALWAYS BE IN THE SAME ORDER AS THE 'cmdList' CLASS</p>
     */
    public static void execute(int cmdIndex, ArrayList<String> args) throws Exception {
        String workingDir = Main.workingDir;
        String path = null;
        new fPrintln(ConsoleColors.BLUE, "Executing command: " + cmdIndex + " with args: " + args.toString().replace("[", "").replace("]", ""));
        ArrayList<Command> commands = new ArrayList<>();
        // spam the same command 50 times
        commands.add(new HelpCommand());
        commands.add(new QuitCommand());
        commands.add(new EchoCommand());
        commands.add(new CDCommand());
        commands.add(new ListDir());
        commands.add(new MakeDir());
        commands.add(new DelDir());
        commands.add(new ListFile());
        commands.add(new MakeFile());
        commands.add(new DelFile());
        commands.add(new RenFile());
        commands.add(new CompFile());
        if (cmdIndex != 0 && cmdIndex != 1 && cmdIndex != 2) {
            try {
                path = args.get(0);
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
                    path = workingDir;
                } else if (count == 0) {
                    if (path.charAt(0) == '/') {
                        workingDir = workingDir + path;
                    }
                    else {
                        workingDir = workingDir + "/" + path;
                    }
                    path = workingDir;
                } else if (count > 0) {
                    File topDir = new File(workingDir);
                    for (int i = 0; i < count; i++) {
                        topDir = topDir.getAbsoluteFile().getParentFile().getAbsoluteFile();
                    }

                    path = topDir.getPath() + processedPath;
                }
            }
            catch (Exception e) {
                if (!(cmdIndex == 4)) {
                    new fPrintln(ConsoleColors.RED, "No arguments given for command. Exception: " + e.getCause() +e.getStackTrace());
                }

            }

        }
        if (path != null) {
            try {
                commands.get(cmdIndex).run(args, workingDir, path);
            }
            catch (IndexOutOfBoundsException | IOException e) {

                // i dont even know anymore but this just fixes all my issues
                //throw new Exception("An error occured. Executor attempting to execute non-existent command at command index: " + cmdIndex);
            }
        }
        else {
            try {
                commands.get(cmdIndex).run(args, workingDir, workingDir);
            }
            catch (IndexOutOfBoundsException | IOException e) {
                //throw new IndexOutOfBoundsException("An error occured. Executor attempting to execute non-existent command at command index: " + cmdIndex);
            }
        }


    }
}
