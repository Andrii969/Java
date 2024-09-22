package CollectionsIntroduction;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edha"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        list.removeIf((s) -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        list.sort(Comparator.naturalOrder());

        // // // // // // // // //
        System.out.println("-".repeat(30));

        Collection<String> collectionList = new TreeSet<>();

        String[] otherNames = {"Anna", "Bob", "Carol", "David", "Edha"};
        collectionList.addAll(Arrays.asList(otherNames));
        System.out.println(collectionList);

        collectionList.add("Fred");
        collectionList.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(collectionList);
        System.out.println("Gary is in the collectionList? " + collectionList.contains("Gary"));

        collectionList.removeIf((s) -> s.charAt(0) == 'G');
        System.out.println(collectionList);
        System.out.println("Gary is in the collectionList? " + collectionList.contains("Gary"));

//        collectionList.sort(); // Cannot resolve method 'sort' in 'Collection'

    }
}
