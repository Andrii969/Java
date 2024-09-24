package IntroductionToSetsAndHashSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        printData("Phones", phones);
        printData("Emails", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone contacts", phoneContacts);
        printData("Email contacts", emailContacts);
        //   You can see that there are still duplicates in both of these sets,
        // but the order is not the same as the order that was in the list.
        // Can you guess why there's duplicates in these Sets, even though I just said on the slides,
        // that HashSets won't have duplicates? Well, duplicates are determined, for hashed collections,
        // first by the hash code, and then the equals method.
        //   In this instance, both the hash code method, and the equals method, are using Object's implementation.
        // This means each of these instances of contacts is considered unique, by that definition.
        // In most cases, this is probably a good thing. But since these are personal contacts, I'm going to make a rule,
        // that contacts that have the same name, are really the same person, but with different data.


    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }
}
