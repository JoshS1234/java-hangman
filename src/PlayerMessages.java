import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public abstract class PlayerMessages {

    static Scanner myScanner = new Scanner(System.in);
    static String[] hangmanImageArray = {"\n\n\n\n\n\n\n", "\n\n\n\n\n\n\n=========", "      +\n      |\n      |\n      |\n      |\n      |\n=========", "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========", "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="};

    public static String startGame() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                   Would you like to start a game? (y/n)                     |");
        System.out.println("-------------------------------------------------------------------------------");
        String startGameResponse = "";
        while (!startGameResponse.equalsIgnoreCase("y") && !startGameResponse.equalsIgnoreCase("n")) {
            startGameResponse = myScanner.nextLine().toLowerCase();
            if (!startGameResponse.equals("y") && !startGameResponse.equals("n")) {
                System.out.println("This was not understood, you need to press 'y' or 'n'. Please try again.");
            }
        }
        return startGameResponse;
    }

    public static String pickPlayerNumber() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|              Would you like to play with 1 or 2 players? (1/2)              |");
        System.out.println("-------------------------------------------------------------------------------");
        String playerNumberResponse = "";
        while (!playerNumberResponse.equalsIgnoreCase("1") && !playerNumberResponse.equalsIgnoreCase("2")) {
            playerNumberResponse = myScanner.nextLine().toLowerCase();
            if (!playerNumberResponse.equals("1") && !playerNumberResponse.equals("2")) {
                System.out.println("This was not understood, you need to press '1' or '2'. Please try again.");
            }
        }
        return playerNumberResponse;
    }

    public static String playerGuess() {
        String letterGuess = "";
        Pattern pattern = Pattern.compile("^[a-z]$");

        while (!pattern.matcher(letterGuess).matches()) {
            System.out.println("Guess a letter: ");
            letterGuess = myScanner.nextLine().toLowerCase();
            if (!pattern.matcher(letterGuess).matches()) {
                System.out.println("this is not a valid letter to guess");
            }
        }
        return letterGuess;
    }

    public static String hangmanImage(int lives) {
        return hangmanImageArray[PlayerMessages.hangmanImageArray.length - lives - 1];
    }

    public static void stateInfo(int lives, ArrayList<String> lettersGuessed, String currentWord) {
        String lifeString = "";
        for (int i = 0; i < lives; i++) {
            lifeString = lifeString + "❤";
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(hangmanImage(lives));
        System.out.println("Lives left: " + lives + " " + lifeString);
        System.out.println("You have already guessed letters: " + lettersGuessed);
        System.out.println("the current word is: " + currentWord);

    }

}
