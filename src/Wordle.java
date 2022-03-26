import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


// words come from https://eslforums.com/4-letter-words/

/**
 * Class that has the logic to run the game
 * @author Aaron Liu
 */
public class Wordle {
    /**
     * Arraylist of all the available words in the game
     */
    private ArrayList<String> wordBank;
    /**
     * String list that contains the winning letters
     */
    private String[] winningLetters;
    /**
     * Scanner for user input
     */
    private Scanner scanner;

    /**
     * Initializes wordle and loads words in the Arrays
     */
    public Wordle() {
        wordBank = new ArrayList<>();
        convertFile();
        winningLetters = getLetters();
        scanner = new Scanner(System.in);
    }

    /**
     *
     * @return WinningLetters
     */
    private String[] getWinningLetters()
    {
        return winningLetters;
    }


    /**
     * helper methods to get winning letters
     * @return a String list of a random word
     */
    private String[] getLetters() // helper for choosing word
    {
        String[] list = new String[4];
        String word = random();

        for (int i = 0; i < word.length(); i++)
        {
            if (i != 3)
            {
                list[i] = word.substring(i, i + 1);
            }
            else
            {
                list[i] = word.substring(i);
            }
        }
        return list;
    }


    /**
     * Method for starting the game
     */
    public void start()
    {
        System.out.println("Welcome to the 4 word-le!");
        GameBoard game = new GameBoard(winningLetters);

        //for (String i : WinningLetters)
        //{
        //    System.out.print(i);
        //} for testing (gives the answer)
        System.out.println();

        while(!game.isSolved() && game.getGuesses() < 6)
        {
            boolean realGuess = true;
            while (realGuess)
            {
                game.printBoard();
                System.out.print("Enter a 4 word: ");
                String guess = scanner.nextLine();
                guess = guess.toLowerCase();

                if (guess.length() == 4 && wordBank.contains(guess))
                {
                    game.addGuess(guess);
                    realGuess = false;
                }
                else
                {
                    System.out.println("Sorry but your letter was not a valid guess");
                }
            }
        }
        if (game.isSolved())
        {
            game.printBoard();
            System.out.println("CONGRATS YOU GUESSED THE WORD!!! It took you " + game.getGuesses() + " guesses!");
        }
        else
        {
            game.printBoard();
            System.out.println("You ran out of guesses \nThe word was " + game.getAnswerStr());
        }

    }

    /**
     *
     * @return a random word from the word bank
     */
    private String random() //gets a random word from array list
    {
        String word = wordBank.get((int) (Math.random()*(2499)+1));
        return word;
    }

    /**
     * Loads a text file into wordBank
     */
    private void convertFile() // converts file to array
    {
        try {
            Scanner input = new Scanner(new File("src\\4letter.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordBank.add(word);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }




}
