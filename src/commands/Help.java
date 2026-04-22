package commands;

import managers.CollectionManager;

import java.util.HashMap;
import java.util.Set;
/**
 * Комманда для выведения справки по всем командам
 *
 */
public class Help implements Command {
    private HashMap<String, Command> commandHashMap;

    public Help(HashMap<String, Command> newCommandHashMap) {
        commandHashMap = newCommandHashMap;
    }
    public void execute(String[] args, CollectionManager collectionManager) {
        Set<String> keys = commandHashMap.keySet();

        for(String i: keys) {
            System.out.println(commandHashMap.get(i).getComandInfo());
        }

        System.out.println("все команды выведены\n");
    }
    public String getComandInfo() {
        return "help : вывести справку по доступным командам\n";
    }
}
