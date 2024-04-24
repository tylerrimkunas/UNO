import java.util.ArrayList;

public class Game {
    private final Player[] players;
    private Deck deck;
    private int index;
    private boolean reverse;

    public Game(String[] names) {
        players = new Player[names.length];
        deck = new Deck();
        index = 0;
        reverse = false;
        players[0] = new Human(names[0], deck.dealToPlayer());
        for(int i = 1; i < players.length; i++) {
            players[i] = new Bot(names[i], deck.dealToPlayer());
        }
    }
    public Player checkWinner() {
        if(players[index].isWinner()) {
            return players[index];
        }
        else return null;
    }
    public void next() {
        if(reverse) {
            if(--index < 0) {
                index = players.length - 1;
            }
        }
        else {
            if(++index >= players.length) {
                index = 0;
            }
        }
    }
    public String getInfo() {
        StringBuilder s = new StringBuilder();
        Player current_player = players[index];
        s.append(current_player.name).append("'s turn.\n");
        for(Player p: players) {
            s.append(p.name).append(": ").append(p.getCardAmount()).append(" Cards.\n");
        }
        s.append("Last Card: ").append(deck.getLastCard()).append("\n");
        s.append(current_player.getTurnInfo());
        return s.toString();
    }
}
