package Commands;

import Collection.*;
import Exeptions.ArgExeption;
import Managers.CollectionManager;
import Utils.Parser;

public class InsertNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length != 12) {
            throw new ArgExeption();
            //System.out.println("неверное число аргументов " + args.length);
        }
        Parser parser = new Parser();
        SpaceMarine spacemar = null;
        try {
            spacemar = parser.parsSpaceMarine(args);
        } catch (Exception e) {
            System.out.println("ошибка ввода данных");
            return;
        }
        collectionManager.inputElement(spacemar);

        System.out.println("элемент добавлен\n");
    }
    public String getComandInfo() {
        return "insert null {element} : добавить новый элемент с заданным ключом\n";
    }
}
