public class switchStatement_video57 {
    public static void main(String[] args) {
        System.out.println(getQuarter("January"));
    }
    public static String getQuarter (String month) {
        switch (month.toLowerCase()) {
            case "january":
            case "february":
            case "march":
                return "1st";
            case "april":
            case "may":
            case "june":
                return "2nd";
            case "july":
            case "august":
            case "september":
                return "3rd";
            case "october":
            case "november":
            case "december":
                return "4th";
        }
        return month + " is bad";
    }
}
