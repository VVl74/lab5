package Managers;

import Collection.SpaceMarine;
import Exeptions.IdElemExeption;
import Exeptions.NotElemExeption;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/**
 * Ключевой класс приложения отвечающий за работу с коллекцией
 * <p>
 *  Функции класса
 *  <ul>
 *      <li> Хранение коллекции спейсмаринов </li>
 *      <li> Менеджмент элементво коллекции </li>
 *      <li> проверка адекватности скриптов </li>
 * </ul>
 */
public class CollectionManager {
    private HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    private LocalDateTime dateInit;

    public CollectionManager(HashMap<Integer, SpaceMarine> newspaceMarineHashMap) {
        spaceMarineHashMap = newspaceMarineHashMap;
        dateInit = LocalDateTime.now();
    }

    /**
     * Метод добавления элемента
     */
    public void inputElement(SpaceMarine newSpaceMarine) {
        if (spaceMarineHashMap.containsKey(newSpaceMarine.getId())) {
            throw new IdElemExeption();
        } else {
            spaceMarineHashMap.put(newSpaceMarine.getId(), newSpaceMarine);
        }
    }
    /**
     * Метод замены элемента
     */
    public void swapElement(SpaceMarine newSpaceMarine, int id) {
        if (spaceMarineHashMap.containsKey(newSpaceMarine.getId())) {
            spaceMarineHashMap.put(id, newSpaceMarine);
        } else {
            throw new NotElemExeption();
        }
    }
    /**
     * Метод удаления элемента
     */
    public void removeElement(int id) {
        if (spaceMarineHashMap.containsKey(id)) {
            spaceMarineHashMap.remove(id);
        } else {
            System.out.println("нет элемента с таким ID");
        }
    }

    public HashMap<Integer, SpaceMarine> getCollection() {
        return spaceMarineHashMap;
    }

    public LocalDateTime getTime() {
        return dateInit;
    }

    ArrayList<String> scriptPul = new ArrayList<String>();

    /**
     * Метод добавления скрипта
     */
    public void scriptInsert(String a) {
        scriptPul.add(a);
    }
    /**
     * Метод удаления элемента
     */
    public void scriptRemove(String a) {
        scriptPul.remove(a);
    }
    /**
     * Метод проверяющий содержится ли скрипт в текущем скриптпуле
     */
    public Boolean scriptIf(String a) {
        if (scriptPul.contains(a)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
