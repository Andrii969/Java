package Game.PirateGame;

import Game.gameConsole.GameConsole;

public class MainPirateGame {

    public static void main(String[] args) {

//        Weapon weapon = Weapon.getWeaponByChar('P');
//        System.out.println("weapon = " + weapon + ", hitPoints = " + weapon.getHitPoints() + ", minLevel = " + weapon.getMinLevel());
//
//        System.out.println("-----");
//
//        var list = Weapon.getWeaponsByLevel(0);
//        list.forEach(System.out::println);
//
//        System.out.println("-----");
//
//        var list2 = (EnumSet.allOf(Weapons.class).stream().toList());
//        list2.forEach(System.out::println);
//
//        System.out.println("-----");
//
//        Pirate tim = new Pirate("Tim");
//        System.out.println(tim);
//
//        PirateGame.getTowns(0).forEach(t -> System.out.println(t.information()));
//        System.out.println("-");
//        PirateGame.getTowns(1).forEach(t -> System.out.println(t.information()));

        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);

//        Town bridgetown = new Town("Brdgetown", "Barbados", 0);
//        System.out.println(bridgetown);
//        System.out.println(bridgetown.information());
    }
}
