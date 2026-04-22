package managers;

import collection.*;
import exeptions.FileExeption;
import exeptions.InputExeption;
import exeptions.ReadExeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Класс для работы с файломи
 * <p>
 *  Функции класса
 *  <ul>
 *      <li> Чтение данных из файла
 *      <li> Собирание данных из файлов в коллекцию
 *      <li> чтение команд из файла
 * </ul>
 */
public class FileManager {
    Logger logger = LoggerFactory.getLogger(FileManager.class);
    private static int id = 1;
    public String filename;

    public void setFilename(String name) {
        filename = name;
    }


    /**
     * Читатель изначальной коллекции
     *  <ol>
     *      <li> читаем файл с данными </li>
     *      <li> собираем их в спейсмаринов </li>
     *      <li> собираем спейсмаринов в мапу </li>
     *      <li> возвращаем мапу спейсмаринов </li>
     *  </ol>
     */
    public HashMap<Integer, SpaceMarine> fileRead() throws FileNotFoundException {
        HashMap <Integer, SpaceMarine> spaceMarineHashMap = new HashMap<>();

        try (InputStreamReader bufreader = new InputStreamReader(new FileInputStream(filename))) {
            BufferedReader reader = new BufferedReader(bufreader);

            String input;

            while (true) {
                input = reader.readLine();

                if (input == null) {
                    break;
                }
                SpaceMarine newmarine;

                try {
                    newmarine = parserMar(input);
                } catch (Exception e) {
                    System.out.println("Считать строку не удалось");
                    continue;
                }

                spaceMarineHashMap.put(newmarine.getId(), newmarine);
                id++;
            }
        } catch(IOException exep) {
            throw new ReadExeption(exep.getMessage());
            // System.out.println("с файлом что то не то " + exep.getMessage());
        }

        return spaceMarineHashMap;
    }

    /**
     * Читатель команд
     *  <ol>
     *      <li> читаем файл с командами </li>
     *      <li> закидываем команду в массив </li>
     *      <li> возвращаем массив команд </li>
     *  </ol>
     */

    public ArrayList<String> commandRead() throws FileNotFoundException {
        ArrayList<String> args = new ArrayList<>();
        try (InputStreamReader bufreader = new InputStreamReader(new FileInputStream(filename))) {
            BufferedReader reader = new BufferedReader(bufreader);

            String input;


            while(true) {
                input = reader.readLine();

                if (input == null) {
                    break;
                }
                args.add(input);
            }
        } catch(IOException exep) {
            System.out.println("с файлом что то не то " + exep.getMessage());
        }

        return args;
    }

    /**
     * Билдер спейсмарина из строки
     *  <ol>
     *      <li> получаем массив с данными для SpaceMarine </li>
     *      <li> считываем и валидируем их </li>
     *      <li> возвращаем собранный элемент </li>
     *  </ol>
     */
    public SpaceMarine parserMar(String str) {
        try {
            String[] elem = str.split(";");

            if (elem.length != 11) {
                throw new FileExeption("неверное число аргументов");
            }

            for (int i=0; i < elem.length; i++) {
                elem[i] = elem[i].trim();
            }

            int nid = id;
            String name = elem[0];

            if (name.isEmpty()) {
                throw new FileExeption("имя не может быть пустым");
            }

            float x = Float.parseFloat(elem[1]);
            Long y = (long) Integer.parseInt(elem[2]);

            Coordinates cord = new Coordinates(x, y);

            LocalDateTime ndate = LocalDateTime.now();

            double health = (double) Float.parseFloat(elem[3]);

            if (Double.isNaN(health) || health < 0) {
                throw new FileExeption("здоровье не может быть NaN или < 0");
            }

            AstartesCategory nc = AstartesCategory.valueOf(elem[4].toUpperCase());

            Weapon nweapon = Weapon.valueOf(elem[5].toUpperCase());

            MeleeWeapon nmeleeweapon = MeleeWeapon.valueOf(elem[6].toUpperCase());

            String nchaptername = elem[7];
            String nparentlegion = elem[8];


            Long marinescount = (long) Integer.parseInt(elem[9]);

            if (marinescount <= 0 || marinescount > 1000) {
                throw new FileExeption("неверныая численность");
            }

            String world = elem[10];

            Chapter marinchapt = new Chapter(nchaptername, nparentlegion, marinescount, world);

            SpaceMarine spacemar = new SpaceMarine(nid, name, cord, ndate, health, nc, nweapon, nmeleeweapon, marinchapt);

            return spacemar;
        } catch (Exception e) {
            throw new InputExeption();
        }
    }
}
