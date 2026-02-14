package Managers;

import Collection.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;

public class FileManager {
    private static int id = 1;
    public String filename;

    public void setFilename(String name) {
        filename = name;
    }

    public HashMap<Integer, SpaceMarine> fileRead() throws FileNotFoundException {
        HashMap <Integer, SpaceMarine> spaceMarineHashMap = new HashMap<>();

        //name;x;y;health;astartescategory;weapon;meleeWeapon;chapterName;parentLegion;marinesCount;world

        try (InputStreamReader bufreader = new InputStreamReader(new FileInputStream(filename))) {
            BufferedReader reader = new BufferedReader(bufreader);

            String input;

            while ((input = reader.readLine()) != null) {
                SpaceMarine newmarine = parserMar(input);
                spaceMarineHashMap.put(newmarine.getId(), newmarine);
                id++;
            }
        } catch(IOException exep) {
            System.out.println("с файлом что то не то " + exep.getMessage());
        }

        return spaceMarineHashMap;
    }

    public SpaceMarine parserMar(String str) {
        String[] elem = str.split(";");

        int nid = id;
        String name = elem[0];
        float x = Float.parseFloat(elem[1]);
        Long y = (long) Integer.parseInt(elem[2]);

        Coordinates cord = new Coordinates(x, y);

        LocalDateTime ndate = LocalDateTime.now();

        double health = (double) Float.parseFloat(elem[3]);

        AstartesCategory nc =  AstartesCategory.valueOf(elem[4]);

        Weapon nweapon = Weapon.valueOf(elem[5]);

        MeleeWeapon nmeleeweapon = MeleeWeapon.valueOf(elem[6]);

        String nchaptername = elem[7];
        String nparentlegion = elem[8];

        Long marinescount = (long) Integer.parseInt(elem[9]);

        String world = elem[10];

        Chapter marinchapt = new Chapter(nchaptername, nparentlegion, marinescount, world);

        SpaceMarine spacemar = new SpaceMarine(nid, name, cord, ndate, health, nc, nweapon, nmeleeweapon, marinchapt);

        return spacemar;
    }
}
