import Collection.SpaceMarine;
import Commands.Command;
import Commands.*;
import Commands.Info;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        HashMap <String, Command> commandHashMap = new HashMap<>();

        HashMap <Integer, SpaceMarine> spaceMarineHashMap = new HashMap<>();

        commandHashMap.put("help", new Help());
        commandHashMap.put("info", new Info());




    }
}