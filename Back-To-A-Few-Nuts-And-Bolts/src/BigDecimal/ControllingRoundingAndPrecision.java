package BigDecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class ControllingRoundingAndPrecision {

    public static void main(String[] args) {

        BigDecimal[] bds = new BigDecimal[4];
        double[] doubles = {15.456, 8, 10000.000001, .123};
        Arrays.setAll(bds, i -> BigDecimal.valueOf(doubles[i])); // use valueOf

        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
            bd.setScale(2, RoundingMode.HALF_UP); // doesn't change the instance, need to reassign
        }
        // almost every method you use on BigDecimal, will need to be assigned to some variable.
        System.out.println("-".repeat(30));
        for (var bd : bds) {
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.printf("%-15s %-15d %-8d %d %n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

        System.out.println("-".repeat(30));
        BigDecimal policyPayout = new BigDecimal(BigInteger.valueOf(100_000_000));
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");
        System.out.printf("%-15s %-15d %-8d %d %n", policyPayout, policyPayout.unscaledValue(), policyPayout.scale(), policyPayout.precision());

        System.out.println("-".repeat(30));
        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(3), MathContext.DECIMAL32);
        System.out.println(percent);
        BigDecimal customPercent = BigDecimal.ONE.divide(BigDecimal.valueOf(3), new MathContext(60, RoundingMode.UP));
        System.out.println(customPercent);


    }
}
