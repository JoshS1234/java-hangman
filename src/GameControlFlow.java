import java.util.Arrays;

public class GameControlFlow {
    protected String wordToGuess;
    protected String currentWord;
    protected int lives;

    WordUtils wordUtils = new WordUtils();
    PlayerMessages playerMessages = new PlayerMessages();


    public GameControlFlow() {
        this.wordToGuess = wordUtils.chooseRandomWord();
        this.currentWord = "";
        for(int i=0; i<this.wordToGuess.length(); i++) {
            this.currentWord = this.currentWord + "_";
            System.out.println(this.currentWord);
        }
        this.lives=9;
    }


    public void playGame() {
        String playerResponse = playerMessages.startGame();
        if (playerResponse.equals("y")) {
            stateInfo();
            playerGuess();
        } else {
            System.out.println("See you later!");
        }
    }

    public void stateInfo() {
        System.out.println("you have " + this.lives + " lives left");
        System.out.println("You have already guessed letters: " + Arrays.toString(wordUtils.lettersGuessed));
        System.out.println("the current word is: ");
        System.out.println(this.currentWord);
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
    }






}
