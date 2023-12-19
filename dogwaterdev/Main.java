package dogwaterdev;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static List<String> possibleStarters = new ArrayList<String>();
    public static void main(String[] args) {

        possibleStarters.add("C:");
        possibleStarters.add("D:");
        possibleStarters.add("E:");
        Scanner scanner = new Scanner(System.in);
        String e;
        e = scanner.next();
        String workingDir;
        workingDir = "D:\\Projekte\\GitHub\\JLI-C\\test";
        String nextDir;
        while (true) {
            System.out.print("JLI-C -- " + workingDir + " >> ");
            e = scanner.next();
            e = e.replace("JLI-C >> ", "");
            switch (e.toLowerCase()) {
                case "help":
                    String temp = scanner.next();
                    System.out.println("JLI-C HELP");
                    System.out.println("Command List:\n-help: opens the help menu. You can use help __COMMAND__ to get info for a specific command\n-quit: closes the terminal\n-cd: sets path as working directory\n-md: creates new directory, taking input for its name\n-dd: deletes a directory, taking input for the specified directory\n-nf: creates an empty file, takes two inputs. 1:file name and 2: file type");
                case "cd":
                    temp = scanner.next();
                    workingDir = Commands.navigateDirectory(workingDir, temp);
                    break;

                case "md":
                    temp = scanner.next();
                    System.out.println("creating directory: " + temp);
                    Commands.createDirectory(workingDir, temp);
                    break;

                case "dd":
                    temp = scanner.next();
                    System.out.println("deleting directory: " + temp);
                    Commands.deleteDirectory(workingDir, temp);
                    break;
                case "ld":
                case "quit":
                    System.exit(69420);
            }
        }
    }
}
