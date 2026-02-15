package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class CountLessThanHealth implements Command {
    HashMap<Integer, SpaceMarine> spaceMarineHashMap;
    int hp;

    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length > 1) {
            System.out.println("нужен только 1 аргумент");
        } else {
            hp = Integer.parseInt(args[0]);
            int sh = 0;
            Set <Integer> mapValues = spaceMarineHashMap.keySet();

            for (var v : mapValues) {
                if (spaceMarineHashMap.get(v).getHealth() < hp) {
                    sh++;
                }
            }
            System.out.println(sh);
        }
    }
    public String getComandInfo() {
        return "count_less_than_health: вывести количество элементов," +
                " значение поля health которых меньше заданного\n";
    }
}
