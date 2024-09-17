package FunctionalInterfacesFunctionSupplier;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        var list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        System.out.println(list);

//        var doubles = List.of(new double[]{12.2, 232.1}, new double[]{232.2, 233.2});
//        doubles.forEach((d) -> System.out.println(Arrays.toString(d)));
//
//        double[][] doubles1 = new double[4][];
//        doubles1[0] = new double[]{12.23, 232.23};
//        System.out.println(Arrays.deepToString(doubles1));

        list.replaceAll((s) -> s.charAt(0) + " - " + s.toUpperCase());
        // This method uses ListIterator, because for each element, it's going to call the set method, replacing the current element
        // in the iterator with a different value, the value that gets returned from the apply method. This should remind you that the
        // ListIterator gives us this option, meaning using set, which the Iterator by itself doesn't, because it only supports removing elements.
        list.forEach((s) -> System.out.println(s));
        // alternatively
        // List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
        //        System.out.println(list);
        //        Iterator<String> iterator = list.iterator();
        //        while (iterator.hasNext()) {
        //            String s = iterator.next();
        //            // Create the new value
        //            String newValue = s.charAt(0) + " - " + s.toUpperCase();
        //            // Remove the old value
        //            iterator.remove();
        //            // Add the new value (or use another list to store modified values and then replace)
        //            list.add(newValue);
        //        }
        //        System.out.println(list);
        //    }

        String[] emptyStrings = new String[10];

        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (s) -> "" + (s + 1) + ". ");
        // Arrays.setAll updates each element of the array by applying the provided lambda expression (s) -> "" + (s + 1) + ". ".
        // Here, s represents the index of the element in the array.
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (s) -> "" + (s + 1) + ". " + switch (s) {
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            default -> "";
        });
        System.out.println(Arrays.toString(emptyStrings));


        System.out.println("-".repeat(30));
        Random random = new Random();
        String[] values = {"Andy", "Amanda", "Merry", "Jesica", "Jenny"};
        String[] randomStrings = randomlySelectedValues(3, values, () -> random.nextInt(0, values.length));
        System.out.println(Arrays.toString(randomStrings));

//        var randomSupplier = (Supplier<Integer>) () -> random.nextInt(0, values.length); // Chat's GPT example
//        String[] randomStrings1 = randomlySelectedValues(3, values, randomSupplier);
//        System.out.println(Arrays.toString(randomStrings1));


        Supplier<String> randomName = () -> values[random.nextInt(0, values.length)]; // similar example
        System.out.println(randomName.get());
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    };
}
