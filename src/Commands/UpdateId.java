package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;
import Managers.Parser;

import java.util.HashMap;

public class UpdateId implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        Parser parser = new Parser();
        SpaceMarine spacemar = parser.parsSpaceMarine(args);
        collectionManager.swapElement(spacemar, spacemar.getId());
    }
    public String getComandInfo() {
        return "update id {element} : обновить значение элемента коллекции," +
                " id которого равен заданному\n";
    }
}
