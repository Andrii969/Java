public class whileStatement_video64 {

    public static void main(String[] args) {

        // 1st option
        for (int i=1; i<=5; i++) {
            System.out.println("i" + i);
        }

        // 2nd option
        int j = 1;
        while(j<=5) {
            System.out.println("j" + j);
            j++;
        }

        // 3rd option
        int k = 1;
        while(true) {
            if (k>5){
                break;
            }
            System.out.println("k" + k);
            k++;
        }

        // 4th option
        int h = 1;
        boolean isReady1 = false;
        do {
            if (h>5) {
                break;
            }
            System.out.println("h" + h);
            h++;
        } while (isReady1); // h1 > it's still executed one time

        // 5th option
        int g = 1;
        boolean isReady2 = false;
        do {
            if (g>5) {
                break;
            }
            System.out.println("g" + g);
            g++;
            isReady2 = (g>0);
        } while (isReady2);

//        // 6th option
//        int number = 0;
//        while (number < 50) {
//            number += 5;
//            System.out.print(number + "_");
//        } // 5_10_15_20_25_30_35_40_45_50_

        // 7th option
        int numberr = 0;
        while (numberr < 50) {
            numberr += 5;
            if (numberr % 25 == 0) {
                continue;
            }
            System.out.print(numberr + "_");
        } // 5_10_15_20_30_35_40_45_


    }

}
