package genericsPart3_2;

public record Affiliation(String name, String type, String countryCode) {

    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}
