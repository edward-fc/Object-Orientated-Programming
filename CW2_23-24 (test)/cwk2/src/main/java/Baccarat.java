import java.util.Scanner;
public class Baccarat {
  // TODO: Implement your Baccarat simulation program here
    private static Shoe shoe;
    private static int playerWins = 0;
    private static int bankerWins = 0;
    private static int ties = 0;
    private static int rounds = 0;
    // Main Game of Baccarat
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        shoe = new Shoe(8);
        shoe.shuffle();

        while (shoe.size() >= 6) {
            playRound();
            System.out.print("Continue playing? (Y/N): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("N")) {
                break;
            }
        }

        System.out.println(getGameStats());
        scanner.close();
    }
    // play a round of Baccarat
    public static void playRound(){
        rounds++;
        System.out.println("Rounds: " + rounds);
        BaccaratHand playerHand = new BaccaratHand();
        BaccaratHand bankerHand = new BaccaratHand();

        // dealing the cards
        playerHand.add(shoe.deal());
        playerHand.add(shoe.deal());
        bankerHand.add(shoe.deal());
        bankerHand.add(shoe.deal());

        // implement rules of the game
        int playerScore = playerHand.value();
        int bankerScore = bankerHand.value();

        System.out.println("Player: " + playerHand.toString()+ " = " + playerScore);
        System.out.println("Banker: " + bankerHand.toString()+ " = " + bankerScore);
        String results;
        if ((!playerHand.isNatural() && !bankerHand.isNatural())){
            System.out.println((!playerHand.isNatural() && !bankerHand.isNatural()));
            System.out.println("Dealing third card to player and banker...");
            bankerHand.add(shoe.deal());
            bankerScore = bankerHand.value();
            playerHand.add(shoe.deal());
            playerScore = playerHand.value();
            System.out.println("Player: " + playerHand.toString()+ " = " + playerScore);
            System.out.println("Banker: " + bankerHand.toString()+ " = " + bankerScore);
        }
        else if (playerHand.isNatural() && !bankerHand.isNatural()){
            System.out.println("Dealing third card to banker...");
            bankerHand.add(shoe.deal());
            bankerScore = bankerHand.value();
            System.out.println("Player: " + playerHand.toString()+ " = " + playerScore);
            System.out.println("Banker: " + bankerHand.toString()+ " = " + bankerScore);
            }
        else if (bankerHand.isNatural() && !playerHand.isNatural()){
            System.out.println("Dealing third card to player...");
            playerHand.add(shoe.deal());
            playerScore = playerHand.value();
            System.out.println("Player: " + playerHand.toString()+ " = " + playerScore);
            System.out.println("Banker: " + bankerHand.toString()+ " = " + bankerScore);
            }
        if (playerScore > bankerScore){
            System.out.println("Player wins!");
            playerWins++;
        }
        else if (bankerScore > playerScore){
            System.out.println("Banker wins!");
            bankerWins++;
        }
        else {
            System.out.println("Tie");
            ties++;
        }

    }
    // get stats from the previous rounds
    public static String getGameStats() {
        return "Rounds Played: " + rounds + ", Player Wins: " + playerWins +
                ", Banker Wins: " + bankerWins + ", Ties: " + ties;
    }
}
