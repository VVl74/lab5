package Utils;

import Collection.*;
import Exeptions.InputExeption;

import java.time.LocalDateTime;

public class Parser {
    public SpaceMarine parsSpaceMarine(String[] args) {
        try {
            int nid = Integer.parseInt(args[0]);
            String name = args[1];
            float x = Float.parseFloat(args[2]);
            Long y = (long) Integer.parseInt(args[3]);

            Coordinates cord = new Coordinates(x, y);

            LocalDateTime ndate = LocalDateTime.now();

            double health = (double) Float.parseFloat(args[4]);

            AstartesCategory nc = AstartesCategory.valueOf(args[5]);

            Weapon nweapon = Weapon.valueOf(args[6]);

            MeleeWeapon nmeleeweapon = MeleeWeapon.valueOf(args[7]);

            String nchaptername = args[8];
            String nparentlegion = args[9];

            Long marinescount = (long) Integer.parseInt(args[10]);

            String world = args[11];

            Chapter marinchapt = new Chapter(nchaptername, nparentlegion, marinescount, world);

            SpaceMarine spacemar = new SpaceMarine(nid, name, cord, ndate, health, nc, nweapon, nmeleeweapon, marinchapt);
            return spacemar;
        } catch (Exception e) {
            throw new InputExeption();
        }
    }
    public Chapter parseChapter(String[] args) {
        try {
            String s1 = args[0];
            String s2 = args[1];
            Long chislen = (long) Integer.parseInt(args[2]);
            String s3 = args[3];

            Chapter nchapt = new Chapter(s1, s2, chislen, s3);

            return nchapt;

        } catch(Exception e) {
            throw new InputExeption();
        }
    }
}
