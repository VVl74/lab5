package Commands;

import Collection.SpaceMarine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class RemoveLowerKeyNull {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    int id;

    public RemoveLowerKeyNull(HashMap<Integer, SpaceMarine> marineHashMap, int reid) {
        spaceMarineHashMap = marineHashMap;
        id = reid;
    }
    public void execute() {
        Set<Integer> mapValues = spaceMarineHashMap.keySet();
        for (var v: mapValues) {
            if (v < id) {
                spaceMarineHashMap.remove(id);
            }
        }
    }
    public String getName() {
        return "removeKeyNull";
    }
    public String getDescription() {
        return "1234";
    }
}
