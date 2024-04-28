public class operatorPrecedence_video39 {
    public static void main(String[] args) {
        double doubleStep1 = 20.00;
        double doubleStep2 = 80.00;
        double totalDouble = 100.00 * (doubleStep1 + doubleStep2);
        System.out.println("totalDouble value is: " + totalDouble);
        double remainder = totalDouble % 40.00;
        System.out.println("Remainder value is: " + remainder);
        boolean remainderIsZero = (remainder == 0.00) ? true : false;
        System.out.println("Remainder is zero: " + remainderIsZero);
        if (!remainderIsZero) {
            System.out.println("Got some remainder, that is " + remainder);
        }
    }
}
