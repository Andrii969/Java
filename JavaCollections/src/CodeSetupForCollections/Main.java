package CodeSetupForCollections;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Card card = new Card(Card.Suit.CLUB, "Q", 10);
        System.out.println(card);

        List<Card> deck = Card.getStandartDeck();
        Card.printDesk(deck);

        deck.sort(Comparator.comparing(Card::rank));
        Card.printDesk(deck, "current desk", 13);



    }
}
