import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class PlayerMessages {

    static Scanner myScanner = new Scanner(System.in);
    static String[] hangmanImageArray = {"\n\n\n\n\n\n\n","\n\n\n\n\n\n\n=========", "      +\n      |\n      |\n      |\n      |\n      |\n=========","  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========","  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========","  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========","  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========","  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="};

    public static String startGame() {
        System.out.println("Would you like to start a game? (y/n)");
        String startGameResponse = "";
        while(!startGameResponse.equalsIgnoreCase("y") && !startGameResponse.equalsIgnoreCase("n")) {
            startGameResponse = myScanner.nextLine().toLowerCase();
            if(!startGameResponse.equals("y") && !startGameResponse.equals("n")) {
                System.out.println("This was not understood, you need to press 'y' or 'n'. Please try again.");
            }
        }
        return startGameResponse;
    }

    public static String pickDifficulty() {
        System.out.println("What difficulty would you like to play? (type easy/medium/hard to select)");
        String difficultyResponse = "";
        while(!difficultyResponse.equalsIgnoreCase("easy") && !difficultyResponse.equalsIgnoreCase("medium") && !difficultyResponse.equalsIgnoreCase("hard")) {
            difficultyResponse = myScanner.nextLine().toLowerCase();
            if(!difficultyResponse.equals("easy") && !difficultyResponse.equals("medium") && !difficultyResponse.equals("hard")) {
                System.out.println("This was not understood, you need to type 'easy', 'medium' or 'hard'. Please try again.");
            }
        }
        return difficultyResponse;
    }

    public static String playerGuess() {
        String letterGuess = "";
        Pattern pattern = Pattern.compile("^[a-z]$");

        while (!pattern.matcher(letterGuess).matches()) {
            System.out.println("Guess a letter: ");
            letterGuess = myScanner.nextLine().toLowerCase();
            if(!pattern.matcher(letterGuess).matches()) {
                System.out.println("this is not a valid letter to guess");
            }
        }
        return letterGuess;
    }

    public static String hangmanImage(int lives) {
        return hangmanImageArray[PlayerMessages.hangmanImageArray.length-lives-1];
    }

    public static void stateInfo(int lives, ArrayList<String> lettersGuessed, String currentWord) {
        System.out.println("\n");
        System.out.println(hangmanImage(lives));
        System.out.println("you have " + lives + " lives left. " + "You have already guessed letters: " + lettersGuessed);
        System.out.println("the current word is: " + currentWord);
    }


}
