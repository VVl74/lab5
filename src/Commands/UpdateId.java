package Commands;

import Collection.SpaceMarine;
import Exeptions.ArgExeption;
import Managers.CollectionManager;
import Utils.Parser;

public class UpdateId implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length != 12) {
            throw new ArgExeption();
        }
        Parser parser = new Parser();
        SpaceMarine spacemar;
        try {
            spacemar = parser.parsSpaceMarine(args);
        } catch (Exception e) {
            System.out.println("ошибка ввода данных");
            return;
        }
        collectionManager.swapElement(spacemar, spacemar.getId());
    }
    public String getComandInfo() {
        return "update id {element} : обновить значение элемента коллекции," +
                " id которого равен заданному\n";
    }
}
