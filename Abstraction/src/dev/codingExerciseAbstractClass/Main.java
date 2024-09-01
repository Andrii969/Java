package dev.codingExerciseAbstractClass;

public class Main {
    public static void main(String[] args) {
        // Test MyLinkedList functionality
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot()); // The list is empty

        String[] cities = {"Sydney", "Melbourne", "Brisbane", "Perth", "Adelaide", "Darwin", "Canberra"};
        for (String city : cities) {
            list.addItem(new Node(city));
        }
        list.traverse(list.getRoot()); // Traverse and print all cities

        list.removeItem(new Node("Brisbane")); // Remove Brisbane
        list.traverse(list.getRoot()); // Traverse again after removal

        list.removeItem(new Node("Sydney")); // Remove Sydney (root)
        list.traverse(list.getRoot()); // Traverse again after removal

        list.removeItem(new Node("Perth")); // Remove Perth
        list.traverse(list.getRoot()); // Traverse again after removal

        // Test SearchTree functionality
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot()); // The tree is empty

        String[] fruits = {"Apple", "Orange", "Banana", "Pear", "Peach", "Mango", "Plum"};
        for (String fruit : fruits) {
            tree.addItem(new Node(fruit));
        }
        tree.traverse(tree.getRoot()); // Traverse and print all fruits

        tree.removeItem(new Node("Banana")); // Remove Banana
        tree.traverse(tree.getRoot()); // Traverse again after removal

        tree.removeItem(new Node("Apple")); // Remove Apple (root)
        tree.traverse(tree.getRoot()); // Traverse again after removal

        tree.removeItem(new Node("Plum")); // Remove Plum
        tree.traverse(tree.getRoot()); // Traverse again after removal
    }
}

