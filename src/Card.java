public class Card {
    public final colors color;
    public final values value;
    public Card(colors color, values value) {
        this.color = color;
        this.value = value;
    }
    public boolean match(Card other) {
        return this.color == other.color || this.value == other.value;
    }
    public String toString() {
        return color + " " + value;
    }
}
