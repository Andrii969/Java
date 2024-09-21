package Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        record Person(String firstName, String lastname) {}

        List<Person> list = new ArrayList<>(List.of(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

        list.sort(((o1, o2) -> o1.lastname.compareTo(o2.lastname)));
        list.forEach(System.out::println);

        System.out.println("-".repeat(30));

        list.sort(Comparator.comparing(Person::lastname));
        list.forEach(System.out::println);

        System.out.println("-".repeat(30));

        list.sort(Comparator.comparing(Person::lastname).thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("-".repeat(30));

        list.sort(Comparator.comparing(Person::lastname).thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);

    }
}
