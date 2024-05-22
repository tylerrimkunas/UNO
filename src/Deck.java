import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck;
    private Stack<Card> discard;
    public Deck() {
        deck = new Stack<>();
        discard = new Stack<>();

        for(colors c: colors.values()) { // MAKING THE DECK
           if(c != colors.WILD) { // COLORED CARDS
               for(values v: values.values()) {
                   if(v == values.ZERO) { //ONLY ONE ZERO CARD
                       deck.push(new Card(c, v));
                   }
                   else if(v.compareTo(values.NINE) <= 0) { //NUMBERED CARDS
                       for(int i = 0; i < 2; i++) {
                           deck.push(new Card(c, v));
                       }
                   }
                   else if(v.compareTo(values.DRAW_2) <= 0){ //COLORED ACTION CARDS
                       for(int i = 0; i < 2; i++) {
                           if(v == values.DRAW_2) {
                               deck.push(new Draw2Card(c, v));
                           }
                           else if(v == values.REVERSE) {
                               deck.push(new ReverseCard(c, v));
                           }
                           else if(v == values.SKIP) {
                               deck.push(new SkipCard(c, v));
                           }
                       }
                   }
               }
           }
           else { // WILD CARDS
               for(int i = 0; i < 4; i++) { //4 WILD CARDS EACH
                   deck.push(new ChangeColorCard(c, values.CHANGE_COLOR));
                   deck.push(new Draw4Card(c, values.DRAW_4));
               }
           }
        }

        Collections.shuffle(deck); // SHUFFLE FOR RANDOMNESS
        discard.push(deck.pop()); // PLACE STARTING CARD

    }
    public void reshuffle() {
        Card last_card = discard.pop();
        Collections.shuffle(discard);
        deck = discard;
        discard = new Stack<>();
        discard.push(last_card);
    }

    public Card takeCard() {
        try {
            return deck.pop();
        } catch(EmptyStackException e) {
            this.reshuffle();
            return this.takeCard();
        }
    }

    public ArrayList<Card> dealToPlayer() {
        ArrayList<Card> cards = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            cards.add(takeCard());
        }
        return cards;
    }

    public void putCard(Card c) {
        discard.push(c);
    }

    public Card getLastCard() {
        try {
            return discard.peek();
        } catch(EmptyStackException e) {
            discard.push(deck.pop());
            return getLastCard();
        }
    }
}
