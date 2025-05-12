public class Game {
    public static void main(String[] args) {
        Deck.init();

        Scanner in = new Scanner(System.in);

        Dealer dealer = new Dealer();
        Player player = new Player();

        while (!(dealer.isStood() && player.isStood())) {
            System.out.println("Hit(h) or Stand(s)?");
            String i = in.next().charAt(0);

            if (i.equals("h")) {
                player.hit();
            } else if (i.equals("s")) {
                player.stand();
            } else {
                continue;
            }

            if (dealer.getValue() >= 17) {
                dealer.stand();
                System.out.printf("Dealer Stood. Current hand at $d\n", player.getValue());
            } else {
                dealer.hit();
            }

            if (player.getValue() > 21) {
                System.out.printf("Player miss! Current hand at $d\n", player.getValue());
                System.out.printf("Dealer wins with $d", dealer.getValue());
                break;
            }

            if (dealer.getValue() > 21) {
                System.out.printf("Dealer miss! Current hand at $d\n", dealer.getValue());
                System.out.printf("Player wins with $d", player.getValue());
                break;
            }
        }

        System.out.println("Both Player and Dealer have stood.");
        if (dealer.getValue() > player.getValue()) {
            System.out.printf("Dealer wins with $d", dealer.getValue());
        } else if (dealer.getValue() < player.getValue()) {
            System.out.printf("Player wins with $d", player.getValue());
        } else {
            System.out.println("Push.");
        }
    }
}
