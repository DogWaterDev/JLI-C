package dogwaterdev;
import dogwaterdev.parse.Parser;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static List<String> possibleStarters = new ArrayList<String>();

    public static Parser parser = new Parser();
    public static void main(String[] args) throws Exception {

        possibleStarters.add("C:");
        possibleStarters.add("D:");
        possibleStarters.add("E:");
        parser.init(System.in);
        while (true) {
            ArrayList<String> tokens = parser.getTokens();
            parser.parse(tokens);
        }
    }
}
