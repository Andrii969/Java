package MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class PlainOld {

    private static int last_id = 1;
    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object; id = " + id);
    }

    @Override
    public String toString() {
        return "PlainOld{" +
                "id=" + id +
                '}';
    }
}

public class MethodReference {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));

        list.forEach((s) -> System.out.println(s)); // lambda
        list.forEach(System.out::println); // method reference

        calculator((a, b) -> a + b, "Hello ", "World!"); // lambda
        calculator((a, b) -> a + b, 10, 25); // lambda

        calculator(Integer::sum, 10, 25); // method reference
        calculator(Double::sum, 10.1, 25.9); // method reference

        Supplier<PlainOld> reference1 = () -> new PlainOld(); // lambda
        var object1 = reference1.get();
        System.out.println(object1);

        Supplier<PlainOld> reference2 = PlainOld::new; // method reference
        var object2 = reference2.get();
        System.out.println(object2);

        System.out.println("-".repeat(20));

        PlainOld[] array = seedArray(() -> new PlainOld(), 5); // lambda

        System.out.println("-".repeat(20));

        PlainOld[] array1 = seedArray(PlainOld::new, 5); // method reference



    }

    public static <T> void calculator(BinaryOperator<T> bioperator, T value1, T value2) {
        T result = bioperator.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> supplier, int count) {
        PlainOld[] array = new PlainOld[count];
//        for (int i = 0; i <= count; i++) {
//            array[i] = supplier.get();
//        }
        Arrays.setAll(array, i -> supplier.get());
        return array;
    }
}
