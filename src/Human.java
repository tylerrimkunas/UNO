import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player{
    public Human(String name, ArrayList<Card> cards) {
        super(name, cards);
    }

    @Override
    public String getTurnInfo() {
        StringBuilder s = new StringBuilder();
        s.append("Your cards are: ");
        for(int i = 0; i < cards.size(); i++) {
            s.append(i + 1).append(". ").append(cards.get(i)).append(" ");
        }
        s.append("\n");
        s.append("Which card would you like to choose (use the number next to it or type 0 for new card): ");
        return s.toString();
    }

    @Override
    public Card askForCard(Card last_Card) {
        System.out.println(getTurnInfo());
        Scanner input = new Scanner(System.in);
        int choice;
        try {
            choice = input.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Not a number! Try again: ");
            return askForCard(last_Card);
        }
        if(choice < 0 || choice > cards.size()) {
            System.out.println("Out of range! Try again: ");
            return askForCard(last_Card);
        }
        else if(choice == 0) {
            System.out.println("You chose to pick up a card");
            return null;
        }
        else if(!cards.get(choice - 1).match(last_Card)) {
            System.out.println("This card cannot be matched with the last card");
            return askForCard(last_Card);
        }
        return cards.remove(choice - 1);
    }

    @Override
    public colors askForColor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Which color would you like(yellow, blue, green, red): ");
        String choice = input.nextLine();
        switch(choice.toLowerCase()) {
            case "yellow" -> {
                return colors.YELLOW;
            }
            case "blue" -> {
                return colors.BLUE;
            }
            case "green" -> {
                return colors.GREEN;
            }
            case "red" -> {
                return colors.RED;
            }
        }
        System.out.println("Bad input! Try again");
        return askForColor();
    }
}
