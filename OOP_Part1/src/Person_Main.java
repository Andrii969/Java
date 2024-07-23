public class Person_Main {

    public static void main(String[] args) {

        Person person = new Person();

        person.setFirstName("John");    // firstName is set to John
        person.setLastName("Smith");    // lastName is set to Smith
        System.out.println(person.getFullName());

    }
}
