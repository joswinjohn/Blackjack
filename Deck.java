public class Deck {
    private ArrayList<Integer> deck;

    public Deck() {
         init();
    }

    public void init() {
        for (int i = 1; i <= 13; i++) {
            deck.add(i);
            deck.add(i);
            deck.add(i);
            deck.add(i);
        }
    }
    
    public int draw() {
        int i = (int)(Math.random()) * deck.size();

        return deck.remove(i);
    }
}
