import Collection.SpaceMarine;
import Exeptions.CommandExeption;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        String filename = "data.csv";

        FileManager fileManager = new FileManager();

        fileManager.setFilename(filename);

        HashMap <Integer, SpaceMarine> newCollection = new HashMap<>();

        try {
            newCollection = fileManager.fileRead();
        } catch (Exception e) {
             System.out.println("не удалось прочитать файл");
        }

        CollectionManager collectionManager = new CollectionManager(newCollection);

        // Scanner scanner = new Scanner(System.in);

        Terminal terminal = null;

        try {
            terminal = TerminalBuilder.builder().system(true).build();
        } catch (Exception e) {
            throw new RuntimeException();
        }

        LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();

        CommandManager curCommandManager = new CommandManager(collectionManager);

        while (true) {
            String input = null;
            try {
                input = reader.readLine();
            } catch (Exception e) {
                System.out.println("ввод завершен");
            }
            /*
            if (!scanner.hasNextLine()) {
                System.out.println("Ввод завершен");
                break;
            }
            String input = scanner.nextLine();
            */
            if (input == null) {
                continue;
            }
            String[] parts = input.split(" ");

            try {
                curCommandManager.newCommand(parts);
            } catch (Exception e) {
                System.out.println("Ошибка, команда не выполнена");
            }
        }
    }
}