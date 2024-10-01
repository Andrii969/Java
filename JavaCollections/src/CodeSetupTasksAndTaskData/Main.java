package CodeSetupTasksAndTaskData;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All tasks", tasks);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's tasks", annsTasks);

        Comparator<Task> sortByPriority = (Comparator.comparing(Task::getPriority)); // .reversed() to reverse
        // = ((o1, o2) -> o1.getPriority().compareTo(o2.getPriority()));

        sortAndPrint("Ann's tasks Sorted By Priority", annsTasks, sortByPriority);
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

}
