package RecordConstructors;

public class Main {

    public static void main(String[] args) {

//        Person jack = new Person("Jack", "12-12-1912");
//        System.out.println(jack);
//
//        Person jackCopy = new Person(jack);
//        System.out.println(jackCopy);

        PersonCanonicalConstructor p1 = new PersonCanonicalConstructor("  John Doe  ", "2000-01-01");
        System.out.println(p1); // Person[name=John Doe, dob=2000/01/01]

        // ---------------

        PersonCompactConstructor p2 = new PersonCompactConstructor("  Jane Smith  ", "1995-07-23");
        System.out.println(p2); // Person[name=Jane Smith, dob=1995/07/23]

        // ---------------

        PersonCustomConstructor original = new PersonCustomConstructor("Alice", "1980-12-01");
        PersonCustomConstructor copy = new PersonCustomConstructor(original); // Using custom constructor
        System.out.println(copy); // Person[name=Alice, dob=1980-12-01]

        PersonCustomConstructor p3 = new PersonCustomConstructor("Bob"); // Using another custom constructor
        System.out.println(p3); // Person[name=Bob, dob=Unknown]
    }
}
