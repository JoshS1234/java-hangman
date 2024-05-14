import java.util.Arrays;

public class WordUtils {
    protected String[] wordArr={"cat", "frog"};
    protected String chosenWord;
    protected String[] lettersGuessed = {"a"};

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
        newArray[lettersGuessed.length + 1] = letter;
        this.lettersGuessed = newArray;
    }




}
