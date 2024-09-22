package ShuffleReverseSortIndexofsublist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandartDeck();
        Card.printDesk(deck);

        Collections.shuffle(deck);
        Card.printDesk(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDesk(deck, "Reversed Deck Of Cards", 4);

        var sortingAlgoritm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
//        deck.sort(sortingAlgoritm);
//        Collections.sort(deck, Comparator.comparingInt(Card::rank));
        Collections.sort(deck, sortingAlgoritm);
        Card.printDesk(deck, "Sorted Deck Of Cards", 13);

        Collections.reverse(deck);
        Card.printDesk(deck, "Reversed Deck Of Cards", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDesk(kings, "Kings in Deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDesk(tens, "Tens in Deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, deck.subList(16, 20));
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(deck.subList(16, 20)));

        // The next method I want to look at is, the disjoint method.
        // This method returns true if the two lists have no elements in common.

        boolean disjoint = Collections.disjoint(deck, deck.subList(16, 20));
        System.out.println("disjoint = " + disjoint); // false

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint2); // true







    }
}
