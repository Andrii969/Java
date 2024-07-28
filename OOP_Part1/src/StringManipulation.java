public class StringManipulation {

    public static void main(String[] args) {

        String birthDate = "25.11.1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println(startingIndex); // 6
        System.out.println("Birth year = " + birthDate.substring(startingIndex)); // Birth year = 1982
        int yearOfBirth = Integer.parseInt(birthDate.substring(startingIndex));
        System.out.println(yearOfBirth); // 1982
        System.out.println("Birth year = " + yearOfBirth); // Birth year = 1982

        System.out.println("Month = " + birthDate.substring(3,5)); // Month = 11
        System.out.println("Day = " + birthDate.substring(0,2)); // Day = 25

        String newDate = String.join(".", "25","11","1982");
        System.out.println(newDate); // 25.11.1982

        newDate = "25"; //
        newDate = newDate.concat(".");
        newDate = newDate.concat("11");
        newDate = newDate.concat(".");
        newDate = newDate.concat("1982");
        System.out.println(newDate); // 25.11.1982

        newDate = "25".concat(".").concat("11").concat(".").concat("1982");
        System.out.println(newDate); // 25.11.1982

        newDate = "25/11/1982";

        System.out.println(newDate.replace("/","-")); // 25-11-1982 //  in replace() it is a String
        System.out.println(newDate.replaceFirst("/","-")); // 25-11/1982 // in replaceFirst() it is a regex
        System.out.println(newDate.replaceAll("/","-")); // 25-11-1982 // in replaceAll() it is a regex

        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));

        System.out.println("ABC\n".repeat(3).indent(8)); // adding 8 spaces before
        System.out.println("-".repeat(20));

    }
}
