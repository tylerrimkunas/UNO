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
    public int getCardAmount() {
        return cards.size();
    }
    public abstract String getTurnInfo();
    public abstract Card askForCard(Card last_Card);
    public void addCard(Card new_card) {
        cards.add(new_card);
    }

    public abstract colors askForColor();
}
