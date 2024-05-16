public class TwoPlayerGame {

    protected int lives;
    protected boolean hasLost;
    protected boolean hasWon;

    WordUtils wordUtils;

    public TwoPlayerGame() {
        this.lives=9;
        this.hasLost=false;
        this.hasWon=false;
    }

    public void beginTwoPlayerGame() {
        String[] playerNames = PlayerMessages.getPlayerNames();
        String player1Name = playerNames[0];
        String player2Name = playerNames[1];
        String player1Word = PlayerMessages.getPlayerWord(player1Name, player2Name);
        wordUtils = new WordUtils(2, player1Word);
        while (!this.hasWon && !this.hasLost) {
            PlayerMessages.stateInfo(this.lives, wordUtils.lettersGuessed, wordUtils.currentWord);
            playerGuess();
        }
        System.out.println("The word was: " + wordUtils.wordToGuess);
        if (this.hasWon) {
            System.out.println(PlayerMessages.hangmanImage(this.lives));
            System.out.println(player2Name + " wins! Better luck next time " + player1Name);
        }
        if (hasLost) {
            System.out.println(PlayerMessages.hangmanImage(this.lives));
            System.out.println(player1Name + " wins! Better luck next time " + player2Name);
        }

    }

    public void playerGuess() {
        String letterToCheck=PlayerMessages.playerGuess();
        if(wordUtils.letterHasBeenGuessed(letterToCheck)) {
            System.out.println("This letter has already been guessed");
        }

        while(wordUtils.letterHasBeenGuessed(letterToCheck)) {
            letterToCheck=PlayerMessages.playerGuess();
            if(wordUtils.letterHasBeenGuessed(letterToCheck)) {
                System.out.println("This letter has already been guessed");
            }
        }
        System.out.println("your guess was: " + letterToCheck);
        wordUtils.addLetterToGuessedList(letterToCheck);
        if(!wordUtils.checkIfLetterIsInWordAndUpdateCurrWord(letterToCheck)) {
            this.lives=this.lives-1;
            System.out.println("\nThis was not in the word!");
        } else {
            System.out.println("\nThis was in the word!");
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
}
