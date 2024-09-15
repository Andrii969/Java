package LambdaIntroduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    record Person (String firstName, String lastName) {
        // Records are implicitly static, when used as an inner class, in the same way enums and interfaces are.
        // It means that I can access the record directly using Main's class name,
        // if I wanted to create instances of it, from outside this class

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Lucy", "Van Pelt"),
                // I could use the class qualifier to create a new person, because person is really
                // a static nested class of main (it's not required thought)
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")));

        // // // // // // // //

        var comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };

        people.sort(comparator);

        // // // // // // // //

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });

        // // // // // // // //

        people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName)); // replaced with lambda
        System.out.println(people);

        interface EnchancedComparator<T> extends Comparator<T> { // local generic interface (only to this method)
            int secondLevel(T o1, T o2);
            // interfaces inherit abstract methods. my new interface here, inherits the abstract method, compare,
            // that's on the Comparator interface. I could've implemented it in EnhancedComparator, but I didn't.
            // Remember, you don't have to implement abstract methods, when you extend interfaces.
            // This means there are now two abstract methods, on the EnhancedComparator, that concrete classes
            // have to implement, if they use this interface. I'll generate those two methods.
        }

        var comparatorMixed = new EnchancedComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName.compareTo(o2.lastName);
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };

        // // // // // // // //

        people.sort(comparatorMixed);
        System.out.println(people);
    }
}
// Now, let's say I want to turn this anonymous class, into a lambda expression? Well, I can't. This is because it's not
// technically a functional interface. When I say a functional interface can only have one abstract method,
// this means only one, and includes counting any inherited methods. Java can't determine which abstract method to use
// for this interface, so it can't be a target type for lambda expressions.
// Because this interface ultimately requires classes to implement two abstract methods.