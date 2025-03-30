package RecordConstructors;

// for a record, the fields are final, the constructor is inserted by a compiler
public record PersonCanonicalConstructor(String name, String dob) {

    public PersonCanonicalConstructor(String name, String dob) {
        this.name = name.trim();
        this.dob = dob.replace('-', '/');
    }
}
