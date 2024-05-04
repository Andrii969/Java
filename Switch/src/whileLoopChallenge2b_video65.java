public class whileLoopChallenge2b_video65 {

    public static void main(String[] args) {

        int countEvenNumbers = 0;
        int countOddNumbers = 0;

        int input = 4;
        while (input <= 20) {
            input++;
            if (!isEvenNumber(input)) {
                System.out.println("Odd number: " + input);
                countOddNumbers++;
                continue;
            }
            System.out.println("Even number: " + input);
            countEvenNumbers++;

            if (countEvenNumbers >= 5) {
                break;
            }
        }

        System.out.println("The number of even numbers: " + countEvenNumbers);
        System.out.println("The number of odd numbers: " + countOddNumbers);
    }

    public static boolean isEvenNumber (int input) {
        return input % 2 == 0 ? true : false;
    }

}
