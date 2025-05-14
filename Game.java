import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Initialize Deck
        Deck.init();

        Scanner in = new Scanner(System.in);

        // create dealer and player
        Dealer dealer = new Dealer();
        Player player = new Player();

        // start dealing hands for the player
        while (!player.isStood()) {
            // return if player busts, break loop if player hand at 21 in case dealer also gets 21
            if (player.getValue() > 21) {
                System.out.printf("Player bust\n");
                printScores(dealer, player);
                System.out.printf("Dealer wins!\n");
                return;
            } else if (player.getValue() == 21) {
                player.stand();
                break;
            }

            // Ask player if they want to hit or stand and take input
            printScores(dealer, player);
            System.out.printf("Hit(h) or Stand(s)?\n");
            String i = in.nextLine();

            // Hit or stand according to input
            if (i.equals("h")) {
                player.hit();
                continue;
            } else if (i.equals("s")) {
                player.stand();
                break;
            }
        }
        
        // reveal the hidden card
        dealer.reveal();
        printScores(dealer, player);

        // start dealing hands for the Dealer
        while (!dealer.isStood()) {
            if (dealer.getValue() > 21) {
                System.out.printf("Dealer bust\n");
                System.out.printf("Player wins!\n");
                return;
            }

            if (dealer.getValue() >= 17 && player.getValue() != 21) {
                dealer.stand();
                break;
            } else {
                dealer.hit();
                printScores(dealer, player);
                continue;
            }
        }

        // Once all have stood, check values and declare the winner
        System.out.println("Both Player and Dealer have stood.");
        if (dealer.getValue() == player.getValue()) {
            System.out.printf("Push, Both Player and Dealer have 21.\n");
            return;
        }
        if (dealer.getValue() > player.getValue()) {
            printScores(dealer, player);
            System.out.printf("Dealer Wins!\n");
        }
        if (dealer.getValue() < player.getValue()) {
            printScores(dealer, player);
            System.out.printf("Player Wins!\n");
        }
    }

    // Print scores in format
    public static void printScores(Dealer dealer, Player player) {
        System.out.printf("\n\tDealer Hand\tPlayer Hand\n\t%d\t\t%d\n\n", dealer.getValue(), player.getValue());
    }
}
