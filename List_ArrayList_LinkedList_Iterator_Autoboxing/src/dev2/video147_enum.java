package dev2;

import java.util.Random;

public class video147_enum {

    public static void main(String[] args) {

        DayOfTheWeek weekDay;
        for (int i = 0; i < 5; i++) {
            weekDay = getRandomWeekDay();
            switchDayOfWeek(weekDay);
        }
    }

    public static DayOfTheWeek getRandomWeekDay() {
        int randomInt = new Random().nextInt(7);
        return DayOfTheWeek.values()[randomInt];
    }

    public static void switchDayOfWeek (DayOfTheWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay) {
            case WED -> System.out.println("Wednesday is Day " + weekDayInteger);
            case SAT -> System.out.println("Saturday is Day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) + weekDay.name().substring(1).toLowerCase() + "day is Day " + weekDayInteger);
        }
    }
}
