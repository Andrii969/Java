public class switchStatement_video56 {

    public static void main(String[] args) {

        int switchValue = 3;

        switch(switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value was 3, or 4, or 5");
                System.out.println("Actually it was a " + switchValue);
                break;
            default:
                System.out.println("another");
                break;
        }

    }

}