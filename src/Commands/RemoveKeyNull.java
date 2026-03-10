package Commands;

import Exeptions.ArgExeption;
import Managers.CollectionManager;
/**
 * Комманда для удаления элемента из коллекции по ключу
 *
 */
public class RemoveKeyNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length !=1) {
            throw new ArgExeption();
            // System.out.println("неверное число аргументов");
        }
        int id = Integer.parseInt(args[0]);
        collectionManager.removeElement(id);

        System.out.println("элемент удален\n");
    }
    public String getComandInfo() {
        return "remove_key key (int) : удалить элемент из коллекции по его ключу\n";
    }
}
