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
                   else if(v.compareTo(values.NINE) >= 0) { //NUMBERED CARDS
                       for(int i = 0; i < 2; i++) {
                           deck.push(new Card(c, v));
                       }
                   }
                   else { //COLORED ACTION CARDS
                       for(int i = 0; i < 2; i++) {
                           deck.push(new Card(c, v)); //TODO: make actionCard class
                       }
                   }
               }
           }
           else { // WILD CARDS
               for(int i = 0; i < 4; i++) { //4 WILD CARDS EACH
                   deck.push(new Card(c, values.WILD)); //TODO: make an actionCard class
                   deck.push(new Card(c, values.WILD_DRAW_4));
               }
           }
        }

        Collections.shuffle(deck); // SHUFFLE FOR RANDOMNESS
        discard.push(deck.pop()); // PLACE STARTING CARD

    }
    public boolean isEmpty() {
        return deck.isEmpty();
    }
    public void reshuffle() {
        Collections.shuffle(discard);
        deck = discard;
        discard = new Stack<>();
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
        for(int i = 0; i < 5; i++) {
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
