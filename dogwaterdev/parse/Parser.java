package dogwaterdev.parse;

import dogwaterdev.commands.misc.HelpCommand;
import dogwaterdev.commands.misc.QuitCommand;
import dogwaterdev.exceptions.UnkownArgumentsException;
import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.fPrint;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    private ArrayList<String> commands;
    private Scanner scanner;
    public Parser() {

    }

    public void init(InputStream inputStream) throws IOException {
        scanner = new Scanner(inputStream);
        File file = new File("dogwaterdev/util/cmdList.txt");
        commands = new ArrayList<String>(Files.readAllLines(file.toPath()));
    }

    public ArrayList<String> getTokens() {
        return new ArrayList<>(List.of(scanner.nextLine().split(" ")));
    }
    public void parse(ArrayList<String> tokens) throws Exception {
        int index;
        ArrayList<String> args = new ArrayList<String>();
        // Check if first token is a command (it needs to be)
        if (commands.contains(tokens.get(0))) {
            index = commands.indexOf(tokens.get(0));
            tokens.remove(0);
        } else {
            System.out.println(ConsoleColors.RED + "First token of input is not a command." + ConsoleColors.RESET);
            tokens.remove(0);
            return;
        }
        args.addAll(tokens);
        execute(index, args);
    }

    public void execute(int cmdIndex, ArrayList<String> args) throws UnkownArgumentsException {
        new fPrint(ConsoleColors.BLUE, "Executing command: " + cmdIndex);
        switch(cmdIndex) {
            case 0:
                new HelpCommand().run(args);
                break;
            case 1:
                new QuitCommand().run(args);
                break;
        }
    }

}
