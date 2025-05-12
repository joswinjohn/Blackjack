public class Player {
    private int value;
    private boolean stood;
    
    public Player() {
        value = 0;
        stood = false;

        value += Deck.draw("Player");
        value += Deck.draw("Player");
    }

    public void hit() {
        int v = Deck.draw("Player");
        if (v == 1) {
            if (value <= 10) {
                value += 11;
                System.out.printf("Player Hit %d. Current hand at $d\n", 11, value);
            }
            else {
                value += 1;
                System.out.printf("Player Hit %d. Current hand at $d\n", 1, value);
            }
        }
        else {
            value += v; 
            System.out.printf("Player Hit %d. Current hand at $d\n", v, value);
        }
    }

    public boolean stand() {
        stood = true;
        System.out.printf("Player Stood. Current hand at $d\n", value);
    }

    public int getValue() {
        return value;
    }

    public boolean isStood() {
        return stood;
    }
}
