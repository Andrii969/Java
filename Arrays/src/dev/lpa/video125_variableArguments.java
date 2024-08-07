package dev.lpa;

public class video125_variableArguments {

    public static void main(String... args) { // using ... instead of []

        String[] myStringArray = {"Hello World One", "Hello World Two", "Hello World Three"};
        printText(myStringArray);
        System.out.println("-".repeat(30));

        String[] splitStrings = "One Two Three".split(" "); // split the string using regex -> space " "
        printText(splitStrings);
        System.out.println("-".repeat(30));

        printText("Hello"); // using printText(String... textList) allows to print a single string, not only the array
        System.out.println("-".repeat(30));

        printText("Hello One", "Hello Two", "Hello Three");
        System.out.println("-".repeat(30));

        String[] sArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join(",", sArray)); // first,second,third,fourth,fifth
    }

    private static void printText(String... textList) { // using ... instead of []
        for (String t : textList) {
            System.out.println(t);
        }
    }

}