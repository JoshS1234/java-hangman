public class TwoPlayerGame extends Game {

    @Override
    public void beginGame() {
        String[] playerNames = TwoPlayerMessages.getPlayerNames();
        String player1Name = playerNames[0];
        String player2Name = playerNames[1];
        String player1Word = TwoPlayerMessages.getPlayerWord(player1Name, player2Name);
        wordUtils = new WordUtils(2, player1Word);
        while (!this.hasWon && !this.hasLost) {
            PlayerMessages.stateInfo(this.lives, wordUtils.getLettersGuessed(), wordUtils.getCurrentWord());
            playerGuess();
        }
        System.out.println("The word was: " + wordUtils.getWordToGuess());
        if (this.hasWon) {
            System.out.println(PlayerMessages.hangmanImage(this.lives));
            System.out.println(player2Name + " wins! Better luck next time " + player1Name);
        }
        if (hasLost) {
            System.out.println(PlayerMessages.hangmanImage(this.lives));
            System.out.println(player1Name + " wins! Better luck next time " + player2Name);
        }
    }

}
