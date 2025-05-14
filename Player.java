public class Player {
    protected int value;
    protected boolean stood;
    
    public Player() {
        value = 0;
        stood = false;
    }

    public void initialDraw() {
        String c1 = initialHit();
        String c2 = initialHit();

        System.out.printf("Player drew %s and %s\n", c1, c2);
    }

    // hit without any standard output
    protected String initialHit() {
        int v = Deck.draw();
        if (v == 1) {
            if (value <= 10) {
                value += 11;
            } else {
                value += 1;
            }
        } else if (v > 10) {
            value += 10;
        }
        else {
            value += v;
        }
        return Deck.getCard(v);
    }

    // verbose hit for use outside of the class
    public void hit() {
        int v = Deck.draw();
        if (v == 1) {
            if (value <= 10) {
                value += 11;
                System.out.printf("Player Hit Ace. Current hand at %d\n", value);
            } else {
                value += 1;
                System.out.printf("Player Hit Ace. Current hand at %d\n", value);
            }
        } else if (v > 10) {
            value += 10;
            System.out.printf("Player Hit %s. Current hand at %d\n", Deck.getCard(v), value);
        }
        else {
            value += v; 
            System.out.printf("Player Hit %s. Current hand at %d\n", Deck.getCard(v), value);
        }
    }

    public void stand() {
        stood = true;
        System.out.printf("Player Stood. Current hand at %d\n", value);
    }

    public int getValue() {
        return value;
    }

    public boolean isStood() {
        return stood;
    }
}
