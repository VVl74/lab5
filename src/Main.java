import Collection.SpaceMarine;
import Exeptions.CommandExeption;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;
import Utils.Wrapper;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Scanner;
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
            // System.out.println("не удалось прочитать файл");
            logger.info("не удалось прочитать файл");
        }

        CollectionManager collectionManager = new CollectionManager(newCollection);

        CommandManager curCommandManager = new CommandManager(collectionManager);

        DatagramChannel servChannel = DatagramChannel.open();
        servChannel.bind(new InetSocketAddress(12345));
        servChannel.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(16384);

        // System.out.println("Сервер запущен");
        logger.info("Сервер запущен");

        Terminal terminal = null;

        try {
            terminal = TerminalBuilder.builder().system(true).build();
        } catch (Exception e) {
            throw new RuntimeException();
        }

        LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();


        while (true) {


            buf.clear();
            SocketAddress client = servChannel.receive(buf);

            // logger.info("запрос получен");

            String input = null;

            // ByteBuffer vvodBuf = ByteBuffer.allocate(16384);

            if (client != null) {
                logger.info("запрос получен");
                buf.flip();

                ObjectMapper mapper = new ObjectMapper();

                byte[] data = new byte[buf.limit()];

                buf.get(data);

                Wrapper prvvod = mapper.readValue(data, Wrapper.class);

                input  = prvvod.getZapr();


                // String prs = new String(buf.array(), 0, buf.limit());

                // input = prs;
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
                    //System.out.println(parts[0]);
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

                // ans =  stream.toString();

                servChannel.send(otvet, client);

                logger.info("Ответ отправлен");

            } else {
                // System.out.println("С склиентом что то не так, адреса нет");
                // logger.info("Ошибка у клиента нет адреса");
            }

            if (System.in.available() > 0) {
                String TerInput = null;
                try {
                    TerInput = reader.readLine();
                } catch (Exception e) {
                    System.out.println("ввод завершен");
                }

                TerInput = TerInput.trim();

                if (TerInput == null) {
                    continue;
                }

                String[] TerArgs = TerInput.split(" ");

                if (TerArgs[0].equals("exit") || TerArgs[0].equals("save")) {
                    logger.info("команда выполнена");
                    curCommandManager.newCommand(TerArgs);
                } else {
                    logger.info("команда не выполнена");
                }
            }
        }
    }
}