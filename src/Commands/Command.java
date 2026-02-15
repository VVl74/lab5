package Commands;

import Managers.CollectionManager;

public interface Command {
    void execute(String[] args, CollectionManager collectionManager);
    String getComandInfo();
}
