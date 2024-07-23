public class codingExercise6_25 {

    public static void main(String[] args) {
        System.out.println(canPack(2, 5, 6));
        System.out.println(canPack(1, 5, 6));
    }

    public static boolean canPack (int bigCount, int smallCount, int goal) { // big = 5, small = 1
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        if (bigCount * 5 + smallCount < goal) {
            return false;
        }

        int bigBagsMax = goal / 5;
        int needSmallBags = goal - bigBagsMax * 5;
        return smallCount >= needSmallBags;
    }

//    == alternative ==
//    private static final int BIG_WEIGHT = 5;
//
//    public static boolean canPack(int bigCount, int smallCount, int goal) {
//
//        if (bigCount < 0 || smallCount < 0 || goal < 0) {
//            return false;
//        }
//
//        boolean result = false;
//        int totalBigWeight = bigCount * BIG_WEIGHT;
//        if (totalBigWeight >= goal) {
//            int remaining = goal % BIG_WEIGHT;
//            if (smallCount >= remaining) {
//                result = true;
//            }
//        } else {
//            if (smallCount >= goal - totalBigWeight) {
//                result = true;
//            }
//        }
//        return result;
//    }

}


////////// TASK DESCRIPTION
//Flour Pack Problem
//Write a method named canPack with three parameters of type int named bigCount, smallCount, and goal.
//The parameter bigCount represents the count of big flour bags (5 kilos each).
//The parameter smallCount represents the count of small flour bags (1 kilo each).
//The parameter goal represents the goal amount of kilos of flour needed to assemble a package.
//Therefore, the sum of the kilos of bigCount and smallCount must be at least equal to the value of goal. The method should return true if it is possible to make a package with goal kilos of flour.
//If the sum is greater than goal, ensure that only full bags are used towards the goal amount. For example, if goal = 9, bigCount = 2, and smallCount = 0, the method should return false since each big bag is 5 kilos and cannot be divided. However, if goal = 9, bigCount = 1, and smallCount = 5, the method should return true because of 1 full bigCount bag and 4 full smallCount bags equal goal, and it's okay if there are additional bags left over.
//If any of the parameters are negative, return false.

