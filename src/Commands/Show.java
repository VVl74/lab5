package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;
import Managers.CommandManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Show implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        Collection<SpaceMarine> mapValues = collectionManager.getCollection().values();
        for (var v: mapValues) {
            System.out.println(v);
        }
    }

    public  String getComandInfo() {
        return "show : вывести в стандартный поток вывода все элементы" +
                " коллекции в строковом представлении\n";
    }
}
