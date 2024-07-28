public class StringBuilderExample {

    public static void main(String[] args) {

        String helloWorld = "Hello" + " World";
        printInformation(helloWorld); // String = Hello World // Length = 11
        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        printInformation(helloWorldBuilder); // String = Hello World // Length = 11

        helloWorld.concat(" and Goodbye");
        printInformation(helloWorld); // String = Hello World // Length = 11
        helloWorldBuilder.append(" and Goodbye");
        printInformation(helloWorldBuilder); // String = Hello World and Goodbye // Length = 23

        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and Goodbye");
        builderPlus.deleteCharAt(16).insert(16, 'g'); // delete G and insert g
        printInformation(builderPlus);
        builderPlus.replace(16,17,"G"); // replace g with G
        printInformation(builderPlus);
        builderPlus.reverse().setLength(7);
        printInformation(builderPlus); // eybdooG

        StringBuilder emptyStart = new StringBuilder(); // default capacity 16
        emptyStart.append("a".repeat(17));
        printInformation(emptyStart); // capacity=(16+1)×2=34

        StringBuilder emptyStart32 = new StringBuilder(32); // capacity set to 32
        emptyStart32.append("a".repeat(17));
        printInformation(emptyStart32); // capacity=32
    }

    public static void printInformation(String string) {
        System.out.println("String = " + string);
        System.out.println("Length = " + string.length());
        System.out.println("---");
    }

    public static void printInformation(StringBuilder builder) {
        System.out.println("Builder String = " + builder);
        System.out.println("Builder Length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());
        System.out.println("---");
    }

}
