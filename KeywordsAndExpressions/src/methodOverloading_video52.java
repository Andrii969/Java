public class methodOverloading_video52 {

    public static void main(String[] args) {

        System.out.println(convertToCentimeters (12));

    }

    public static double convertToCentimeters (int feet, int inches) {
        int totalInches = feet * 12 + inches;
        return convertToCentimeters(totalInches);
    }

    public static double convertToCentimeters (int inches) {
        return inches * 2.54;
    }

}