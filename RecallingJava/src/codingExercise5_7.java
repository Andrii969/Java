public class codingExercise5_7 {
    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, -1, 0));
    }
    public static boolean hasEqualSum (int first, int second, int third) {
        return first + second == third;
    }
}

//////// TASK DESCRIPTION
//Equal Sum Checker
//Write a method hasEqualSum with 3 parameters of type int.
//The method should return boolean and it needs to return true if the sum of the first and second parameter is equal to the third parameter. Otherwise, return false.
