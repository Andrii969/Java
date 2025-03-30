package DefensiveCopiesShallowAndDeepCopies.CopyingClasses;

import java.util.Arrays;

record PersonRec(String name, String dob, PersonRec[] kids) {

//    @Override
//    public PersonRec[] kids() {
//        return kids == null ? null : Arrays.copyOf(kids, kids.length);
//    }


    public PersonRec(PersonRec p) {
        this(p.name, p.dob, p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }

    @Override
    public String toString() {
        return "PersonRec{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}

public class Main { // shallow and deep copies

    public static void main(String[] args) {

        PersonRec joe = new PersonRec("Joe", "01/01/1961", null);
        PersonRec jim = new PersonRec("Jim", "02/02/1961", null);
        PersonRec jack = new PersonRec("Jack", "03/03/1961",
                new PersonRec[]{joe, jim});
        PersonRec jane = new PersonRec("Jane", "01/01/1961", null);
        PersonRec jill = new PersonRec("Jill", "01/01/1961",
                new PersonRec[]{joe, jim});

        PersonRec[] persons = {joe, jim, jack, jane, jill};

        PersonRec[] personsCopy = Arrays.copyOf(persons, persons.length);
        PersonRec[] anotherPersonsCopy = new PersonRec[persons.length]; // making a deep copy of the array
        for (int i = 0; i < persons.length; i++) {
            PersonRec current = persons[i];
            PersonRec[] currentKids = current.kids() == null ? null : Arrays.copyOf(current.kids(), current.kids().length); // deep copy again here
            anotherPersonsCopy[i] = new PersonRec(current.name(), current.dob(), currentKids);
        }

        var jillsKids = anotherPersonsCopy[4].kids();
        jillsKids[1] = jane;

        for (int i = 0; i < 5; i++) {
            if (persons[i] == anotherPersonsCopy[i]) { // so, if I put here (persons[i] == anotherPersonsCopy[i]), no element will match
                System.out.println("Equal References " + persons[i]);
            }
        }

        System.out.println("persons[4] = " + persons[4]);
//        System.out.println("personsCopy[4] = " + personsCopy[4]);
        System.out.println("anotherPersonsCopy[4] = " + anotherPersonsCopy[4]);
    }
}
