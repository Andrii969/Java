package Game.ShooterGame;

import Game.gameConsole.Game;
import Game.gameConsole.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ShooterGame extends Game<Shooter> {

    private static final Scanner scanner = new Scanner(System.in);

    public ShooterGame(String gameName) {
        super(gameName);
    }

    @Override
    public Shooter createNewPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        var map = new LinkedHashMap<>(Map.of(
                'F',
                new GameAction('F', "Find Prize", this::findPrize),
                'S',
                new GameAction('S', "Use your weapon", this::useWeapon)
        ));
        map.putAll(getStandardActions());
        return map;
    }

    public boolean findPrize(int playerIndex) {
        return getPlayer(playerIndex).findPrize();
    }

    public boolean useWeapon(int playerIndex) {
        System.out.println("What weapon would you like to use?");
        String weapon = scanner.nextLine();
        return getPlayer(playerIndex).useWeapon(weapon);
    }
}
