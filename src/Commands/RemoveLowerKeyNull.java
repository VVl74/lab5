package Commands;

import Collection.SpaceMarine;
import Exeptions.ArgExeption;
import Exeptions.InputExeption;
import Managers.CollectionManager;

import java.util.*;

public class RemoveLowerKeyNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length > 1) {
            throw new ArgExeption();
        }
        int id;
        try {
            id = Integer.parseInt(args[0]);
        } catch (Exception e) {
            throw new InputExeption();
        }

        List<Integer> removeList = new ArrayList<>();

        Set<Integer> mapValues = collectionManager.getCollection().keySet();
        for (var v : mapValues) {
            if (v < id) {
                removeList.add(v);
            }
        }

        for (var k: removeList) {
            collectionManager.removeElement(k);
        }

        System.out.println("все элементы чей ключ < заданного удалены\n");
    }
    public String getComandInfo() {
        return "remove_lower_key key (int) : удалить из коллекции все элементы, " +
                "ключ которых меньше, чем заданный\n";
    }
}
