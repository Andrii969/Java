package LambdaChallenges;

import java.util.Arrays;
import java.util.function.Consumer;

public class ChallengeOne {

    public static void main(String[] args) {

        Consumer<String> printWords1 = new Consumer<String>() { // VOID
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        printWords1.accept("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        System.out.println("-".repeat(30));

        // // // // // // // // // // // // // // //

        Consumer<String> printWords2 = (sentence) -> { // VOID
            String[] words = sentence.split(" ");
            for (String word : words) {
                System.out.println(word);
            }
        };

        printWords2.accept("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        System.out.println("-".repeat(30));

        // // // // // // // // // // // // // // //

        Consumer<String> printWords3 = (sentence) -> { // VOID
            String[] words = sentence.split(" ");
            Arrays.asList(words).forEach((w) -> System.out.println(w));
        };

        printWords3.accept("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        System.out.println("-".repeat(30));

        // // // // // // // // // // // // // // //

        Consumer<String> printWords4 = (sentence) -> { // VOID
            Arrays.asList(sentence.split(" ")).forEach((w) -> System.out.println(w));
        };

        printWords4.accept("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        System.out.println("-".repeat(30));
    }
}
