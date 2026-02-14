package Commands;

import Collection.SpaceMarine;

import java.util.HashMap;
import java.util.Set;

public class FilterLessThanChapter implements Command {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    int chapt;

    public FilterLessThanChapter(HashMap<Integer, SpaceMarine> marineHashMap, int rechapt) {
        spaceMarineHashMap = marineHashMap;
        chapt = rechapt;
    }
    public void execute() {
        Set<Integer> mapValues = spaceMarineHashMap.keySet();
        for (var v: mapValues) {
            if (spaceMarineHashMap.get(v).getChapter().getMarinesCount() < chapt) {
                System.out.println(spaceMarineHashMap.get(v));
            }
        }
    }
    public String getName() {
        return "FilterLessThanChapter";
    }
    public String getDescription() {
        return "1234";
    }
}
