public class MobilePhone_Main {

    public static void main(String[] args) {

//        Contact contactJane = new Contact("Jane", "123456789");
//        MobilePhone myPhone = new MobilePhone("12345");
//        myPhone.addNewContact(contactJane);
//        myPhone.addNewContact(contactJane);
//        System.out.println(myPhone.findContact(contactJane));
//        myPhone.printContacts();

        MobilePhone mobilePhone = new MobilePhone("123-456-7890");

        // Create some Contact objects
        Contact contact1 = Contact.createContact("Alice", "111-111-1111");
        Contact contact2 = Contact.createContact("Alice", "222-222-2222");
        Contact contact3 = Contact.createContact("Charlie", "333-333-3333");

        // Add contacts
        System.out.println("Adding contacts:");
        System.out.println("Add Alice: " + mobilePhone.addNewContact(contact1));
        System.out.println("Add Bob: " + mobilePhone.addNewContact(contact2));
        System.out.println("Add Charlie: " + mobilePhone.addNewContact(contact3));

        // Print all contacts
        System.out.println("\nContact List:");
        mobilePhone.printContacts();
    }
}
