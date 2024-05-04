public class whileLoopChallenge2a_video65 {

    public static void main(String[] args) {

        int countEvenNumbers = 0;
        int countNotEvenNumbers = 0;
        int input = 5;
        while (input <= 20) {
            if (isEvenNumber(input)) {
                System.out.println("Even number: " + input);
                countEvenNumbers++;
            } else if (!isEvenNumber(input)) {
                System.out.println("Not even number: " + input);
                countNotEvenNumbers++;
            }
            if (countEvenNumbers == 5) {
                break;
            }
            input++;
        }
        System.out.println("The number of even numbers: " + countEvenNumbers);
        System.out.println("The number of not even numbers: " + countNotEvenNumbers);
    }

    public static boolean isEvenNumber (int input) {
        return input % 2 == 0 ? true : false;
    }

}
