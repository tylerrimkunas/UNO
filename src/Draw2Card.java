public class Draw2Card extends ActionCard {
    public Draw2Card(colors color, values value) {
        super(color, value);
    }

    @Override
    public String doAction(Game g) {
        g.draw(2);
        g.next();
        return "The next player draws 2 cards and gets skipped\n";
    }
}
