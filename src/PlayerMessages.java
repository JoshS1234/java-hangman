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

    public static String pickPlayerNumber() {
        System.out.println("Would you like to play with 1 or 2 players? (1/2)");
        String playerNumberResponse = "";
        while(!playerNumberResponse.equalsIgnoreCase("1") && !playerNumberResponse.equalsIgnoreCase("2")) {
            playerNumberResponse = myScanner.nextLine().toLowerCase();
            if(!playerNumberResponse.equals("1") && !playerNumberResponse.equals("2")) {
                System.out.println("This was not understood, you need to press '1' or '2'. Please try again.");
            }
        }
        return playerNumberResponse;
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
        String lifeString="";
        for (int i=0; i<lives; i++) {
            lifeString=lifeString+"\u2764";
        }

        System.out.println(hangmanImage(lives));
        System.out.println("Lives left: " + lives + " " + lifeString);
        System.out.println("You have already guessed letters: " + lettersGuessed);
        System.out.println("the current word is: " + currentWord);
    }

    public static String[] getPlayerNames(){
        String player1Name = "";
        Pattern pattern1 = Pattern.compile("^[a-zA-Z]+$");
        while (!pattern1.matcher(player1Name).matches()) {
            System.out.println("Player 1 (chooses the word), what is your name? (alphabet characters only)");
            player1Name = myScanner.nextLine();
            if(!pattern1.matcher(player1Name).matches()) {
                System.out.println("this is not a valid name, must be 1 word with only alphabet characters");
            }
        }

        String player2Name = "";
        Pattern pattern2 = Pattern.compile("^[a-zA-Z]+$");
        while (!pattern2.matcher(player2Name).matches()) {
            System.out.println("Player 2 (guesses the word), what is your name? (alphabet characters only)");
            player2Name = myScanner.nextLine();
            if(!pattern2.matcher(player2Name).matches()) {
                System.out.println("this is not a valid name, must be 1 word with only alphabet characters");
            }
        }

        System.out.println("Hello " + player1Name + " and " + player2Name);
        return new String[] {player1Name, player2Name};
    }

    public static String getPlayerWord(String player1Name,String player2Name) {
        System.out.println("OK " + player1Name + ", you will now choose your word. Make sure "+player2Name+" cannot see the screen!");
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        String player1Word = "";
        while (!pattern.matcher(player1Word).matches()) {
            System.out.println(player1Name + ", please enter your word (alphabet characters only, no spaces): ");
            player1Word = myScanner.nextLine().toLowerCase();
            if(!pattern.matcher(player1Word).matches()) {
                System.out.println("this is not a valid word, must be 1 word with only alphabet characters");
            }
        }
        return player1Word;
    }


}
