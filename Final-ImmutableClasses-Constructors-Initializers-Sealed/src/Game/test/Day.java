package Game.test;

public enum Day {
    MONDAY("Start of the work week"),
    TUESDAY("Second day"),
    WEDNESDAY("Midweek"),
    THURSDAY("Almost there"),
    FRIDAY("Last workday"),
    SATURDAY("Weekend begins"),
    SUNDAY("Rest day");

    private final String description;

    Day(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
