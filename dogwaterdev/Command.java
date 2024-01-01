package dogwaterdev;

import dogwaterdev.exceptions.UnkownArgumentsException;

import java.util.ArrayList;

public abstract class Command {
    public String name;
    public String desc;
    public ArrayList<String> args;
    public ArrayList<Integer> maxArguments = new ArrayList<>();
    public abstract void run(ArrayList<String> params, String workingDir) throws UnkownArgumentsException;
}
