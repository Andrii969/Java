public class ternaryOperator_video38 {
    public static void main(String[] args) {
        String makeOfCar = "Wolkswagen";
        boolean isDomestic = makeOfCar == "Wolkswagen" ? false : true;
// Basically what we're saying here is, If the condition returns true,
// we assign the value after the question mark,
// to the variable on the left side of the equals sign.
        if (isDomestic) {
            System.out.println("This car is domestic");
        }

        String s = (isDomestic) ? "This car is domestic" : "This car is not domestic";
        // if statement is true -> is domestic, if false -> is not domestic
        System.out.println(s);

        int ageOfClient = 19;
        String ageText = ageOfClient >= 18 ? "adult" : "still a kid";
        System.out.println("Our client is " + ageText);
    }
}
