public class secondsAndMinutesChallenge_video53 {
    public static void main(String[] args) {
        System.out.println(getDurationString(4543));
        System.out.println(getDurationString(343, 58));
    }

    public static String getDurationString (int seconds) {
        if (seconds < 0) {
            return "Invalid value for seconds (" + seconds + "), must be a positive integer.";
        }
        int hours = seconds / 3600;
        int remainingMinutes = seconds % 3600;
        int minutes = remainingMinutes / 60;
        int secondsLeft = remainingMinutes % 60;
        return hours + "h " + minutes + "m " + secondsLeft + "s";
    }

    // ANOTHER APPROACH
    // int minutes = seconds / 60;
    // int hours = minutes / 60;
    // int remainingMinutes = minutes % 60;
    // int remainingSeconds = seconds % 60;

    public static String getDurationString (int minutes, int seconds) {
        if (minutes < 0) {
            return "Invalid value for minutes (" + minutes + "), must be a positive integer.";
        }
        if (seconds < 0 || seconds > 59) {
            return "Invalid value for seconds (" + seconds + "), must be between 0 and 59.";
        }

        int totalSeconds = minutes * 60 + seconds;
        return getDurationString(totalSeconds);
    }
}