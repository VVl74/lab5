package Commands;

import Managers.CollectionManager;

public class Info implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        System.out.println("Тип коллекции: " + collectionManager.getCollection().getClass().getName() +
                " время создания "  + collectionManager.getTime() +
                " колличество элементов " + collectionManager.getCollection().size());
    }
    public String getComandInfo() {
        return "info : вывести в стандартный поток вывода информацию" +
                " о коллекции (тип, дата инициализации, количество элементов и т.д.)\n";
    }
}
