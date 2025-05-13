import java.util.HashMap;
import java.util.ArrayList;

public class Deck {
    private static ArrayList<Integer> deck;
    private static HashMap<Integer, String> map;

    public static void init() {
        deck = new ArrayList<Integer>();
        map = new HashMap<Integer, String>();

        for (int i = 1; i <= 13; i++) {
            deck.add(i);
            deck.add(i);
            deck.add(i);
            deck.add(i);
        }

        map.put(1, "Ace");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Jack");
        map.put(12, "Queen");
        map.put(13, "King");
    }
    
    public static int draw() {
        int i = (int)(Math.random() * deck.size());
        return deck.remove(i);
    }

    public static String getCard(int i) {
        return map.get(i);
    }
}
