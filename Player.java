public class Player {
    private int value;
    private boolean stood;
    
    public Player() {
        value = 0;
        stood = false;

        int c1 = _hit();
        int c2 = _hit();

        value += c1 + c2;
        System.out.printf("Player drew %s and %s\n", Deck.getCard(c1), Deck.getCard(c2));
    }

    // hit without any standard output
    private int _hit() {
        int v = Deck.draw();
        if (v == 1) {
            if (value <= 10) {
                return 11;
            } else {
                return 1;
            }
        } else if (v > 10) {
            return 10;
        }
        else {
            return v; 
        }
    }

    // vebose hit for use outside of the class
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
