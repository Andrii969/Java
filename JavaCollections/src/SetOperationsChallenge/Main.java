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

        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks); // alternative to the commented code above

        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned Tasks", assignedTasks);

        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("The True All Tasks", everyTask);

        Set<Task> missingTasks = getDifference(everyTask, tasks);
        sortAndPrint("Missing Tasks", missingTasks);
        // I get two tasks that weren't on the boss's radar, but are assigned to Ann.

        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("Unnassigned Tasks", unassignedTasks, Comparator.comparing(Task::getPriority));

        Set<Task> overlap = getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(bobsTasks, carolsTasks),
                getIntersect(carolsTasks, annsTasks)
        ));
        sortAndPrint("Assinged to Multiples", overlap, sortByPriority);
        // I discover that four of my tasks are assigned to multiple team members.
        // Note that name here represents only the first person assigned to the task.
        // Interestingly enough, it looks like Anne is assigned to all the duplicate tasks.

        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set : sets) {
            Set<Task> dupes = getIntersect(set, overlap);
            overlapping.addAll(dupes);
        }
        sortAndPrint("Overlapping", overlapping, sortByPriority.thenComparing(Comparator.naturalOrder()));
        // I get returned a list of tasks that I'll most likely need to reassign. Ann and Bob, my strongest team members,
        // are assigned to the same tickets in all of these cases.
        // Carol, a new member, has some overlapping tickets but she hasn't started any.

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

    // Combine all without duplicates
    private static Set<Task> getUnion (List<Set<Task>> listOfTasks) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> list : listOfTasks) {
            union.addAll(list);
        }
        return union;
    }

    // Retain only tasks that exist in both sets
    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    // difference: from set a remove tasks from set b
    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }


}
