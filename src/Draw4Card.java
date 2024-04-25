public class Draw4Card extends ChangeColorCard{
    public Draw4Card(colors color, values value) {
        super(color, value);
    }
    public String doAction(Game g) {
        StringBuilder s = new StringBuilder();
        s.append(super.doAction(g));
        g.draw(4);
        g.next();
        s.append("The next player draws 4 cards and gets skipped\n");
        return s.toString();
    }
}
