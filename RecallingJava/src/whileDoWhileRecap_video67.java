public class whileDoWhileRecap_video67 {
    public static void main(String[] args) {
     int number = 0;
     while (number < 15) {
         number++;
         if (number <= 5) {
             System.out.println("Skipping the number " + number);
             continue;
         }

         System.out.println("Number = " + number);

         if (number >= 10) {
             System.out.println("Breaking at the number " + number);
             break;
         }
     }
    }
}
