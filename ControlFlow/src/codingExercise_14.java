public class codingExercise_14 {

    public static void main(String[] args) {

        System.out.println(isLeapYear(2000));
        System.out.println(getDaysInMonth(1, -2020));

    }

    public static boolean isLeapYear (int year) {

        return (year >= 1 && year <= 9999)
                && (year % 4 == 0)
                && (year % 100 != 0 || year % 400 == 0);
        }

    public static int getDaysInMonth (int month, int year) {

        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        } else {
           return switch (month) {
               case 9, 4, 6, 11 -> 30;
               case 1, 3, 5, 7, 8, 10, 12 -> 31;
               case 2 -> {
                   yield isLeapYear(year) ? 29 : 28;
               }
               // OR case 2 -> isLeapYear(year) ? 29 : 28;
               default -> -1;
            };

        }
    }
}
