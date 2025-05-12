public class Game {
    public static void main(String[] args) {
        Deck.deck = new ArrayList<Integer>();

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
            }

            if (player.getValue() > 21) {
                System.out.printf("Player miss! Current hand at $d\n", player.getValue());
            }

            if (dealer.getValue() > 21) {
                System.out.printf("Dealer miss! Current hand at $d\n", dealer.getValue());
            }
        }

        System.out.println("Both Player and Dealer have stood.");
        if (dealer.getValue() > player.getValue()) {
            System.out.println("Dealer wins with");
        }
    }
}
