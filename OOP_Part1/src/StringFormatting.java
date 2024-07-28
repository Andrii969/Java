public class StringFormatting {

    public static void main(String[] args) {

        String bulletIt = "Print a Bulleted List:" +
                "\u2022 First Point" +
                "\u2022 Sub Point";
        System.out.println(bulletIt);

        bulletIt = "Print a Bulleted List:\n" +
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";
        System.out.println(bulletIt);

        String textBlock = """
                Print a Bulleted List:
                    \u2022 First Point
                        \u2022 Sub Point""";
        System.out.println(textBlock); // three double quotes are required, and they must be on their own line.
        // The text block lets me format text in the source code the same way I want to see it in the output.

        int age = 35;
        System.out.printf("Your age is %d %n", age); // printf() method used to format text and variables for output
        System.out.printf("Your age is %f %n", (float) age); // f - for float or double, d - for decimal integer
        System.out.printf("Your age is %.2f %n", (float) age); // .2f - for 2 decimal points
        // In summary, if you want to ensure your newline characters are platform-independent
        // and work correctly across different operating systems, use %n in formatted strings.
        // For general string literals where platform independence is not a concern, \n can be used.

        int yearOfBirth = 2024 - age;
        System.out.printf("Age is %d, Birth year is %d %n", age, yearOfBirth);

        for (int i = 1; i <= 100000; i *= 10) {
            System.out.printf("Printing %6d %n", i); // each number fills 6 spaces
        }

        String formattedString = String.format("Your age is %d", age); // String format() method returns a formatted string
                                                                        // using the specified format string, and arguments.
        System.out.println(formattedString);

        formattedString = "Your age is %d".formatted(age); // the same result here
        System.out.println(formattedString);
    }
}


/////// ANOTHER EXAMPLE
//String text = String.format("User = {name: %s, age: %d years, friend: %s, weight: %d kg.}", user.getName(),
// user.getAge(), user.getFriends().get(0), user.getExtraInformation().getWeight())
//System.out.println(text);

