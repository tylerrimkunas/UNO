import java.util.ArrayList;
public abstract class Player {
    protected ArrayList<Card> cards;
    public final String name;

    public Player(String name, ArrayList<Card> cards) {
        this.name = name;
        this.cards = cards;
    }
    public boolean isWinner() {
        return cards.isEmpty();
    }
}
