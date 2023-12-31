package dogwaterdev.util;


import static com.diogonunes.jcolor.Ansi.colorize;

public class fPrint {
    public fPrint(String color, String text) {
        System.out.println(colorize(text, color) + ConsoleColors.RESET);
    }
}
