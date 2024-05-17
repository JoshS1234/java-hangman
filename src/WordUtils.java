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
        String[] wordArrHard = {"cryptocurrency", "juxtaposition", "quizzical", "phlegm", "sphinx", "vexing", "zephyr", "pizzazz", "Pneumonoultramicroscopicsilicovolcanoconiosis", "frazzled", "lymph"};
        String[] wordArrMedium = {"ghost", "cheeky", "celebrity", "database", "javascript", "typescript"};
        String[] wordArrEasy = {"shirt", "smile", "eggs", "apple", "whale", "spoon", "cheese"};
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
