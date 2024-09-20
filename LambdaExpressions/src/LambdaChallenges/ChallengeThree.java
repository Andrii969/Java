package LambdaChallenges;

import java.util.function.UnaryOperator;

public class ChallengeThree {

    public static void main(String[] args) {

        UnaryOperator<String> everySecondChar = (source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        String testString = "1234567890";
        System.out.println(everySecondChar.apply(testString));



    }
}
