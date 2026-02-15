package Managers;

import Collection.SpaceMarine;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;

public class CollectionManager {
    private HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    private LocalDateTime dateInit;

    public CollectionManager(HashMap<Integer, SpaceMarine> newspaceMarineHashMap) {
        spaceMarineHashMap = newspaceMarineHashMap;
        dateInit = LocalDateTime.now();
    }

    public void inputElement(SpaceMarine newSpaceMarine) {
        spaceMarineHashMap.put(newSpaceMarine.getId(), newSpaceMarine);
    }
    public void swapElement(SpaceMarine newSpaceMarine, int id) {
        spaceMarineHashMap.remove(id);
        spaceMarineHashMap.put(id, newSpaceMarine);
    }
    public void removeElement(int id) {
        spaceMarineHashMap.remove(id);
    }

    public HashMap<Integer, SpaceMarine> getCollection() {
        return spaceMarineHashMap;
    }

    public LocalDateTime getTime() {
        return dateInit;
    }
}
