package Game.PirateGame;

import Game.gameConsole.Game;
import Game.gameConsole.GameAction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PirateGame extends Game<PirateV2> {

    private static final List<List<Town>> levelMap;

    //------------------------------------------------------------
    static {
        levelMap = new ArrayList<>();
        System.out.println("Loading Data...");
        loadData();

        if (levelMap.size() == 0) {
            throw new RuntimeException("Could not load data, try later");
        }
        System.out.println("Finished Loading Data.");
    }
    //------------------------------------------------------------

    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public PirateV2 createNewPlayer(String name) {
        return new PirateV2(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        PirateV2 pirate = getPlayer(playerIndex);
        System.out.println(pirate);
        List<Weapon> weapons = Weapon.getWeaponsByLevel(pirate.value("level"));

        Map<Character, GameAction> map = new LinkedHashMap<>();
        if (pirate.hasOpponents()) {
            for (Weapon weapon : weapons) {
                char init = weapon.name().charAt(0);
                map.put(init, new GameAction(init, "Use " + weapon,
                        this::useWeapon));
            }
        }

        map.put('F', new GameAction('F', "Find Loot", this::findLoot));
        if (pirate.hasExperiences()) {
            map.put('X', new GameAction('X', "Experience Town Feature",
                    this::experienceFeature));
        }
        map.putAll(getStandardActions());
        return map;
    }

    private static void loadData() {

        // Level 1 Towns
        levelMap.add(new ArrayList<Town>(List.of(
                new Town("Bridgetown", "Barbados", 0),
                new Town("Fitts Village", "Barbados", 0),
                new Town("Holetown", "Barbados", 0)
        )));
        // Level 2 Towns
        levelMap.add(new ArrayList<Town>(List.of(
                new Town("Fort-de-France", "Martinique", 1),
                new Town("Sainte-Anne", "Martinique", 1),
                new Town("Le Vauclin", "Martinique", 1)
        )));
    }

    public static List<Town> getTowns(int level) {

        if (level <= (levelMap.size() - 1)) {
            return levelMap.get(level);
        }
        return null;
    }

    private boolean useWeapon(int playerIndex) {
        return getPlayer(playerIndex).useWeapon();
    }

    @Override
    public boolean executeGameAction(int player, GameAction action) {

        getPlayer(player).setCurrentWeapon(Weapon.getWeaponByChar(action.key()));
        return super.executeGameAction(player, action);
    }

    @Override
    public boolean printPlayer(int playerIndex) {

        System.out.println(getPlayer(playerIndex).information());
        return false;
    }

    private boolean findLoot(int playerIndex) {
        return getPlayer(playerIndex).findLoot();
    }

    private boolean experienceFeature(int playerIndex) {
        return getPlayer(playerIndex).experienceFeature();
    }
}
