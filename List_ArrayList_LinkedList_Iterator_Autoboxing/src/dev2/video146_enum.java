package dev2;

import java.util.Random;

public class video146_enum {


    public static void main(String[] args) {

        DayOfTheWeek weekDay = DayOfTheWeek.TUES;
        System.out.println(weekDay); // TUES

        System.out.printf("Names is %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal()); // Names is TUES, Ordinal Value = 1

        DayOfTheWeek randomWeekDay = getRandomDay();
        System.out.println(randomWeekDay);

        for (int i = 0; i < 5; i++) {
            randomWeekDay = getRandomDay();
            System.out.printf("Names is %s, Ordinal Value = %d%n", randomWeekDay, randomWeekDay.ordinal());
            if (randomWeekDay == DayOfTheWeek.FRI) {
                System.out.println("\u2191 Found a Friday"); // ↑ Found a Friday
            }
        }

        System.out.println("-".repeat(30));
        System.out.println(DayOfTheWeek.values().length + " days in a week");
        for (int i = 0; i < DayOfTheWeek.values().length; i++) {
            System.out.println(DayOfTheWeek.values()[i]);
        }


    }

    public static DayOfTheWeek getRandomDay() {

        int randomInteger = new Random().nextInt(7);
//        var allDays = DayOfTheWeek.values();
//        return allDays[randomInteger];
        return DayOfTheWeek.values()[randomInteger];
    }
}
