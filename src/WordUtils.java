import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class WordUtils {
    protected String[] wordArr={"catapult", "alien"};
    protected String chosenWord;
    protected String[] lettersGuessed = {};
    protected String wordToGuess;
    protected String currentWord;

    public WordUtils() {
        this.wordToGuess = chooseRandomWord();
        this.currentWord = "";
        for(int i=0; i<this.chosenWord.length(); i++) {
            this.currentWord = this.currentWord + "_";
        }
    }

    public String[] getWordArr() {
        return wordArr;
    }

    public void setWordArr(String[] wordArr) {
        this.wordArr = wordArr;
    }

    public String getChosenWord() {
        return chosenWord;
    }

    public void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord;
    }

    public String chooseRandomWord() {
        this.chosenWord = wordArr[(int) Math.floor(Math.random()*wordArr.length)];
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
        String[] newArray = new String[lettersGuessed.length + 1];;
        for(int i=0; i<lettersGuessed.length; i++) {
            newArray[i]=lettersGuessed[i];
        }
        newArray[lettersGuessed.length] = letter;
        this.lettersGuessed = newArray;
    }

    public boolean checkIfLetterIsInWordAndUpdateCurrWord(String letter) {
        String[] letterArr = chosenWord.split("");
        String[] blankedLetterArr = currentWord.split("");
        boolean match = false;
        for(int i=0; i<letterArr.length; i++) {
            if(letterArr[i].equals(letter)) {
                blankedLetterArr[i]=letter;
                match=true;
            }
        }
        if(match) {
            String rejoinedCurrentWord="";
            for (int i=0; i<blankedLetterArr.length; i++) {
                rejoinedCurrentWord=rejoinedCurrentWord+blankedLetterArr[i];
            }
            this.currentWord = rejoinedCurrentWord;
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCurrWordFull() {
        String[] currentWordArr=currentWord.split("");
        for (String s : currentWordArr) {
            if(s.equals("_")) {
                return false;
            }
        }
        return true;
    }




}
