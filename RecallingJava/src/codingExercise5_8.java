public class codingExercise5_8 {
    public static void main(String[] args) {

    }
    public static boolean hasTeen (int first, int second, int third) {
        return isTeen(first) || isTeen(second) || isTeen(third);
    }
    public static boolean isTeen (int age) {
        return age >= 13 && age <= 19;
    }
}


//////// TASK DESCRIPTION
//Teen Number Checker
//We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
//Write a method named hasTeen with 3 parameters of type int.
//The method should return boolean and it needs to return true if one of the parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return false.
//Teen Number Checker
//We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
//Write a method named hasTeen with 3 parameters of type int.
//The method should return boolean and it needs to return true if one of the parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return false.
