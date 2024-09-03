package genericsPart2_1;

public record BaseballPlayer(String name, String position) implements Player {};
    // record can implement interfaces, but can't extend classes
