import java.util.ArrayList;

public class WordUtils {
    private ArrayList<String> lettersGuessed = new ArrayList<>() {};
    private String wordToGuess;
    private String currentWord;

    public ArrayList<String> getLettersGuessed() {
        return lettersGuessed;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public WordUtils(String difficulty) {
        final String[] WORD_ARR_HARD = {"cryptocurrency", "juxtaposition", "quizzical", "phlegm", "sphinx", "vexing", "zephyr", "pizzazz", "Pneumonoultramicroscopicsilicovolcanoconiosis", "frazzled", "lymph"};
        final String[] WORD_ARR_MEDIUM = {"ghost", "cheeky", "celebrity", "database", "javascript", "typescript"};
        final String[] WORD_ARR_EASY = {"shirt", "smile", "eggs", "apple", "whale", "spoon", "cheese"};
        switch (difficulty) {
            case "easy":
                this.wordToGuess = chooseRandomWord(WORD_ARR_EASY);
                break;
            case "medium":
                this.wordToGuess = chooseRandomWord(WORD_ARR_MEDIUM);
                break;
            case "hard":
                this.wordToGuess = chooseRandomWord(WORD_ARR_HARD);
                break;
            default:
                System.out.println("Error!");
                this.wordToGuess = chooseRandomWord(WORD_ARR_EASY);
                break;
        }
        this.currentWord = "";
        for (int i = 0; i < this.wordToGuess.length(); i++) {
            this.currentWord = this.currentWord + "_";
        }
    }

    public WordUtils(int players, String wordToGuess) {
        this.wordToGuess = wordToGuess;
        this.currentWord = "";
        for (int i = 0; i < this.wordToGuess.length(); i++) {
            this.currentWord = this.currentWord + "_";
        }
    }

    public String chooseRandomWord(String[] wordArr) {
        return wordArr[(int) Math.floor(Math.random() * wordArr.length)];
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
        String[] letterArr = this.wordToGuess.split("");
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
            for (String s : blankedLetterArr) {
                rejoinedCurrentWord = rejoinedCurrentWord + s;
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
