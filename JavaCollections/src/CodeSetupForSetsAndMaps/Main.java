package CodeSetupForSetsAndMaps;

import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        printData("Phones", phones);
        printData("Emails", emails);
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }
}
