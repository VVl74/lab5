package Managers;

import Commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommandManager {
    public HashMap<String, Command> commandHashMap = new HashMap<>();
    public CollectionManager collectionManager;
    ArrayList<String> commandHistory = new ArrayList<String>();

    public CommandManager(CollectionManager newCollectionManager) {
        collectionManager = newCollectionManager;
        commandHashMap.put("help", new Help(commandHashMap));
        commandHashMap.put("info", new Info());
        commandHashMap.put("history", new History(commandHistory));
        commandHashMap.put("exit", new Exit());
        commandHashMap.put("cleat", new Clear());
        commandHashMap.put("show", new Show());
        commandHashMap.put("insert null", new InsertNull());
        commandHashMap.put("update id", new UpdateId());
        commandHashMap.put("remove_key", new RemoveKeyNull());
        commandHashMap.put("execute_script", new ExecuteScriptFileName());
        commandHashMap.put("save", new Save());
        commandHashMap.put("replace_if_lowe", new ReplaceIfLoweNull());
        commandHashMap.put("remove_lower_key", new RemoveLowerKeyNull());
        commandHashMap.put("count_less_than_health", new CountLessThanHealth());
        commandHashMap.put("filter_less_than_chapter", new FilterLessThanChapter());
        commandHashMap.put("filter_greater_than_chapter", new FilterGreaterThanChapter());
    }

    public void newCommand(String[] args) {
        String com = args[0];

        String[] commandArgs = Arrays.copyOfRange(args, 1, args.length);

        if (commandHashMap.containsKey(com)) {
            commandHashMap.get(com).execute(commandArgs, collectionManager);
            commandHistory.add(com);
        } else {
            System.out.println("неизвестная команда");
        }
    }
}
