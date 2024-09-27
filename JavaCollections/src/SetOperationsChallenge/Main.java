package SetOperationsChallenge;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All tasks Sorted By Default", tasks);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's tasks Sorted By Default", annsTasks);

        Comparator<Task> sortByPriority = (Comparator.comparing(Task::getPriority)); // .reversed() to reverse
        // = ((o1, o2) -> o1.getPriority().compareTo(o2.getPriority()));

        sortAndPrint("Ann's tasks Sorted By Priority", annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        sortAndPrint("Bob's tasks Sorted By Default", bobsTasks);

        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        sortAndPrint("Carol's tasks Sorted By Default", carolsTasks);

        // // // // // // // // // // // // // //

//        List<Set<Task>> listsOfTaskSets = new ArrayList<>();
//        listsOfTaskSets.add(annsTasks);
//        listsOfTaskSets.add(bobsTasks);
//        listsOfTaskSets.add(carolsTasks);

        List<Set<Task>> listsOfTaskSets = List.of(annsTasks, bobsTasks, carolsTasks); // alternatively to the commented code above
        Set<Task> assignedTasks = getUnion(listsOfTaskSets);
        sortAndPrint("Assigned Tasks", assignedTasks);




    }

    private static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
        // null works because Task implements Comparable
    }

    private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter) {
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        List<Task> tasksCollection = new ArrayList<>(collection);
        tasksCollection.sort(sorter);
        tasksCollection.forEach(System.out::println);
    }

    private static Set<Task> getUnion (List<Set<Task>> listOfTasks) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> list : listOfTasks) {
            union.addAll(list);
        }
        return union;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }


}
