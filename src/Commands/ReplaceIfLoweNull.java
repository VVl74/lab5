package Commands;

import Collection.SpaceMarine;

import java.util.HashMap;

public class ReplaceIfLoweNull implements Command {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    SpaceMarine spaceMarine;

    public ReplaceIfLoweNull(HashMap<Integer, SpaceMarine> marineHashMap, SpaceMarine newSpaceMarine) {
        spaceMarineHashMap = marineHashMap;
        spaceMarine = newSpaceMarine;
    }
    public void execute() {
        if (spaceMarineHashMap.get(spaceMarine.getId()).getHealth() > spaceMarine.getHealth()) {
            spaceMarineHashMap.put(spaceMarine.getId(), spaceMarine);
        }
    }
    public String getName() {
        return "ReplaceIfLoweNull";
    }
    public String getDescription() {
        return "1234";
    }
}
