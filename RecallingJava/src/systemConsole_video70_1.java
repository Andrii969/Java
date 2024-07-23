public class systemConsole_video70_1 {

    public static void main(String[] args) {

        int currentYear = 2024;

        System.out.println(getInputFromConsole(currentYear));

        System.out.println(getInputFromScanner(currentYear));
    }

    public static String getInputFromConsole (int currentYear) {

        String name = System.console().readLine("Hi, What's your Name? ");
        System.out.println("Hi " + name + ", nice to meet you!");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);
        System.out.println("So, " + name + ", you are " + age + " years old ;)");


        return "";

    }

    public static String getInputFromScanner (int currentYear) {

        return "";

    }

}


//////// GETTING AN ERROR
///Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=57674:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/andriisavonov/Projects/Java/RecallingJava/out/production/RecallingJava systemConsole_video70_1
//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.io.Console.readLine(String, Object[])" because the return value of "java.lang.System.console()" is null
//at systemConsole_video70_1.getInputFromConsole(systemConsole_video70_1.java:14)
//at systemConsole_video70_1.main(systemConsole_video70_1.java:7)