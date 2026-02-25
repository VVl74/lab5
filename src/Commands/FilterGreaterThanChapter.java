package Commands;

import Collection.Chapter;
import Collection.SpaceMarine;
import Exeptions.ArgExeption;
import Exeptions.InputExeption;
import Managers.CollectionManager;
import Utils.Parser;

import java.util.HashMap;
import java.util.Set;

public class FilterGreaterThanChapter implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length !=4) {
            throw new ArgExeption();
        }

        Parser parser = new Parser();
        Chapter chapter = null;
        try {
            chapter = parser.parseChapter(args);
        } catch (Exception e) {
            throw new InputExeption();
        }

        Set<Integer> mapValues = collectionManager.getCollection().keySet();

        for (var v : mapValues) {
            if (collectionManager.getCollection().get(v).getChapter().compareTo(chapter) > 0) {
                System.out.println(collectionManager.getCollection().get(v));
            }
        }

        System.out.println("все элементы с Chapter > заданного выведены\n");
    }
    public String getComandInfo() {
        return "filter_greater_than_chapter chapter : вывести элементы, " +
                "значение поля chapter которых больше заданного\n";
    }
}
