import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


// words come from https://eslforums.com/4-letter-words/

public class Wordle {

    private ArrayList<String> wordBank;
    private String[] Letter4Letter;

    public Wordle() {
        importWordList("src\\4letter.txt");
        Letter4Letter = getLetters();
    }


    private String[] getLetters() // breaks a random wor in word bank
    {
        String[] list = new String[4];
        String word = random();

        for (int i = 1; i < word.length(); i++){
            list[i] = word.substring(i - 1, i);
        }
        return list;
    }

    private String random() //gets a random word from array list
    {
        String word = wordBank.get((int) (Math.random()*(2499)+1));
        return word;
    }








    private void importWordList(String fileName) //converts file to array
    {
        /* TASK 1: IMPLEMENT ME! */
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            wordBank = new ArrayList<String>();

            while ((line = bufferedReader.readLine()) != null) {
                // import all cells for a single row as an array of Strings,


                String word = line;;
                wordBank.add(word);
            }
            bufferedReader.close();
        } catch (IOException exception) {
            // Print out the exception that occurred
            System.out.println("Unable to access " + exception.getMessage());
        }
    }

}
