package LinkedHashMapTreeMapNavigableMap;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Map<String, Purchase> purchases = new LinkedHashMap<>();

    private static NavigableMap<String, Student> students = new TreeMap<>();

    public static void main(String[] args) {

        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course python = new Course("pyt101", "Python Master Class", "Python");

        addPurchase("Mary Martin", jmc, 129.99);
        addPurchase("Andy Martin", jmc, 139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Mary Brown", python, 109.99);
        addPurchase("Andy Brown", python, 129.99);
        addPurchase("Joe Brown", python, 149.99);
        addPurchase("Bill Brown", python, 159.99);

        purchases.forEach((k,v) -> System.out.println(k + ": " + v)); // in the same order as added
        System.out.println("-".repeat(30));
        students.forEach((k,v) -> System.out.println(k + ": " + v)); // in the alphabetical order

        System.out.println("-".repeat(30));
        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();
        // Group purchases by their purchase date in the TreeMap
        for (Purchase p : purchases.values()) {
            // Compute or update the list of purchases for the current purchase date
            datedPurchases.compute(p.purchaseDate(),
                    (pdate, plist) -> {
                        // If there are no purchases yet for this date, create a new list
                        List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;
                        // Add the current purchase to the list
                        list.add(p);
                        // Return the updated list (whether new or existing)
                        return list;
                    });
        }
        datedPurchases.forEach((k,v) -> System.out.println(k + ": " + v));

        int currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
        LocalDate week1 = firstDay.plusDays(7);
        Map<LocalDate, List<Purchase>> week1Purchases = datedPurchases.headMap(week1); // all the dates before week1 in the map (7th and earlier)
        Map<LocalDate, List<Purchase>> week2Purchases = datedPurchases.tailMap(week1); // starting from week1 onward in the map (8th and later)

        System.out.println("-".repeat(30));
        week1Purchases.forEach((k,v) -> System.out.println(k + ": " + v));
        System.out.println("-".repeat(30));
        week2Purchases.forEach((k,v) -> System.out.println(k + ": " + v));

        displayStats(1, week1Purchases);
        displayStats(2, week2Purchases);

        System.out.println("-".repeat(30));
        LocalDate lastDate = datedPurchases.lastKey();
        var previousEntry = datedPurchases.lastEntry();

        List<Purchase> lastDaysData = previousEntry.getValue();
        System.out.println(lastDate + " purchases : " + lastDaysData.size());


    }

    private static void addPurchase(String name, Course course, double price) {
        Student existingStudent = students.get(name); // both HashMap and TreeMap work for retrieving values by keys
        if (existingStudent == null) {
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);
        } else {
            existingStudent.addCourse(course);
        }

        int day = new Random().nextInt(1,15);
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(), price, year, day);
        purchases.put(key, purchase);
    }

    private static void displayStats(int period, Map<LocalDate, List<Purchase>> periodData) {
        System.out.println("-".repeat(30));
        // TreeMap to store course ID and the number of purchases, sorted by course ID
        Map<String, Integer> weeklyCounts = new TreeMap<>();

        // Iterate over each date and its corresponding list of purchases
        periodData.forEach((key, value) -> {
            // Print the date and the list of purchases made on that date
            System.out.println(key + ": " + value);

            // For each purchase in the list, update the count for the respective course
            for (Purchase p : value) {
                // If the courseId is already in the map, increment its count by 1,
                // otherwise initialize it with a count of 1.
                weeklyCounts.merge(p.courseId(), 1, (prev, current) -> prev + current);
            }
        });
        System.out.printf("Week %d Purchases = %s%n", period, weeklyCounts);
    }
}
