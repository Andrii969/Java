package DeclaringImmutableClassesToProduceImmutableObjects.Part1;

import java.util.Arrays;

public class Person {

    private String name;
    private String dob;
    private Person[] kids;

    public Person(String name, String dob, Person[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids;
    }

    public Person(String name, String dob) {
        this(name, dob, null);
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) { // remove setter to protect change
//        this.name = name;
//    }

    public String getDob() {
        return dob;
    }

//    public void setDob(String dob) { // remove setter to protect change
//        this.dob = dob;
//    }

    public Person[] getKids() {
        return kids;
    }

    public void setKids(Person[] kids) {
        this.kids = kids;
    }

    public static void doSmth() {
        System.out.println("Doing smth");
    }

    @Override
    public String toString() {

        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", dob = " + dob + ", kids = " + kidString;
    }
}
