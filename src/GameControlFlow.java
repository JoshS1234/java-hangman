import java.util.Arrays;
import java.util.regex.Pattern;

public class GameControlFlow {


    SinglePlayerGame singlePlayerGame;
    TwoPlayerGame twoPlayerGame;

    public void playGame() {
        String playerResponse = PlayerMessages.startGame();
        if (playerResponse.equals("y")) {
            String playerNumber = PlayerMessages.pickPlayerNumber();
            if (playerNumber.equals("1")) {
                singlePlayerGame = new SinglePlayerGame();
                singlePlayerGame.beginGame();
            } else {
                System.out.println("requested a 2 player game");
                twoPlayerGame = new TwoPlayerGame();
                twoPlayerGame.beginGame();
            }
            resetGame();
        } else {
            System.out.println("See you later!");
        }
    }


    public void resetGame() {
        playGame();
    }






}
