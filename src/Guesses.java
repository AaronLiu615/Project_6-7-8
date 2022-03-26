public class Guesses
{
    /**
     * A array of a word split up
     */
    private String[] letter;

    /**
     * Initiazlies a new Guesses object that splits up a String into letters.
     * @param guess The String being split
     */
    public Guesses(String guess)
    {
        letter = new String[4];

        for (int i = 0; i < 4; i++)
        {
            if (i != 3)
            {
                letter[i] = guess.substring(i, i + 1);
            }
            else
            {
                letter[i] = guess.substring(3);
            }
        }
    }

    /**
     *
     * @return the 1D array of words
     */
    public String[] getLetter()
    {
        return letter;
    }

    /**
     *
     * @return The original string
     */
    public String toString()
    {
        String str = "";
        for (String l : letter)
        {
            str += l;
        }
        return str;
    }
}
