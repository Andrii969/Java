package SetOperationsSymmetricAndAsymmetricResults;

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

        // Union (A ∪ B): Combine all elements from emailContacts and phoneContacts into a single set.
        // Duplicates will be removed since sets don't allow duplicates
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A ∪ B) Union of emails (A) with phones (B)", unionAB);

        // Intersection (A ∩ B): Retain only elements that exist in both emailContacts and phoneContacts.
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A ∩ B) Intersect emails (A) and phones (B)", intersectAB);

        // Intersection (B ∩ A): Same operation as above but starting with phoneContacts.
        // Result will be the same as intersectAB because intersection is commutative.
        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(A ∩ B) Intersect phones (B) and emails (A)", intersectBA);

        // Asymmetric Difference (A - B): Remove from emailContacts all contacts that exist in phoneContacts.
        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)", AMinusB);
        // This shows us that Linus and Daffy are the only two records in the email list,
        // that aren't in the phones list.

        // Asymmetric Difference (B - A): Remove from phoneContacts all contacts that exist in emailContacts.
        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);
        printData("(B - A) phones (A) - emails (B)", BMinusA);
        // As you can see, the set of contacts is a
        // different Set of characters all together, Lucy Van Pelt, Charlie Brown, and Maid Marion.

        // Symmetric Difference (A Δ B): Combine the two asymmetric differences to get contacts that are only in A or B, but not both.
        Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printData("Symmetric Difference: phones and emails", symmetricDiff);

        // Alternative Symmetric Difference: Start with the union of A and B, then remove the intersection (common elements).
        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric Difference2: phones and emails", symmetricDiff2);
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }
}
