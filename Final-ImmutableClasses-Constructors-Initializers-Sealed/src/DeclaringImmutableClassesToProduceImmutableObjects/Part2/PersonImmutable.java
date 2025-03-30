package DeclaringImmutableClassesToProduceImmutableObjects.Part2;

import java.util.Arrays;

public class PersonImmutable {

    private final String name;
    private final String dob;
    private final PersonImmutable[] kids;

    public PersonImmutable(String name, String dob, PersonImmutable[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids;
    }

    public PersonImmutable(String name, String dob) {
        this(name, dob, null);
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) { // can't use setter when the field is final
//        this.name = name;
//    }

    public String getDob() {
        return dob;
    }

//    public void setDob(String dob) { // can't use setter when the field is final
//        this.dob = dob;
//    }

    public PersonImmutable[] getKids() { // return copy when the dataType is mutable
        return kids== null ? null : Arrays.copyOf(kids, kids.length);
    }

//    public void setKids(PersonImmutable[] kids) { // can't use setter when the field is final
//        this.kids = kids;
//    }

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
