package commands;

import managers.CollectionManager;
/**
 * Комманда для выхода из программы
 *
 */
public class Exit implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        System.exit(0);
    }
    public String getComandInfo() {
        return "exit : завершить программу (без сохранения в файл)\n";
    }
}
