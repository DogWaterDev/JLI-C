package dogwaterdev;
import dogwaterdev.parse.Parser;
import dogwaterdev.util.ConsoleColors;
import dogwaterdev.util.fPrint;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static List<String> possibleStarters = new ArrayList<String>();

    public static Parser parser = new Parser();
    public static String workingDir;

    public static void main(String[] args) throws Exception {
        workingDir = "D:\\Projekte\\GitHub\\JLI-C\\work";
        possibleStarters.add("C:");
        possibleStarters.add("D:");
        possibleStarters.add("E:");
        parser.init(System.in);
        while (true) {
            new fPrint(ConsoleColors.PURPLE_BRIGHT, "JLI || " + workingDir + " >> ");
            ArrayList<String> tokens = parser.getTokens();
            parser.parse(tokens);
        }
    }
}
