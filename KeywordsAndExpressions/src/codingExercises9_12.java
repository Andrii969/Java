public class codingExercises9_12 {

    public static void main(String[] args) {

        System.out.println(isCatPlaying(true, 36));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));

    }

    public static boolean isCatPlaying(boolean summer, int temperature) {

        int max = summer ? 45 : 35;
        return temperature >= 25 && temperature <= max;
    }
}
