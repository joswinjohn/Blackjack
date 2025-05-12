public class Deck {
    private static ArrayList<Integer> deck;

    public static void init() {
        for (int i = 1; i <= 13; i++) {
            deck.add(i);
            deck.add(i);
            deck.add(i);
            deck.add(i);
        }
    }
    
    public static int draw() {
        int i = (int)(Math.random()) * deck.size();
        return deck.remove(i);
    }
}
