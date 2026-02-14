package Managers;

import Commands.Command;
import Commands.Help;
import Commands.Info;

import java.util.Arrays;
import java.util.HashMap;

public class CommandManager {
    public HashMap<String, Command> commandHashMap = new HashMap<>();
    public CollectionManager collectionManager;

    public CommandManager(CollectionManager newCollectionManager) {
        collectionManager = newCollectionManager;
        commandHashMap.put("help", new Help());
        commandHashMap.put("info", new Info());
    }

    public void newCommand(String[] args) {
        String com = args[0];

        String[] commandArgs = Arrays.copyOfRange(args, 1, args.length);

        if (commandHashMap.containsKey(com)) {
            commandHashMap.get(com).execute(commandArgs);
        } else {
            System.out.println("неизвестная команда");
        }
    }
}
