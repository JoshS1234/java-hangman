import java.util.regex.Pattern;

public class TwoPlayerMessages extends PlayerMessages {

    public static String[] getPlayerNames() {
        String player1Name = "";
        Pattern pattern1 = Pattern.compile("^[a-zA-Z]+$");
        while (!pattern1.matcher(player1Name).matches()) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|  Player 1 (chooses the word), what is your name? (alphabet characters only) |");
            System.out.println("-------------------------------------------------------------------------------");

            player1Name = myScanner.nextLine();
            if (!pattern1.matcher(player1Name).matches()) {
                System.out.println("this is not a valid name, must be 1 word with only alphabet characters");
            }
        }

        String player2Name = "";
        Pattern pattern2 = Pattern.compile("^[a-zA-Z]+$");
        while (!pattern2.matcher(player2Name).matches()) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|  Player 2 (guesses the word), what is your name? (alphabet characters only) |");
            System.out.println("-------------------------------------------------------------------------------");

            player2Name = myScanner.nextLine();
            if (!pattern2.matcher(player2Name).matches()) {
                System.out.println("this is not a valid name, must be 1 word with only alphabet characters");
            }
        }

        return new String[]{player1Name, player2Name};
    }

    public static String getPlayerWord(String player1Name, String player2Name) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("OK " + player1Name + ", you will now choose your word.");
        System.out.println("Make sure " + player2Name + " can't see the screen!");
        System.out.println("-------------------------------------------------------------------------------");


        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        String player1Word = "";
        while (!pattern.matcher(player1Word).matches()) {
            System.out.println(player1Name + ", please enter your word (alphabet characters only, no spaces): ");
            player1Word = myScanner.nextLine().toLowerCase();
            if (!pattern.matcher(player1Word).matches()) {
                System.out.println("this is not a valid word, must be 1 word with only alphabet characters");
            }
        }

        return player1Word;
    }

}
