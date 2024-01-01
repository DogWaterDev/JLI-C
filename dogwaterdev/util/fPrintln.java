package dogwaterdev.util;


import static com.diogonunes.jcolor.Ansi.colorize;

public class fPrintln {
    public fPrintln(String color, String text) {
        System.out.println(colorize(text, color) + ConsoleColors.RESET);
    }
}
