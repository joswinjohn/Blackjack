import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Deck.init();

        Scanner in = new Scanner(System.in);

        Dealer dealer = new Dealer();
        Player player = new Player();

        while (!player.isStood()) {
            // return if bust, break loop if at 21 in case dealer also gets 21
            if (player.getValue() > 21) {
                System.out.printf("Player bust\n");
                printScores(dealer, player);
                System.out.printf("Dealer wins!\n");
                return;
            } else if (player.getValue() == 21) {
                player.stand();
                break;
            }

            // Ask player if they want to hit or stand if their score is under 21
            printScores(dealer, player);
            System.out.printf("Hit(h) or Stand(s)?\n");
            String i = String.valueOf(in.next().charAt(0));

            if (i.equals("h")) {
                player.hit();
                continue;
            } else if (i.equals("s")) {
                player.stand();
                break;
            } 
        }
        
        dealer.reveal();
        printScores(dealer, player);

        while (!dealer.isStood()) {
            if (dealer.getValue() > 21) {
                System.out.printf("Dealer bust\n");
                printScores(dealer, player);
                System.out.printf("Player wins!\n");
                return;
            }

            if (dealer.getValue() >= 17) {
                dealer.stand();
                break;
            } else {
                dealer.hit();
                printScores(dealer, player);
                continue;
            }
        }

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

    public static void printScores(Dealer dealer, Player player) {
        System.out.printf("\n\tDealer Hand\tPlayer Hand\n\t%d\t\t%d\n\n", dealer.getValue(), player.getValue());
    }
}
