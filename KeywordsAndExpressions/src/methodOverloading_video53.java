public class methodOverloading_video53 {

    public static void main(String[] args) {

        System.out.println(getDurationString(-3945));
        System.out.println(getDurationString(-878, 40 ));
        System.out.println(getDurationString(878, 60 ));

    }

    public static String getDurationString(int seconds) {

        int minutes;

        if (seconds < 0) {
            return "Time can't be negative: " + seconds;
        } else {
            minutes = seconds / 60; // get minutes from seconds
            seconds = seconds % 60; // get rest of seconds

            return getDurationString(minutes,seconds);
        }
    }

    public static String getDurationString(int minutes, int seconds) {

        int hours;

        if (minutes < 0 || seconds < 0) {
            return "Time can't be negative: " + minutes + "m " + seconds + "s";
        } else if (seconds > 59) {
            return "Seconds value can't exceed 59 seconds";
        } else {
            hours = minutes / 60; // get hours from minutes
            minutes = minutes % 60; // get rest of minutes
            return hours + "h " + minutes + "m " + seconds + "s ";
        }
    }
}
