package Commands;

import Collection.SpaceMarine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Show implements Command {
    HashMap<Integer, SpaceMarine> marineMap;
    public Show(HashMap<Integer, SpaceMarine> spaceMarineMap) {
        marineMap = spaceMarineMap;
    }
    public void execute() {
        Collection<SpaceMarine> mapValues = marineMap.values();
        for (var v: mapValues) {
            System.out.println(v);
        }
    }

    public  String getName() {
        return "show";
    }

    public String getDescription() {
        return "что то полезное";
    }
}
