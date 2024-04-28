public class exercise1_section5 {

    public static void main(String[] args) {

        System.out.println(hasTeen(20, 11, 10));

    }

    public static boolean hasTeen (int numberOne, int numberTwo, int numberThree) {
        return (isTeen(numberOne) || isTeen(numberTwo) || isTeen(numberThree));
    }

    public static boolean isTeen (int number) {
        return (number >= 13 && number <= 19);
    }


}