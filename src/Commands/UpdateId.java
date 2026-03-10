package Commands;

import Collection.SpaceMarine;
import Exeptions.ArgExeption;
import Managers.CollectionManager;
import Utils.Parser;
/**
 * Комманда для обновления элемента на новый по заданному ID
 *
 */
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

        System.out.println("элемент обновлен\n");
    }
    public String getComandInfo() {
        return "update id {element} : обновить значение элемента коллекции," +
                " id которого равен заданному передать элемент необходимо в формате" +
                "аналогичном команде insert\n";
    }
}
