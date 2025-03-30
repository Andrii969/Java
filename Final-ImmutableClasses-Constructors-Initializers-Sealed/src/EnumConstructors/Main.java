package EnumConstructors;

import static EnumConstructors.Generation.GEN_X;

public class Main {

    public static void main(String[] args) {

        System.out.println(GEN_X.getYears());

//        for (Generation generation : Generation.values()) {
//            System.out.println(generation + ": " + generation.getDescription());
//        }
    }
}
