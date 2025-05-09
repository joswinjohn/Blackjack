public class Dealer {
    private int hand;

    public static int draw() {
        int v = (int)(Math.random() * 10) + 2;
        if (v == 11) {
            if (hand + 11 <= 21) {
                return 11;
            } else {
                return 1;
            }
        }
               
        if () {

        }
    }
}
