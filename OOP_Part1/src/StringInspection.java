public class StringInspection {

    public static void main(String[] args) {
        printInformation("Hello World");
            System.out.println();
        printInformation("");
            System.out.println();
        printInformation("\t   \n");
            System.out.println();

        String helloWorld = "Hello World";
        // index is zero-based, so the 1st character is at index 0, the 2nd character is at index 1, and so on.
        System.out.printf("first index of l = %d %n",helloWorld.indexOf('l')); // 2
        System.out.printf("last index of l = %d %n",helloWorld.lastIndexOf('l')); // 9
        System.out.printf("index of l = %d %n",helloWorld.indexOf('l',3)); // 3
        System.out.printf("index of l = %d %n",helloWorld.lastIndexOf('l',8)); // 3
        System.out.printf("first index of r = %d %n",helloWorld.indexOf('r')); // 8
        System.out.printf("first index of World = %d %n",helloWorld.indexOf("World")); // 6
    }

    public static void printInformation(String string) {
        int length = string.length(); // System.out.println("Hello World".length());
        System.out.printf("Length = %d %n", length);

        if (string.isEmpty()) {
            System.out.println("String is Empty");
            return;
        }

        if (string.isBlank()) {
            System.out.println("String is Blank");
        }

        System.out.printf("First char = %c %n", string.charAt(0)); // %c - char - prints the single character
        System.out.printf("Last char = %c %n", string.charAt(length-1)); // %c - char - prints the single character
    }

}
