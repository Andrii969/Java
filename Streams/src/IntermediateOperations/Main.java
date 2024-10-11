package IntermediateOperations;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic) // A B C D E F G H I J K L M N O P Q R S T U V W X Y Z a b c d e f g h i j k l m n o p q r s t u v w x y z
                .filter(i -> Character.toUpperCase(i) > 'E') // F G H I J K L M N O P Q R S T U V W X Y Z f g h i j k l m n o p q r s t u v w x y z
                .skip(5) // K L M N O P Q R S T U V W X Y Z f g h i j k l m n o p q r s t u v w x y z
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println();
        System.out.println("-".repeat(30));

        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .dropWhile(i -> i <= 'E') // happens until the predicate becomes false the first time, and then that condition is no longer checked
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println();
        System.out.println("-".repeat(30));

        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .takeWhile(i -> i <= 'E')
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println();
        System.out.println("-".repeat(30));

        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println();
        System.out.println("-".repeat(30));

        Random random = new Random();
        Stream.generate(() -> random.nextInt((int) 'A', (int) 'Z')) // Supplier takes no args and generates value
                .limit(50)
//                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));
    }
}
