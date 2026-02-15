package Commands;

import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExecuteScriptFileName implements Command {

    public void execute(String[] args, CollectionManager collection) {
        if (args.length > 1 || args.length == 0) {
            System.out.println("не правильный формат ввода");
        } else {
            String filename = args[0];
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
            }
        }
    }

    public String getComandInfo() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь" +
                " в интерактивном режиме.\n";

    }
}
