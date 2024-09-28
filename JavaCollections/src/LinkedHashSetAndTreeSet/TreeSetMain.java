package LinkedHashSetAndTreeSet;

import java.util.*;

public class TreeSetMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        printData("Phones", phones);
        printData("Emails", emails);

        // A LinkedHashSet maintains the insertion order of the elements.
        // The TreeSet is a sorted collection, sorted by the natural order of the elements,
        // or by specifying the required sort during the creation of the set.

        // Two important points :
        // Elements which implement Comparable (said to have a natural order sort, like Strings and numbers)
        // can be elements of a TreeSet. If your elements don't implement Comparable,
        // you must pass a Comparator to the constructor.

//        NavigableSet<Contact> sorted = new TreeSet<>(phones); // class LinkedHashSetAndTreeSet.Contact cannot be cast to class java.lang.Comparable
//        sorted.forEach(System.out::println);

        System.out.println("-".repeat(30));
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println); // And now you can see my phone contacts, in name order, and without duplicates.

        System.out.println("-".repeat(30));
        NavigableSet<String> justNames = new TreeSet<>();
        // Since we know Strings have a natural sort order, I'll create a TreeSet of those next. I'm using the no args constructor in this case.
        phones.forEach((n) -> justNames.add(n.getName()));
        System.out.println(justNames);

        System.out.println("-".repeat(30));
        NavigableSet<Contact> fullSet = new TreeSet<>(sorted); // I can pass a sorted set (with phones) to the TreeSet constructor.
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println); // This compiles and runs, and shows that I now have a combined list of contacts.
        // In this case, the sort was determined by the sort mechanism of the TreeSet passed to the constructor.

        System.out.println("-".repeat(30));
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator()); // using the comparator from the sorted NavigableSet.
        fullList.forEach(System.out::println);
        // We get this list, that contains duplicates, but I was able to sort in the same way as the Set, alphabetically by the name.

//        Contact min = Collections.min(fullSet); // ERROR: no instance(s) of type variable(s) T exist so that Contact conforms to Comparable<? super T>
        Contact min = Collections.min(fullSet, Comparator.comparing(Contact::getName));
        Contact max = Collections.max(fullSet, fullSet.comparator());
        // The SortedSet interface includes first and last methods:
        Contact first = fullSet.first();
        Contact last = fullSet.last();
        System.out.println("-".repeat(30));
        System.out.printf("min = %s, first = %s %n", min, first);
        System.out.printf("max = %s, last = %s %n", max, last);

        System.out.println("-".repeat(30));
        NavigableSet<Contact> copied = new TreeSet<>(fullSet);
        System.out.println("First element = " + copied.pollFirst());
        System.out.println("Last element = " + copied.pollFirst());
        copied.forEach(System.out::println);
        // The elements are first removed from the set, which you can see here, when I print out the elements in the copied set

        // // // // // // // // // // // // // // // //
        System.out.println("-".repeat(60));
        fullSet.forEach(System.out::println);
        System.out.println("-".repeat(30));
        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact c : List.of(daffy, daisy, last, snoopy)) {
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            // ceiling will return the element that equals the value passed
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println("-".repeat(30));
        for (Contact c : List.of(daffy, daisy, first, archie)) {
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            // floor is similar to ceiling. It returns the element that's equal to the argument passed, if that element's in the Set.
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }

        System.out.println("-".repeat(60));
        NavigableSet<Contact> descSet = fullSet.descendingSet();
        descSet.forEach(System.out::println);

        System.out.println("-".repeat(30));
        Contact lastContact = descSet.pollLast();
        // Whatever you do to the descending set, will be reflected in the Set that backs it, in my case the fullSet.
        System.out.println("Last Contact Removed = " + lastContact);
        descSet.forEach(System.out::println);

        System.out.println("-".repeat(30));
        fullSet.forEach(System.out::println);

        System.out.println("-".repeat(30));
        Contact marion = new Contact("Maid Marion"); // Now, you want to get all contacts that come before "Maid Marion."
        // You can't directly access "Maid Marion" from the set without knowing where it is. So, you create a new Contact with the same name
        var headSet = fullSet.headSet(marion);
        headSet.forEach(System.out::println);
        System.out.println("-".repeat(30));
        var tailSet = fullSet.tailSet(marion); //  Get all elements after "Maid Marion" including it.
//        var tailSet2 = fullSet.tailSet(marion, false); //  Get all elements after "Maid Marion" without including it.
        tailSet.forEach(System.out::println);

        System.out.println("-".repeat(30));
        Contact linus = new Contact("Linus Van Pelt");
        var subset = fullSet.subSet(linus, marion);
        // This subSet method includes the first contact, linus, and excludes the second contact, marion.
        subset.forEach(System.out::println);

        System.out.println("-".repeat(30));
        var subset2 = fullSet.subSet(linus, false, marion, true);
        // This subSet method excludes the first contact, linus, and includes the second contact, marion.
        subset2.forEach(System.out::println);






    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }
}
