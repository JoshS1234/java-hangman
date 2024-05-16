import java.util.ArrayList;

public class WordUtils {
    protected String[] wordArrHard = {"cryptocurrency", "juxtaposition", "quizzical", "phlegm", "sphinx", "vexing", "zephyr", "pizzazz", "Pneumonoultramicroscopicsilicovolcanoconiosis", "frazzled", "lymph"};
    protected String[] wordArrMedium = {"ghost", "cheeky", "celebrity", "database", "javascript", "typescript"};
    protected String[] wordArrEasy = {"shirt", "smile", "eggs", "apple", "whale", "spoon", "cheese"};
    protected String chosenWord;
    protected ArrayList<String> lettersGuessed = new ArrayList<>() {
    };
    protected String wordToGuess;
    protected String currentWord;

    public WordUtils(String difficulty) {
        switch (difficulty) {
            case "easy":
                this.wordToGuess = chooseRandomWord(wordArrEasy);
                break;
            case "medium":
                this.wordToGuess = chooseRandomWord(wordArrMedium);
                break;
            case "hard":
                this.wordToGuess = chooseRandomWord(wordArrHard);
                break;
            default:
                System.out.println("Error!");
                this.wordToGuess = chooseRandomWord(wordArrEasy);
                break;
        }
        this.currentWord = "";
        for (int i = 0; i < this.chosenWord.length(); i++) {
            this.currentWord = this.currentWord + "_";
        }
    }

    public String[] getWordArrHard() {
        return wordArrHard;
    }

    public void setWordArrHard(String[] wordArrHard) {
        this.wordArrHard = wordArrHard;
    }

    public String getChosenWord() {
        return chosenWord;
    }

    public void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord;
    }

    public String chooseRandomWord(String[] wordArr) {
        this.chosenWord = wordArr[(int) Math.floor(Math.random() * wordArr.length)];
        return this.chosenWord;
    }

    public boolean letterHasBeenGuessed(String letter) {
        for (String s : lettersGuessed) {
            if (s.equals(letter)) {
                return true;
            }
        }
        return false;
    }

    public void addLetterToGuessedList(String letter) {
        lettersGuessed.add(letter);
    }

    public boolean checkIfLetterIsInWordAndUpdateCurrWord(String letter) {
        String[] letterArr = chosenWord.split("");
        String[] blankedLetterArr = currentWord.split("");
        boolean match = false;
        for (int i = 0; i < letterArr.length; i++) {
            if (letterArr[i].equals(letter)) {
                blankedLetterArr[i] = letter;
                match = true;
            }
        }
        if (match) {
            String rejoinedCurrentWord = "";
            for (int i = 0; i < blankedLetterArr.length; i++) {
                rejoinedCurrentWord = rejoinedCurrentWord + blankedLetterArr[i];
            }
            this.currentWord = rejoinedCurrentWord;
            return true;
        } else {
            return false;
        }
    }



    public boolean checkCurrWordFull() {
        String[] currentWordArr = currentWord.split("");
        for (String s : currentWordArr) {
            if (s.equals("_")) {
                return false;
            }
        }
        return true;
    }


}
