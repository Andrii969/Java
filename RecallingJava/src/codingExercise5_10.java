public class codingExercise5_10 {
    public static void main(String[] args) {
        printYearsAndDays(56657657);
    }

    public static void printYearsAndDays (long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
            return;
        }
        long minutesInYear = 525600; // 60 * 24 * 365
        long minutesInDay = 1440; // 60 * 24
        long minutesInHour = 60; // 60

        long years = minutes / minutesInYear;
        long remainingMinutes = minutes % minutesInYear;
        long days = remainingMinutes / minutesInDay;
        remainingMinutes = remainingMinutes % minutesInDay;
        long hours = remainingMinutes / minutesInHour;
        long minutesLeft = remainingMinutes % minutesInHour;
        System.out.println(minutes + " min = " + years + " y and " + days + " d");
    }
}

//////// TASK DESCRIPTION
//Minutes To Years and Days Calculator
//Write a method printYearsAndDays with parameter of type long named minutes.
//The method should not return anything (void) and it needs to calculate the years and days from the minutes parameter.
//If the parameter is less than 0, print text "Invalid Value".
//Otherwise, if the parameter is valid then it needs to print a message in the format "XX min = YY y and ZZ d".
//XX represents the original value minutes.
//YY represents the calculated years.
//ZZ represents the calculated days.