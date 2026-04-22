package commands;

import collection.Chapter;
import exeptions.ArgExeption;
import exeptions.InputExeption;
import managers.CollectionManager;
import utils.Parser;

import java.util.Set;
/**
 * Комманда для выведения всех элементов чей Chapter меньше заданного
 *
 */
public class FilterLessThanChapter implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length !=4) {
            throw  new ArgExeption();
            // System.out.println("неверное число аргументов");
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
            if (collectionManager.getCollection().get(v).getChapter().compareTo(chapter) < 0) {
                System.out.println(collectionManager.getCollection().get(v));
            }
        }

        System.out.println("все элементы с Chapter < заданного выведены\n");
    }
    public String getComandInfo() {
        return "filter_greater_than_chapter chapter : вывести элементы, значение поля chapter которых меньше заданного\n" +
                "сравнение производится по полю marinesCount\n" +
                "chapter вводится через пробел в следующем порядке:\n" +
                "(string) name (string) parentLegion (long) marinesCount (string) world\n";
    }
}
