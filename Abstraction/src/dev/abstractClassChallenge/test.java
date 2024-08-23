package dev.abstractClassChallenge;

public class test {

    public static void main(String[] args) {

        Node node1 = new Node("banana");
        Node node2 = new Node("apple");

        int result = node1.compareTo(node2);
        System.out.println(result);

    }
}
