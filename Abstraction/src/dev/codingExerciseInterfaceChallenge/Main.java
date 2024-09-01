package dev.codingExerciseInterfaceChallenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create a Player object
        Player player = new Player("Arthur", 100, 50);
        System.out.println(player);  // Display the player's initial state

        // Save the player's state
        List<String> savedPlayerState = player.write();

        // Modify the player's state
        player.setHitPoints(80);
        player.setWeapon("Axe");
        System.out.println("Modified Player: " + player);  // Display the player's modified state

        // Reload the player's state from the saved data
        player.read(savedPlayerState);
        System.out.println("Reloaded Player: " + player);  // Display the player's reloaded state

        // Create a Monster object
        Monster monster = new Monster("Goblin", 60, 20);
        System.out.println(monster);  // Display the monster's initial state

        // Save the monster's state
        List<String> savedMonsterState = monster.write();

        // Modify the monster's state
        monster.read(new ArrayList<>(List.of("Orc", "80", "30")));
        System.out.println("Modified Monster: " + monster);  // Display the monster's modified state

        // Reload the monster's state from the saved data
        monster.read(savedMonsterState);
        System.out.println("Reloaded Monster: " + monster);  // Display the monster's reloaded state
    }
}
