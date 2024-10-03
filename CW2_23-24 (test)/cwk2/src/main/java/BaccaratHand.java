import java.util.*;

// TODO: Implement the BaccaratHand class in the file
 public class BaccaratHand {
    private CardCollection hand;

    // initialize the hand as empty CardCollection
    public BaccaratHand() {
        this.hand = new ConcreteCardCollection();
        }
    // add BaccaratCard to the BaccaratHand
    public void add(BaccaratCard card){
        hand.add(card);
    }
    // get the size of the BaccaratHand
    public int size(){
        return hand.size();
    }
    // get the total value of the BaccaratHand
    public int value() {
        int sum = 0;
        for (Card card : hand.cards){
            sum += card.value();
        }
        while (sum >= 10){
            sum -= 10;
        }
        return sum;
    }
    public boolean isNatural(){
        return (size() == 2 && (value() == 8 || value() == 9));
    }
    // Get BaccaratCard under string form
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Card card : hand.cards){
            str.append(card.toString()).append(" ");
        }
        return str.toString().trim();
    }
}