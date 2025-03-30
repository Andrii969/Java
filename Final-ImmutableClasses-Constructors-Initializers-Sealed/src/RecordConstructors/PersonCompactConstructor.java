package RecordConstructors;

public record PersonCompactConstructor(String name, String dob) {

    public PersonCompactConstructor {
        name = name.trim();
        dob = dob.replace('-', '/');
    }
}
