package IntroductionToCollections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandartDeck();
        Card.printDesk(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDesk(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        // This method is meant to fill a list with a specific element, but it requires the list to have elements already
        // in it (i.e., the list size must be greater than 0). Since the cards list is empty, Collections.fill doesn't add
        // anything. It just silently does nothing because there's nothing to fill.
        Collections.addAll(cards, aceOfHearts);
        Card aceOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'A');
        Collections.fill(cards, aceOfClubs);
//        Collections.fill(cards, deck); // ERROR HERE
// The Collections.fill() method in Java can only accept one item to fill a list, not a list or array.
// This method works by replacing every element of the specified list with the single object provided as the second parameter.
        System.out.println(cards); // []
        System.out.println("cards.size() = " + cards.size()); // cards.size() = 0

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDesk(acesOfHearts, "nCopies Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDesk(kingsOfClubs, "Kings of Clubs", 1);


        Collections.addAll(cards, cardArray); // accepts an array of items or one item
//        Card.printDesk(cards, "Card Collection with Aces added", 1);
        // Collections.addAll works because cardArray is an array, treated as individual elements, it will not work with a list.
        // Like List, the Collections class includes an addAll method. It's first argument is the list I want
        // to add elements to. The second argument is for the elements to be added, but unlike list's addAll method,
        // this is a variable argument of elements to be added.

//        cards.addAll(cardArray);
        // This code doesn't compile, because you can't pass an array to the addAll method on List.
        // You can pass a collection, or another list, which is why you'll often see me using List.of, or Array.asList,
        // as part of that method.

        Collections.copy(cards, kingsOfClubs);
        // You can't use this copy method if the number of elements in your current list, is less
        // than the number of elements in the source list
        Card.printDesk(cards, "Card Collection with Kings copied", 1);
        System.out.println(cards.size());

        Collections.addAll(cards, cardArray);
        Collections.copy(cards, kingsOfClubs);
        // What happens if my destination has more elements than the source?
        // You can see it only copied over 13 elements, replacing the first 13 aces with kings.
        // !!! What I want you to understand here is that this method, copies elements from one list to another,
        // it doesn't return a copy of your list.
        Card.printDesk(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        // If you want a full list copy, you'd use the List.copyOf method
        // This method is a true copy, though it's important to remember that
        // this method returns an unmodifiable list. If you needed a modifiable copy of the list, you'd
        // make a call to the copyOf method, and pass it to a List constructor, or use addAll for example.
        Card.printDesk(cards, "List copy of kings", 1);







    }
}
