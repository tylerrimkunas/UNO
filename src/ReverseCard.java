public class ReverseCard extends ActionCard{
    public ReverseCard(colors color, values value) {
        super(color, value);
    }

    @Override
    public String doAction(Game g) {
        g.reverse();
        return "The order is now reversed";
    }
}
