package Randomization;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

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
