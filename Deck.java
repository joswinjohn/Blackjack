import java.util.ArrayList;

public class Deck {
    private static ArrayList<Integer> deck;
    private static String[] map;

    public static void init() {
        deck = new ArrayList<Integer>();
        map = new String[] {"", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

        for (int i = 1; i <= 13; i++) {
            deck.add(i);
            deck.add(i);
            deck.add(i);
            deck.add(i);
        }
    }
    
    public static int draw() {
        int i = (int)(Math.random() * deck.size());
        return deck.remove(i);
    }

    public static String getCard(int i) {
        return map[i];
    }
}
