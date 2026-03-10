package Commands;

import Managers.CollectionManager;
/**
 * Интерфейс для всех команд для комманд паттерна
 *
 */
public interface Command {
    void execute(String[] args, CollectionManager collectionManager);
    String getComandInfo();
}
