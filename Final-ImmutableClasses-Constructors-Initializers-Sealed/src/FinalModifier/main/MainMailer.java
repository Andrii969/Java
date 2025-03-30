package FinalModifier.main;

import java.util.*;

public class MainMailer {

    public static void main(String[] args) {

        String[] names = {"Ann Jones", "Ann Jones Ph.D.", "Bob Jones M.D.", "Carol Jones", "Ed Green Ph.D.", "Ed Green M.D.", "Ed Black"};
        List<StringBuilder> population = getNames(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(n -> {
            counts.merge(n, 1, Integer::sum);
            // This lets me add a new name with a value of 1, if it's a name not yet in the map, or
            // increment the value that's already in the map, if it is there.

            // Equivalent logic without merge
//            if (counts.containsKey(n)) {
//                counts.put(n, counts.get(n) + 1);
//            } else {
//                counts.put(n, 1);
//            }
        });
        counts.forEach((k, v) -> System.out.println(k + " - " + v));

        StringBuilder annJonesPhd = new StringBuilder("Ann Jones Ph.D.");
        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);

        List<StringBuilder> cleanedNames = standardizeNames(population);
        System.out.println(cleanedNames);
        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);
        // A change to one variable in any collection, will change that instance in memory.
        // If that instance's a key to a mapped collection, you get into this ugly situation.
        // This is why you should use an immutable object for keys in a map, so that this never happens.
    }

    private static List<StringBuilder> getNames(String[] names) {
        List <StringBuilder> list = new ArrayList<>();
        int index = 3;
        for (String name : names) {
            for (int i = 0; i <= index; i++) {
                list.add(new StringBuilder(name));
            }
            index++;
        }
        return list;
    }

    private static List<StringBuilder> standardizeNames(List<StringBuilder> list) {

        List<StringBuilder> newList = new ArrayList<>();
        for (var name : list) {
            for (String suffix : new String[]{"Ph.D.", "M.D."}) {
                int startIndex = -1;
                if ((startIndex = name.indexOf(suffix)) > -1) {
                    name.replace(startIndex - 1, startIndex + suffix.length(), "");
                }
            }
            newList.add(name);
        }
        return newList;
    }
}
