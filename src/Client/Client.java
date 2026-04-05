package Client;

import Utils.Wrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

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
public class Client {
    /**
     * Начало программы
     *  <ol>
     *      <li> Получаем имя файла </li>
     *      <li> Считываем коллекцию </li>
     *      <li> Создаем коллекшн менеджер и команд менеджер </li>
     *      <li> Запускаем режим интерактивной работы с коллекцией </li>
     *  </ol>
     */
    public static void main(String[] args) throws JsonProcessingException {

        Terminal terminal = null;

        try {
            terminal = TerminalBuilder.builder().system(true).build();
        } catch (Exception e) {
            throw new RuntimeException();
        }

        LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();

        ObjectMapper mapper = new ObjectMapper();


        while (true) {
            String input = null;
            try {
                input = reader.readLine();
            } catch (Exception e) {
                System.out.println("ввод завершен");
            }

            if (input == null) {
                continue;
            }
            Wrapper outWrap = new Wrapper();

            outWrap.setZapr(input);

            byte[] jsonByte = mapper.writeValueAsBytes(outWrap);

            ByteBuffer sendBuf = ByteBuffer.wrap(jsonByte);

            try {
                DatagramChannel channel = DatagramChannel.open();
                channel.configureBlocking(false);

                InetSocketAddress serverAdress = new InetSocketAddress("localhost", 12345);

                // ByteBuffer sendBuf = ByteBuffer.wrap((input).getBytes());

                channel.send(sendBuf, serverAdress);

                ByteBuffer vvodBuf = ByteBuffer.allocate(16384);

                SocketAddress from = null;

                while(true) {
                    from = channel.receive(vvodBuf);

                    if (from != null) {
                        break;
                    }

                    Thread.sleep(100);
                }

                vvodBuf.flip();

                byte[] data = new byte[vvodBuf.limit()];

                vvodBuf.get(data);

                Wrapper prvvod = mapper.readValue(data, Wrapper.class);

                String itog  = prvvod.getZapr();

                System.out.println(itog);
            } catch (Exception e) {
                System.out.println("Ошибка, команда не выполнена "  + e.getMessage());
            }
        }
    }
}

