package Commands;

import Collection.SpaceMarine;

import java.util.HashMap;
import java.util.Set;

public class CountLessThanHealth implements Command {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    int hp;

    public CountLessThanHealth(HashMap<Integer, SpaceMarine> marineHashMap, int rehp) {
        spaceMarineHashMap = marineHashMap;
        hp = rehp;
    }
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("нужен только 1 аргумент");
        }
        int sh = 0;
        Set<Integer> mapValues = spaceMarineHashMap.keySet();
        for (var v: mapValues) {
            if (spaceMarineHashMap.get(v).getHealth() < hp) {
                sh++;
            }
        }

        System.out.println(sh);
    }
    public String getName() {
        return "CountLessThanHealth";
    }
    public String getDescription() {
        return "1234";
    }
}
