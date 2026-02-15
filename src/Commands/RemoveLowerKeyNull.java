package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class RemoveLowerKeyNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length > 1) {
            System.out.println("слишком много аргументов");
        } else {
            int id = Integer.parseInt(args[0]);

            Set<Integer> mapValues = collectionManager.getCollection().keySet();
            for (var v : mapValues) {
                if (v < id) {
                    collectionManager.getCollection().remove(id);
                }
            }
        }
    }
    public String getComandInfo() {
        return "remove_lower_key null : удалить из коллекции все элементы, " +
                "ключ которых меньше, чем заданный\n";
    }
}
