package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;

import java.util.HashMap;

public class Clear implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        collectionManager.getCollection().clear();
    }
    public String getComandInfo() {
        return "clear: очистить коллекцию\n";
    }
}

