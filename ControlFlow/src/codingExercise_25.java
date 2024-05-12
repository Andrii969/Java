public class codingExercise_25 {

    public static void main(String[] args) {

        System.out.println(canPack (2, 0, 9)); // should be false
        System.out.println(9 / 5);


    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        // Check if any input is negative
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false; // Can't have negative counts or goal
        }

        // Variable to hold the result
        boolean result = false;

        // Calculate total weight of big bags
        int totalBigWeight = bigCount * 5;

        // If total weight of big bags is sufficient to meet the goal
        if (totalBigWeight >= goal) {
            // Calculate the remaining amount needed after using big bags
            int remaining = goal % 5;
            // Check if small bags can fulfill the remaining amount
            if (smallCount >= remaining) {
                result = true; // Set result to true if possible
            }
        } else {
            // If total weight of big bags is insufficient
            // Check if small bags can fulfill the remaining amount needed after using big bags
            if (smallCount >= goal - totalBigWeight) {
                result = true; // Set result to true if possible
            }
        }
        return result; // Return the result
    }


}
