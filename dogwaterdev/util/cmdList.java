package dogwaterdev.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class cmdList {
    private static final String rawList = """
help
quit
echo
cd
ld
md
dd
mf
lf
df
""";

    /** This is a way to package the cmdList into the JAR file...
     *  <p>You may be asking why, and it's because I'm too lazy to figure out how to package a txt into a JAR.</p>
     *  <p>If I make the txt in the Java code, I don't have to deal with that</p>
     */
    public static ArrayList<String> init() {
        return new ArrayList<String>(Arrays.asList(rawList.split("\n")));
    }
}
