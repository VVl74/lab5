package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;
import Managers.Parser;

import java.util.HashMap;

public class ReplaceIfLoweNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length != 11) {
            System.out.println("Неверный ввод данных");
        } else {
            Parser parser = new Parser();

            SpaceMarine spacemar;
            spacemar = parser.parsSpaceMarine(args);
            if (collectionManager.getCollection().get(spacemar.getId()).compareTo(spacemar) > 0) {
                collectionManager.swapElement(spacemar, spacemar.getId());
            }
        }
    }
    public String getComandInfo() {
        return "replace_if_lowe null {element} : заменить значение по ключу," +
                " если новое значение меньше старого\n";
    }
}
