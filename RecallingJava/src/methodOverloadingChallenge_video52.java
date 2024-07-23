public class methodOverloadingChallenge_video52 {
    public static void main(String[] args) {
        System.out.println("5ft, 8in = " + convertToCentimeters(5, 8) + " cm");
        System.out.println("68in = " + convertToCentimeters(68) + " cm");
    }

    public static double convertToCentimeters(int inches) {
        if (inches < 0) {
            return -1;
        }
        return inches * 2.54;
    }

    public static double convertToCentimeters(int feet, int inches) {
        if (feet < 0 || inches < 0) {
            return -1;
        }
        int feetToInches = feet * 12;
        int totalInches = feetToInches + inches;
        double result = convertToCentimeters(totalInches);
        return result;
    }
}