public abstract class ActionCard extends Card{
    public ActionCard(colors color, values value) {
        super(color, value);
    }

    public abstract String doAction(Game g);
}
