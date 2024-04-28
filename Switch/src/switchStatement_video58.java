public class switchStatement_video58 {

    public static void main(String[] args) {

        char letter = 'F';
        letter = 'A';

        switch (letter) {
            case 'A':
                System.out.println(letter + " means Able");
                break;
            case 'B':
                System.out.println(letter + " means Baker");
                break;
            case 'C':
                System.out.println(letter + " means Charlie");
                break;
            case 'D':
                System.out.println(letter + " means Dog");
                break;
            case 'E':
                System.out.println(letter + " means Easy");
                break;
            default:
                System.out.println(letter + " wasn't found");
                break;
        }


    }

}
