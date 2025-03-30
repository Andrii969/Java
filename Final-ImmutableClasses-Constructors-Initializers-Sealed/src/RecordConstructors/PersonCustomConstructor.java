package RecordConstructors;

public record PersonCustomConstructor(String name, String dob) {

    // Custom constructor copying another Person object
    public PersonCustomConstructor(PersonCustomConstructor other) {
        this(other.name, other.dob);
    }

    // Another custom constructor
    public PersonCustomConstructor(String name) {
        this(name, "Unknown");
    }
}
