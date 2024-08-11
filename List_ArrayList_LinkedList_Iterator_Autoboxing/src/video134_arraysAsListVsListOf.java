import java.util.Arrays;
import java.util.List;

public class video134_arraysAsListVsListOf {

    public static void main(String[] args) {

        String[] daysAsList = new String[]{"Sunday", "Monday", "Tuesday"};
        List<String> newListdaysAsList = Arrays.asList(daysAsList); // returned list is NOT resizable, but is MUTABLE
        System.out.println(newListdaysAsList);
        newListdaysAsList.set(0, "Wednesday");
        System.out.println(newListdaysAsList);


        String[] daysListOf = new String[]{"Sunday", "Monday", "Tuesday"};
        List<String> newListDaysListOf = List.of(daysListOf); // // returned list is IMMUTABLE
        System.out.println(newListDaysListOf);
//        newListDaysListOf.set(0, "Wednesday"); // UnsupportedOperationException
    }
}
