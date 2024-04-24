import java.util.ArrayList;

public class Bot extends Player{
    public Bot(String name, ArrayList<Card> cards) {
        super(name, cards);
    }

    @Override
    public String getTurnInfo() {
        return null;
    }

    @Override
    public Card askForCard(Card last_Card) {
        return null;
    }
}
