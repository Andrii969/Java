public class codingExercise5_12 {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 10));
    }
    public static boolean isCatPlaying (boolean summer, int temperature) {
        if (summer && temperature >= 25 && temperature <= 45) {
            return true;
        } else if (!summer && temperature >= 25 && temperature <= 35) {
            return true;
        } else {
            return false;
        }
    }
}


//// IMPROVED VERSION
//public static boolean isCatPlaying(boolean summer, int temperature) {
//    int max = summer ? 45 : 35;
//    return temperature >= 25 && temperature <= max;
//}

//////// TASK DESCRIPTION
// Playing Cat
//The cats spend most of the day playing. In particular, they play if the temperature is between 25 and 35 (inclusive). Unless it is summer, then the upper limit is 45 (inclusive) instead of 35.
//Write a method isCatPlaying that has 2 parameters. Method needs to return true if the cat is playing, otherwise return false
