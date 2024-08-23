package dev.abstractClassChallenge;

public class Node extends ListItem{


    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem listItem) {
        this.rightLink = listItem;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem listItem) {
        this.leftLink = listItem;
        return leftLink;
    }

    @Override
    int compareTo(ListItem listItem) {
        if (listItem != null) {
            System.out.println((String) this.getValue() + " VS " + (String) listItem.getValue());
            return ((String) this.getValue()).compareTo((String) listItem.getValue()); // returns -1 if this value is greater, 1 if it's less, 0 if equal
        } else {
            return -1;
        }
    }
}
