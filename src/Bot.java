import java.util.ArrayList;

public class Bot extends Player{
    public Bot(String name, ArrayList<Card> cards) {
        super(name, cards);
    }

    @Override
    public String getTurnInfo() {
        return name + ": Thinking of its move";
    }

    @Override
    public Card askForCard(Card last_Card) {
        for(Card c: cards) {
            if(c.match(last_Card)) {
                cards.remove(c);
                return c;
            }
        }
        return null;
    }
}
