package Commands;

import Collection.*;
import Exeptions.ArgExeption;
import Managers.CollectionManager;
import Utils.Parser;

public class InsertNull implements Command {
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length != 12) {
            throw new ArgExeption();
            //System.out.println("неверное число аргументов " + args.length);
        }
        Parser parser = new Parser();
        SpaceMarine spacemar = null;
        try {
            spacemar = parser.parsSpaceMarine(args);
        } catch (Exception e) {
            System.out.println("ошибка ввода данных");
            return;
        }
        collectionManager.inputElement(spacemar);

        System.out.println("элемент добавлен\n");
    }
    public String getComandInfo() {
        // insert 500 Ultramarine 12.5 7 150 ASSAULT BOLTGUN CHAIN_SWORD Ultramar Guilliman 500 Macragge
        return "insert {element} : добавить новый элемент с заданным ключом аргументы необходимо" +
                "вводить через пробел в следующем порядке:" +
                " (int)id (string)name (Float)cordX (Long)cordY (Float)Health \n" +
                "Weapon из списка:(BOLTGUN,MELTAGUN,FLAMER, HEAVY_FLAMER)\n" +
                "MeleeWeapon из списка: (CHAIN_SWORD, POWER_SWORD,CHAIN_AXE,MANREAPER, POWER_FIST)\n" +
                "(string)name_legion (string)commander_legion (int)marinesCount (string)название планеты  \n";
    }
}
