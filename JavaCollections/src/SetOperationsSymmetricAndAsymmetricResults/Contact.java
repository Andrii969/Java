package SetOperationsSymmetricAndAsymmetricResults;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact {

    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null) {
            emails.add(email);
        }
        if (phone > 0) {
            String p = String.valueOf(phone);
            p = "(%s) %s-%s".formatted(p.substring(0,3), p.substring(3,6), p.substring(6));
            phones.add(p);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    public Contact mergeContactData(Contact contact) {
        Contact newContact = new Contact(name);
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);
        return newContact;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Contact contact = (Contact) object;
        return Objects.equals(getName(), contact.getName())
//                &&
//                Objects.equals(emails, contact.emails) &&
//                Objects.equals(phones, contact.phones)
                ;
    }
    // equals()
    // This method is used to determine if two Contact objects are "equal."
    // When you add objects to a HashSet, the set needs a way to check if an object is already present,
    // and this is done using the equals() method. In your case, two contacts are considered equal if:
    // They have the same name (Objects.equals(getName(), contact.getName()))
    // They have the same set of emails (Objects.equals(emails, contact.emails))
    // They have the same set of phone numbers (Objects.equals(phones, contact.phones))
    // By overriding equals(), you're specifying that all three fields (name, emails, phones)
    // must be identical for two Contact objects to be considered equal.

    @Override
    public int hashCode() {
        return Objects.hash(getName()
//                ,emails, phones
        );
    }
    // hashCode()
    //The hashCode() method returns an integer (the hash code) for the object.
    // This method is used in hashed collections like HashSet to quickly locate an object.
    // Objects that are considered equal according to the equals() method must have the same hash code.
    // Here, you use Objects.hash() to combine the hash codes of the name, emails, and phones fields.
    // This ensures that if two Contact objects have the same name, emails, and phones,
    // they will also have the same hash code, which is important for maintaining uniqueness in a HashSet.

    public void addEmail(String companyName) {
        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length -1],
                companyName.replaceAll(" ", "").toLowerCase());
        if (!emails.add(email)) {
            System.out.println(name + " already has email " + email);
        } else {
            System.out.println(name + " now has an email " + email);
        }
    }

    public void replaceEmailIfExists(String oldEmail, String newEmail) {
        if (emails.contains(oldEmail)) {
            emails.remove(oldEmail);
            emails.add(newEmail);
        }
    }
}
