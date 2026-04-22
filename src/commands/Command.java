package commands;

import managers.CollectionManager;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Интерфейс для всех команд для комманд паттерна
 *
 */

public interface Command {
    void execute(String[] args, CollectionManager collectionManager, PrintWriter out);
    String getComandInfo();
}
