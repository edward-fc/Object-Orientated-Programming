// TODO: Implement the BaccaratCard class in this file
public class BaccaratCard extends Card {
    // Create a constructor that uses the contrustor of Card
    public BaccaratCard(Rank rank, Suit suit){
        // use super() to call the constructor from Card
        super(rank, suit);
    }

    // get the values of each card
    @Override
    public int value(){
        return switch (getRank().getSymbol()) {
            case 'A' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 5;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case 'K', 'Q', 'J', 'T' -> 0;
            default -> throw new IllegalArgumentException("uknown card symbol");
        };
    }
}