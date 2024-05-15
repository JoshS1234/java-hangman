import java.util.Scanner;
import java.util.regex.*;

public class PlayerMessages {

    Scanner myScanner = new Scanner(System.in);

    public String startGame() {
        System.out.println("Would you like to start a game? (y/n) \n");
        String startGameResponse = "";
        while(!startGameResponse.equalsIgnoreCase("y") && !startGameResponse.equalsIgnoreCase("n")) {
            startGameResponse = myScanner.nextLine().toLowerCase();
            if(!startGameResponse.equals("y") && !startGameResponse.equals("n")) {
                System.out.println("This was not understood, you need to press 'y' or 'n'. Please try again.");
            }
        }

        return startGameResponse;
    }

    public String pickDifficulty() {
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

    public String playerGuess() {
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


}
