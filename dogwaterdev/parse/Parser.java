package dogwaterdev.parse;

import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.cmdList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    private ArrayList<String> commands;
    private Scanner scanner;
    private int commandCount;
    public Parser() {

    }

    public void init(InputStream inputStream) {
        scanner = new Scanner(inputStream);
        commands = cmdList.init();
        commandCount = commands.size();
    }

    public ArrayList<String> getTokens() {
        return new ArrayList<>(List.of(scanner.nextLine().split(" ")));
    }
    public void parse(ArrayList<String> tokens) throws Exception {
        int index;
        // Check if first token is a command (it needs to be)
        if (commands.contains(tokens.get(0))) {
            index = commands.indexOf(tokens.get(0));
            tokens.remove(0);
        } else {
            System.out.println(ConsoleColors.RED + "First token of input is not a command." + ConsoleColors.RESET);
            tokens.remove(0);
            return;
        }
        ArrayList<String> args = new ArrayList<>(tokens);
        Executor.execute(index, args);
    }


    }

