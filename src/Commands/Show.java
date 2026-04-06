package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;
import Managers.CommandManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

import Collection.Chapter;
/**
 * Комманда для выведения всех элементов коллекции
 *
 */
public class Show implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        Collection<SpaceMarine> mapValues = collectionManager.getCollection().values();

        HashMap <Integer, SpaceMarine> space = collectionManager.getCollection();
        ArrayList<SpaceMarine> nmarines =  mapValues.stream()
                .sorted(Comparator.comparing(marine -> marine.getChapter().getWorld()))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));


        for (var v: nmarines) {
            System.out.println(v);
        }

        System.out.println("элементы коллекции выведены\n");
    }

    public  String getComandInfo() {
        return "show : вывести в стандартный поток вывода все элементы" +
                " коллекции в строковом представлении\n";
    }
}
