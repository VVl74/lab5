package Commands;

import Collection.SpaceMarine;

import java.util.HashMap;

public class UpdateId implements Command {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    SpaceMarine spaceMarine;

    public UpdateId(HashMap<Integer, SpaceMarine> marineHashMap, SpaceMarine newSpaceMarine) {
        spaceMarineHashMap = marineHashMap;
        spaceMarine = newSpaceMarine;
    }
    public void execute() {
        spaceMarineHashMap.put(spaceMarine.getId(), spaceMarine);
    }
    public String getName() {
        return "UpdateId";
    }
    public String getDescription() {
        return "1234";
    }
}
