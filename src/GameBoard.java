/**
 * This class is for the board that will be printed that represents the player's guesses
 *
 * @author Aaron Liu
 */
public class GameBoard {

    /**
     * ANSI code for green
     */
    public static final String GREEN = "\033[0;32m";

    /**
     * ANSI code for white
     */
    public static final String WHITE = "\u001B[37m";

    /**
     * ANSI code for yellow
     */
    public static final String YELLOW = "\033[0;33m";

    /**
     * ASNI code for reset
     */
    public static final String RESET = "\u001B[0m";

    /**
     * A 2d array that is the game board
     */
    private String[][] board;
    /**
     * A array for the answer
     */
    private String[] answer;
    /**
     * To see if the user has solved the board
     */
    private boolean solved;
    /**
     * number of guesses the user currently has
     */
    private int guesses;
    /**
     * Final string that represents the answer
     */
    private final String ANSWER;


    /**
     * Initializes the GameBoard object
     * @param answer
     */
    public GameBoard(String[] answer)
    {
        this.answer = answer;
        ANSWER = convertToString(answer);

        board = new String[][]{
                {"_", "_", "_", "_"},
                {"_", "_", "_", "_"},
                {"_", "_", "_", "_"},
                {"_", "_", "_", "_"},
                {"_", "_", "_", "_"},
                {"_", "_", "_", "_"}};

        solved = false;
        guesses = 0;
    }

    /**
     *
     * @return the number of guesses the user has
     */
    public int getGuesses()
    {
        return guesses;
    }

    /**
     *
     * @return true if the board is solved by the user
     */
    public boolean isSolved()
    {
        return solved;
    }

    /**
     *
     * @return the answer to the board
     */
    public String getAnswerStr()
    {
        return ANSWER;
    }

    /**
     * Adds the user's guess into the board and checks if the guess given matches with the answer
     * @param guess
     */
    public void addGuess(String guess){
        for (int i = 0; i < 4; i++)
        {
            if (i != 3)
            {
                board[guesses][i] = guess.substring(i, i + 1);
            }
            else
            {
                board[guesses][i] = guess.substring(3);
            }
        }
        guesses += 1;
        changeColor();

        if (answer[0].equals(guess.substring(0,1))
                && answer[1].equals(guess.substring(1,2))
                && answer[2].equals(guess.substring(2,3))
                && answer[3].equals(guess.substring(3)))
        {
            solved = true;
        }

    }

    /**
     * Update the board's colors based on if they are in the correct/incorrect spot and if it is in the word.
     */
    public void changeColor() // change the color of the letters
    {

        for(int row = 0; row < board[0].length; row++) {
            for(int col = 0; col < 4; col++) {

                String letter = board[row][col];

                if(letter.equals(answer[col]))
                {
                    board[row][col] = GREEN + letter + RESET;
                }

                else if(isYellow(letter))
                {
                    board[row][col] = YELLOW + letter + RESET;
                }

                else
                {
                    board[row][col] = WHITE + letter + RESET;
                }
            }
        }
    }

    /**
     * Prints the 2d array board for the user to see
     */
    public void printBoard() // prints the board
    {
        for(String[] row : board) {
            for(String letter : row) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }
    }


    /**
     *
     * @param list
     * @return the list as a string
     */
    private String convertToString(String[] list) //STRING list to string
    {
        String str = "";
        for (int i = 0; i < list.length; i++)
        {
            str += list[i];
        }
        return str;
    }

    /**
     * Checks if the letter is a part of the answer
     * @param letter
     * @return true if it is included in the answer and false otherwise
     */
    private boolean isYellow(String letter) //check if letter is in word
    {
        for (String l : answer)
        {
            if (l.equals(letter))
            {
                return true;
            }
        }
        return false;
    }




}
