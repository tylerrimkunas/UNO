import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to UNO.\nWhat is your name? ");
        String name = askName();

        System.out.println("How many bots will you like to play with (1-9)? ");
        int bot_num = howManyBots();

        System.out.println("Great! Making the game now");
        String[] names = generateNamesArray(name, bot_num);

        Game game = new Game(names);
        Player winner = null;
        System.out.println("Game starts now!");
        while(winner == null) {
            //game.getInfo();

            winner = game.checkWinner();
        }
    }

    public static int howManyBots() {
        Scanner input = new Scanner(System.in);
        int botNum = 0;
        while(true) {
            try {
                botNum = input.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("That is not a number! Please try again: ");
                continue;
            }
            if(botNum < 1 || botNum > 9) {
                System.out.println("That number is out of range! Please try again: ");
                continue;
            }
            break;
        }
        return botNum;
    }

    public static String askName() {
        Scanner input = new Scanner(System.in);
        String name = "";
        while(true) {
            try {
                name = input.nextLine();
            } catch(NoSuchElementException e) {
                System.out.println("You have to put something! Please try again: ");
                continue;
            }
            break;
        }
        return name;
    }

    public static String[] generateNamesArray(String human_name, int bot_num) {
        String[] names = new String[bot_num + 1];
        names[0] = human_name;
        for(int i = 1; i < names.length; i++) {
            names[i] = "Bot #" + i;
        }
        return names;
    }
}