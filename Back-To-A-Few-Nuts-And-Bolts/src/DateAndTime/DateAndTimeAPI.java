package DateAndTime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import static java.time.Month.MAY;

public class DateAndTimeAPI {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate five5 = LocalDate.of(2022, 5, 5);
        System.out.println(five5);

        LocalDate may5th = LocalDate.of(2022, MAY, 5);
        System.out.println(may5th);

        LocalDate day125 = LocalDate.ofYearDay(2022, 125);
        System.out.println(day125);

        LocalDate may5 = LocalDate.parse("2022-05-05");
        System.out.println(may5);

        System.out.println("getYear = " + may5.getYear());
        System.out.println("getMonth = " + may5.getMonth());
        System.out.println("getMonthValue = " + may5.getMonthValue());
        System.out.println("getDayOfMonth = " + may5.getDayOfMonth());
        System.out.println("getDayOfWeek = " + may5.getDayOfWeek());
        System.out.println("getDayOfYear = " + may5.getDayOfYear());

        System.out.println();

        System.out.println("get(ChronoField.YEAR) = " + may5.get(ChronoField.YEAR));
        System.out.println("get(ChronoField.MONTH_OF_YEAR) = " + may5.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("get(ChronoField.DAY_OF_MONTH) = " + may5.get(ChronoField.DAY_OF_MONTH));
        System.out.println("get(ChronoField.DAY_OF_YEAR) = " + may5.get(ChronoField.DAY_OF_YEAR));

        System.out.println();

        System.out.println("may5.withYear(2000) = " + may5.withYear(2000));
        System.out.println("may5.withMonth(3) = " + may5.withMonth(3));
        System.out.println("may5.withDayOfMonth(4) = " + may5.withDayOfMonth(4));
        System.out.println("may5.withDayOfYear(126) = " + may5.withDayOfYear(126));
        System.out.println("may5.with(ChronoField.DAY_OF_YEAR, 126) = " + may5.with(ChronoField.DAY_OF_YEAR, 126));
        System.out.println("may5 = " + may5);

        System.out.println();

        System.out.println("may5.plusYears(1) = " + may5.plusYears(1));
        System.out.println("may5.plusMonths(12) = " + may5.plusMonths(12));
        System.out.println("may5.plusDays(365) = " + may5.plusDays(365));
        System.out.println("may5.plusWeeks(52) = " + may5.plusWeeks(52));

        System.out.println();

        System.out.println("may5 > today?: " + may5.isAfter(today));
        System.out.println("may5 < today?: " + may5.isBefore(today));
        System.out.println("may5 > today?: " + may5.compareTo(today));
        System.out.println("may5 < today?: " + today.compareTo(may5));
        System.out.println("today == now: " + today.compareTo(LocalDate.now()));
        System.out.println("today == now: " + today.equals(LocalDate.now()));
        System.out.println("may2022IsLeapYear?: " + may5.isLeapYear());
        System.out.println("may2020IsLeapYear?: " + may5.minusYears(2).isLeapYear());

    }
}
