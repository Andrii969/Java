package EnumCollections;

import java.util.*;

public class Main {

    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static void main(String[] args) {

        List<WeekDay> annsWorkDays = new ArrayList<>(List.of(WeekDay.MONDAY, WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));
        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName()); // RegularEnumSet
        annsDaysSet.forEach(System.out::println);

        System.out.println("-".repeat(30));
        var allDaysSet = EnumSet.allOf(WeekDay.class);
        allDaysSet.forEach((d) -> System.out.println(d));

        System.out.println("-".repeat(30));
        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaysSet);
        // This method computes the complement of annsDaysSet, meaning it returns all elements from the original EnumSet
        // (which in this case is WeekDay) except the elements that are in annsDaysSet.
        newPersonDays.forEach(System.out::println);

        System.out.println("-".repeat(30));
        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaysSet);
        anotherWay.removeAll(annsDaysSet);
        anotherWay.forEach(System.out::println);

        System.out.println("-".repeat(30));
        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        businessDays.forEach(System.out::println);

        System.out.println("-".repeat(30));
        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ann", "Marry", "Bob"});
        employeeMap.put(WeekDay.MONDAY, new String[]{"Marry", "Bob"});
        employeeMap.forEach((k,v) -> System.out.println(k + ": " + Arrays.toString(v)));

    }
}
