package Commands;

import Collection.*;
import Managers.CollectionManager;
import Managers.Parser;

import java.time.LocalDateTime;
import java.util.HashMap;

public class InsertNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length != 11) {
            System.out.println("неверное число аргументов");
        } else {
            Parser parser = new Parser();
            SpaceMarine spacemar = parser.parsSpaceMarine(args);
            collectionManager.inputElement(spacemar);
        }
    }
    public String getComandInfo() {
        return "insert null {element} : добавить новый элемент с заданным ключом\n";
    }
}
