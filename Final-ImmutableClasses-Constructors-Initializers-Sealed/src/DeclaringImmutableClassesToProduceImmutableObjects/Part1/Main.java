package DeclaringImmutableClassesToProduceImmutableObjects.Part1;

public class Main {

    public static void main(String[] args) {

        Person jane = new Person("Jane", "02/02/2010");
        Person jim = new Person("Jim", "03/03/2011");
        Person joe = new Person("Joe","04/04/2012");
        Person john = new Person("John", "05/05/1990");
        john.setKids(new Person[]{jane, jim, joe});
        System.out.println(john);

        System.out.println("-".repeat(30));

        john.setKids(new Person[]{new Person("Ann", "04/04/2013")});
        System.out.println(john);

        System.out.println("-".repeat(40));

        Person[] johnKids;
        johnKids = john.getKids();
        johnKids[0] = jim;
        System.out.println(john);

        johnKids[0] = jane;
        System.out.println(john);

        System.out.println("-".repeat(50));

        johnKids = null; // Sets the reference to null, thus doesn't change the original
//        johnKids[0] = jim; // Can't use it
        System.out.println(john);

        System.out.println("-".repeat(60));
        john.setKids(johnKids);
        System.out.println(john); // kids = n/a











    }
}
