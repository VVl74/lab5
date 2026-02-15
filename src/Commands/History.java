package Commands;

import Managers.CollectionManager;

import java.util.ArrayList;

public class History implements Command {
    ArrayList<String> history;
    public History(ArrayList<String> commandHistory) {
        history = commandHistory;
    }
    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        for (int i=history.toArray().length - 14; i < history.toArray().length; i++) {
            System.out.println(history.get(i));
        }
    }

    @Override
    public String getComandInfo() {
        return "history : вывести последние 14 команд (без их аргументов)\n";
    }
}
