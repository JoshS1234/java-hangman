import java.util.Arrays;
import java.util.regex.Pattern;

public class GameControlFlow {
    protected int lives;
    protected boolean hasWon;
    protected boolean hasLost;

    WordUtils wordUtils = new WordUtils();
    PlayerMessages playerMessages = new PlayerMessages();


    public GameControlFlow() {
        this.lives=9;
        this.hasLost=false;
        this.hasWon=false;
    }


    public void playGame() {
        String playerResponse = playerMessages.startGame();
        if (playerResponse.equals("y")) {
            while (!hasWon && !hasLost) {
                stateInfo();
                playerGuess();
            }
            if (hasWon) {
                System.out.println("You win!");
            }
            if (hasLost) {
                System.out.println("You lose!");
            }
            System.out.println("The word was: " + wordUtils.wordToGuess);
            resetGame();
        } else {
            System.out.println("See you later!");
        }
    }

    public void stateInfo() {
        System.out.println("you have " + this.lives + " lives left");
        System.out.println("You have already guessed letters: " + Arrays.toString(wordUtils.lettersGuessed));
        System.out.println("the current word is: ");
        System.out.println(wordUtils.currentWord);
    }

    public void playerGuess() {
        String letterToCheck=playerMessages.playerGuess();
        if(wordUtils.letterHasBeenGuessed(letterToCheck)) {
            System.out.println("This letter has already been guessed");
        }

        while(wordUtils.letterHasBeenGuessed(letterToCheck)) {
            letterToCheck=playerMessages.playerGuess();
            if(wordUtils.letterHasBeenGuessed(letterToCheck)) {
                System.out.println("This letter has already been guessed");
            }
        }
        System.out.println("your guess was: " + letterToCheck);
        wordUtils.addLetterToGuessedList(letterToCheck);
        //Check if letter is in word and update lives
        if(!wordUtils.checkIfLetterIsInWordAndUpdateCurrWord(letterToCheck)) {
            //UPDATE LIVES COUNT
            //UPDATE THE WORD WITH UNDERLINES
            this.lives=this.lives-1;
        }
        //CHECK IF WON OR LOST (lives=0, word is full)
        this.hasWon=checkWin();
        this.hasLost=checkLose();

    }

    public boolean checkLose() {
        return this.lives==0;
    }

    public boolean checkWin() {
        return wordUtils.checkCurrWordFull();
    }

    public void resetGame() {
        wordUtils = new WordUtils();
        playGame();
    }






}
