package dev.abstractClassChallenge;

public class Node extends ListItem{


    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return null;
    }

    @Override
    ListItem setNext(ListItem listItem) {
        return null;
    }

    @Override
    ListItem previous() {
        return null;
    }

    @Override
    ListItem setPrevious(ListItem listItem) {
        return null;
    }

    @Override
    int compareTo(ListItem listItem) {
        return 0;
    }
}
