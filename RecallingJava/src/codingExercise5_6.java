public class codingExercise5_6 {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(3.1756, 3.175));
    }

    public static boolean areEqualByThreeDecimalPlaces (double first, double second) {
        long firstRounded = (long) (1000 * first);
        long secondRounded = (long) (1000 * second);
        return firstRounded == secondRounded;
    }
}


//////// TASK DESCRIPTION
//DecimalComparator
//Write a method areEqualByThreeDecimalPlaces with two parameters of type double.
//The method should return boolean and it needs to return true if two double numbers are the same up to three decimal places. Otherwise, return false.
