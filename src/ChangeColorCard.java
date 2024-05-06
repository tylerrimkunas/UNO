public class ChangeColorCard extends ActionCard{
    protected colors fake_color;
    public ChangeColorCard(colors color, values value) {
        super(color, value);
        fake_color = null;
    }

    @Override
    public String doAction(Game g) {
        fake_color = g.changeColor();
        return "The color is now " + fake_color + "\n";
    }

    @Override
    public colors getColor() {
        return fake_color;
    }

}
