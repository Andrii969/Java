public class systemConsole_video70 {

    public static void main(String[] args) {

        String currentYear = "2024";
        String usersDateOfBirth = "1999";

        System.out.println("Age = " + (Integer.parseInt(currentYear) - Integer.parseInt(usersDateOfBirth)));

        String usersAgeWithPartialYear = "22.5";
        double ageWithPartialYear = Double.parseDouble(usersAgeWithPartialYear);
        System.out.println("User's age with partial year = " + ageWithPartialYear);

    }

}
