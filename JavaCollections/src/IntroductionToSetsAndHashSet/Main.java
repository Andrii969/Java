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
        // Since both 'emailContacts' and 'phoneContacts' are stored in a HashSet, duplicates will not be printed.
        // This is because HashSet does not allow duplicate elements and relies on the Contact class's overridden
        // 'equals()' and 'hashCode()' methods to determine uniqueness. If two Contact objects have the same name,
        // emails, and phone numbers, they will be considered equal and only one of them will be stored in the set.
        // Thus, when adding phones and emails into the Set<Contact>, duplicates are automatically filtered out,
        // and you won't see them printed.

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");
        System.out.println(robinHood);
        printData("Email contacts updated", emailContacts);
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }
}
