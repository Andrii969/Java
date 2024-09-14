package LambdaIntroduction;

import java.util.ArrayList;
import java.util.Arrays;
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

    }
}
