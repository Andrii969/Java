package LambdaChallenges;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChallengeTwo {

    public static void main(String[] args) {

        System.out.println(everySecondChar("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));

        // // // // // // // // // // // //

        Consumer<String> printEverySecondChar = (string) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(string.charAt(i));
                }
            }
            ;
            System.out.println(returnVal);
        };

        printEverySecondChar.accept("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");

        // // // // // // // // // // // //

        Function<String, String> everySecondChar = (sentence) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < sentence.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(sentence.charAt(i));
                }
            }
            ;
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));

        // // // // // // // // // // // //

        UnaryOperator<String> everySecondChar2 = (sentence) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < sentence.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(sentence.charAt(i));
                }
            }
            ;
            return returnVal.toString();
        };

        System.out.println(everySecondChar2.apply("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));

    };

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        ;
        return returnVal.toString();
    }

    ;
}
