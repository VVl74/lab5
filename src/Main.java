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
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

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

        CommandManager curCommandManager = new CommandManager(collectionManager);

        DatagramChannel servChannel = DatagramChannel.open();
        servChannel.bind(new InetSocketAddress(12345));
        servChannel.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(16384);

        System.out.println("Сервер запущен");

        while (true) {
            buf.clear();
            SocketAddress client = servChannel.receive(buf);

            String input = null;

            if (client != null) {
                buf.flip();
                String prs = new String(buf.array(), 0, buf.limit());

                input = prs;
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
                    curCommandManager.newCommand(parts);
                    System.out.println(parts[0]);
                } catch (Exception e) {
                    ans = ("Ошибка, команда не выполнена");
                } finally {
                    System.setOut(old);
                }

                String prStr = stream.toString();

                Wrapper res = new Wrapper();
                res.setZapr(prStr);

                ObjectMapper mapper = new ObjectMapper();

                byte[] jsonByte = mapper.writeValueAsBytes(res);

                ByteBuffer otvet = ByteBuffer.wrap(jsonByte);

                // ans =  stream.toString();

                servChannel.send(otvet, client);

            } else {
                // System.out.println("С склиентом что то не так, адреса нет");
            }
        }
    }
}