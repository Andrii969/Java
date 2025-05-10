package DateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeAndLocalDateTime {

    public static void main(String[] args) {

        LocalDate may5 = LocalDate.of(2022, 5, 5);

        may5.datesUntil(may5.plusDays(7)).forEach(System.out::println);
        System.out.println();
        may5.datesUntil(may5.plusMonths(1), Period.ofWeeks(1)).forEach(System.out::println);
        System.out.println();

        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime sevenAM = LocalTime.of(7, 0);
        System.out.println(sevenAM);
        System.out.println("sevenAM.get(ChronoField.AMPM_OF_DAY) = " + sevenAM.get(ChronoField.AMPM_OF_DAY));
        LocalTime sevenThirtyAM = LocalTime.of(7, 30, 15);
        System.out.println(sevenThirtyAM);
        LocalTime sevenPM = LocalTime.parse("19:00");
        System.out.println(sevenPM);
        System.out.println("sevenPM.get(ChronoField.AMPM_OF_DAY) = " + sevenPM.get(ChronoField.AMPM_OF_DAY));
        LocalTime sevenThirtyPM = LocalTime.parse("19:30:15.1000");
        System.out.println(sevenThirtyPM);
        System.out.println();

        System.out.println(sevenThirtyPM.getHour()); // 19
        System.out.println(sevenThirtyPM.get(ChronoField.HOUR_OF_DAY)); // 19

//        System.out.println(sevenThirtyPM.plus(1, ChronoUnit.DAYS)); // Exception: Unsupported unit: Days
        System.out.println(sevenThirtyPM.plus(1, ChronoUnit.HOURS)); // 20:30:15.100
        System.out.println(sevenThirtyPM.plusHours(1)); // 20:30:15.100
        System.out.println();

        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println(localDateTimeNow);

        LocalDateTime may6Noon = LocalDateTime.of(2022, 5, 6, 12, 0, 0);
        System.out.println(may6Noon);
        System.out.printf("%tD %tr %n", may6Noon, may6Noon);
        System.out.printf("%1$tF %1$tT %n", may6Noon);
        System.out.println(may6Noon.format(DateTimeFormatter.ISO_WEEK_DATE));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(may6Noon.format(dateTimeFormatter));
        System.out.println(may6Noon.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

        LocalDateTime may7Noon = may6Noon.plusHours(24);
        System.out.println(may7Noon.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));











    }
}
