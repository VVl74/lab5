package Commands;

import Collection.SpaceMarine;

import java.util.HashMap;

public class Clear implements Command {
    HashMap <Integer, SpaceMarine> spaceMarineHashMap;

    public Clear(HashMap <Integer, SpaceMarine> marineHashMap) {
        spaceMarineHashMap = marineHashMap;

    }
    public void execute(String[] args) {
        spaceMarineHashMap.clear();
    }
    public String getName() {
        return "clear";
    }
    public String getDescription() {
        return "1234";
    }
}

