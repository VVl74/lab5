package Commands;

import Collection.Chapter;
import Collection.SpaceMarine;
import Managers.CollectionManager;

import java.util.HashMap;
import java.util.Set;

public class FilterLessThanChapter implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length !=4) {
            System.out.println("неверное число аргументов");
        } else {
            Chapter chapter = new Chapter(args[0], args[1], (long) Integer.parseInt(args[2]), args[3]);
            Set<Integer> mapValues = collectionManager.getCollection().keySet();
            for (var v : mapValues) {
                if (collectionManager.getCollection().get(v).getChapter().compareTo(chapter) < 0) {
                    System.out.println(collectionManager.getCollection().get(v));
                }
            }
        }
    }
    public String getComandInfo() {
        return "filter_less_than_chapter chapter : вывести элементы, значение поля" +
                " chapter которых меньше заданного\n";
    }
}
