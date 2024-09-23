package BinarySearchFrequencyMinMaxRotate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandartDeck();
        Card.printDesk(deck);

        System.out.println("-".repeat(30));

        var sortingAlgoritm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
//        deck.sort(sortingAlgoritm);
//        Collections.sort(deck, Comparator.comparingInt(Card::rank));
        Collections.sort(deck, sortingAlgoritm);
        Card.printDesk(deck, "Sorted Deck Of Cards", 13);

//        Collections.shuffle(deck);
        Card tensOfHeart = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tensOfHeart, sortingAlgoritm);
        // !!! Your list must be sorted before you can execute a binarySearch on it
        System.out.println("foundIndex = " + foundIndex);
        System.out.println("foundIndex = " + deck.indexOf(tensOfHeart));
        System.out.println(deck.get(foundIndex));
        // You might be asking, which method should you use? The basic rule of thumb is if your lists contain
        // a small number of elements, or if your list is unsorted or may contain duplicates, then using the indexOf method,
        // or its cohort, the lastIndexOf method, will provide better performance. If your list is already sorted,
        // and contains a large number of elements, then the binarySearch method will likely produce performance improvements.

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tensOfHeart); // tenOfClubs replaced by tensOfHeart
        // Collections.replaceAll(List<T> list, T oldVal, T newVal)
        Card.printDesk(deck.subList(32, 36), "Tens row", 1);
//        Card.printDesk(deck, "Sorted Deck Of Cards", 13);

        Collections.replaceAll(deck, tensOfHeart, tenOfClubs);
        Card.printDesk(deck.subList(32, 36), "Tens row", 1);

        if (Collections.replaceAll(deck, tensOfHeart, tenOfClubs)) {
            System.out.println("Tens of hearts replaced with tens of clubs");
        } else {
            System.out.println("No tens of hearts found in the list");
        }

        System.out.println("Ten of Clubs Cards = " + Collections.frequency(deck, tenOfClubs));
        // Another interesting function is the
        // frequency method, which allows you to check for duplicates in your collection.

        System.out.println("Best Card = " + Collections.max(deck, sortingAlgoritm));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgoritm));

        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDesk(deck, "Sorted by Suit, Rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, 2);
        // A positive number passed to this method, moves that number of elements in the
        // list from the back of the list to the front of the list, as you can see here.
        System.out.println("UnRotated: " + (deck.subList(0,13)));
        System.out.println("Rotated 2: " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, -2);
        // Using a negative number though, you can see it moves the elements from the start to the end of the list.
        // Here, the 2 and 3 of clubs were rotated to the end of the list.
        System.out.println("UnRotated: " + (deck.subList(0,13)));
        System.out.println("Rotated -2: " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        for (int i = 0; i < copied.size() / 2; i++) {
            Collections.swap(copied, i, copied.size() - 1 - i);
        }
        System.out.println("Manual reverse :" + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Using reverse :" + copied);
    }
}
