package BigDecimal;

import java.math.BigDecimal;
import java.util.Arrays;

public class PrecisionAndScale {

    public static void main(String[] args) {

        double policyAmount = 100_100_000;
        int beneficiaries = 3;
        float percentageFloat = 1.0f / beneficiaries;
        double percentageDouble = 1.0/ beneficiaries;

        System.out.printf("Payout float = %,.2f%n", policyAmount * percentageFloat);
        System.out.printf("Payout double = %,.2f%n", policyAmount * percentageDouble);

        double totalUsingFloat = policyAmount - ((policyAmount * percentageFloat) * beneficiaries);
        System.out.printf("totalUsingFloat = %,.2f%n", totalUsingFloat);

        double totalUsingDouble = policyAmount - ((policyAmount * percentageDouble) * beneficiaries);
        System.out.printf("totalUsingDouble = %,.2f%n", totalUsingDouble);

        // ---------------------------------------------------------------

        String[] tests = {"15.456", "8", "10000.000001", ".123"}; // you should always use the String constructor,
                                                                  // to create a BigDecimal for a predictable value.
        BigDecimal[] bds = new BigDecimal[tests.length];
        Arrays.setAll(bds, i -> new BigDecimal(tests[i])); // Arrays.setAll(bds, BigDecimal::new);

        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
        } // Value: 15.456 / Unscaled Value: 15456 / Scale: 3 (digits after the decimal) / Precision: 5 (total digits: 1, 5, 4, 5, 6)

        System.out.println("---------------------------");


        double[] doubles = {15.456, 8, 10000.000001, .123};
        Arrays.setAll(bds, i -> BigDecimal.valueOf(doubles[i]));

        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

        System.out.println("---------------------------");

        BigDecimal test1 = new BigDecimal("1.1111122222333334444455555");
        BigDecimal test2 = BigDecimal.valueOf(1.1111122222333334444455555);

        System.out.printf("%-30s %-30s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");
        System.out.printf("%-30s %-30d %-8d %d %n", test1, test1.unscaledValue(), test1.scale(), test1.precision());
        System.out.printf("%-30s %-30d %-8d %d %n", test2, test2.unscaledValue(), test2.scale(), test2.precision());
    }
}
