public class Student_Main {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            Student pojoStudent = new Student("S02300" + i,
                    switch (i) {
                case 1 -> "Mary";
                case 2 -> "Maria";
                case 3 -> "Marta";
                case 4 -> "Mira";
                case 5 -> "Mantra";
                default -> "Anonymous";
                    },
                    "0" + i + ".01.24",
                    "Math");

            System.out.println(pojoStudent);
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) {
            Student_Record recordStudent = new Student_Record("S02300" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Maria";
                        case 3 -> "Marta";
                        case 4 -> "Mira";
                        case 5 -> "Mantra";
                        default -> "Anonymous";
                    },
                    "0" + i + ".01.24",
                    "Math");

            System.out.println(recordStudent);
        }
    }

}
