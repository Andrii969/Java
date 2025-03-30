package EnumConstructors;

public enum Generation {

    GEN_Z(2001, 2025),
    MILLENNIAL(1981, 2000),
    GEN_X(1965, 1980),
    BABY_BOOMER(1946, 1964),
    SILENT_GENERATION(1927, 1945),
    GREATEST_GENERATION(1901, 1926),;

    private final int startYear;
    private final int endYear;

    Generation(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
//        System.out.println(this); // all Enum values will be printed, once the enum is instantiated
    }

    public String getYears() {
        return startYear + " - " + endYear;
    }

    @Override
    public String toString() {
        return this.name() + " " +  startYear + " - " + endYear;
    }

    //    private final String description;

//    // All-args constructor
//    private Generation(String description) {
//        this.description = description;
//    }
//
//    // Getter for description
//    public String getDescription() {
//        return description;
//    }
}
