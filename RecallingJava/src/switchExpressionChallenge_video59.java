public class switchExpressionChallenge_video59 {
    public static void main(String[] args) {
        printDayOfWeek(0);
        printDayWeek(9);
    }

    public static void printDayOfWeek(int day) {
        String dayOfTheWeek = switch (day) {
            case 0 -> {yield "Monday";}
            case 1 -> "Tuesday";
            case 2 -> "Wednesday";
            case 3 -> "Thursday";
            case 4 -> "Friday";
            case 5 -> "Saturday";
            case 6 -> "Sunday";
            default -> "not found";
        };
        System.out.println(dayOfTheWeek);
    };

    public static void printDayWeek(int day) {
        String dayOfTheWeek = "";
        if (day == 0) {
            dayOfTheWeek = "Monday";
        } else if (day == 1) {
            dayOfTheWeek = "Tuesday";
        } else if (day == 2) {
            dayOfTheWeek = "Wednesday";
        } else if (day == 3) {
            dayOfTheWeek = "Thursday";
        } else if (day == 4) {
            dayOfTheWeek = "Friday";
        } else if (day == 5) {
            dayOfTheWeek = "Saturday";
        } else if (day == 6) {
            dayOfTheWeek = "Sunday";
        } else {
            System.out.println(day + " not found");
            return;
        }
        System.out.println(dayOfTheWeek);
    }
}
