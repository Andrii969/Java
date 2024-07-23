public class switchStatementV2_video57 {
    public static void main(String[] args) {
        System.out.println(getQuarter("JANUARY"));
    }
    public static String getQuarter (String month) {
        return switch (month.toLowerCase()) {
            case "january", "february", "march" -> "1st"; // one more example: -> { yield "1st"; }
            case "april", "may", "june" -> "2nd";
            case "july", "august", "september" -> "3rd";
            case "october", "november", "december" -> "4th";
            default -> {
                yield month + " is bad"; // here the 'yield' instead of 'return'
            }
    };
}
}
