package genericsPart3_2;

public record BaseballPlayer(String name, String position) implements Player {}; // -> implements abstract method 'name()' in 'Player'
    // record can implement interfaces, but can't extend classes