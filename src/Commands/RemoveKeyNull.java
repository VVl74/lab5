package Commands;

import Managers.CollectionManager;

public class RemoveKeyNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length !=1) {
            System.out.println("неверное число аргументов");
        } else {
            int id = Integer.parseInt(args[0]);
            collectionManager.removeElement(id);
        }
    }
    public String getComandInfo() {
        return "remove_key null : удалить элемент из коллекции по его ключу\n";
    }
}
