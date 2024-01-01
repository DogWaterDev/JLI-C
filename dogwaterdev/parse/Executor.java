package dogwaterdev.parse;

import dogwaterdev.Main;
import dogwaterdev.commands.dir.DelDir;
import dogwaterdev.commands.dir.ListDir;
import dogwaterdev.commands.dir.MakeDir;
import dogwaterdev.commands.misc.CDCommand;
import dogwaterdev.commands.misc.EchoCommand;
import dogwaterdev.commands.misc.HelpCommand;
import dogwaterdev.commands.misc.QuitCommand;
import dogwaterdev.exceptions.UnkownArgumentsException;
import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.fPrintln;

import java.util.ArrayList;

public class Executor {

    public static void execute(int cmdIndex, ArrayList<String> args) throws UnkownArgumentsException {
        new fPrintln(ConsoleColors.BLUE, "Executing command: " + cmdIndex + " with args: " + args.toString().replace("[", "").replace("]", ""));

        switch (cmdIndex) {
            case 0:
                new HelpCommand().run(args, Main.workingDir);
                break;
            case 1:
                new QuitCommand().run(args, Main.workingDir);
                break;
            case 2:
                new EchoCommand().run(args, Main.workingDir);
                break;
            case 3:
                new CDCommand().run(args, Main.workingDir);
                break;
            case 4:
                new DelDir().run(args, Main.workingDir);
                break;
            case 5:
                new MakeDir().run(args, Main.workingDir);
                break;
            case 6:
                new ListDir().run(args, Main.workingDir);
                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            default:
                throw new RuntimeException("An error occured. Executor attempting to execute non-existent command at command index: " + cmdIndex);
        }
    }
}
