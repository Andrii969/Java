public class switchStatement_video57 {

    public static void main(String[] args) {

        String month = "notExisting";
        System.out.println(getQuarter(month));

    }

        public static String getQuarter (String month) {

            return switch (month) {
                case "January", "February", "March" -> month + " is in the 1st quarter";
                case "April", "May", "June" -> month + " is in the 2nd quarter";
                case "July", "August", "September" -> month + " is in the 3rd quarter";
                case "October", "November", "December" -> month + " is in the 4th quarter";
                default -> {
                    String badResponse = month + " is an invalid month name";
                    yield badResponse;
                }
            };
    }
}
