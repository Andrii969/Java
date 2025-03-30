package JavaLangMath;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int maxMinusFive = Integer.MAX_VALUE - 5;
        for (int j = 0, id = maxMinusFive; j < 10; id++, j++) {
            System.out.printf("Assigning id %,d%n", id);
        }

        System.out.println("-".repeat(30));

//        for (int j = 0, id = maxMinusFive; j < 10; id = Math.incrementExact(id), j++) {
//            System.out.printf("Assigning id %,d%n", id); // integer overflow
//        }

        System.out.println("-".repeat(30));

        System.out.println(Math.abs(-50)); // 50
        System.out.println(Math.abs(Integer.MAX_VALUE)); // 2147483647
//        System.out.println(Math.absExact(Integer.MIN_VALUE)); // Overflow to represent absolute value of Integer.MIN_VALUE
        System.out.println(Math.abs((long) Integer.MIN_VALUE)); // 2147483648

        System.out.println("Max = " + Math.max(10, -10)); // Max = 10
        System.out.println("Min = " + Math.min(10.0000002, 10.001f)); // Min = 10.0000002

        System.out.println("Round Down = " + Math.round(10.2)); // Round Down = 10
        System.out.println("Round Up = " + Math.round(10.8)); // Round Up = 11
        System.out.println("Round ? = " + Math.round(10.5)); // Round ? = 11

        System.out.println("Floor = " + Math.floor(10.8)); // Floor = 10.0
        System.out.println("Ceil = " + Math.ceil(10.2)); // Ceil = 11.0

        System.out.println("Square root of 100 = " + Math.sqrt(100)); // Square root of 100 = 10.0
        System.out.println("2 to the third power (2*2*2) = " + Math.pow(2, 3)); // 2 to the third power (2*2*2) = 8.0
        System.out.println("10 to the fifth power (10*10*10*10*10)" + Math.pow(10, 5)); // 10 to the fifth power (10*10*10*10*10)100000.0

        for(int i = 0; i < 3; i++) {
            System.out.println(Math.random());
        }

        System.out.println("-".repeat(30));

        for(int i = 0; i < 3; i++) {
            System.out.println(Math.random() * 10);
        }

        System.out.println("-".repeat(30));

        for(int i = 0; i < 3; i++) {
            System.out.println((int) (Math.random() * 10) + 1);
        }

        System.out.println("-".repeat(30));
        Random random = new Random();

        for(int i = 0; i < 3; i++) {
            System.out.printf("%1$d = %1$c%n", random.nextInt(65, 91));
        }

        System.out.println("-".repeat(30));

        random.ints(10, 1, 10+1).forEach(System.out::println);
    }
}
