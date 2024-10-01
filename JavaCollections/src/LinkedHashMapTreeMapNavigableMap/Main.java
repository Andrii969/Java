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
        addPurchase("Bill Brown", python, 119.99);

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


    }

    private static void addPurchase(String name, Course course, double price) {
        Student existingStudent = students.get(name); // both HashMap and TreeMap work for retrieving values by keys
        if (existingStudent == null) {
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);
        } else {
            existingStudent.addCourse(course);
        }

        int day = new Random().nextInt(1,5);
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(), price, year, day);
        purchases.put(key, purchase);
    }
}
