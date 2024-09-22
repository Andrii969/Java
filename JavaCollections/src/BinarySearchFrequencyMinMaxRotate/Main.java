package BinarySearchFrequencyMinMaxRotate;

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
        Card.printDesk(deck.subList(32, 36), "Tens row", 1);
//        Card.printDesk(deck, "Sorted Deck Of Cards", 13);


    }
}
