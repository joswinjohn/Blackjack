public class Player {
    private int value;
    private boolean stood;
    
    public Player() {
        value = 0;
        stood = false;

        value += Deck.draw();
        value += Deck.draw();
    }

    public boolean hit() {
        v = Deck.draw();
        value += v; 
        System.out.printf("Player Hit %d. Current hand at $d\n", v, value);
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
