public class Dealer extends Player {
    private int hidden;
    
    public Dealer() {
        value = 0;
        stood = false;

        int c1 = super.hitNoVerbose();
        hidden = super.hitNoVerbose();
        System.out.printf("Dealer drew %s and one hidden card\n", Deck.getCard(c1));

        value += c1;
    }

    // verbose hit for use outside of the class
    public void hit() {
        int v = Deck.draw();
        if (v == 1) {
            if (value <= 10) {
                value += 11;
                System.out.printf("Dealer Hit Ace. Current hand at %d\n", value);
            }
            else {
                value += 1;
                System.out.printf("Dealer Hit Ace. Current hand at %d\n", value);
            }
        } else if (v > 10) {
            value += 10;
            System.out.printf("Dealer Hit %s. Current hand at %d\n", Deck.getCard(v), value);
        }
        else {
            value += v; 
            System.out.printf("Dealer Hit %s. Current hand at %d\n", Deck.getCard(v), value);
        }
    }

    // reveal hidden card from inital draw
    public void reveal() {
        System.out.printf("Dealer\'s hidden card was %s\n", Deck.getCard(hidden));
        value += hidden;
    }

    public void stand() {
        stood = true;
        System.out.printf("Dealer Stood. Current hand at %d\n", value);
    }
}
