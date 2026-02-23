package Commands;

import Exeptions.ArgExeption;
import Exeptions.RecursExeption;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExecuteScriptFileName implements Command {

    public void execute(String[] args, CollectionManager collection) {
        if (args.length > 1 || args.length == 0) {
            throw  new ArgExeption();
            // System.out.println("не правильный формат ввода");
        }
        String filename = args[0];

        if (collection.scriptIf(filename)) {
            throw new RecursExeption();
        } else {
            collection.scriptInsert(filename);
        }

        FileManager fileManager = new FileManager();

        fileManager.setFilename(filename);
        ArrayList<String> commands = null;

        try {
            commands = fileManager.commandRead();
        } catch (FileNotFoundException e) {
            System.out.println("имя файла неверно или файл не читаем");
        }

        CommandManager commandManager = new CommandManager(collection);

        if (commands != null) {
            for (String i : commands) {
                String[] newArgs = i.split(" ");
                commandManager.newCommand(newArgs);
            }
            collection.scriptRemove(filename);
        }
    }

    public String getComandInfo() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь" +
                " в интерактивном режиме.\n";

    }
}
