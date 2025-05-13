public class Dealer{
    private int value;
    private boolean stood;
    private int hidden;
    
    public Dealer() {
        value = 0;
        stood = false;

        int c1 = _hit();
        hidden = _hit();
        System.out.printf("Dealer drew %s and one hidden card\n", Deck.getCard(c1));

        value += c1;
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

    public void reveal() {
        System.out.printf("Dealer\'s hidden card was %s\n", Deck.getCard(hidden));
        value += hidden;
    }

    public void stand() {
        stood = true;
        System.out.printf("Dealer Stood. Current hand at %d\n", value);
    }

    public int getValue() {
        return value;
    }

    public boolean isStood() {
        return stood;
    }
}
