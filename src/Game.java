public class Game {
    protected int lives;
    protected boolean hasLost;
    protected boolean hasWon;

    WordUtils wordUtils;


    public Game() {
        this.lives = 9;
        this.hasLost = false;
        this.hasWon = false;
    }

    public void beginGame() {
        System.out.println("This is the begin game method, it will be overridden by single/two player games");
    }

    public void playerGuess() {
        String letterToCheck = PlayerMessages.playerGuess();
        if (wordUtils.letterHasBeenGuessed(letterToCheck)) {
            System.out.println("This letter has already been guessed");
        }

        while (wordUtils.letterHasBeenGuessed(letterToCheck)) {
            letterToCheck = PlayerMessages.playerGuess();
            if (wordUtils.letterHasBeenGuessed(letterToCheck)) {
                System.out.println("This letter has already been guessed");
            }
        }
        System.out.println("your guess was: " + letterToCheck);
        wordUtils.addLetterToGuessedList(letterToCheck);
        if (!wordUtils.checkIfLetterIsInWordAndUpdateCurrWord(letterToCheck)) {
            this.lives = this.lives - 1;
            System.out.println("\nThis was not in the word!");
        } else {
            System.out.println("\nThis was in the word!");
        }

        //CHECK IF WON OR LOST (lives=0, word is full)
        this.hasWon = checkWin();
        this.hasLost = checkLose();
    }

    private boolean checkLose() {
        return this.lives == 0;
    }

    private boolean checkWin() {
        return wordUtils.checkCurrWordFull();
    }

}
