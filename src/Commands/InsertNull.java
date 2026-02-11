package Commands;

import Collection.SpaceMarine;

import java.util.HashMap;

public class InsertNull implements Command {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    SpaceMarine spaceMarine;

    public InsertNull(HashMap<Integer, SpaceMarine> marineHashMap, SpaceMarine newSpaceMarine) {
        spaceMarineHashMap = marineHashMap;
        spaceMarine = newSpaceMarine;
    }
    public void execute() {
        spaceMarineHashMap.put(spaceMarine.getId(), spaceMarine);
    }
    public String getName() {
        return "InsertNull";
    }
    public String getDescription() {
        return "1234";
    }
}
