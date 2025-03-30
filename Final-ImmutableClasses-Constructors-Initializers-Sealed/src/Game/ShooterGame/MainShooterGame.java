package Game.ShooterGame;

import Game.gameConsole.GameConsole;

public class MainShooterGame {

    public static void main(String[] args) {

        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));

        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
