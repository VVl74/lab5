package Commands;

import Collection.SpaceMarine;
import Exeptions.ArgExeption;
import Managers.CollectionManager;
import Utils.Parser;
/**
 * Комманда замены элемента если его здоровье меньше чем текущего
 *
 */
public class ReplaceIfLoweNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length != 12) {
            throw new ArgExeption();
            // System.out.println("Неверный ввод данных");
        }
        Parser parser = new Parser();

        SpaceMarine spacemar;
        try {
            spacemar = parser.parsSpaceMarine(args);
        } catch (Exception e) {
            System.out.println("ошибка ввода данных");
            return;
        }
        if (collectionManager.getCollection().get(spacemar.getId()).compareTo(spacemar) > 0) {
            collectionManager.swapElement(spacemar, spacemar.getId());
            System.out.println("элемент обновлен\n");
        } else {
            System.out.println("элемент не обновлен\n");
        }
    }
    public String getComandInfo() {
        return "replace_if_lower key {element} : заменить значение по ключу, если новое значение меньше старого\n" +
                "сравнение производится по полю health\n" +
                "элемент необходимо передать в том же формате, что и в команде insert\n";
    }
}
