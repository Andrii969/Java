package LambdaChallenges;

import java.util.function.Supplier;

public class ChallengeFive {

    public static void main(String[] args) {

        Supplier<String> iLoveJavaSupplier = () -> "I love Java";

        String iLoveJava = iLoveJavaSupplier.get();
        System.out.println(iLoveJava);

        // // // // // // // // // // // // // //

        Supplier<String> iLoveJavaSupplier2 = () -> {
            return "I love Java";
        };

        String iLoveJava2 = iLoveJavaSupplier2.get();
        System.out.println(iLoveJava2);

        // // // // // // // // // // // // // //

        System.out.println(iLoveJavaSupplier.get());

        System.out.println(iLoveJavaSupplier2.get());


    }
}
