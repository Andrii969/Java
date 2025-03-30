package DeclaringImmutableClassesToProduceImmutableObjects.Part1;

public class MainRecord {

    public static void main(String[] args) {

        PersonRecord jane = new PersonRecord("Jane", "02/02/2010");
        PersonRecord jim = new PersonRecord("Jim", "03/03/2011");
        PersonRecord joe = new PersonRecord("Joe","04/04/2012");

        PersonRecord[] johnsKids = {jane, jim, joe};
        PersonRecord john = new PersonRecord("John", "05/05/1990", johnsKids);
        System.out.println(john);

        PersonRecord Martin = new PersonRecord("Martin", "05/05/1990");
        System.out.println(Martin);

        PersonRecord[] kids = Martin.kids(); // see kids() method - to prevent changes it returns copy of kids array
        kids[0] = jim;
        kids[1] = new PersonRecord("Ann", "04/04/1936");
        System.out.println(Martin);

        johnsKids[0] = new PersonRecord("Ann", "04/04/1936"); // can change the value of johnsKids
        System.out.println(john);





    }
}
