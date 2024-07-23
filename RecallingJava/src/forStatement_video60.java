public class forStatement_video60 {
    public static void main(String[] args) {
//        for (int i = 0; i < 9; i++) {
//            System.out.println(i);
//        }

        for (double interestRate = 7.5; interestRate <= 10; interestRate += 0.25) {
            double interestAmount = calculateInterest(100, interestRate);
            if (interestAmount > 9.5) {
                break;
            }
            System.out.println("100 at " + interestRate + "% interest = " +  interestAmount);
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return amount * (interestRate / 100);
    }
}
