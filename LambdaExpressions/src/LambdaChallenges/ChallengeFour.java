package LambdaChallenges;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChallengeFour {

    public static void main(String[] args) {


        UnaryOperator<String> everySecondCharacter = (source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharacter.apply("1234567890"));


        // // // // // // // // // // // // // // // // // // // // //

        String modifiedString2 = everySecondCharacter2("1234567890", (s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        });

        System.out.println(modifiedString2);

        // // // // // // // // // // // // // // // // // // // // //

        String modifiedString3 = everySecondCharacter3("1234567890", (s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        });

        System.out.println(modifiedString3);

        // // // // // // // // // // // // // // // // // // // // //

        String modifiedString4 = everySecondCharacter3("1234567890", everySecondCharacter);

        System.out.println(modifiedString4);

    }

    public static String everySecondCharacter2(String string, UnaryOperator<String> unaryOperator) {
        return unaryOperator.apply(string);
    };

    public static String everySecondCharacter3(String string, Function<String, String> function) {
        return function.apply(string);
    };
}
