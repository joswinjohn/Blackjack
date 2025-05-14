public class Dealer extends Player {
    private int hidden;
    
    public Dealer() {
        super();
        hidden = 0;
    }

    public void initialDraw() {
        String c1 = super.initialHit();
        hidden = Deck.draw();
        
        System.out.printf("Dealer drew %s and one hidden card\n", c1);
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
        if (hidden == 1) {
            if (value <= 10) {
                value += 11;
            } else {
                value += 1;
            }
        } else if (hidden > 10) {
            value += 10;
        }
        else {
            value += hidden;
        }
        System.out.printf("Dealer\'s hidden card was %s\n", Deck.getCard(hidden));
    }

    public void stand() {
        stood = true;
        System.out.printf("Dealer Stood. Current hand at %d\n", value);
    }
}
