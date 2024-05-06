import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println(getTurnInfo());
        for(Card c: cards) {
            if(c.match(last_Card)) {
                cards.remove(c);
                return c;
            }
        }
        return null;
    }

    @Override
    public colors askForColor() { //todo: make better
        HashMap<colors, Integer> map = new HashMap<>();
        for(Card c: cards) {
            if(c instanceof ChangeColorCard) {
                continue;
            }
            int color_count;
            try {
                color_count = map.get(c.getColor());
            }
            catch (NullPointerException e) {
                color_count = 0;
            }
            map.put(c.getColor(), color_count + 1);
        }
        Map.Entry<colors, Integer> highest = null;
        for(Map.Entry<colors, Integer> entry: map.entrySet()) {
            if(highest == null) {
                highest = entry;
            }
            else if(highest.getValue() < entry.getValue()) {
                highest = entry;
            }
        }
        assert highest != null;
        return highest.getKey();
    }
}
