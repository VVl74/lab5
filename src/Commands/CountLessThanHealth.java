package Commands;

import Collection.SpaceMarine;
import Exeptions.ArgExeption;
import Exeptions.InputExeption;
import Managers.CollectionManager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class CountLessThanHealth implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length > 1) {
            throw new ArgExeption();
            // System.out.println("нужен только 1 аргумент");
        }

        double hp;

        try {
            hp = Double.parseDouble(args[0]);
        } catch (Exception e) {
            throw new InputExeption();
        }

        int sh = 0;
        Set <Integer> mapValues = collectionManager.getCollection().keySet();

        for (var v : mapValues) {
            if (collectionManager.getCollection().get(v).getHealth() < hp) {
                sh++;
            }
        }
        System.out.println(sh);
    }
    public String getComandInfo() {
        return "count_less_than_health: вывести количество элементов," +
                " значение поля health которых меньше заданного\n";
    }
}
