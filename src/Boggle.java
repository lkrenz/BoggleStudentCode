import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Convert the dictionary into a TST

        // Use DFS to search through the 2D array
        // In the DFS keep track of the path taken through and back up once a null value is found on the TST
        // Could maybe use a Trie here, much simpler and wouldn't be massive because of small alphabet
        // Everytime a true value is encountered in the Trie / tst simply remove the word from the TST (set it to false)


        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    // Uses depth first search to search through inputted 2D array
    public static String[] depthFirstSearch() {
        return null;
    }
}
