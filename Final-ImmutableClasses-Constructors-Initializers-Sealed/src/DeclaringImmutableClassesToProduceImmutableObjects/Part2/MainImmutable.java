package DeclaringImmutableClassesToProduceImmutableObjects.Part2;

public class MainImmutable {

    public static void main(String[] args) {

        PersonImmutable jane = new PersonImmutable("Jane", "02/02/1990",
                new PersonImmutable[]{new PersonImmutable("Ann",  "03/03/2015")});

        PersonImmutable[] janeKids = jane.getKids();
        janeKids[0] = new PersonImmutable("Jimmy",  "04/05/2018"); // change not applied, see getKids() -- here I return a copy

        System.out.println(jane);
    }
}
