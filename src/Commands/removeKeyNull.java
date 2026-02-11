package Commands;

import Collection.SpaceMarine;

import java.util.HashMap;

public class removeKeyNull implements Command {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    int id;

    public removeKeyNull(HashMap<Integer, SpaceMarine> marineHashMap, int reid) {
        spaceMarineHashMap = marineHashMap;
        id = reid;
    }
    public void execute() {
        spaceMarineHashMap.remove(id);
    }
    public String getName() {
        return "removeKeyNull";
    }
    public String getDescription() {
        return "1234";
    }
}
