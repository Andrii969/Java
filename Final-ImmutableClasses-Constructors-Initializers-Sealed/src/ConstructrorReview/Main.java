package ConstructrorReview;

import ConstructrorReview.child.Child;

public class Main {

    public static void main(String[] args) {

        Parent parent = new Parent("John Doe", "12/12/1990", 4);
        System.out.println("Parent:" + parent);

        Child child = new Child();
        System.out.println("Child: " + child);

        Parent parent2 = new Parent("John Doe2", "12/12/1990", 4);
        System.out.println("Parent2:" + parent2);

    }
}
