package Commands;

import Collection.SpaceMarine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class RemoveLowerKeyNull implements Command {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    int id;

    public RemoveLowerKeyNull(HashMap<Integer, SpaceMarine> marineHashMap) {
        spaceMarineHashMap = marineHashMap;
    }
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("слишком много аргументов");
        } else {
            id = Integer.parseInt(args[0]);
        }
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
