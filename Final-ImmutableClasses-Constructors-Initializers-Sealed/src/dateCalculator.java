import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class dateCalculator {
    public static void main(String[] args) {
        final int days = 30;

        // Current time in UTC+0
        ZonedDateTime currentTimeUTC = ZonedDateTime.now(ZoneOffset.UTC);

        // Time 3 weeks ago in UTC+0
        ZonedDateTime calculatedTime = currentTimeUTC.minusDays(days);

        // Format the output as 2024-12-06T07:33:00+00:00
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        System.out.println("Current Time in UTC+0: " + currentTimeUTC.format(formatter));
        System.out.println("Time " + days + " Days Ago in UTC+0: " + calculatedTime.format(formatter));
    }
}
