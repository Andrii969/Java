public class traditionalSwitchChallenge_video58 {
    public static void main(String[] args) {
        natoAlphabet('L'); // char should be in the single quotes
    }

    public static void natoAlphabet (char charValue) {
        switch (charValue) {
            case 'A':
                System.out.println("A is Able");
                break;
            case 'B':
                System.out.println("B is Baker");
                break;
            case 'C':
                System.out.println("C is Charlie");
                break;
            case 'D':
                System.out.println("D is Dog");
                break;
            case 'E':
                System.out.println("E is Easy");
                break;
            default:
                System.out.println("Letter " + charValue + " was not found.");
                break;
        }
    }
}
