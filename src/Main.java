import Collection.SpaceMarine;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;

import java.io.FileNotFoundException;
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

        HashMap <Integer, SpaceMarine> newCollection;

        try {
            newCollection = fileManager.fileRead();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        CollectionManager collectionManager = new CollectionManager(newCollection);

        Scanner scanner = new Scanner(System.in);

        CommandManager curCommandManager = new CommandManager(collectionManager);

        while (true) {
            String input = scanner.nextLine();

            String[] parts = input.split(" ");

            curCommandManager.newCommand(parts);
        }

    }
}