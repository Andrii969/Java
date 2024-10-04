package StreamSources;

import java.util.*;

public class MainBingo {

    public static void main(String[] args) {

        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
            }
            start += 15;
        }

        Map<Character, int[]> myMap = new LinkedHashMap<>();
        int bingoIndex = 1;
        for (char c : "BINGO".toCharArray()) {
            int[] numbers = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll(numbers, i -> i + labelNo);
            myMap.put(c, numbers);
            bingoIndex += 15;
        }

        myMap.forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));

        myMap.entrySet()// entrySet() returns a Set of key-value pairs (entries) from the map (Set<Map.Entry<Character, int[]>>)
                        // but, if you're just printing the keys, keySet() is enough
                .stream()
                .map(e -> e.getKey() + " has range: " + e.getValue()[0] + " - " + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);


    }
}
