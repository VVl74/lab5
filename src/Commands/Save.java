package Commands;

import Collection.SpaceMarine;
import Managers.CollectionManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Save implements Command {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        if (args.length == 1) {
            String filename = args[0];

            HashMap <Integer, SpaceMarine> spaceMarineHashMap = collectionManager.getCollection();

            Set<Integer> keys = spaceMarineHashMap.keySet();

            try(BufferedWriter bufwriter = new BufferedWriter(new FileWriter(filename))) {

                for (int i : keys) {
                    SpaceMarine spaceMarine = spaceMarineHashMap.get(i);

                    String str = spaceMarine.getId() + ";" + spaceMarine.getName() +
                            ";" + spaceMarine.getCoordinates().getX() + ";" + spaceMarine.getCoordinates().getY() +
                            ";" + spaceMarine.spaceGetTime() + ";" + spaceMarine.getHealth() + ";" +
                            spaceMarine.getCategory() + ";" + spaceMarine.getWeaponType() + ";" +
                            spaceMarine.getMeleeWeapon() + ";" + spaceMarine.getChapter().getName() + ";" +
                            spaceMarine.getChapter().getParentLegion() + ";" + spaceMarine.getChapter().getMarinesCount() + ";" +
                            spaceMarine.getChapter().getWorld();

                    bufwriter.write(str);

                }
            } catch(IOException exep) {
                System.out.println("файла нет либо запись не удалась");
            }



        } else {
            System.out.println("неверный формат ввода");
        }
    }

    @Override
    public String getComandInfo() {
        return "save : сохранить коллекцию в файл\n";
    }
}
