public class secondClass {
    public static void main(String[] args) {

        boolean isAlien = false;
        if (!isAlien) {
            System.out.println("It's not an alien!");
        }

        int topScore = 80;
        if (topScore >= 100) {
            System.out.println("You got a high score!");
        }
        if (topScore > 50 && topScore < 100) {
            System.out.println("You got quite a good score!");
        }

        String makeOfCar = "Audi";
//        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true; // OR: boolean isDomestic = (makeOfCar != "Volkswagen");
//        if (isDomestic) {
//            System.out.println("This car is domestic is our country.");
//        }
        boolean isDomestic = (makeOfCar != "Volkswagen");
        String s = (isDomestic) ? "This car is domestic" : "This car is not domestic";
        System.out.println(s);

        int ageOfClient = 20;
        String ageText = ageOfClient >= 18 ? "over eighteen" : "still a kid";
        System.out.println("Our client is " + ageText);

    }
}
