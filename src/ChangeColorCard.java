public class ChangeColorCard extends ActionCard{
    public ChangeColorCard(colors color, values value) {
        super(color, value);
    }

    @Override
    public String doAction(Game g) {
        color = g.changeColor();
        return "The color is now " + color + "\n";
    }

}
