package genericsPart3;

public record FootballPlayer(String name, String position) implements Player {};
    // record can implement interfaces, but can't extend classes
