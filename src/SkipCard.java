public class SkipCard extends ActionCard {
    public SkipCard(colors color, values value) {
        super(color, value);
    }

    @Override
    public String doAction(Game g) {
        g.next();
        return "The next player has been skipped";
    }
}
