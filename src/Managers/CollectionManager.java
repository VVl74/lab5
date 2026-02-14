package Managers;

import Collection.SpaceMarine;

import java.util.Collection;
import java.util.HashMap;

public class CollectionManager {
    private HashMap<Integer, SpaceMarine> spaceMarineHashMap;

    public CollectionManager(HashMap<Integer, SpaceMarine> newspaceMarineHashMap) {
        spaceMarineHashMap = newspaceMarineHashMap;
    }

    public void inputElement(SpaceMarine newSpaceMarine) {
        spaceMarineHashMap.put(newSpaceMarine.getId(), newSpaceMarine);
    }
    public void removeElement(int id) {
        spaceMarineHashMap.remove(id);
    }

    public HashMap<Integer, SpaceMarine> getCollection() {
        return spaceMarineHashMap;
    }
}
