public class SinglePlayerGame extends Game {

    @Override
    public void beginGame() {
        String difficultyChoice = SinglePlayerMessages.pickDifficulty();
        switch (difficultyChoice) {
            case "easy":
                wordUtils = new WordUtils("easy");
                break;
            case "medium":
                wordUtils = new WordUtils("medium");
                break;
            case "hard":
                wordUtils = new WordUtils("hard");
                break;
            default:
                System.out.println("Error!");
                wordUtils = new WordUtils("easy");
                break;
        }
        while (!this.hasWon && !this.hasLost) {
            PlayerMessages.stateInfo(this.lives, wordUtils.getLettersGuessed(), wordUtils.getCurrentWord());
            playerGuess();
        }
        System.out.println("The word was: " + wordUtils.getWordToGuess());
        if (this.hasWon) {
            System.out.println(PlayerMessages.hangmanImage(this.lives));
            System.out.println("\nYou win!");
        }
        if (hasLost) {
            System.out.println(PlayerMessages.hangmanImage(this.lives));
            System.out.println("\nYou lose!");
        }
    }


}
