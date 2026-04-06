package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
/**
 * Комманда для удаления всех элементов коллекции
 *
 */
public class Clear implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        Logger logger = LoggerFactory.getLogger(Clear.class);
        collectionManager.getCollection().clear();
        System.out.println("коллекция очищена\n");
        logger.info("коллекция очщена");
    }
    public String getComandInfo() {
        return "clear: очистить коллекцию\n";
    }
}

