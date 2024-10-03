// TODO: Implement the Shoe class in this file

import java.util.Collections;
import java.util.Random;
import java.util.List;


public class Shoe {
    private CardCollection cards;
    private Random random;

    // initialize with a specific number of decks
    public Shoe(int numberOfDecks){
        if (numberOfDecks != 6 && numberOfDecks != 8){
            throw new CardException("Invalid number of decks");
        }
        cards = new ConcreteCardCollection();
        for (int i = 0; i < numberOfDecks; i++) {
            addDeck();
        }
    }
    // add a Deck to the SHoe
    public void addDeck(){
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new BaccaratCard(rank, suit));
            }
        }
    }
    // get the size of the Shoe
    public int size(){
        return cards.size();
    }
    // shuffle the Shoe
    public void shuffle() {
        Collections.shuffle(cards.cards); // Assuming CardCollection exposes a method getCards() that returns a List<Card>
    }
    // Extract a BaccaratCard and remove from the pack
    public BaccaratCard deal() throws CardException {
        if (cards.isEmpty()) {
            throw new CardException("No card in the deck");
        }

        CardCollection dealtCard = new ConcreteCardCollection();
        dealtCard.add(cards.cards.getFirst());
        cards.cards.removeFirst();
        return (BaccaratCard) dealtCard.cards.getFirst();
    }
}