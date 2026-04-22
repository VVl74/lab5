import collection.SpaceMarine;
import managers.*;
import utils.InputPack;
import utils.OutputPack;
import utils.Wrapper;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Главный класс приложения отвечающий за запуск работы с коллекциями
 * <p>
 *  Функции класса
 *  <ul>
 *      <li> Чтение коллекции с помощью файл менеджера </li>
 *      <li> Создание коллекшн менеджера и запуск работы с коллекцией </li>
 *      <li> Обработка пользовательских комманд </li>
 *      <li> Обработка некоторых ошибок </li>
 * </ul>
 */
public class Main {
    /**
     * Начало программы
     *  <ol>
     *      <li> Получаем имя файла </li>
     *      <li> Считываем коллекцию </li>
     *      <li> Создаем коллекшн менеджер и команд менеджер </li>
     *      <li> Запускаем режим интерактивной работы с коллекцией </li>
     *  </ol>
     */
    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(Main.class);
        String filename = "data.csv";

        FileManager fileManager = new FileManager();

        fileManager.setFilename(filename);

        HashMap <Integer, SpaceMarine> newCollection = new HashMap<>();

        try {
            newCollection = fileManager.fileRead();
        } catch (Exception e) {
            logger.info("не удалось прочитать файл");
        }

        CollectionManager collectionManager = new CollectionManager(newCollection);

        CommandManager curCommandManager = new CommandManager(collectionManager);

        ServerManager servChannel = new ServerManager(12345);

        logger.info("Сервер запущен");

        InputManager inputManager = new InputManager();

        while (true) {
            InputPack pack;
            pack = servChannel.recive();
            String input = null;

            if (pack.client != null) {
                logger.info("запрос получен");

                ObjectMapper mapper = new ObjectMapper();

                Wrapper prvvod = mapper.readValue(pack.data, Wrapper.class);

                input  = prvvod.getZapr();

                if (input == null) {
                    continue;
                }

                String[] parts = input.split(" ");
                String ans = " ";

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream prstream = new PrintStream(stream);
                PrintStream old = System.out;
                System.setOut(prstream);

                try {
                    if (!parts[0].equals("exit") && !parts[0].equals("save")) {
                        curCommandManager.newCommand(parts);
                    }
                } catch (Exception e) {
                    ans = ("Ошибка, команда не выполнена");
                } finally {
                    System.setOut(old);
                }

                String prStr = stream.toString();

                Wrapper res = new Wrapper();
                res.setZapr(prStr);

                byte[] jsonByte = mapper.writeValueAsBytes(res);

                ByteBuffer otvet = ByteBuffer.wrap(jsonByte);

                OutputPack outPack = new OutputPack(otvet, pack.client);

                servChannel.send(outPack);

                logger.info("Ответ отправлен");
            }
            inputManager.InputTerm(curCommandManager);
        }
    }
}