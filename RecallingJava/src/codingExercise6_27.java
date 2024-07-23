public class codingExercise6_27 {

    public static void main(String[] args) {
        printSquareStar(2);
    }

    public static void printSquareStar (int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }

        for (int row = 1; row <= number; row++) {
            for (int column = 1; column <= number; column++) {
                boolean firstRowOrColumn = row == 1 || column == 1;
                boolean lastRowOrColumn = row == number || column == number;
                boolean diagonal = column == row || column == (number - row + 1);

                if (firstRowOrColumn || lastRowOrColumn || diagonal) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


}