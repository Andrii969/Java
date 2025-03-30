package Game.test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static Game.PirateGame.Weapon.KNIFE;
import static Game.PirateGame.Weapon.getWeaponByChar;

public class MainTest {

    public static void main(String[] args) {

        for (Day day : Day.values()) {
            System.out.println(day + ": " + day.getDescription());
        }

        for (Weapons weapon : Weapons.values()) {
            System.out.println(weapon + ": " + weapon.name().toLowerCase() + " - " + weapon.getMinLevel() + " - " + weapon.getHitPoints());
        }

        System.out.println(Weapons.values()[0]);

        System.out.println("-".repeat(30));
        List<Weapons> weapons = new ArrayList<>(EnumSet.allOf(Weapons.class));
        weapons.forEach(System.out::println);

        System.out.println("-".repeat(30));

        System.out.println(getWeaponByChar('A'));

        System.out.println(KNIFE.name().toLowerCase());
    }
}
