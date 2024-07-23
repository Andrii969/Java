public class operatorPrecendence_video38 {

    public static void main(String[] args) {
        double firstDouble = 20;
        double secondDouble = 80;
        double thirdDouble = 100 * (firstDouble + secondDouble);
        double getRemainder = thirdDouble % 40;
        boolean b = (getRemainder == 0);
        System.out.println(b);
        String s = (b) ? "no remainder" : "got some remainder";
        System.out.println(s);
    }
}
