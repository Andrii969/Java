package genericsPart3;

public record BaseballPlayer(String name, String position) implements Player {};
    // record can implement interfaces, but can't extend classes
